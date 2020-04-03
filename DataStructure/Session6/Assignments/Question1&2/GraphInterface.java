import java.util.List;

/**
 * @author Ramdev 
 * Interface For a Graph
 */
public interface GraphInterface
{
	/**
	 * @return true if the nodes of the graph are connected
	 */
	public boolean isConnected();

	/**
	 * @param node
	 * @return the nodes reachable from the specified node
	 */
	public List<Integer> reachableNodes(int node);

	/**
	 * @return MST
	 */
	public List<Edge> getMinimumSpanningTree();

	/**
	 * @param vertex1
	 * @param vertex2
	 * @return the shortest path between two vertex
	 */
	public List<Integer> shortestPath(int vertex1, int vertex2);
}