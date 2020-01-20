/**
 * 
 * @author Ramdev
 * implements the methods for finding the LCM and HCF of any two Values.
 * LCM : lowest common multiple
 * HCF : Highest common factor
 */
public class LcmHcf 
{
	/**
	 * find the H.C.F of two values 
	 * @param firstValue
	 * @param secondValue
	 * @return H.C.F of first value and second value
	 * @throws AssertionError when values less than zero
	 */
	int hcf(int firstValue, int secondValue) throws AssertionError
	{
		if(firstValue < 0 || secondValue < 0)
			throw new AssertionError("Values Should be Positive");
		
		if (secondValue == 0)
			return firstValue;
		else
			return hcf(secondValue, firstValue % secondValue);
	}
	/**
	 * find the L.C.M of two values 
	 * @param firstValue
	 * @param secondValue
	 * @return L.C.M of first value and second value
	 * @throws AssertionError when values less than one
	 * 	 
	 * */
	int lcm(int firstValue, int secondValue) throws AssertionError
	{	
		if(firstValue < 1 || secondValue < 1)
			throw new AssertionError("Values Should be Positive and greater than one");
		int lcm = firstValue * secondValue / hcf(firstValue, secondValue); 
        return lcm;
	}
}
