import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestIsSubSet 
{
	private IntSet input;
	private Object expectedOutput;
	public TestIsSubSet(IntSet input, Object output)
	{
		this.input = input;
		this.expectedOutput = output;
	}
	@Parameters
	public static Collection<Object[]> testCases()
	{
		return Arrays.asList(new Object[][]
		{
			{  new IntSet( new int[]{ 1, 2 }), true },
			{  new IntSet( new int[]{ 1, 2 , 5}),  false},
			{  new IntSet( new int[]{ 1, 2, 3, 4 }),  true }
		});	
		
	}
	@Test
	public void test_GivenInputSet_IS_Member_Or_Not() 
	{
		IntSet set = new IntSet(new int[]{1, 2, 3, 4 });
		try
		{
		assertEquals(expectedOutput, set.isSubSet(input));
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}

}

