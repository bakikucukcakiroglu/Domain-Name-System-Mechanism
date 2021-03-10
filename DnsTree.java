
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package question;

import java.util.*;


/**
 * DnsTree class implements a DnsTree to represent the main DNS structure. The
 * main objective is this class making operations on the tree. This class has
 * only one field called root and has insert, remove and get all methods.
 * 
 * @author Hasan Baki Kucukcakiroglu
 * 
 * @since 30-05-2020
 *
 */
public class DnsTree {

	/**
	 * The root of the tree. It is initialized as empty tree node.
	 */
	DnsNode root;

	/**
	 * Constructs a new DNS tree and initializes the root of this tree as empty tree node.
	 */
	public DnsTree() {

		root = new DnsNode();

	}

	/**
	 * This method inserts a new record for a given domain name. If a corresponding
	 * node is not available in the tree, it is created and validDomain is marked as
	 * true. Otherwise, the IP address list of the node is updated with this method.
	 *
	 * @param domainName the domain name that will be inserted to tree
	 * 
	 * @param ipAddress	 the IP address that will be inserted to tree
	 */
	public void insertRecord(String domainName, String ipAddress) {

		DnsNode current = root; // pointer that helps traveling on the tree starting from root of the tree

		Stack<String> parcalar = pullToPieces(domainName); // pull domain to pieces and keeps pieces on a stack

		while (!parcalar.isEmpty()) { // travels the stack and checks if these domain pieces exist in tree or not

			String nodeName = parcalar.pop();//pops pieces one by one

			if (current.childNodeList.containsKey(nodeName)) { // if the piece exist in the tree, just sets forward the pointer

				current = current.childNodeList.get(nodeName);

			} else { //if there is not such a node in tree, adds tree a new node 

				DnsNode newNode = new DnsNode();

				current.childNodeList.put(nodeName, newNode); // adds the new node to parent's child list

				current = newNode; // sets forward the pointer

			}
		}

		current.ipAddresses.add(ipAddress); //add the given IP address to domain's IP list
		
		current.queryQueue.add(ipAddress); //adds the given IP address to domain's query list
		
		current.setValidDomain(true); // sets the domain as valid 
		
		current.name = domainName; // sets current node's name as domain name

	}

	/**
	 * This method removes the node with the given domainName from the tree. 
	 * If the node is a intermediate node, this method just deletes its IP addresses
	 * If successfully removed, return true, otherwise, return false.
	 *
	 * @param domainName the domain name which will be deleted from tree
	 *
	 * @return a boolean value according to if deleting operation occurs successfully
	 */
	public boolean removeRecord(String domainName) {

		DnsNode current = root; // pointer that helps traveling on the tree starting from root of the tree

		DnsNode previous = null; // another pointer that trace current one step behind

		Stack<String> piecesOfDomain = pullToPieces(domainName); // pull domain to pieces and keeps pieces on a stack

		int size = piecesOfDomain.size(); // size of the stack

		String nodeName = "";

		for (int i = 0; i < size; i++) { // travels all stack and checks if all elements on the stack exist in the tree or not 

			nodeName = piecesOfDomain.pop(); // pops elements one by one

			if (current.childNodeList.containsKey(nodeName)) { // if the piece exist in the tree, just sets forward pointers

				previous = current;

				current = current.childNodeList.get(nodeName);

			} else { //if there is not such a node in tree, returns false
				
				return false;
			}

		}

		if (current.childNodeList.size() == 0) { // if the last node of the domain has not a child, remove the last node fully

			previous.childNodeList.remove(nodeName); // removes the last node from its parent's child list

			current.ipAddresses.clear(); // clears all IP addressees from the IP list of the last node

			current.queryQueue.clear(); // clears all IP addresses from the query list of the last node

			current.setValidDomain(false); // sets the last node as invalid

			return true;

		} else { // if the last node of the domain has a child, just remove IP addresses from this node and set as invalid

			if(current.isValidDomain()) {
			
			current.ipAddresses.clear(); // clears all IP addressees from the IP list of the last node

			current.queryQueue.clear(); // clears all IP addresses from the query list of the last node

			current.setValidDomain(false); // sets the last node as invalid

			return true;
			
			}else { //if the node is intermediate and has no IP address returns false
				
				return false;
			}
		}

	}

