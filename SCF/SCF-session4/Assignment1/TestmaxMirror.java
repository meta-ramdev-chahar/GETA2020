import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestmaxMirror 
{
	private int[] inputArray;
	private Object expectedOutput;
	public TestmaxMirror(int[] input, Object output)
	{
		this.inputArray = input;
		this.expectedOutput = output;
	}
	@Parameters
	public static Collection<Object[]> testCases()
	{
		return Arrays.asList(new Object[][]
		{
			{ new int[] { 1, 2, 3, 8, 9, 3, 2, 1 }, 3 },
			{ new int[] { 7, 1, 4, 9, 7, 4, 1 }, 2 },
			{ new int[] { 1, 2, 1, 4 }, 3 },
			{ new int[] { 1, 4, 5, 3, 5, 4, 1 }, 7 },
			{ new int[] {}, "Null Array"}
		});	
		
	}
	@Test
	public void test() 
	{
		ArrOperations maxMirrorObject = new ArrOperations();
		try
		{
		assertEquals(expectedOutput, maxMirrorObject.maxMirror(inputArray));
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}

}
