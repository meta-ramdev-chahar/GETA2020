import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestCountClumps 
{
	private int[] inputArray;
	private Object expectedOutput;
	public TestCountClumps(int[] input, Object output)
	{
		this.inputArray = input;
		this.expectedOutput = output;
	}
	@Parameters
	public static Collection<Object[]> testCases()
	{
		return Arrays.asList(new Object[][]
		{
			{ new int[] { 1, 2, 2, 3, 4, 4 }, 2 },
			{ new int[] { 1, 1, 2, 1, 1 }, 2 },
			{ new int[] { 1, 1, 1, 1, 1 }, 1 },
			{ new int[] {}, "Null Array"}
		});	
		
	}
	@Test
	public void test() 
	{
		ArrOperations countClumpsObject = new ArrOperations();
		try
		{
		assertEquals(expectedOutput, countClumpsObject.countClumps(inputArray));
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}

}

