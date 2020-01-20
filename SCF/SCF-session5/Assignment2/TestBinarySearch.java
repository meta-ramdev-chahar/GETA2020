import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestBinarySearch
{
	private int[] inputArray;
	private int elementToBeSearched;
	private int leftIndex;
	private int rightIndex;
	private Object expectedOutput;
	public TestBinarySearch(int[] input1, int input2, int input3, int input4, Object output)
	{
		this.inputArray = input1;
		this.elementToBeSearched = input2;
		this.leftIndex = input3;
		this.rightIndex = input4;
		this.expectedOutput = output;
	}
	@Parameters
	public static Collection<Object[]> testCases()
	{
		return Arrays.asList(new Object[][]
		{
				{ new int[] { 1, 2, 2, 3, 4, 4 }, 2, 0, 5, 1 },
				{ new int[] { 1, 1, 2, 1, 1 }, 2, 0, 4, 2 },
				{ new int[] { 1, 1, 1, 1, 1 }, 1, 0, 4, 0 },
				{ new int[] { 8, 7, 6, 6, 4 }, 1, 0, 4, -1 },
				{ new int[] {}, 3, 0, 0, "Null Array"}
			
		});	
		
	}
	@Test
	public void test() 
	{
		Search searchBy = new Search();
		try
		{
		assertEquals(expectedOutput, searchBy.binarySearch(inputArray, elementToBeSearched, leftIndex, rightIndex ));
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}

}

