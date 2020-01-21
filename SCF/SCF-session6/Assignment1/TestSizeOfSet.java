import static org.junit.Assert.*;

//import java.util.Arrays;
//import java.util.Collection;

import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//import org.junit.runners.Parameterized.Parameters;

//@RunWith(Parameterized.class)
public class TestSizeOfSet 
{
	/** MAY BE USEFULL IN FUTURE
	 * private Object expectedOutput;
	 * @param output
	
	public TestSizeOfSet(Object output)
	{
		this.expectedOutput = output;
	}
	@Parameters
	public static Collection<Object[]> testCases()
	{
		return Arrays.asList(new Object[][]
		{
			{5}
		});	
		
	}
	*/
	@Test
	public void test_SizeOfSet_WhenElementsAre_Repetitive() 
	{
		IntSet set = new IntSet(new int[]{1, 2, 5, 3, 4 ,4, 4});
		try
		{
		assertEquals(5, set.size());
		}
		catch(AssertionError ae)
		{
			assertEquals("Invalied input found", ae.getMessage());
		}
	}
	
	@Test
	public void test_SizeOfSet_WhenElementsAre_NotRepetitive() 
	{
		IntSet set = new IntSet(new int[]{ 2, 5, 3, 7 , 4});
		try
		{
		assertEquals(5, set.size());
		}
		catch(AssertionError ae)
		{
			assertEquals("Invalied input found", ae.getMessage());
		}
	}

}

