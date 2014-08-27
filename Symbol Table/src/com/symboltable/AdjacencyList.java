package com.symboltable;

/**
 * An adjacency list of strings, implemented with a linked list.
 * 
 * @author shivam
 *
 */
public class AdjacencyList {

	/**
	 * Beginning element of the list (first node).
	 */
	private Node firstElement;

	/**
	 * Size of the list.
	 */
	private int size;

	/**
	 * Helper linked list data type to build nodes
	 * 
	 * @author shivam
	 *
	 */
	private static class Node {

		/**
		 * Name of the node.
		 */
		String name;

		/**
		 * Next node.
		 */
		Node next;

		/**
		 * Constructor to set name of the node and next node.
		 * 
		 * @param name
		 * 			Name of the node.
		 * @param next
		 * 			Next node.
		 */
		Node(String name, Node next) {
			this.name = name;
			this.next = next;
		}
	}

	/**
	 * Method to check whether list is empty.
	 * 
	 * @return True, if empty.
	 */
	public boolean isEmpty() {
		return (firstElement == null);
	}

	/**
	 * Method to return size of list.
	 * 
	 * @return Size of list.
	 */
	public int size() {
		return size;
	}

	/**
	 * Method to add string to the adjacency list.
	 * 
	 * @param s
	 *            String to be added to adjacency list.
	 */
	public void insert(String s) {
		firstElement = new Node(s, firstElement);
		size++;
	}

	/**
	 * Method to return string representation of list but in reverse order.
	 * 
	 * @return String representation of list (in reverse order of list).
	 */
	public String toString() {
		String s = "";
		for (Node x = firstElement; x != null; x = x.next)
			s = x.name + ", " + s;
		return "{ " + s + "}";
	}

	/**
	 * Method to build array of strings comprising this adjacency list.
	 * 
	 * @return Array of strings comprising this adjacency list.
	 */
	public String[] toArray() {
		String[] names = new String[size];
		int i = size;
		for (Node x = firstElement; x != null; x = x.next)
			names[--i] = x.name;
		return names;
	}

	public static void main(String[] args) {

		AdjacencyList adjancencyList = new AdjacencyList();
		adjancencyList.insert("Java");
		adjancencyList.insert("C");
		adjancencyList.insert("C++");
		adjancencyList.insert("Matlab");

		System.out.println(adjancencyList);
	}
}