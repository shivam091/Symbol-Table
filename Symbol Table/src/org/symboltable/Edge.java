package org.symboltable;

/**
 * Java class containing methods to draw edges between two nodes.
 * 
 * @author shivam
 * 
 */
public class Edge {
	/**
	 * node1:First node. node2:Second node.
	 */
	protected Node node1, node2;

	/**
	 * Name of the edge.
	 */
	protected String edgeName;

	/**
	 * Default constructor to initialize class.
	 */
	public Edge() {
	}

	/**
	 * Constructor to initialize the class with nodes.
	 * 
	 * @param node1
	 *            First node.
	 * @param node2
	 *            Second node.
	 */
	public Edge(Node node1, Node node2) {
		this.node1 = node1;
		this.node2 = node2;
	}

	/**
	 * Constructor to initialize the class with <i>edgeName</i> and <i>node1</i>
	 * and <i>node2</i>.
	 * 
	 * @param edgeName
	 *            Name of the edge.
	 * @param node1
	 *            First node.
	 * @param node2
	 *            Second node.
	 */
	public Edge(String edgeName, Node node1, Node node2) {
		this.node1 = node1;
		this.node2 = node2;
		this.edgeName = edgeName;
	}

	/**
	 * Method to compute edge length.
	 * 
	 * @return Length of edge.
	 */
	public double length() {
		return node1.sub(node2).length();
	}

	/**
	 * Method to convert edge to a string.
	 * 
	 * @return Node in string format.
	 */
	@Override
	public String toString() {
		return "Edge(\"" + edgeName + "\") connects nodes (" + node1.nodeName
				+ ", " + node2.nodeName + ")";
	}

	public static void main(String args[]) {

		System.out.println("Exercise methods in Edge class");
		System.out.println("==============================");

		// Create "Edge 1" .....
		Edge eA = new Edge();
		eA.node1 = new Node("Point 1", 0.0, 0.0);
		eA.node2 = new Node("Point 2", 5.0, 0.0);
		eA.edgeName = "Edge 1";

		// Create "Edge 2" and "Edge 3" ....
		Node node3 = new Node("Point 3", 5.0, 5.0);
		Edge eB = new Edge("Edge 2", eA.node2, node3);
		Edge eC = new Edge("Edge 3", node3, eA.node1);

		// Create details of edges ....
		System.out.println(eA.toString());
		System.out.println(eB.toString());
		System.out.println(eC.toString());

		// Compute and print lengths of each edge ....
		System.out.println("Length (" + eA.edgeName + ") = " + eA.length());
		System.out.println("Length (" + eB.edgeName + ") = " + eB.length());
		System.out.println("Length (" + eC.edgeName + ") = " + eC.length());

	}
}