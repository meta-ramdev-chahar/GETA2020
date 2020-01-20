/**
 * 
 * @author Ramdev
 * Implements the methods for Linear searching and binary searching into the array
 */
public class Search 
{
	private int startIndex;
	public Search() 
	{
		startIndex = 0;
	}
	/**
	 * find a element occur or not in given array
	 * @param inputArray : Array of Integers
	 * @param elementToBeSearched : the Integer which we want to search in the given array
	 * @return the index of elementToBeSearched inside the inputArray if not found return -1
	 * @throws AssertionError when input array in null  
	 */
	int linerSearch(int[] inputArray, int elementToBeSearched) throws AssertionError
	{
		int arrayLength = inputArray.length;
		
		if(arrayLength == 0)
			throw new AssertionError("Null Array");
		
		if(startIndex == arrayLength)
			return -1;
		
		else if( elementToBeSearched == inputArray[startIndex])
			return startIndex;
		
		else
		{   startIndex += 1;
			return linerSearch(inputArray, elementToBeSearched);
		}	
	}
	/**
	 * find a element occur or not in given array
	 * @param inputArray
	 * @param elementToBeSearched
	 * @return the index of elementToBeSearched inside the inputArray if not found return -1
	 * @throws AssertionError
	 */
	int binarySearch(int[] inputArray, int elementToBeSearched, int leftIndex, int rightIndex) throws AssertionError
	{
		int arrayLength = inputArray.length;
		
		if(arrayLength == 0)
			throw new AssertionError("Null Array");
		
		if (rightIndex >= leftIndex) { 
            int mid = leftIndex + (rightIndex - leftIndex) / 2; 
  
            if (inputArray[mid] == elementToBeSearched) 
                return mid; 
   
            if (inputArray[mid] > elementToBeSearched) 
                return binarySearch(inputArray, elementToBeSearched, leftIndex, mid - 1); 
  
            return binarySearch(inputArray, elementToBeSearched, mid + 1, rightIndex); 
        }  
        return -1;
	}
}
