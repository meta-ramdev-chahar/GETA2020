package ds4question2;

import java.util.HashMap;

/**
 * 
 * @author Ramdev
 * Implement method to get unique number of characters in a string
 */
public class UniqueCharacters 
{
	HashMap<String, Integer> previousResult;
	
	public UniqueCharacters() 
	{
		this.previousResult = new HashMap<>();
	}
	
	public int getNumberOfUniqueCharacters(String string)throws AssertionError
	{
		if(string == null)
			throw new AssertionError("Null String");
		if(previousResult.get(string) != null)
			return previousResult.get(string);
		
		int numberOfUniqueCharacters = 0;
		String stringToStoreInResult = new String(string); 
		
		while(string.length() > 0)
		{
			string = string.replaceAll(string.charAt(0) + "", "");
			numberOfUniqueCharacters++;
		}
		previousResult.put(stringToStoreInResult, numberOfUniqueCharacters);
		return numberOfUniqueCharacters;
	}
	
	public static void main(String args[])
	{
		UniqueCharacters un = new UniqueCharacters();
		System.out.println(un.getNumberOfUniqueCharacters("vvvvvvvvvvvvvvvv"));
	}

}
