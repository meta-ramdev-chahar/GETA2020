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
	 * To add the employee in the list 
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
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * To perform sorting of the employee on the basis of empName
	 */
	public void sortEmployeeByName() 
	{
		Collections.sort(listOfEmployee, Employee.sortByNameComparator);
	}

	/**
	 *To  print the list of Employee
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