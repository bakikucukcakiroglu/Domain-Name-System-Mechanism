
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package question;

import java.util.*;


/**
 * DnsNode class implements a basic DNS tree node to create a DNS tree.
 * Instances of this class are fundamental pieces of the tree.
 * 
 * @author Hasan Baki Kucukcakiroglu
 * 
 * @since 30-05-2020
 *
 */
public class DnsNode {

	/**
	 * This field is utilized for maintaining the tree structure. The keys are
	 * represented as strings, and the values are DNS nodes. Each key is a sub domain
	 * name and the value it is mapped represents a child node in the tree
	 * structure.
	 */
	Map<String, DnsNode> childNodeList;

	/**
	 * It shows whether the current node is a valid domain name or just a sub domain that cannot have any IP address.
	 */
	private boolean validDomain;

	/**
	 * This set stores the IP addresses as a list of a domain name. 
	 */
	Set<String> ipAddresses;
	
	/**
	 * This queue stores all IP addresses belonging this node. It is utilized for maintaining Round Robin mechanism
	 */
	Queue<String> queryQueue;
	
	/**
	 * This field keeps the full domain name belonging this node
	 */
	String name;


	/**
	 * Constructs a DNS node object and initializes its fields. 
	 * Creates Map, Set, and a queue and set them as a field.
	 * Sets validDomain as false default.
	 */
	public DnsNode() {

		childNodeList = new HashMap<String, DnsNode>();

		validDomain = false;

		ipAddresses = new HashSet<String>();

		queryQueue = new LinkedList<>();

	}

	/**
	 * Getter method for validDomain field
	 *
	 * @return  the validDomain value belonging this node
	 */
	public boolean isValidDomain() {
		return validDomain;
	}

	
	/**
	 * Setter method for validDomain field.
	 * 
	 * @param validDomain  takes a boolean value as parameter and sets it as validDomain
	 */
	public void setValidDomain(boolean validDomain) {
		this.validDomain = validDomain;
	}

	
	/**
	 * Getter method for IpAddresses set
	 *
	 * @return the set of IP addresses belonging this node
	 */
	public Set<String> getIpAddresses() {
		return ipAddresses;
	}

	
	/**
	 * Setter method for IpAddresses set
	 * 
	 * @param ipAddresses takes a set object as parameter and set it as set of IP addresses belonging this node
	 */
	public void setIpAddresses(Set<String> ipAddresses) {
		this.ipAddresses = ipAddresses;
	}

}




//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

   