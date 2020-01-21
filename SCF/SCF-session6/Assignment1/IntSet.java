/**
 * 
 * @author Ramdev
 * Implement the methods used in set operations Like isMember, size, isSubset , getCompliment, union
 */
final class IntSet 
{
	private final int[] set;
	private final int MAXSIZE = 1000; // maximum Size of element that can be stored in a array
	/**
	 * initialize the set by Integer array having values between 1 to 1000
	 * @param set : array of integer
	 */
	public IntSet(int[] set) 
	{
		
		int arr[] = this.repetitiveRemover(set);
 		this.set = arr; 
	}
	
	/**
	 * check an element is member or not of a set
	 * @param element : set element
	 * @return true if given element is a member of set else false
	 */
	public boolean isMember(int element)
	{
		for(int i = 0; i < this.size(); i++ )
		{
			if(element == this.set[i])
				return true;
		}
		return false;
	}
	/**
	 * find a element in array
	 * @param inputArray
	 * @param element
	 * @return true if element found else false
	 */
	private boolean isInArray(int[] inputArray, int element)
	{
		for(int i = 0; i < inputArray.length; i++ )
		{
			if(element == inputArray[i])
				return true;
		}
		return false;
	}
	/**
	 * find the size of the set
	 * @return the length of set array
	 */
	public int size()
	{
		return this.set.length;
	}
	
	/**
	 * find given set is subset or not of another
	 * @param inputSet : input set
	 * @return true if given set if subset else false
	 */
	public boolean isSubSet(IntSet inputSet)
	{
		for(int i = 0; i < inputSet.size(); i++)
		{
			if( !this.isMember(inputSet.set[i]) )
				return false;
		}
		return true;
	}
	/**
	 * Find the compliment of given set
	 * @param complimentingSet : array of element that has to be complimented
	 * @return complimented set;
	 */
	
	public IntSet getComplement( )
	{
		int[] newArray = new int[MAXSIZE - this.set.length]; // create a new array
		int  newArrayIndex = 0;
		
		for(int i = 1; i <= MAXSIZE; i++ )  // assign all elements to this new array which are not member of this set 
		{
			if( !this.isMember(i) )
			{
				newArray[newArrayIndex] = i;
				newArrayIndex++;
			}
		}
		IntSet complimentedSet = new IntSet(newArray); // create the set of this array
		return complimentedSet;
	}
	/**
	 * find the union of two sets
	 * @param firstSet : First set
	 * @param secondSet : Second set
	 * @return the Union of First Set and Second Set
	 */
    public IntSet union(IntSet firstSet, IntSet secondSet)
    {
    	int[] combinedArray = new int[firstSet.size() + secondSet.size()]; // create new array
    	
    	/**
    	 *  assign all elements of first and second set to this array
    	 */
    	for(int i = 0; i < firstSet.size(); i++) 
    		combinedArray[i] = firstSet.set[i];
    	
    	for(int i = firstSet.size(), secondSetIndex = 0; i < firstSet.size() + secondSet.size(); i++, secondSetIndex++)
    		combinedArray[i] = secondSet.set[secondSetIndex];
    	
    	IntSet unionSet = new IntSet(combinedArray); //create the set of this array
    	return unionSet;
    }
    
    /**
     * Truncate a array after occurrence of decider
     * @param inputArray
     * @param decider : it is an integer which indicates that this is the end of array
     * @return truncated array
     */
    private int[] arrayTruncater(int[] inputArray, int decider)
    {
    	int newLength = 0;
    	
    	// find the number of required elements or required length from given inputArray
    	while(inputArray[newLength] != decider) 
    		newLength++;
    	
    	//create new array of required length
    	int[] truncatedArray = new int[newLength];
    	
    	//assign all starting elements of input array to this new array
    	for(int i = 0; i < newLength; i++)
    		truncatedArray[i] = inputArray[i];
    	
    	return truncatedArray;
    }
    
    /**
     * remove all the repetitive elements from array 
     * @param inputArray
     * @return array after removing all repetitive elements
     */
    private int[] repetitiveRemover(int[] inputArray) throws AssertionError
    {
    	//create new array
    	int[] newArray  = new int[inputArray.length + 1];
    	
    	int newArrayIndex = 0;
    	
    	/**
    	 * add all the elements of input array to this new array but if a element is already added then in second
    	 * occurrence it will be skipped 
    	 */
    	for(int i = 0; i < inputArray.length; i++)
    	{
    		if(inputArray[i] > MAXSIZE || inputArray[i] < 1)
    			throw new AssertionError("Invalied input found");
    		if( !isInArray(newArray, inputArray[i]) )
    		{
    			newArray[newArrayIndex] = inputArray[i];
    			newArrayIndex++;
    		}
    	}
    	
    	// here MAXSIZE + 1 works as an indicator so that all the elements after it can be truncated
    	newArray[newArrayIndex] = MAXSIZE + 1; 
    	int[] arr = arrayTruncater(newArray, MAXSIZE + 1);
    	return arr;
    }
    /**
     * to get a array from a set Object
     * @return integer array of Set object
     */
    public int[] toArray()
    {
    	int[] arr = set.clone();
    	return arr;
    	
    }
    
}
