import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestAddMetrixMethod
{
	private int[][] inputMatrixOne;
	private int[][] inputMatrixTwo;
	private int[][] expectedOutput;

	public TestAddMetrixMethod(int[][] input1, int[][] input2 , int[][] expectedOutput)
	{
			this.inputMatrixOne = input1;
			this.inputMatrixTwo = input2;
			this.expectedOutput = expectedOutput;
	}
	
	@Parameters
	public static Collection<Object[]> testCases() throws IOException
	{
		return Arrays.asList(new Object[][]
		{
				{
					new int[][] { {1, 0, 3}, {7, 5, 4}, {0, 0, 0} },
					new int[][] { {1, 7, 0}, {0, 5, 0}, {3, 4, 0} },
					new int[][] { {2, 7, 3}, {7, 10, 4}, {3, 4, 0} }
				},
				{
					new int[][] { {0, 0, 1}, {0, 2, 4}, {2, 0, 7} }, 
					new int[][] { {0, 0, 2}, {0, 2, 0}, {1, 4, 7} },
					new int[][] { {0, 0, 3}, {0, 4, 4}, {3, 4, 14} }
				},
		});	
		
	}

	@Test
	public void testAddtionOfTwoSparseMatrix() 
	{
		try
		{
			SparseMatrix smOne = new SparseMatrix(inputMatrixOne); 
			SparseMatrix smTwo = new SparseMatrix(inputMatrixTwo);
			assertArrayEquals(expectedOutput, SparseMatrix.addSparseMatrices(smOne, smTwo).sparseMatrixToMatrix());
		}
		catch(AssertionError ie)
		{
			assertEquals("Addition not possible", ie.getMessage());
		}
	}
	@Test(expected = AssertionError.class)
	public void testAddtionOfTwoSparseMatrix_AssertionError()
	{   
		int[][] matrixOne = new int[][] { {1, 2}, {0, 3} };
		int[][] matrixTwo = new int[][] { {0, 0, 1}, {0, 2, 4}, {2, 0, 7} };
		SparseMatrix smOne = new SparseMatrix(matrixOne); 
		SparseMatrix smTwo = new SparseMatrix(matrixTwo);
		SparseMatrix.addSparseMatrices(smOne, smTwo);
	}

}