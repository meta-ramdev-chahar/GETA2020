import java.util.HashSet;
import java.util.Set;
/**
 * 
 * @author Ramdev
 * This class implements the methods to find out the loop inside a LinkedList
 * 
 */
class DetectLoop 
{
	/**
	 * 
	 * Node of a Linked List
	 *
	 */
	static class Node 
	{
		int value;
		Node next = null;

		public Node(int value)
		{
			this.value = value;
		}
	}
	/**
	 * TO push a new head of a linked list
	 * @param head
	 * @param value
	 * @return the new Head of Linked list
	 */
	static Node push( Node head, int value)  
	{  
		Node newNode = new Node(value);    
		newNode.next = head;  
		head = newNode;  
		return head; 
	}
	/**
	 * To find the loop in a linked list
	 * @param head
	 * @return true if loop found else false
	 */
	public static boolean findLoop(Node head) 
	{
		if (head.next == null || head.next.next == null) 
		{
			return false;
		}
		int count = 0;
		int countinuesSame = 0;
		Set<Integer> setOfNodeValues = new HashSet<Integer>();
		while (head != null)
		{
			if(head.next != null && head.value == head.next.value)
				countinuesSame++;
			count++;
			setOfNodeValues.add(head.value);
			head = head.next;
		}
		if(setOfNodeValues.size() + countinuesSame < count)
			return true;
		return false;
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
}