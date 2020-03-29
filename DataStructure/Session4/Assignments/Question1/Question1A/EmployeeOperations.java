
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ramdev 
 * EmployeeOperations class is for operations with Employee class
 */
public class EmployeeOperations 
{
	List<Employee> listOfEmployee = new ArrayList<Employee>();

	/**
	 * To add employee object to list using the collection
	 * @param employee
	 */
	public void addEmployee(Employee employee)
	{
		try {
			if (employee == null) 
			{
				throw new Exception("Employee cant be null");
			}
			listOfEmployee.add(employee);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * To sort the employee object using the comparable by EmpId
	 */
	public void sortedList() 
	{
		Collections.sort(listOfEmployee);
	}

	/**
	 *To print the list of employee object
	 */
	public void printList() 
	{
		try {
			for (int i = 0; i < listOfEmployee.size(); i++) 
			{
				System.out.println(listOfEmployee.get(i).toString());
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}