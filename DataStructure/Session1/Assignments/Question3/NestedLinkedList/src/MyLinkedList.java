/**
 * 
 * @author Ramdev
 * MyLinkedList class implements the methods to get degree of multivariate polynomial using nested Linked List  
 */
public class MyLinkedList 
{
	Node head;

	public MyLinkedList()
	{
		head = null;
	}

	/**
	 * 
	 * @author Ramdev
	 * Implement node of a Linked List
	 */
	class Node 
	{ 
		int data; 
		Node next, child; 

		Node(int d) 
		{ 
			data = d; 
			next = child = null; 
		}
	}

	/**
	 * To get a multivariate Polynomial from a 2d Array
	 * @param array
	 * @return head node of polynomial
	 * @throws AssertionError
	 */
	public Node getMultivariatePolynomial(int[][] array)throws AssertionError
	{
		if(array.length == 0)
			throw new AssertionError("Null Array");
		for(int i = array.length - 1; i >= 0 ; i--)
		{
			if(array[i][0] == 0)
				throw new AssertionError("Invalid Coficient");
			this.head = push(this.head, array[i][0]);

			Node headOfChildList = null;
			//Creating child for this node
			for(int j = array[0].length - 1; j > 0 ; j--)
			{
				headOfChildList = push(headOfChildList, array[i][j]);
			}

			this.head = pushChild(this.head, headOfChildList);
		}


		return this.head;
	}

	/**
	 * To push a node in linked list
	 * @param head
	 * @param value
	 * @return Head node after pushing new head node
	 */
	Node push( Node head, int value)  
	{  
		Node newNode = new Node(value);  
		newNode.next = head;  
		head = newNode;  
		return head; 
	}
	/**
	 * To push a new child list to a node of parent list
	 * @param head
	 * @param headOfChildList
	 * @return head of parent list where the child node is inserted
	 */
	Node pushChild(Node head, Node headOfChildList)
	{
		head.child = headOfChildList;
		return head;
	}

	/**
	 * To get degree of polynomial
	 * @param head
	 * @return Degree of polynomial
	 */
	public int getDegreeOfPolynomial(Node head)
	{
		int degree = 0, temp = 0 ; 
		while(head!= null)
		{
			if(head.child != null )
			{
				temp = getDegree(head.child);
			}
			if(temp > degree)
			{
				degree = temp;
			}
			head = head.next;
		}
		return degree;
	}
	/**
	 * To get degree of a term of Polynomial 
	 * @param head
	 * @return
	 */
	private int getDegree(Node head)
	{
		int degree = 0;
		while(head != null)
		{
			degree += head.data;
			head = head.next;
		}
		return degree;
	}
}