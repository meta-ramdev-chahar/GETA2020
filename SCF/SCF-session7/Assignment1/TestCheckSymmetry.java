import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestCheckSymmetry
{
	private int[][] inputMatrix;
	private boolean expectedOutput;

	public TestCheckSymmetry(int[][] input , boolean expectedOutput)
	{
			this.inputMatrix = input;
			this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testCases() throws IOException
	{
		return Arrays.asList(new Object[][]
		{
				{
					new int[][] { {1, 0, 3}, {7, 5, 4}, {0, 0, 0} }, false
				},
				{
					new int[][] { {0, 0, 1}, {0, 2, 4}, {2, 0, 7} }, false
				},
				{
					new int[][] { {0, 0, 1}, {0, 1, 0}, {1, 0, 0} }, true
				},
				{
					new int[][] { {1, 0, 1}, {0, 0, 0}, {1, 0, 1} }, true
				}
		});	
		
	}

	@Test
	public void testSymeetryOfTwoSparseMatrix() 
	{
		try
		{
			SparseMatrix sparseMatrixObject = new SparseMatrix(inputMatrix); 
			assertEquals(expectedOutput, sparseMatrixObject.checkSymmetry());
		}
		catch(AssertionError ie)
		{
			assertEquals("Addition not possible", ie.getMessage());
		}
	}

}