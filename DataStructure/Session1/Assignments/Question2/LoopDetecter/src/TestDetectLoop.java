import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestDetectLoop
{
	private int[] inputarray;
	private boolean expectedOutput;

	public TestDetectLoop(int[] inputarray, boolean expectedOutput)
	{
		this.inputarray = inputarray;
		this.expectedOutput = expectedOutput;
	}
	
	
	@Parameters
	public static Collection<Object[]> testCases()
	{
		return Arrays.asList(new Object[][]
		{
				//Positive Case
				{ new int[]{2, 3, 4, 5, 6, 7, 2}, true},
				
				//Negative Case
				{ new int[]{2, 3, 4, 5, 5, 6, 7}, false},
				
				//Null Array Negative case
				{ new int[]{}, true },
				
				//Negative case
				{ new int[]{2, 3}, false},
				
				//Negative case
				{ new int[]{2, 3, 3}, false},
				
				//Positive case
				{ new int[]{3, 2, 3}, true},
		});	
		
	}

	@Test
	public void test()
	{
		try
		{
			DetectLoop.Node head = DetectLoop.getLinkedListFromArray(inputarray);
			assertEquals(expectedOutput, DetectLoop.findLoop(head));
		}
		catch(AssertionError ae)
		{
			assertEquals("Null Array", ae.getMessage());
		}
	}
	
}
