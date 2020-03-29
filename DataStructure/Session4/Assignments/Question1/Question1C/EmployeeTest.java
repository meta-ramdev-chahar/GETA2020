import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class EmployeeTest
{
	private int[] expectedOutput;

	public EmployeeTest( int[] expectedOutput)
	{
		this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testCases()
	{
		return Arrays.asList(new Object[][]
		{
				//Positive Case
				{ new int[]{1, 2, 3, 4, 5}}
				
		});	
		
	}

	@Test
	public void test()
	{
		
			EmployeeOperations eop = new EmployeeOperations();
			eop.addEmployee(new Employee(1, "rama", "churu"));
			eop.addEmployee(new Employee(5, "nilesh", "Udaipur"));
			eop.addEmployee(new Employee(3, "yash", "somewhere"));
			eop.addEmployee(new Employee(4, "dighvijay", "jaipur"));
			eop.addEmployee(new Employee(2, "lovendra", "Jaipur"));
			eop.addEmployee(new Employee(3, "yash", "somewhere"));
			eop.addEmployee(new Employee(4, "dighvijay", "jaipur"));
			eop.addEmployee(new Employee(2, "lovendra", "Jaipur"));
			
			System.out.print(eop.listOfEmployee.size());
			int[] outputArray = new int[5];
			
			List<Employee> list = new ArrayList<>(eop.listOfEmployee.values());			
			for(int i = 0; i < eop.listOfEmployee.size(); i++ )
				outputArray[i] = list.get(i).getEmpId();

			assertArrayEquals(expectedOutput, outputArray);
		
	}
	
}
