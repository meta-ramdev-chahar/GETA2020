import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author Ramdev
 * Implements methods used ..........
 */
final class SparseMatrix 
{
	private final int[][] sparseMatrix; 
	private final int numberOfRows; //number of rows of actual matrix
	private final int numberOfColumns; //number of columns of actual matrix
	private final int totalNonZeroElements;
	private final int ROW_INDEX = 0;
	private final int COL_INDEX = 1;
	private final int VALUE_INDEX = 2;
	
	/**
	 * Create SparseMatrix Object of A normal Array
	 * @param inputMatrix : 2D array of integers or normal matrix
	 */
	public SparseMatrix(int[][] inputMatrix)
	{
			this.numberOfRows = inputMatrix.length;
			this.numberOfColumns = inputMatrix[0].length;
		    this.sparseMatrix = this.matrixToSparseMatrix(inputMatrix);
		    this.totalNonZeroElements = this.sparseMatrix.length;
	}
	/**
	 * A Private constructor which is used Create SparseMatrix Object of A Sparse Array
	 * @param sparseMatrix : 2D Sparse Array representation of a Sparse matrix 
	 * @param row : number of rows
	 * @param col : number of columns
	 */
	private SparseMatrix(int[][] sparseMatrix, int row, int col)
	{
		this.numberOfRows = row;
		this.numberOfColumns = col;
		this.sparseMatrix = sparseMatrix;
		this.totalNonZeroElements = this.sparseMatrix.length;
	}
	
