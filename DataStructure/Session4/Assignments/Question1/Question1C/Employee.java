/**
 * @author Ramdev
 * Employee class is to keep data of employee
 *
 */
public class Employee
{
	int empId;
	String empName;
	String empAddress;

	public Employee(int empId, String empName, String empAddress) 
	{

		try
		{
			if(empAddress == null|| empName == null)
			{
				throw new Exception("Employee cant be null");
			}
			this.empId = empId;
			this.empName = empName;
			this.empAddress = empAddress;
		}
		catch(Exception e)
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

	@Override
	public String toString() 
	{
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + "]";
	}

}