import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestNQueenProblem
{
	private int noOfQueens;
	private int[][] expectedOutput;
	private NQueenProblem queen= new NQueenProblem();

	public TestNQueenProblem(int input1, int[][] expectedOutput)
	{
		this.noOfQueens = input1;
		this.expectedOutput = expectedOutput;
	}
	
	
	@Parameters
	public static Collection<Object[]> testCases()
	{
		return Arrays.asList(new Object[][]
		{
				{ 4, new int[][] { {0, 0, 1, 0},
								   {1, 0, 0, 0},
	    						   {0, 0, 0, 1},
								   {0, 1, 0, 0} }
				},
				{
				  1 , new int[][] {{1}}
				}
		});	
		
	}

	@Test
	public void test()
	{
		try
		{
			assertArrayEquals(expectedOutput, queen.solveNQ( noOfQueens));
		}
		catch(AssertionError ae)
		{
			assertEquals(expectedOutput, ae.getMessage());
		}
	}


	 @Test(expected = AssertionError.class)
	 
	public void test1()
	{   
		queen.solveNQ(2);
	}
	
	@Test(expected = AssertionError.class)
	public void test2()
	{   
        queen.solveNQ(3);
	}
	
}