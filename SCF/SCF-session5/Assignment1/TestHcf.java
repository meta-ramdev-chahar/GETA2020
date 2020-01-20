import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestHcf
{
	private int firstInput;
	private int secondInput;
	private Object expectedOutput;
	public TestHcf(int input1, int input2, Object output)
	{
		this.firstInput = input1;
		this.secondInput = input2;
		this.expectedOutput = output;
	}
	@Parameters
	public static Collection<Object[]> testCases()
	{
		return Arrays.asList(new Object[][]
		{
			{ 6, 8, 2 },
			{ 4, -4, "Values Should be Positive"},
			{ 6, 0, 6 },
			{ 5, 5, 5 },
			{ 13, 7, 1}
		});	
		
	}
	@Test
	public void test() 
	{
		LcmHcf hcfObject = new LcmHcf();
		try
		{
		assertEquals(expectedOutput, hcfObject.hcf(firstInput, secondInput));
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}

}

