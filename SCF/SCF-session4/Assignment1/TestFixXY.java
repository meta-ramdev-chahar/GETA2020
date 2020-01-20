import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestFixXY
{

	private int[] inputArray;
	private int x;
	private int y;
	private int[] expectedOutput;
	private ArrOperations fixXYObject = new ArrOperations();

	public TestFixXY(int[] input, int x, int y, int[] expectedOutput)
	{
			this.inputArray = input;
			this.expectedOutput = expectedOutput;
			this.x = x;
			this.y = y;
	}
	
	@Parameters
	public static Collection<Object[]> testCases()
	{
		return Arrays.asList(new Object[][]
		{
				{new int[] {5, 4, 9, 4, 9, 5}, 4, 5, new int[] {9, 4, 5, 4, 5, 9}}, 
				{new int[] {1, 4, 1, 5}, 4, 5, new int[] {1, 4, 5, 1}}, 
				{new int[] {1, 4, 1, 5, 5, 4, 1}, 4, 5, new int[] {1, 4, 5, 1, 1, 4, 5}}
		});	
		
	}

	@Test
	public void test()
	{
		try
		{
			assertArrayEquals(expectedOutput, fixXYObject.fixXY(inputArray, x, y));
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}
	
	@Test(expected = AssertionError.class)
	public void test1()
	{   
		int[] inputArray = {};
		fixXYObject.fixXY(inputArray, 4, 5);
	}
	
	@Test(expected = AssertionError.class)
	public void test2()
	{   
		int[] inputArray =  {5, 4, 9, 2, 5, 4, 5, 6};
		fixXYObject.fixXY(inputArray, 4, 5);
	}
	
	@Test(expected = AssertionError.class)
	public void test3()
	{   
		int[] inputArray = {5, 1, 4, 4, 7, 5};
		fixXYObject.fixXY(inputArray, 4, 5);
	}
	@Test(expected = AssertionError.class)
	public void test4()
	{   
		int[] inputArray = {5, 1, 4, 5, 4};
		fixXYObject.fixXY(inputArray, 4, 5);
	}
}