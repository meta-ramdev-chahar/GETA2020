/**
 * @author Ramdev
 * Employee class is to keep data of employee
 *
 */
public class Employee implements Comparable<Employee> 
{
	int empId;
	String empName;
	String empAddress;

	public Employee(int empId, String empName, String empAddress) 
	{
		try
		{
			if (empAddress == null || empName == null) 
			{
				throw new Exception("Employee can't be null");
			}
			this.empId = empId;
			this.empName = empName;
			this.empAddress = empAddress;
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public int getEmpId() 
	{
		return empId;
	}

	public void setEmpId(int empId) 
	{
		this.empId = empId;
	}

	public String getEmpName() 
	{
		return empName;
	}

	public void setEmpName(String empName) 
	{
		this.empName = empName;
	}

	public String getempAddress() 
	{
		return empAddress;
	}

	public void setEmpAdresses(String empAddress) 
	{
		this.empAddress = empAddress;
	}

	/**
	 * To perform sorting of employee on the basis of the Id using the comparable
	 */
	@Override
	public int compareTo(Employee employee) 
	{
		int empId = 0;
		try 
		{
			empId = employee.getEmpId();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		// For Ascending order 
		return this.empId - empId;

	}

	@Override
	public String toString() 
	{
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + "]";
	}

}