	/**
	 * This method removes the given ipAddress of a DNS node with the given
	 * domainName. If successfully removed, return true, otherwise, return false.
	 * 
	 * @param domainName the domain name whose IP address will be deleted
	 * 
	 * @param ipAdress   the IP address to be deleted
	 * 
	 * @return a boolean value according to if given IP address removed successfully or not
	 */
	public boolean removeRecord(String domainName, String ipAdress) {

		DnsNode current = root; // pointer that helps traveling on the tree starting from root of the tree

		Stack<String> piecesOfDomain = pullToPieces(domainName); // pull domain to pieces and keeps pieces on a stack

		int size = piecesOfDomain.size(); // size of the stack

		for (int i = 0; i < size; i++) { // travels all stack and checks if all elements on the stack exist in the tree or not 
			
			String nodeName = piecesOfDomain.pop(); // pops elements one by one

			if (current.childNodeList.containsKey(nodeName)) { // if the piece exist in the tree, just sets forward pointers

				current = current.childNodeList.get(nodeName);

			} else { //if there is not such a node in tree, returns false

				return false;
			}

		}

		if (current.ipAddresses.contains(ipAdress)) { // if the last node includes the given IP address, delete the IP address

			if (current.ipAddresses.size() == 1) { // if the IP is the last IP of domain, previous remove method runs this process

				return removeRecord(domainName); // calls previous remove method

			} else { // if the IP is not the only IP of the node, delete this IP from node

				current.ipAddresses.remove(ipAdress); // delete this IP from node

				current.queryQueue.remove(ipAdress); //delete this IP from node's query list

				return true;
			}

		} else { // if the last node does not include the given IP address, return false

			return false;
		}

	}

	/**
	 * This method queries a domain name within the DNS, and returns the next IP address of the domainName, 
	 * following the Round Robin mechanism. If there is no such domain name available in the tree, this method returns null.
	 * 
	 * @param domainName the domain name whose IP address will be returned
	 * 
	 * @return an  IP address of domain according to Round Robin mechanism
	 */
	public String queryDomain(String domainName) {

		DnsNode current = root; // pointer that helps traveling on the tree starting from root of the tree

		Stack<String> piecesOfDomain = pullToPieces(domainName); // pull domain to pieces and keeps pieces on a stack

		int size = piecesOfDomain.size(); // size of the stack

		for (int i = 0; i < size; i++) { // travels all stack and checks if all elements on the stack exist in the tree or not 
										 // if there is, gives the last node of the domain

			String nodeName = piecesOfDomain.pop(); // pops elements one by one

			if (current.childNodeList.containsKey(nodeName)) { // if the piece exist in the tree, just sets forward pointers

				current = current.childNodeList.get(nodeName);

			} else { // if the domain doesn't exist in the tree, returns false

				return null;
			}

		}

		if (current.isValidDomain()) { // checks if the last node of the domain has an IP or not

			String first = current.queryQueue.poll(); //takes one of the IP addresses from requested domain

			current.queryQueue.add(first); //adds it this queue again to provide Round Robin algorithm

			return first; 

		} else { // if the last node is empty, returns null

			return null;
		}

	}

	/**
	 * This method returns all the valid domain names in the DNS mechanism with at least 1 IP address. 
	 * This method calls recursiveTraverse method when it is executed.
	 * 
	 * @return returns a Map object whose keys represent the valid domain names, and value is the set
	 * of IP addresses of a particular key (domain name).
	 */
	public Map<String, Set<String>> getAllRecords() {

		Map<String, Set<String>> map = new HashMap<>(); 

		recursiveTraverse(root, map);

		return map;

	}

	/**
	 * This method traverse the tree recursively and adds all valid domains to the map given as a parameter.
	 * 
	 * @param currentNode the pointer that helps method to travel all tree starting from root
	 * 
	 * @param map a map object given to store all valid domains
	 */
	public void recursiveTraverse(DnsNode currentNode, Map<String, Set<String>> map) {

		for (Map.Entry mapElement : currentNode.childNodeList.entrySet()) { // travels all children of the current node

			if (((DnsNode) mapElement.getValue()).isValidDomain()) { // checks if the given node is valid or not

				map.put(((DnsNode) mapElement.getValue()).name, ((DnsNode) mapElement.getValue()).ipAddresses);
				//if it is valid, adds it to map

			}

			recursiveTraverse(((DnsNode) mapElement.getValue()), map); //calls itself with child node of current node

		}

	}

	/**
	 * This method takes an domain and pulls it to pieces. Stores all pieces in a stack.
	 *
	 * @param OriginalDomainName the given domain name to be separated
	 * 
	 * @return returns a stack storing all pieces of the domain
	 */
	public Stack<String> pullToPieces(String OriginalDomainName) {

		String domainName = OriginalDomainName + "."; //adds a dot to end of the domain to make operations easier 

		Stack<String> stackOfDomainParts = new Stack<>(); // a empty stack to store pieces of the domain

		while (domainName.contains(".")) { // checks if there is still a piece or not

			int rightIndex = domainName.indexOf("."); // right limit index

			stackOfDomainParts.push(domainName.substring(0, rightIndex)); // adds the piece to the stack

			domainName = domainName.substring(rightIndex + 1); // sets the new string according to separated piece

		}

		return stackOfDomainParts;

	}

	/**
	 * Getter method of the root of the tree
	 * @return the root of the tree
	 */
	public DnsNode getRoot() {
		return root;
	}

	/**
	 * Setter method of the root of the tree
	 * @param root takes a node and set it as root of the tree
	 */
	public void setRoot(DnsNode root) {
		this.root = root;
	}

}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

