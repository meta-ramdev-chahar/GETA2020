import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestLinerSearch
{
	private int[] inputArray;
	private int elementToBeSearched;
	private Object expectedOutput;
	public TestLinerSearch(int[] input1, int input2, Object output)
	{
		this.inputArray = input1;
		this.elementToBeSearched = input2;
		this.expectedOutput = output;
	}
	@Parameters
	public static Collection<Object[]> testCases()
	{
		return Arrays.asList(new Object[][]
		{
				{ new int[] { 1, 2, 2, 3, 4, 4 }, 2, 1 },
				{ new int[] { 1, 1, 2, 1, 1 }, 2, 2 },
				{ new int[] { 1, 1, 1, 1, 1 }, 1, 0 },
				{ new int[] { 8, 7, 6, 6, 4 }, 1, -1 },
				{ new int[] {}, 3,  "Null Array"}
			
		});	
		
	}
	@Test
	public void test() 
	{
		Search searchBy = new Search();
		try
		{
		assertEquals(expectedOutput, searchBy.linerSearch(inputArray, elementToBeSearched));
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}

}

