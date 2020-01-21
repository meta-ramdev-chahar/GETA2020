import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestIsMember 
{
	private int input;
	private Object expectedOutput;
	public TestIsMember(int input, Object output)
	{
		this.input = input;
		this.expectedOutput = output;
	}
	@Parameters
	public static Collection<Object[]> testCases()
	{
		return Arrays.asList(new Object[][]
		{
			{ 3, true },
			{ 5, false},
			{ 1, true }
			
		});	
		
	}
	@Test
	public void test_Given_Inputs_Are_Member_Or_Not() 
	{
		IntSet set = new IntSet(new int[]{1, 2, 3, 4, });
		try
		{
		assertEquals(expectedOutput, set.isMember(input));
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}

}

