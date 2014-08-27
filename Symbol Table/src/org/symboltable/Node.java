package org.symboltable;

/**
 * Java class for nodes in a simple polygon. The class node extends user-defined
 * class {@link Vector}.
 * 
 * @author shivam
 */

public class Node extends Vector {

	/**
	 * Name of the node.
	 */
	protected String nodeName;

	/**
	 * Constructor to set default coordinates for the node.
	 */
	public Node() {
		super(0.0, 0.0);
	}

	/**
	 * Constructor to set coordinates <i>dX</i> and <i>dY</i> for the node.
	 * 
	 * @param dX
	 *            X coordinate of the node.
	 * @param dY
	 *            Y coordinate of the node.
	 */
	public Node(double dX, double dY) {
		super(dX, dY);
	}

	/**
	 * Constructor to set coordinates <i>dX</i> and <i>dY</i> for the node along
	 * with its name.
	 * 
	 * @param nodeName
	 *            Name of the node.
	 * @param dX
	 *            X coordinate of the node.
	 * @param dY
	 *            Y coordinate of the node.
	 */
	public Node(String nodeName, double dX, double dY) {
		super(dX, dY);
		this.nodeName = nodeName;
	}

	/**
	 * Method to set name for the node.
	 * 
	 * @param nodeName
	 *            Name of the node to be set.
	 */
	public void setName(String nodeName) {
		this.nodeName = nodeName;
	}

	/**
	 * Method to convert node to a string.
	 * 
	 * @return Node details in string format.
	 */
	@Override
	public String toString() {
		return "Node(\"" + nodeName + "\") is at (" + dX + ", " + dY + ")";
	}

	public static void main(String args[]) {

		// Create and print "point 1", a node at coordinate (1,2)...
		Node nA = new Node();
		nA.dX = 1.0;
		nA.dY = 2.0;
		nA.nodeName = "Point 1";

		System.out.println(nA.toString());

		// Create and print "point 2", a node at coordinate (5,2)...
		Node nB = new Node("Point 2", 5.0, 5.0);
		System.out.println("\n" + nB);
		System.out.println("Vector Magnitude =" + nB.length());

	}
}