	/**
	 * find Sparse Matrix of normal Matrix
	 * @param inputMatrix : 2D integer array
	 * @return Sparse Matrix 
	 */
	private int[][] matrixToSparseMatrix(int[][] inputMatrix)
	{
		int row = inputMatrix.length, col = inputMatrix[0].length, counter = 0; //counter counts total non Zero elements 
		
		/**if all elements are non zero then max number or rows of sparse matrix will be row*col
		* So  create a dummy 2D array of size (row*col)*3  
		*/
		int[][] sparseMatrix = new int[row*col][3];
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				if(inputMatrix[i][j] != 0)
				{
					sparseMatrix[counter][0] = i;
					sparseMatrix[counter][1] = j;
					sparseMatrix[counter][2] = inputMatrix[i][j];
					counter++;
				}
			}
		} 
		if(counter < sparseMatrix.length)
		{
			int[][] newSparseMatrix = new int[counter][3];
			
			for(int i = 0; i < counter; i++)
			{
				newSparseMatrix[i] = sparseMatrix[i].clone();
			}
			
			return newSparseMatrix;
		}
		
		return sparseMatrix;
	}
	/**
	 * find the transposed of a matrix in when it is in the Sparse Format
	 * @return transposedSparseMatrix : Object of SparseMatrix
	 */
	public SparseMatrix transpose()
	{

		int[][] transposedArrayOfSparseMatrix = new int[this.totalNonZeroElements][3];
		int[][] localSparseMatrix = this.sparseMatrix;
		
		/**
		 * Swap 1st Column value with 2nd Column value of all Rows
		 */
		for(int i = 0; i < this.totalNonZeroElements; i++)
		{
			transposedArrayOfSparseMatrix[i][0] = localSparseMatrix[i][1];
			transposedArrayOfSparseMatrix[i][1] = localSparseMatrix[i][0];
			transposedArrayOfSparseMatrix[i][2] = localSparseMatrix[i][2];
		}
		//Sort the order as per RowColumn wise 
		transposedArrayOfSparseMatrix = sortSparseByRowColumn(transposedArrayOfSparseMatrix);
		
		SparseMatrix transposedSparseMatrix = new SparseMatrix(transposedArrayOfSparseMatrix, numberOfColumns, numberOfRows);
		
		return transposedSparseMatrix;
	}
	
	/**
	 * find A Matrix of SparseMatrix is Symmetric or not
	 * @return true if Matrix is Symmetric else false
	 */
	public boolean checkSymmetry()
	{
		if (this.numberOfRows != this.numberOfColumns)
			return false;
		
		int[][] transposedMatrix = this.transpose().sparseMatrix;
		
		int[][] thisMatrix = this.sparseMatrix;
		
		for(int i = 0; i < this.totalNonZeroElements; i++)
		{
			if( transposedMatrix[i][ROW_INDEX] != thisMatrix[i][ROW_INDEX] || transposedMatrix[i][COL_INDEX] != thisMatrix[i][COL_INDEX] || transposedMatrix[i][VALUE_INDEX] != thisMatrix[i][VALUE_INDEX] )
				return false;
		}
		
		return true;
	}
	
	/**
	 * Add two Sparse Matrix 
	 * @param firstMatrix : first sparse matrix
	 * @param secondMatrix : second sparse matrix
	 * @return Added sparse matrix
	 * @throws AssertionError when addition not possible
	 */
	public static SparseMatrix addSparseMatrices(SparseMatrix firstMatrix, SparseMatrix secondMatrix)throws AssertionError
	{
		if( firstMatrix.numberOfRows != secondMatrix.numberOfRows || firstMatrix.numberOfColumns != secondMatrix.numberOfColumns)
			throw new AssertionError("Addition not possible");
		
		int[][] addedArray = new int[firstMatrix.numberOfRows][firstMatrix.numberOfColumns];
		
		addedArray = firstMatrix.addSparseToArray(addedArray);
		addedArray = secondMatrix.addSparseToArray(addedArray);
		
		return new SparseMatrix( addedArray );
	}
	
	/**
	 * Find normal matrix from sparse matrix
	 * @return Normal matrix
	 */
	public int[][] sparseMatrixToMatrix()
	{
		int[][] normalArray = new int[this.numberOfRows][this.numberOfColumns];
		
		return addSparseToArray(normalArray);
	}
	
	/**
	 * Add SparseMatrix to A given Normal Array 
	 * @param inputArray
	 * @return
	 */
    private int[][] addSparseToArray(int[][] inputArray)
    {
    	for(int i = 0; i < this.totalNonZeroElements; i++)
		{
    		inputArray[ this.sparseMatrix[i][ROW_INDEX] ][ this.sparseMatrix[i][COL_INDEX] ] += this.sparseMatrix[i][VALUE_INDEX];
		}
    	return inputArray;
    }
    /**
     * Sort a Sparse Matrix As per RowColumn Wise 
     * @param matrix
     * @return Sorted Sparse Matrix
     */
    private int[][] sortSparseByRowColumn(int[][] matrix)
	{
		int[][] sortedMatrix = matrix;
		Arrays.sort(sortedMatrix, new Comparator<int[]>()
				{    
	        @Override              
	        public int compare(final int[] entry1, final int[] entry2)
	        { 
	            if(entry1[0] >= entry2[0])
	            {
	            	return 1;
	            } 
	            else if(entry1[0] == entry2[0] && entry1[1] >= entry2[1])
	            {
	            	return 1;
	            } 
	            else
	            {
	            	return -1;
	            }
	        } 
	        });
		
		return sortedMatrix;
	}
    /**
     * find multiplication of two sparse matrices
     * @param firstMatrix
     * @param secondMatrix
     * @return multiplication of two matrices
     * @throws AssertionError if firstMatrix's numberOfColumns not equal secondMatrix's numberOfRows
     */
    public static SparseMatrix multiplySparse(SparseMatrix firstMatrix, SparseMatrix secondMatrix) throws AssertionError
    {
    	if(firstMatrix.numberOfColumns != secondMatrix.numberOfRows)
    		throw new AssertionError("Multiply Not Possible");
    	int[][] mat1 = firstMatrix.sparseMatrixToMatrix();
    	int[][] mat2 = secondMatrix.sparseMatrixToMatrix();
    	int[][] mat3 = new int[mat1.length][mat1[0].length];
    	
        for (int i = 0; i < mat1.length; i++) 
        { 
            for (int j = 0; j < mat2.length; j++) 
            { 
                mat3[i][j] = 0; 
                for (int k = 0; k < mat2.length; k++) 
                    mat3[i][j] += mat1[i][k]  
                                * mat2[k][j]; 
            } 
        }
        return new SparseMatrix(mat3);
    }
}
