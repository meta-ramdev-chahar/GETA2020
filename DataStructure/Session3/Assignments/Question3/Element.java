package question3;

/**
 * @author Ramdev
 * Define Element that is going to be added or removed from the priority queue
 */
public class Element 
{
	private int elementName;
	private int priority;

	/**
	 * constructor to set instance values
	 * @param elementName
	 * @param prior
	 */
	public Element(int elementName, int prior)
	{
		this.elementName = elementName;
		this.priority = prior;
	}

	/**
	 * @return the element
	 */
	public int getElementName() 
	{
		return this.elementName;
	}

	/**
	 * @return the priority of particular element
	 */
	public int getPriority() 
	{
		return priority;
	}

	/**
	 * To set the priority
	 * @param newPriority
	 */
	public void setPriority(int newPriority) 
	{
		this.priority = newPriority;		
	}
}
