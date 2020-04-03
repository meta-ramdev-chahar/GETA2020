/**
 * @author Ramdev
 * class Edge will have the properties of an edge and create an Edge
 *
 */
public class Edge
{
	private int source, destination, weight;

	/**
	 * @param source
	 * @param destination
	 * @param weight
	 * constructor to set the values of instance variables
	 */
	Edge(int source, int destination, int weight)
	{
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	/**
	 * @return the source node of Edge
	 */
	public int getSource()
	{
		return source;
	}

	/**
	 * @param source 
	 * method to set source node of Edge
	 */
	public void setSource(int source)
	{
		this.source = source;
	}

	/**
	 * @return the destination node of Edge
	 */
	public int getDestination()
	{
		return destination;
	}

	/**
	 * @param destination
	 * method to set destination node of Edge
	 */
	public void setDestination(int destination)
	{
		this.destination = destination;
	}

	/**
	 * @return the weight of Edge
	 */
	public int getWeight()
	{
		return weight;
	}

	/**
	 * @param weight
	 * method to set weight of Edge
	 */
	public void setWeight(int weight)
	{
		this.weight = weight;
	}

}