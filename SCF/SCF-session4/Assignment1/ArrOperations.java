import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Ramdev
 *
 */
public class ArrOperations 
{
	/**
	 * @param array of positive integers.
	 * @return Return the size of the largest mirror section found in the input array.
	 */
	int maxMirror(int[] array) throws AssertionError
	{
		int arrayLength = array.length;
		if(arrayLength == 0)
		{
			throw new AssertionError("Null Array");
		}
		int startPoint = 0, endPoint = arrayLength - 1, maxMirror = 0, count;
		for(int fIndex = startPoint; fIndex <= endPoint; fIndex++) // fIndex stands for forward Index
		{
			count = 0;
			for(int bIndex = endPoint; (bIndex >= startPoint) && (fIndex + count) < arrayLength; bIndex--)
			{
				if(array[fIndex + count] == array[bIndex])
				{
					count += 1;
				}
				else
				{
					if(count > maxMirror)
						maxMirror = count;
					count = 0;
				}
			}
			if(count > maxMirror)
			{
				maxMirror = count;
			}
		}
		return maxMirror;
	}
	/**
	 * 
	 * @param array of positive integers.
	 * @return Clumps: Clump in an array is a series of 2 or more adjacent elements of the same value.
	 */
	int countClumps(int[] array) throws AssertionError
	{
		int arrayLength = array.length, clumps = 0, count = 0;
		if(arrayLength == 0)
		{
			throw new AssertionError("Null Array");
		}
		int containerItem = array[0];
		for(int itreator = 0; itreator < arrayLength; itreator++)
		{
			if(array[itreator] == containerItem)
			{
				count++;
				if(itreator == arrayLength - 1 && count >= 2)
					clumps += 1;
			}
			else
			{
				if(count >= 2)
					clumps += 1;
				containerItem = array[itreator];
				count = 1;
			}
		}
		return clumps;
	}
	/**
	 * 
	 * @param array of positive integers.
	 * @param x , Positive integer.
	 * @param y , Positive integer.
	 * @return array of positive integers with fixed XY problem.
	 */
	 int[] fixXY(int array[],int x, int y)throws AssertionError
	{
		int arrayLength = array.length;
		if(arrayLength == 0)
		{ 
			throw new AssertionError("Null Array"); 
		}
		if(array[arrayLength - 1] == x)
		{ 
			throw new AssertionError("X is at invalid index"); 
		}
		//this will stores all indexes of misplaced y values in the array
		List<Integer> allWrongPlacedY = new ArrayList<Integer>();
		int countX = 0; //To store number of X's in Array
		int countY = 0; //To store number of Y's in Array

		for(int arrayIndex = 0; arrayIndex < arrayLength; arrayIndex++)
		{
			if(array[arrayIndex] == x && array[arrayIndex+1] == x) //checking if two x occur continuously 
			{ 
				throw new AssertionError("Two continues X");
			}
			if(array[arrayIndex] == y && arrayIndex == 0) //checking if y occur in array at first position
			{
				allWrongPlacedY.add(arrayIndex);
				countY++;
				continue;
			}
			//checking if y occurs in array at wrong place than storing index in allWrongPlacedY list
			if(array[arrayIndex] == y && array[arrayIndex-1] != x)
			{
				allWrongPlacedY.add(arrayIndex);
				countY++;
				continue;
			}
			if(array[arrayIndex] == x)
			{ 
				countX++; 
			}
			if(array[arrayIndex] == y)
			{ 
				countY++; 
			}
		}
		if(countX != countY)
		{ 
			throw new AssertionError("Number of X & Y is not Equal"); 
		}

		int fixedXYArray[] = array;
		int arrayListIndex = 0;

		//placing every wrong placed y right next to the x
		for(int arrayIndex = 0; arrayIndex < arrayLength; arrayIndex++)
		{
			//checking if X is not immediately followed by a Y
			if(fixedXYArray[arrayIndex] == x && fixedXYArray[arrayIndex + 1] != y)
			{
				fixedXYArray[allWrongPlacedY.get(arrayListIndex)] = fixedXYArray[arrayIndex + 1];
				fixedXYArray[arrayIndex + 1] = y;
				arrayListIndex++;
			}
		}
		return fixedXYArray;
	}
	/**
	 * 
	 * @param array of positive integers.
	 * @return the index if there is a place to split the input array so that the sum of the numbers
	 * 			on one side is equal to the sum of the numbers on the other side else return -1.
	 */
	 public int splitArray(int array[]) throws AssertionError
		{

		 	int arrayLength = array.length;
			if(arrayLength == 0)
			{
				throw new AssertionError("Null Array");
			}
			
			int sumOfArray = 0;			
			for(int arrayIndex = 0; arrayIndex < arrayLength; arrayIndex++)
				sumOfArray += array[arrayIndex];

			int sumOfLeftSide = 0;
			int sumOfRightSide = sumOfArray;		
			int arrayIndex = 0;

			while(sumOfLeftSide < sumOfRightSide)
			{	
				sumOfLeftSide += array[arrayIndex];
				sumOfRightSide -= array[arrayIndex];
				arrayIndex += 1;
				if(sumOfLeftSide == sumOfRightSide)
				{    
					return arrayIndex;
				}
			}
			return -1;
		}
}
