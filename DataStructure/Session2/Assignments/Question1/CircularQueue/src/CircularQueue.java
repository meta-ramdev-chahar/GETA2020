/**
 * 
 * @author Ramdev
 *
 */
public class CircularQueue implements Queue
{
	private int[] arr;
	private int front, rear;

	/**
	 *  Initialize your data structure here. Set the size of the queue to be k. 
	 *  
	 */
	public CircularQueue(int size)
	{
		this.arr = new int[size];
		this.front = -1;
		this.rear = 0;
	}

	/** 
	 * To Insert an element into the circular queue. Return true if the operation is successful. 
	 */
	public boolean enQueue(int value) 
	{
		if (this.isFull()) 
			return false;
		
		arr[rear] = value;
		
		if (front == -1) 
			front = rear;
		rear = (rear + 1)%arr.length;
		return true;
	}

	/**
	 * To Delete an element from the circular queue. Return true if the operation is successful.   
	 */
	public boolean deQueue() 
	{
		if (this.isEmpty()) 
			return false;
		front = (front+1)%arr.length;
		
		if (front == rear) 
			front = -1;
		return true;
	}

	/** 
	 * To Get the front item from the queue. 
	 * 
	 */
	public int front() 
	{
		if (this.isEmpty()) 
			return -1;
		
		return arr[front];
	}

	/** 
	 * To Get the last item from the queue. 
	 * 
	 */
	public int rear() 
	{
		if (isEmpty()) 
			return -1;
		
		return arr[(rear - 1 + arr.length) % arr.length];
	}

	/** 
	 * To Checks whether the circular queue is empty or not. 
	 * 
	 */
	public boolean isEmpty() 
	{
		return (front == -1);
	}

	/** 
	 * To Checks whether the circular queue is full or not. 
	 */
	public boolean isFull() 
	{
		return (front == rear);
	}
}





