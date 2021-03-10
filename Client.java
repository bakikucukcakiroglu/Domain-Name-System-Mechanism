
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package question;

import java.util.Stack;

/**
 * Client class implements a simple client consist of simple implementation of
 * the cache mechanism. The main objective of client is making operations on the
 * DNS. This class has fields root, ipAdress and cacheList and can execute
 * sendRequest and addToCache methods.
 * 
 * @author Hasan Baki Kucukcakiroglu
 *
 * @since 30-05-2020
 */

public class Client {

	/**
	 * This field is for accessing the tree structure that client make operation on.
	 * There may be different DNS instances, and so the client should possess the
	 * necessary information about the main DNS as soon as it is connected to the
	 * Internet.
	 */
	private DnsTree root;

	/**
	 * IP address of the client. Like web servers, each of the clients is assigned
	 * with an IP address. This is just for identifying the clients, it is not used
	 * for the DNS operations in this project.
	 */
	private String ipAddress;

	/**
	 * Array of CachedContent objects which keeps some IP addresses on the local
	 * device. The capacity of this array is limited to 10. One of the most
	 * important parts of the cache mechanism.
	 */
	CachedContent[] cacheList;

	/**
	 * Constructs a new client to make operations on DNS tree. It initializes IP
	 * address of the client, related DNS tree of the client and a cache list with
	 * the size of 10.
	 * 
	 * @param ipAddress takes this IP address parameter and set as client's IP address.
	 *
	 * @param root      takes this root parameter, and set as client's related DNS tree.
	 */
	public Client(String ipAddress, DnsTree root) {

		this.ipAddress = ipAddress;
		this.root = root;
		this.cacheList = new CachedContent[10];

	}

	/**
	 * This nested class implements a basic cached element to keep proper IPs on the
	 * local machine. It has fields domainName, ipAdress and hit No and has only a
	 * constructor.
	 * 
	 * @author Hasan Baki Kucukcakiroglu
	 *
	 */
	private class CachedContent {

		/**
		 * Domain name of the object that will be stored on the cache.
		 */
		private String domainName;

		/**
		 * IP address of the cached domain.
		 */
		private String ipAddress;

		/**
		 * Counts the number of tries to reach this cached content from the cache starting from 0.
		 */
		private int hitNo = 0;

		/**
		 * Constructs a cached content object with using domain name and ip address
		 * @param domainName the domain name
		 * @param ipAddress  the ip address
		 */
		
		public CachedContent(String domainName, String ipAddress) {

			this.domainName = domainName;
			this.ipAddress = ipAddress;

		}

		public String getDomainName() {
			return domainName;
		}

		public void setDomainName(String domainName) {
			this.domainName = domainName;
		}

		public String getIpAddress() {
			return ipAddress;
		}

		public void setIpAddress(String ipAddress) {
			this.ipAddress = ipAddress;
		}

		public int getHitNo() {
			return hitNo;
		}

		public void setHitNo(int hitNo) {
			this.hitNo = hitNo;
		}

	}

	/**
	 * This method returns the IP address of the requested domain name. If it is available in the cache, it directly 
	 * returns the corresponding IP address in the cache record. If it is not available in the cache, then a request 
	 * should be sent to the DNS. If a domain name has multiple IP addresses in order to decide on the IP address to 
	 * return for a specific request, it uses the Round Robin algorithm.
	 *
	 * @param domainName the domain name whose IP address is wanted.
	 *
	 * @return returns the IP address of the requested domain name.
	 */
	public String sendRequest(String domainName) {

		for (int i = 0; i < 10; i++) { // traverses on the cache list and checks if cache has this domain name or not.

			if (cacheList[i] != null) { // checks if the cache list is empty or not

				if (cacheList[i].domainName == domainName) { // checks the element of cache list is requested domain or not.

					cacheList[i].hitNo++; // increments the hit of this element by one.

					return cacheList[i].ipAddress;
				}
			}
		}

		Stack<String> piecesOfDomain = root.pullToPieces(domainName);// pull domain to pieces and keeps pieces on a stack

		DnsNode current = root.root; // root of the related DNS tree.

		int size = piecesOfDomain.size(); // size of pieces stack.

		for (int i = 0; i < size; i++) { // checks if this domain exist in the tree by checking piecewise and if no returns false

			String nodeName = piecesOfDomain.pop(); // pops the elements one by one

			if (current.childNodeList.containsKey(nodeName)) { // checks if the DNS tree contains the following node.

				current = current.childNodeList.get(nodeName); // set the pointer's position as checked node.

			} else { // if the domain name doesn't exist in the DNS tree returns false
				
				return null;
				
			}
		}

		if (current.isValidDomain()) { //checks the last node of the domain is valid or nor.(valid means containing IP address)

			String sendingIp = current.queryQueue.poll(); //takes one of the IP addresses from requested domain

			current.queryQueue.add(sendingIp); //adds it this queue again to provide Round Robin algorithm

			addToCache(domainName, sendingIp); //adds the domain and IP address to cache

			return sendingIp; //return IP address

		} else { //if the last node of the domain is not valid, it means the domain is not valid and returns false.

			return null;
		}

	}

	/**
	 * After obtaining an IP address through sendRequest method, it is added to the cache by this method. 
	 * This method provides the cache replacement algorithm called Robin algorithm.
	 * If there are two different records with the same domain name, they should be stored as separate records.
	 *
	 * @param domainName domain name of the element that will be added to cache
	 *
	 * @param ipAddress IP address of the element that will be added to cache
	 */
	public void addToCache(String domainName, String ipAddress) {

		int emptyIndex = -1; // the empty index on the cached content array 

		for (int i = 0; i < 10; i++) { // travels on the cached content array

			if (cacheList[i] == null) { //checks if the element is empty or not

				emptyIndex = i; // keeps the empty index
			}
		}

		if (emptyIndex == -1) { // if empty index equals -1, it means that there are not an empty element on the cached list array

			int leastHit = cacheList[0].hitNo;  //keeps the least hit among the cached list elements

			int indexLeastHit = 0; // keeps the index of the element that has least hit

			for (int i = 0; i < 10; i++) { // travels on the cached list array

				if (cacheList[i].hitNo < leastHit) {

					indexLeastHit = i;
					leastHit = cacheList[i].hitNo;

				}
			}

			cacheList[indexLeastHit] = new CachedContent(domainName, ipAddress); //creates a new cached content object and stores on the array
											

		} else { //if there is empty element on the array

			cacheList[emptyIndex] = new CachedContent(domainName, ipAddress); //creates a new cached content object and stores on the array

		}

	}

	/**
	 * Getter method for DNS tree 
	 * @return DNS tree which client makes operations on
	 */
	public DnsTree getRoot() {
		return root;
	}

	/**
	 * Setter method for DNS tree 
	 * @param root takes a DNS tree and set it as DNS tree of this client
	 */
	public void setRoot(DnsTree root) {
		this.root = root;
	}

	/**
	 * Getter method for IP address of the client
	 * @return IP address of the client
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * Setter method for IP address of the client
	 * @param ipAddress takes this IP address as parameter and set is as IP address of the client
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * Getter method for cache list of the client
	 * @return cacheList array that stores cached content
	 */
	public CachedContent[] getCacheList() {
		return cacheList;
	}

	/**
	 * Setter method for cache list of the client
	 * @param cacheList takes an array as parameter and set it as cache list array of the client
	 */
	public void setCacheList(CachedContent[] cacheList) {
		this.cacheList = cacheList;
	}

}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

