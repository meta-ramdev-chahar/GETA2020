import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestEvalute
{
	private int[] inputPolynomial;
	private float input;
	private Object expectedOutput;

	public TestEvalute(int[] inputArray, float input,Object expectedOutput)
	{
			this.inputPolynomial = inputArray;
			this.input = input;
			this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testCases() throws IOException
	{
		return Arrays.asList(new Object[][]
		{
				{new int[] {1, 2, 0, 4, 5 }, 1.5f, 42.8125f},
				{new int[] {0, 2, 3, 4, 5}, 100.5f, 514166053.0f},
				{new int[] {3, 2, 3, 4, 5}, 0.0f, 3.0f},
				{new int[] {}, 1.5f, "Length Should be Greater than zero"}
		});	
		
	}

	@Test
	public void test_Evaluted_Values_When_VariableValue_Is_Inputed() 
	{
		try
		{
			Poly poly1 = new Poly(inputPolynomial);
			assertEquals(expectedOutput, poly1.evaluate(input));
		}
		catch(IOException ie)
		{
			assertEquals("Length Should be Greater than zero", ie.getMessage());
		}
	}

}