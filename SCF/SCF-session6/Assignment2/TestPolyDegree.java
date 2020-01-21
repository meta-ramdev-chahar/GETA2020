import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestPolyDegree
{
	private int[] inputPolynomial;
	private Object expectedOutput;

	public TestPolyDegree(int[] inputArray,Object expectedOutput)
	{
			this.inputPolynomial = inputArray;
			this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testCases() throws IOException
	{
		return Arrays.asList(new Object[][]
		{
				{new int[] {1, 2, 0, 4, 5 }, 4},
				{new int[] {0, 2, 3, 4, 5 , 7}, 5},
				{new int[] {3, 2,  4, 5}, 3},
				{new int[] {},  "Length Should be Greater than zero"}
		});	
		
	}

	@Test
	public void test_DegreeOf_PolyNomial() 
	{
		try
		{
			Poly poly1 = new Poly(inputPolynomial);
			assertEquals(expectedOutput, poly1.degree());
		}
		catch(IOException ie)
		{
			assertEquals("Length Should be Greater than zero", ie.getMessage());
		}
	}

}