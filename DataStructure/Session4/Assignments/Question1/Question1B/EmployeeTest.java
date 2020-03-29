import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
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
				{ new int[]{ 4, 2, 5, 1, 3 }}
				
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
			eop.sortEmployeeByName();
			int[] sortedArrayOfEmpId = new int[5];
			for(int i = 0; i < 5; i++ )
				sortedArrayOfEmpId[i] = eop.listOfEmployee.get(i).getEmpId();

			assertArrayEquals(expectedOutput, sortedArrayOfEmpId);
		
	}
	
}
