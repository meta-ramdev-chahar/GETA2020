import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestLinkedList
{
	private int[] inputarray;
	private int leftIndex, rightIndex, numberOfSteps;
	private int[] expectedOutput;

	public TestLinkedList(int[] inputarray, int leftIndex, int rightIndex, int numberOfSteps, int[] expectedOutput)
	{
		this.inputarray = inputarray;
		this.leftIndex = leftIndex;
		this.rightIndex = rightIndex;
		this.numberOfSteps = numberOfSteps;
		this.expectedOutput = expectedOutput;
	}
	
	
	@Parameters
	public static Collection<Object[]> testCases()
	{
		return Arrays.asList(new Object[][]
		{
				//Positive Case
				{ new int[]{2, 3, 4, 5, 6, 7}, 2, 5, 2, new int[]{2, 5, 6, 3, 4, 7} },
				
				//When number of Steps equals to size of sublist (No impact case)
				{ new int[]{2, 3, 4, 5, 6, 7}, 2, 5, 4, new int[]{2, 3, 4, 5, 6, 7} },
				
				//Null Array Negative case
				{ new int[]{}, 2, 5, 4, new int[]{} },
				
				//When number of Steps is zero (No impact case)
				{ new int[]{2, 3, 4, 5, 6, 7}, 2, 5, 0, new int[]{2, 3, 4, 5, 6, 7} },
		});	
		
	}

	@Test
	public void test()
	{
		try
		{
			LinkedList.Node head = LinkedList.getLinkedListFromArray(inputarray);
			head = LinkedList.rotateSubList(head, leftIndex, rightIndex, numberOfSteps);
			assertArrayEquals(expectedOutput, LinkedList.getArrayFromLinkedList(head) );
		}
		catch(AssertionError ae)
		{
			assertEquals("Null Array", ae.getMessage());
		}
	}
	
}
