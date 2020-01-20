/** 
 * @author Ramdev
 * implement solveNQ, queenCanBePlacedAt, fixNQueenProblem methods
 */
public class NQueenProblem { 
    private int noOfQueens;
  
  /**
   * To check that a Queen Can be placed or not at given row and column location
   * @param board : N*N matrix where N is number of Queens
   * @param row : Row Index
   * @param col : Column Index
   * @return True if Queen can be placed at given location else return False
   */
private  boolean queenCanBePlacedAt(int board[][], int row, int col) //col stands for Column 
    { 
        int i, j; 
        /**  Check this row on left side   */
        for (i = 0; i < col; i++) 
            if (board[row][i] == 1) 
                return false; 
  
        /** Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
            if (board[i][j] == 1) 
                return false; 
  
        /** Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < noOfQueens; i++, j--) 
            if (board[i][j] == 1) 
                return false; 
  
        return true; 
    } 
  
    /**
     * To solve NQueen Problem in matrix named board
     * @param board : N*N matrix where N is number of Queens
     * @param col
     * @return 
     */
 private  boolean fixNQueenProblem(int board[][], int col) 
    {   
	    //return true when we are at last column
        if (col >= noOfQueens) 
            return true; 
        
        for (int row = 0; row < noOfQueens; row++) 
        { 
        	//check if queen can be placed or not in any row of this colomn
            if (queenCanBePlacedAt(board, row, col))
            { 
                board[row][col] = 1; 
                
                if (fixNQueenProblem(board, col + 1) == true) 
                    return true;
                
                //backtracking when if case failed that means Queen can not be placed any row of this column 
                board[row][col] = 0; 
            } 
        } 
  
        /**
         *  If the queen can not be placed in any row in 
         *  this column , then return false 
         */
        return false; 
    } 
    
    /**
     * Solve NQ problem for given number of queens
     * @param board : N*N matrix where N is number of queens
     * @param noOfQueens : number of queens
     * @return N*N matrix with solved NQ problem in this
     * @throws AssertionError when solution is not possible
     */
    int[][] solveNQ(int noOfQueens) throws AssertionError
    { 
    	this.noOfQueens = noOfQueens;
    	
    	int[][] board = createBoard(noOfQueens);
    	
    	if (fixNQueenProblem(board, 0) == false) 
        {
        	throw new AssertionError("Solution does not exist");   
        }
        return board; 
    }
    /**
     * create a board of n*n 
     * @param n : number of row and column
     * @return a n*n matrix with all values zero  
     */
    private int[][] createBoard(int n)
    {
    	int[][] createBoard = new int[n][n];
    	for(int i = 0; i < n; i++)
    	{
    		for(int j =0; j < n; j++)
    		{
    			createBoard[i][j] = 0;
    		}
    	}
    	return createBoard;
    }
  
} 
    