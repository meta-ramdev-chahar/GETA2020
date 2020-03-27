package question2;

/**
 * @author Ramdev
 * Define Element that is going to be added or removed from the priority queue
 */
public class Element 
{
	private String elementName = null;
	private int priority;

	/**
	 * constructor to set instance values
	 * @param elementName
	 * @param prior
	 */
	public Element(String elementName, int prior)
	{
		this.elementName = elementName;
		this.priority = prior;
	}

	/**
	 * @return the element
	 */
	public String getElementName() 
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

}