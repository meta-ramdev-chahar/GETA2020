
/**
 * 
 * @author Ramdev
 * implements methods for comparing two stings , reversal of string, to case vice-versa and to find largest word from a string 
 * 
 */
public class StringOperations 
{
	/**
	 * compare two strings
	 * @param first_string
	 * @param second_string 
	 * @return 1 if both strings are equal else 0
	 */
	public static int compareTwoStrings(String first_string, String second_string)
	{
		if(first_string.equals(second_string))
			return 1;
		else
			return 0;
	}
	/**
	 * reverse the string
	 * @param string to be reversed
	 * @return reversed string
	 */
	public static String revese(String string)
	{
		String reversed_string = "";
		for(int itreator = string.length() - 1; itreator >= 0; itreator-- )
		{
			reversed_string += string.charAt(itreator);
		}
			return reversed_string;
		
	}
	/**
	 * inverts the case of all alphabets
	 * @param string whose case needs to be inverted
	 * @return string with inverted case
	 */
	public static String caseInvertor (String string)
	{
		String caseInvertedString = "";
		for(int itreator = 0; itreator < string.length(); itreator++ )
		{
			if(string.charAt(itreator) == Character.toUpperCase(string.charAt( itreator )))
			{
				caseInvertedString += Character.toLowerCase(string.charAt( itreator ));
			}
			else
			{
				caseInvertedString += Character.toUpperCase(string.charAt(itreator));
			}
				
		}
		return caseInvertedString;
	}
	
	/**
	 * find the word of maximum length in given string
	 * @param a sentence in the form of string
	 * @return the word with largest length
	 */
	public static String getMaxLengthWord(String string)
	{
		string += " ";
		String maxLengthWord = "", temporaryString = "";
		for (int itreator = 0; itreator < string.length(); itreator++)
		{
			if(string.charAt(itreator) == ' ' || string.charAt(itreator) == ',' || string.charAt(itreator) == '.')
			{
				if(temporaryString.length() >= maxLengthWord.length())
				{
					maxLengthWord = temporaryString;
				}
				temporaryString = "";
			}
			else
			{
				temporaryString += string.charAt(itreator);
			}
		}
		return maxLengthWord;
	}
	
}
