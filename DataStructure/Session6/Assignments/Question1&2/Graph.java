import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ramdev
 * Class Graph implements GraphInterface to provide definitions to the methods of Graph Interface
 */
public class Graph implements GraphInterface
{
	HashMap<Integer, List<Edge>> edgeList;
	int totalVertices;

	/**
	 * @param vertices is the total no. of vertices in the graph Constructor initializes the edgeList
	 */
	Graph(int vertices)
	{
		try
		{
			if (vertices <= 0)
			{
				throw new Exception("Invalid value of vertices");
			}
			this.totalVertices = vertices;
			edgeList = new HashMap<>(vertices);
			for (int i = 1; i <= vertices; i++)
			{
				edgeList.put(i, new LinkedList<Edge>());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	/**
	 * @param source is start of the edge
	 * @param destination is the end of the edge
	 * @param weight
	 * @return true if edge is successfully added to the graph
	 */
	public boolean addEdge(int source, int destination, int weight)
	{
		try
		{
			if (source <= 0 || source > totalVertices || destination > totalVertices || destination <= 0)
			{
				throw new Exception("source and destination must be between 1 to " + totalVertices);
			}
			Edge e = new Edge(source, destination, weight);
			edgeList.get(source).add(e);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * method isConnected returns true if all the nodes are connected in the graph
	 * method uses DFS to check if the graph is connected
	 */
	@Override
	public boolean isConnected()
	{
		try
		{
			boolean[] isVisited = new boolean[totalVertices];
			dfs(1, isVisited);
			for (int i = 0; i < totalVertices; i++)
			{
				if (isVisited[i] == false)
				{
					return false;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * This function traverse graph according to depth first traversal.
	 * @param vertex
	 * @param isVisited
	 */
	public void dfs(int vertex, boolean[] isVisited) {
		if(isVisited[vertex - 1] == false) {
			isVisited[vertex - 1] = true;
			for(Edge i : this.edgeList.get(vertex)) {
				dfs(i.getDestination(), isVisited);
			}
		}
	}
	
	/**
	 * @param vertexNode is the root node
	 * @return return the list of the nodes reachable from the @param vertexNode
	 */
	@Override
	public List<Integer> reachableNodes(int vertexNode)
	{
		List<Integer> listOfReachableNode = new ArrayList<Integer>();
		try
		{

			if (vertexNode > totalVertices)
			{
				throw new AssertionError("vertexNode doesn't exist in graph");
			}
			boolean[] isVisited = new boolean[totalVertices];
			dfs(vertexNode, isVisited);
		
			for (int i = 0; i < totalVertices; i++)
			{
				if (isVisited[i])
				{
					listOfReachableNode.add(i + 1);
				}

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return listOfReachableNode;
	}

	/**
	 * @return list of edges with minimum weight for minimum spanning tree
	 */
	@Override
	public List<Edge> getMinimumSpanningTree()
	{
		List<Edge> listOfEdgesInMST = new ArrayList<Edge>();
		try
		{
			boolean[] isVisited = new boolean[totalVertices];
			getMSTUsingPrim(1, new LinkedList<>(), isVisited, listOfEdgesInMST);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return listOfEdgesInMST;
	}

	/**
	 * @param vertex
	 * @param listOfTemporaryEdges
	 * @param isVisited            
	 * getMSTUsingPrim is utility method of prim's algorithm
	 */
	public void getMSTUsingPrim(int vertex, List<Edge> listOfTemporaryEdges, boolean[] isVisited, List<Edge> listOfEdgesInMST)
	{
		try
		{
			if (vertex <= 0 || vertex > totalVertices)
			{
				throw new AssertionError("vertexNode doesn't exist in graph");
			}

			isVisited[vertex - 1] = true;
			List<Edge> listOfAdjacentEdges = edgeList.get(vertex);

			for (Edge edge : listOfAdjacentEdges)
			{
				int destination = edge.getDestination();
				if (!isVisited[destination - 1])
				{
					listOfTemporaryEdges.add(edge);
				}
			}

			Edge currentEdge = listOfTemporaryEdges.get(0);
			int mininmumWeight = Integer.MAX_VALUE;
			for (Edge edge : listOfTemporaryEdges)
			{
				int currentWeight = edge.getWeight();

				boolean isMSTContainEdge = listOfEdgesInMST.contains(edge);

				if (mininmumWeight > currentWeight && !isMSTContainEdge)
				{
					mininmumWeight = currentWeight;
					currentEdge = edge;
				}
			}

			int destinationOfCurrent = currentEdge.getDestination();
			if (!isVisited[destinationOfCurrent - 1])
			{
				listOfEdgesInMST.add(currentEdge);
				listOfTemporaryEdges.remove(currentEdge);
			}
			for (int i = 0; i < isVisited.length; i++)
			{
				// recursive call to function if any node is not visited.
				if (!isVisited[i])
				{
					getMSTUsingPrim(destinationOfCurrent, listOfTemporaryEdges, isVisited, listOfEdgesInMST);
				}

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	
	/**
	 * method to find shortest path between two vertex
	 */
	@Override
	public List<Integer> shortestPath(int source, int destination)
	{
		List<Integer> shortestPath = null;
		try
		{
			if (source <= 0 || source > totalVertices || destination > totalVertices || destination <= 0)
			{
				throw new Exception("source or destination doesn't exist in graph");
			}
			shortestPath = new ArrayList<Integer>();
			boolean[] isVisited = new boolean[totalVertices];
			int[][] distanceParentTable = new int[totalVertices][2];
			/**
			 * Initialize distance with infinity
			 */
			for (int i = 0; i < totalVertices; i++)
			{
				distanceParentTable[i][0] = Integer.MAX_VALUE;
			}
			distanceParentTable[source - 1][0] = 0;
			setDistanceParentTable(source, isVisited, distanceParentTable);
			int currentNode = destination;
			while (currentNode != source)
			{
				shortestPath.add(currentNode);
				currentNode = distanceParentTable[currentNode - 1][1];
			}
			shortestPath.add(currentNode);
			Collections.reverse(shortestPath);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return shortestPath;

	}

	
	/**
	 * @param currentNode contains current node which is traversed.
	 * @param isVisited
	 * @param distanceParentTable
	 * private method to set distanceParentTable with minimum distance of all nodes from source using Dijkstra algorithm.
	 */
	private void setDistanceParentTable(int currentNode, boolean[] isVisited, int[][] distanceParentTable)
	{
		try
		{
			if (currentNode <= 0 || currentNode > totalVertices)
			{
				throw new Exception("node doesn't exist in graph");
			}
			int minimumDistance = distanceParentTable[currentNode - 1][0];
			for (Edge edge : edgeList.get(currentNode))
			{
				int currentDestination = edge.getDestination();
				int currentDistance = edge.getWeight() + minimumDistance;
				if (distanceParentTable[currentDestination - 1][0] > currentDistance)
				{
					distanceParentTable[currentDestination - 1][0] = currentDistance;
					distanceParentTable[currentDestination - 1][1] = currentNode;
				}
			}
			isVisited[currentNode - 1] = true;
			currentNode = getMinimumDistanceNode(distanceParentTable, isVisited);
			for (int i = 0; i < isVisited.length; i++)
			{
				if (!isVisited[i])
				{
					setDistanceParentTable(currentNode, isVisited, distanceParentTable);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
	
	/**
	 * private method to get node with minimum distance distanceParentTable
	 * 
	 * @param distanceParentTable
	 * @param isVisited
	 * @return returns node
	 */
	private int getMinimumDistanceNode(int[][] distanceParentTable, boolean[] isVisited)
	{
		int node = 0;
		try
		{
			int minimum = Integer.MAX_VALUE;
			for (int i = 0; i < distanceParentTable.length; i++)
			{
				if (minimum > distanceParentTable[i][0] && !isVisited[i])
				{
					minimum = distanceParentTable[i][0];
					node = i + 1;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return node;
	}
}