package question2;

import java.util.Scanner;

/**
 * @author Ramdev
 * class priorityQueue will set the priority of element using heap,enqueue an dequeue elements 
 */
public class PriorityQueue implements Queue {
	public Element[] queue;
	private int front = 0;
	private int rear = -1;
	private int Size;

	/**
	 * @param size : size of queue
	 */
	public PriorityQueue(int size)
	{
		this.Size = size + 1;
		this.queue = new Element[Size];
	}

	@Override
	public boolean enqueue(Element element) throws Exception 
	{
		if (!isFull()) 
		{
			Element object = element;
			queue[++this.rear] = element;
			int position = this.rear - 1;
			while ((position >= this.front) && this.rear != 0 && object.getPriority() > queue[position].getPriority()) 
			{
				Element tempElement = queue[position];
				queue[position] = queue[position + 1];
				queue[position + 1] = tempElement;
				position--;
			}
			return true;
		} else {
			throw new Exception("Queue Array is full");
		}
	}

	
	@Override
	public Element dequeue() throws Exception 
	{
		if (isEmpty()) {
			throw (new Exception("queue is empty"));
		}
		return queue[this.front++];
	}


	@Override
	public boolean isEmpty() 
	{
		if (this.rear == -1 || this.front > this.rear)
			return true;
		return false;
	}


	@Override
	public boolean isFull() 
	{
		if (rear == Size - 1)
			return true;
		return false;
	}

	@Override
	public void display() 
	{		
		for (int i = this.front; i <= this.rear; i++) 
		{
			System.out.println("Element is :" + queue[i].getElementName());
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Queue Size");
		int size = input.nextInt();
		PriorityQueue object = new PriorityQueue(size);

		int select;
		int term = 0;
		while (term == 0) {
			System.out.print(
					"\nOption:\tTo Do:\n1\tTo push element.\n2\tTo POP element.\n3\tTo Display the Queue elements.\n4\tTo Exit the Program.\nEnter your option:- ");
			select = input.nextInt();
			input.nextLine();
			switch (select) {
			case 1: {
				System.out.print("Enter element to insert in the Queue:- ");
				String ele = input.nextLine();
				System.out.print("Enter their priority");
				int priority = input.nextInt();
				try{
					object.enqueue(new Element(ele, priority));
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				break;
			}
			case 2: {
				try {
					System.out.println(object.dequeue().getElementName());
				} catch (Exception e) {

					e.printStackTrace();
				}
				break;
			}
			case 3: {
				object.display();
				break;
			}
			case 4: {
				term = 1;
				break;
			}
			default:
				System.out.println("Enter a valid options");
			}
		}
	}

}