import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestTransposedMethod
{
	private int[][] inputMatrix;
	private int[][] expectedOutput;

	public TestTransposedMethod(int[][] input,int[][] expectedOutput)
	{
			this.inputMatrix = input;
			this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testCases() throws IOException
	{
		return Arrays.asList(new Object[][]
		{
				{new int[][] { {1, 0, 3}, {7, 5, 4}, {0, 0, 0} }, new int[][] { {1, 7, 0}, {0, 5, 0}, {3, 4, 0} }, },
				{new int[][] { {0, 0, 1}, {0, 2, 4}, {2, 0, 7} }, new int[][] { {0, 0, 2}, {0, 2, 0}, {1, 4, 7} }, },
		});		
	}
	@Test
	public void testTransposedOfMatrix() 
	{
		try
		{
			SparseMatrix sparseMatrixObject = new SparseMatrix(inputMatrix);
			assertArrayEquals(expectedOutput, sparseMatrixObject.transpose().sparseMatrixToMatrix());
		}
		catch(AssertionError ie)
		{
			assertEquals("Length Should be Greater than zero", ie.getMessage());
		}
	}

}