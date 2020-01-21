import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestUnion
{
	private IntSet inputSet_1;
	private IntSet inputSet_2;
	private int[] expectedOutput;
	public TestUnion(IntSet input1, IntSet input2 ,int[] output)
	{
		this.inputSet_1 = input1;
		this.inputSet_2 = input2;
		this.expectedOutput = output;
	}
	@Parameters
	public static Collection<Object[]> testCases()
	{
		return Arrays.asList(new Object[][]
		{
			{  new IntSet( new int[]{ 1, 2 }), new IntSet( new int[]{ 3, 4 }), new int[]{1, 2, 3, 4} },
			{  new IntSet( new int[]{ 1 }), new IntSet( new int[]{ 2, 3, 4 }), new int[]{1, 2, 3, 4} },
			{  new IntSet( new int[]{ }),  new IntSet( new int[]{ 1, 2, 3, 4 }), new int[]{1, 2, 3, 4}  },
			{  new IntSet( new int[]{ 1, 2, 3, 4 }), new IntSet( new int[]{ }), new int[]{1, 2, 3, 4}  }
		});	
		
	}
	@Test
	public void test_Union_OF_TwoSets() 
	{
		IntSet set = new IntSet(new int[]{ });
		try
		{
		assertArrayEquals(expectedOutput, set.union(inputSet_1,inputSet_2).toArray());
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}

}

