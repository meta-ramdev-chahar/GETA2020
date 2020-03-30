/**
 * 
 * @author Ramdev
 * Implement LinkedList Of Employee and Sorting method for it using insertation sort
 */
public class LinkedListIS  
{ 
	node head; 
	node sorted; 
	/**
	 * 
	 * @author Ramdev
	 * Implement node of LinkedList
	 */
	class node  
	{ 
		Employee employee; 
		node next; 

		public node(Employee newEmployee)  
		{ 
			this.employee = new Employee(newEmployee.getName(), newEmployee.getSalary(), newEmployee.getAge());
		} 
	} 
	/**
	 * To push new node to a linkedlist
	 * @param employee 
	 */
	void push(Employee employee)  
	{ 
		node newnode = new node(employee); 
		newnode.next = head; 
		head = newnode; 
	} 

	/**
	 * To sort linked list using Insertation sort
	 * @param headref
	 */
	void insertionSort(node headref)  
	{ 

		sorted = null; 
		node current = headref; 
		while (current != null)  
		{ 

			node next = current.next; 
			sortedInsert(current); 

			current = next; 
		} 

		head = sorted; 
	} 

	/**
	 * To insert a new_node in a list. But at Sorted place
	 * @param newnode : new node to be inserted 
	 */
	void sortedInsert(node newnode)  
	{ 
		/* Special case for the head end */
		if (sorted == null || sorted.employee.getSalary() >= newnode.employee.getSalary())  
		{ 
			newnode.next = sorted; 
			sorted = newnode; 
		}
		else 
		{ 
			node current = sorted; 
			/* Locate the node before the point of insertion */
			while (current.next != null && ( current.next.employee.getSalary() > newnode.employee.getSalary()))  
			{ 
				current = current.next; 
			} 
			newnode.next = current.next; 
			current.next = newnode; 
		} 
	} 

	/**
	 * To print a linked list
	 * @param head
	 */
	void printlist(node head)  
	{ 
		while (head != null)  
		{ 
			System.out.print(head.employee.getName() + " "); 
			head = head.next; 
		} 
	} 

	public static void main(String[] args)  
	{ 
		LinkedListIS list = new LinkedListIS(); 
		list.push(new Employee("rama", 15000, 23)); 
		list.push(new Employee("nilesh", 2500, 27)); 
		list.push(new Employee("yash", 2500, 25)); 
		list.push(new Employee("dighvijay", 3500, 20)); 
		list.push(new Employee("lovendra", 500, 20)); 
		System.out.println("Linked List before Sorting.."); 
		list.printlist(list.head); 
		list.insertionSort(list.head); 
		System.out.println("\nLinkedList After sorting"); 
		list.printlist(list.head); 
	} 
}