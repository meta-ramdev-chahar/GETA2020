import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestGetCompliment 
{
	private int input;
	private Object expectedOutput;
	public TestGetCompliment(int input, Object output)
	{
		this.input = input;
		this.expectedOutput = output;
	}
	@Parameters
	public static Collection<Object[]> testCases()
	{
		return Arrays.asList(new Object[][]
		{
				{ 4, false },
				{ 3, false },
				{ 2, false },
				{ 1, false },
				{ 5, true }
		});	
		
	}
	//test compliment of set true when is member results false for those elements
	@Test
	public void test_ComplimentOfSet() 
	{
		IntSet set = new IntSet(new int[]{1, 2, 3, 4 });
		IntSet complimentedSet = set.getComplement();
		try
		{
			assertEquals(expectedOutput, complimentedSet.isMember(input));
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}

}

