package org.symboltable;

/**
 * Undirected graph data type implemented using a symbol table of vertices,
 * where each vertex contains a list of its neighbors.
 * 
 * Limitations: ------------ - addEdge(v, v) adds two copies of the self-loop
 * v-v - the adjacency lists use independent copies of each string, which wastes
 * memory
 * 
 * @author shivam
 * 
 */
public class Graph {

	/**
	 * Symbol table of linked lists.
	 */
	private SymbolTable symbolTable = new SymbolTable();

	/**
	 * Add v to w's list of neighbors and w to v's list of neighbors, allowing
	 * parallel edges.
	 * 
	 * @param v
	 *            First vertex.
	 * @param w
	 *            Last Vertex.
	 */
	public void addEdge(String v, String w) {

		if (symbolTable.get(v) == null)
			addVertex(v);
		if (symbolTable.get(w) == null)
			addVertex(w);
		AdjacencyList vlist = (AdjacencyList) symbolTable.get(v);
		AdjacencyList wlist = (AdjacencyList) symbolTable.get(w);
		vlist.insert(w);
		wlist.insert(v);
	}

	/**
	 * Method to add a new vertex v with no neighbors, if vertex does not yet
	 * exist.
	 * 
	 * @param v
	 *            Vertex to be added.
	 */
	public void addVertex(String v) {
		if (symbolTable.get(v) == null)
			symbolTable.put(v, new AdjacencyList());
	}

	/**
	 * Method to return the degree of vertex <i>v</i>.
	 * 
	 * @param v
	 *            Vertex of which the degree is to be calculated.
	 * @return Degree of v.
	 */
	public int degree(String v) {

		AdjacencyList adjacencyList = (AdjacencyList) symbolTable.get(v);
		if (adjacencyList == null)
			return 0;
		else
			return adjacencyList.size();
	}

	/**
	 * Method to return the array of vertices incident to vertex <i>v</i>.
	 * 
	 * @param v
	 *            Vertex.
	 * @return Array of vertices neighboring to vertex v.
	 */
	public String[] neighbors(String v) {
		AdjacencyList adjacencyList = (AdjacencyList) symbolTable.get(v);
		if (adjacencyList == null)
			return new String[0];
		else
			return adjacencyList.toArray();
	}

	/**
	 * Returns list of vertices in string format.
	 */
	@Override
	public String toString() {

		String s = "\n";
		String[] vertices = symbolTable.keys();
		for (int v = 0; v < vertices.length; v++) {
			AdjacencyList AdjacencyList = (AdjacencyList) symbolTable
					.get(vertices[v]);
			s += vertices[v] + ": " + AdjacencyList + "\n";
		}
		return s;
	}

	public static void main(String[] args) {

		// Build graph of DC Metro System .....
		Graph graph = new Graph();
		graph.addEdge("College Park", "Fort Totten");

		graph.addEdge("Greenbelt", "College Park");
		graph.addEdge("Fort Totten", "Silver Spring");
		graph.addEdge("Fort Totten", "Catholic Univ");
		graph.addEdge("Catholic Univ", "Union Station");
		graph.addEdge("Judiciary Sq", "Union Station");
		graph.addEdge("Judiciary Sq", "Fort Totten");
		graph.addEdge("Judiciary Sq", "Metro Center");
		graph.addEdge("Judiciary Sq", "National Airport");
		graph.addEdge("DuPont Circle", "Metro Center");

		// Build graph of DC Metro System .....
		System.out.println();
		System.out.println("Simple Model of DC Metro System");
		System.out.println("===============================");
		System.out.println(graph.toString());

		// Run breadth first search
		System.out.println();
		System.out.println("Source: College Park");
		System.out.println("Destination: Union Station");
		System.out.println("==========================");

		BFSearcher bfSercher1 = new BFSearcher(graph, "Union Station");

		System.out.println(bfSercher1);

		bfSercher1.showPath("College Park");

		System.out.println();
		System.out.println("Source: College Park");
		System.out.println("Destination: National Airport");
		System.out.println("=============================");

		BFSearcher bfSercher2 = new BFSearcher(graph, "National Airport");
		bfSercher2.showPath("College Park");

	}
}