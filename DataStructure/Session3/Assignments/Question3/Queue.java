package question3;
/**
 * @author Ramdev
 * Interface Queue defines the methods of Queue that are to be implemented.
 * @param <T> queue store generic data type
 */
public interface Queue 
{

	/**
	 * To Add an element to a queue
	 * @param object is the object to be inserted
	 * @return true if successfully inserted the element
	 * @throws Exception 
	 */
	public boolean enqueue(Element object) throws Exception;

	/**
	 * To remove element from a queue
	 * @return the removed element
	 */
	public Element dequeue() throws Exception;

	/**
	 * @return true if the queue is empty else return false
	 * @throws Exception
	 */
	public boolean isEmpty();

	/**
	 * @return true if the queue is full else return false
	 */
	public boolean isFull();

	/**
	 * To display all the elements of a queue
	 */
	public void display();
}
