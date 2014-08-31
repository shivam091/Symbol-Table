package org.symboltable;

/**
 * Runs <i>Breadth First Search (BFS)</i> algorithm from source <i>sourceVertex</i> on
 * a graph <i>graph</i>. After pre-processing the graph, can process shortest
 * path queries from any vertex <i>vertex</i> to <i>sourceVertex</i>.
 * 
 * @author shivam
 * 
 */
public class BFSearcher {
	private SymbolTable visited = new SymbolTable();

	/**
	 * Run BFS in graph <i>graph</i> from given source vertex
	 * <i>sourceVertex</i>.
	 * 
	 * @param graph
	 *            Graph.
	 * @param sourceVertex
	 *            Source vertex.
	 */
	public BFSearcher(Graph graph, String sourceVertex) {

		Queue queue = new Queue();
		queue.enqueue(sourceVertex);
		visited.put(sourceVertex, "");

		while (!queue.isEmpty()) {
			String v = (String) queue.dequeue();
			String[] neighbors = graph.neighbors(v);
			for (int i = 0; i < neighbors.length; i++) {
				String w = neighbors[i];
				if (visited.get(w) == null) {
					queue.enqueue(w);
					visited.put(w, v);
				}
			}
		}

	}

	/**
	 * Method to check whether <i>vertex</i> is reachable from the source vertex
	 * <i>sourceVertex</i>.
	 * 
	 * @param vertex
	 *            Vertex.
	 * @return true, if visible.
	 */
	public boolean isReachable(String vertex) {
		return visited.get(vertex) != null;
	}

	/**
	 * Method to compute the length of the shortest path from <i>vertex</i> to
	 * <i>sourceVertex</i>.
	 * 
	 * @param vertex
	 *            Vertex.
	 * @return Length of path.
	 */
	public int pathLength(String vertex) {
		int length = -1;
		while (visited.get(vertex) != null) {
			vertex = (String) visited.get(vertex);
			length++;
		}
		return length;
	}

	/**
	 * Method to print the shortest path from <i>vertex</i> to
	 * <i>sourceVertex</i> to standard output.
	 * 
	 * @param vertex
	 *            Vertex.
	 */
	public void showPath(String vertex) {
		while (visited.get(vertex) != null) {
			System.out.println(vertex);
			vertex = (String) visited.get(vertex);
		}
	}

	/**
	 * Method to return the shortest path from <i>vertex</i> to
	 * <i>sourceVertex</i> as an array of strings.
	 * 
	 * @param vertex
	 *            Vertex,
	 * @return Array of strings.
	 */
	public String[] path(String vertex) {
		int N = pathLength(vertex);
		String[] p = new String[N + 1];
		for (int i = 0; i <= N; i++) {
			p[i] = vertex;
			vertex = (String) visited.get(vertex);
		}
		return p;
	}

	/**
	 * Method to create string of symbol table contents.
	 */
	@Override
	public String toString() {
		return visited.toString();
	}
}