import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestLcm
{
	private int firstInput;
	private int secondInput;
	private Object expectedOutput;
	public TestLcm(int input1, int input2, Object output)
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
			{ 6, 8, 24 },
			{ 4, -4, "Values Should be Positive and greater than one"},
			{ 6, 0, "Values Should be Positive and greater than one"},
			{ 5, 5, 5 },
			{ 13, 7, 91},
		});	
		
	}
	@Test
	public void test() 
	{
		LcmHcf lcmObject = new LcmHcf();
		try
		{
		assertEquals(expectedOutput, lcmObject.lcm(firstInput, secondInput));
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}

}

