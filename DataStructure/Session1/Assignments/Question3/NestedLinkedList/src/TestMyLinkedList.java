import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestMyLinkedList
{
	private int[][] inputarray;
	private int expectedOutput;

	public TestMyLinkedList(int[][] inputarray, int expectedOutput)
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
				{ new int[][]{{2,3,4,5},{3,4,5,6},{5,0,0,0},{2,7,7,7}}, 21 },
				{ new int[][]{{2,3,4,5},{3,4,5,6},{3,34,0,0},{2,7,7,7}}, 34 },

				//negative Case
				{ new int[][]{{2,3,4,5},{3,4,5,6},{0,34,0,0},{2,7,7,7}}, 1 },
				});	

	}

	@Test
	public void test()
	{
		try
		{
			MyLinkedList list = new MyLinkedList();
			list.getMultivariatePolynomial(inputarray);
			assertEquals(expectedOutput, list.getDegreeOfPolynomial(list.getMultivariatePolynomial(inputarray)) );
		}
		catch(AssertionError ae)
		{
			assertEquals("Invalid Coficient", ae.getMessage());
		}
	}

}
