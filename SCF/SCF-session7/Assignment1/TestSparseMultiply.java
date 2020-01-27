import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestSparseMultiply
{
	private int[][] inputMatrixOne;
	private int[][] inputMatrixTwo;
	private int[][] expectedOutput;

	public TestSparseMultiply(int[][] input1, int[][] input2 , int[][] expectedOutput)
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
					new int[][] { {1, 1, 1, 1},{2, 2, 2, 2},{3, 3, 3, 3},{4, 4, 4, 4} },
					new int[][] { {1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3},{4, 4, 4, 4} },
					new int[][] { {10, 10, 10, 10} ,{20, 20, 20, 20}, {30, 30, 30, 30}, {40, 40, 40, 40}  }
				},
				{
					new int[][] { {1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 0 } },
					new int[][] { {1, 0, 0 }, { 0, 0, 1 }, { 0, 1, 0 } },
					new int[][] { {1, 1, 0 }, { 0, 0, 1 }, { 1, 0, 0 } }
				}
		});	
		
	}

	@Test
	public void testMultiplyOfTwoSparseMatrix() 
	{
		try
		{
			SparseMatrix smOne = new SparseMatrix(inputMatrixOne); 
			SparseMatrix smTwo = new SparseMatrix(inputMatrixTwo);
			assertArrayEquals(expectedOutput, SparseMatrix.multiplySparse(smOne, smTwo).sparseMatrixToMatrix());
		}
		catch(AssertionError ie)
		{
			assertEquals("Addition not possible", ie.getMessage());
		}
	}
	@Test(expected = AssertionError.class)
	public void testMultiplyOfTwoSparseMatrix_AssertionError()
	{   
		int[][] matrixOne = new int[][] { {1, 2}, {0, 3} };
		int[][] matrixTwo = new int[][] { {0, 0, 1}, {0, 2, 4}, {2, 0, 7} };
		SparseMatrix smOne = new SparseMatrix(matrixOne); 
		SparseMatrix smTwo = new SparseMatrix(matrixTwo);
		SparseMatrix.multiplySparse(smOne, smTwo);
	}

}
