import java.util.HashMap;
import java.util.Map;

/**
 * @author Ramdev
 * EmployeeOperations class is for operations with Employee class
 */
public class EmployeeOperations 
{
	Map<Integer, Employee> listOfEmployee = new HashMap<Integer, Employee>();

	/**
	 * add employee without duplicate id , if the duplicate Id is Encountered it will be avoided
	 * @param employee
	 */
	public void addEmployee(Employee employee) 
	{
		try {
			if (employee == null) 
			{
				throw new Exception("Employee cant be null");
			}
			if (listOfEmployee.get(employee.getEmpId()) == null)
				listOfEmployee.put(employee.getEmpId(), employee);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * To print the list of the employee
	 */
	public void printList() 
	{
		try {

			for (Employee employee : listOfEmployee.values())
				System.out.println(employee.toString());
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}