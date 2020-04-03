/**
 * 
 * @author Ramdev
 * LinkedList Sorting
 */
class Question3 
{

	static class Node 
	{
		Employee data;
		Node next = null;

		public Node(Employee emp) 
		{
			this.data = emp;
		}
	}

	static class LinkedList 
	{
		Node head = null;
		Node tail = null;


		public Node getHead() 
		{
			return head;
		}

		public Node getTail() 
		{
			return tail;
		}

		void insert(Employee data) 
		{
			Node newNode = new Node(data);
			if (this.head == null) 
			{
				this.head = newNode;
				this.tail = newNode;
			} else 
			{
				this.tail.next = newNode;
				this.tail = newNode;
			}
		}
	}

	static Node paritionLast(Node start, Node end) 
	{ 
		if(start == end || start == null || end == null) 
		{ 
			return start; 
		}

		Node pivot_prev = start; 
		Node curr = start;  
		Employee pivot = end.data;  

		while(start != end ) 
		{ 
			if((start != null && pivot != null) && (start.data.getSalary() > pivot.getSalary() 
					|| (start.data.getSalary() == pivot.getSalary() && start.data.getAge() < pivot.getAge()))) 
			{  
				pivot_prev = curr;  
				Employee temp = curr.data;  
				curr.data = start.data;  
				start.data = temp;  
				curr = curr.next;  
			} 
			start = start.next;  
		}
		
		Employee temp = curr.data;  
		curr.data = pivot;  
		end.data = temp;  
		return pivot_prev; 
	} 

	static void sort(Node start, Node end) 
	{ 
		if(start == end ) 
		{ 
			return; 
		}	
		Node pivot_prev = paritionLast(start, end); 
		sort(start, pivot_prev); 
		sort(pivot_prev.next, end);
	} 


	static void display(LinkedList linkedList) 
	{
		Node i = linkedList.head;
		while (i != null) 
		{
			System.out.println(i.data);
			i = i.next;
		}
	}

	/*public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.insert(new Employee("rama", 15000, 23)); 
		l.insert(new Employee("nilesh", 2500, 27)); 
		l.insert(new Employee("yash", 2500, 28)); 
		l.insert(new Employee("dighvijay", 3500, 20)); 
		l.insert(new Employee("lovendra", 500, 20)); 
		System.out.println("Linked List before Sorting.."); 
		Question3.display(l);

		Question3.sort(l.getHead(), l.getTail()); 

		System.out.println("\nLinkedList After sorting"); 
		Question3.display(l);
	}*/
}