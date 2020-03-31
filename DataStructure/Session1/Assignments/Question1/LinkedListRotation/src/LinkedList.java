/**
 * 
 * @author Ramdev
 * Implement Methods for rotating a sub LinkedList of given LinkedList as per given Steps 
 */
class LinkedList 
{ 
	/**
	 * 
	 *Indicate the Node of a Linked List
	 */
	static class Node 
	{  
		int data;  
		Node next;  
	} 
	
	/**
	 * To get the Linked List after rotated sub List by given number of steps 
	 * @param headNode 
	 * @param leftIndex
	 * @param rightIndex
	 * @param numberOfSteps : By which we want to rotate our sub LinkedList
	 * @return the head node of rotated Linked List
	 */
	static Node rotateSubList(Node headNode, int leftIndex, int rightIndex, int numberOfSteps)  
	{  
		int size = rightIndex - leftIndex + 1;  

		if (numberOfSteps > size) 
		{  
			numberOfSteps = numberOfSteps % size;  
		}  

		if (numberOfSteps == 0 || numberOfSteps == size) 
		{  
			return headNode;
		}  

		Node leftNode = null;
		if (leftIndex == 1) 
		{  
			leftNode = headNode;  
		}  

		Node currentNode = headNode;  
		int count = 0;  
		Node endNode = null; //end node of sublist    
		Node previousOfLeftNode = null;  
		
		while (currentNode != null) 
		{  
			count++;  
			if (count == leftIndex - 1) 
			{  
				previousOfLeftNode = currentNode;  
				leftNode = currentNode.next;  
			}  
			if (count == rightIndex - numberOfSteps) 
			{  
				if (leftIndex == 1) 
				{  
					endNode = currentNode;  
					headNode = currentNode.next;  
				}  
				else 
				{  
					endNode = currentNode;    
					previousOfLeftNode.next = currentNode.next;  
				}  
			}  

			if (count == rightIndex) 
			{  
				Node nextOfRightNode = currentNode.next;  
				currentNode.next = leftNode;  
				endNode.next = nextOfRightNode;  
				Node head = headNode;   
				return head;  
			}  
			currentNode = currentNode.next;  
		}
		return headNode;
	}  

	/**
	 * To push a head node of linked list 
	 * @param head
	 * @param value
	 * @return new head node
	 */
	static Node push( Node head, int value)  
	{  
		Node newNode = new Node();  
		newNode.data = value;  
		newNode.next = head;  
		head = newNode;  
		return head; 
	}  
	
	/**
	 * To get a linked list from array
	 * @param array
	 * @return Head node of linked list
	 * @throws AssertionError : if input array is null
	 */
	public static Node getLinkedListFromArray(int array[]) throws AssertionError
	{
		if(array.length == 0)
		{
			throw new AssertionError("Null Array"); 
		}
		Node head = null;
		int lengthOfArray = array.length;
		int index = lengthOfArray - 1;
		while(index >= 0)
		{
			head = push(head, array[index]);
			index--;
		}
		return head;

	}
	
	/**
	 * 
	 * @param head
	 * @return Array of a given linked list
	 * @throws AssertionError if head node is null
	 */
	public static int[] getArrayFromLinkedList(Node head) throws AssertionError
	{
		if(head == null)
		{
			throw new AssertionError("Given Node is Null");
		}
		Node counterNode = head;
		int count = 0;
		while(counterNode != null)
		{
			count++;
			counterNode = counterNode.next;
		}
		int[] resultingArray = new int[count];

		for(int i = 0; i < count; i++)
		{
			resultingArray[i] = head.data;
			head = head.next;
		}
		return resultingArray;
	}
	
}
