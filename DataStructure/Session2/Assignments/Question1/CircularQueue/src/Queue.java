/**
 * 
 * @author Ramdev
 * Interface for a Queue
 */
public interface Queue 
{
	public boolean enQueue(int value);
	
	public boolean deQueue();
	
	public int front();
	
	public int rear();
	
	public boolean isEmpty();
	
	public boolean isFull();
}
