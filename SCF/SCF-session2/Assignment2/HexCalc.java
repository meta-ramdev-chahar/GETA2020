import java.util.*;
/**
 * 
 * @author Ramdev
 *
 */
public class HexCalc 
{
	/**
	 * 
	 * @param hexaDecimal
	 * @return decimal of given hexadecimal value 
	 */
	private int hexToDecimal (String hexaDecimal)
	 {  
		    String digits = "0123456789ABCDEF";
		    hexaDecimal = hexaDecimal.toUpperCase();  
		             int result = 0, i = 0;  
		             while ( i < hexaDecimal.length())  
		             {    
		            	 result = 16 * result + digits.indexOf(hexaDecimal.charAt(i));
		                 i += 1;
		             }
		    return result;  
		}
	/**
	 * 
	 * @param hexaDecimal
	 * @return true if given string is a hexadecimal string else false
	 */
	static boolean validHex(String hexaDecimal)
	{
		hexaDecimal = hexaDecimal.toUpperCase();
		if(hexaDecimal.matches("[0-9A-F]+"))
			return true;
		else
			return false;
	}
	/**
	 * 
	 * @param decimal
	 * @return hexadecimal of given decimal value
	 */
	private String decimalToHex(int decimal)
	{    
	     int temp;  
	     String result = "";   
	     char hexArray[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  
	    while( decimal > 0 )  
	     {  
	       temp = decimal % 16;   
	       result = hexArray[temp] + result;   
	       decimal = decimal / 16;  
	     }  
	    return result;  
	}
	/**
	 * 
	 * @param hex1
	 * @param hex2
	 * @return addition of hex1 and hex2 in hexadecimal form
	 */
	String addHexa(String hex1 , String hex2)
	{
		int decimal = hexToDecimal(hex1) + hexToDecimal(hex2);
		return decimalToHex(decimal);
	}
	/**
	 * 
	 * @param hex1
	 * @param hex2
	 * @return subtraction of hex1 and hex2 in hexadecimal form
	 */
	String subtractHexa(String hex1 , String hex2)
	{
		if( hexToDecimal(hex1) < hexToDecimal(hex2) )
			return "Not possible because 1st value is Smaller";
		else
		{
			int decimal = hexToDecimal(hex1) - hexToDecimal(hex2);
			if( decimalToHex(decimal) != "")
				return decimalToHex(decimal);
			else
				return "0";
		}
	}
	/**
	 * 
	 * @param hex1
	 * @param hex2
	 * @return multiplication of hex1 and hex2 in hexadecimal form
	 */
	String multiplyHexa(String hex1 , String hex2)
	{
		int decimal = hexToDecimal(hex1) * hexToDecimal(hex2);
		return decimalToHex(decimal);
	}
	/**
	 * 
	 * @param hex1
	 * @param hex2
	 * @return division of hex1 and hex2 in hexadecimal form
	 */
	String devideHexa(String hex1 , String hex2)
	{
		
			int decimal = hexToDecimal(hex1) / hexToDecimal(hex2);
			if( decimalToHex(decimal) != "")
				return decimalToHex(decimal);
			else
				return "0";
	}
	/**
	 * 
	 * @param hex1
	 * @param hex2
	 * @return true if both hex1 and hex2 are equals else false
	 */
	boolean isEquals(String hex1, String hex2)
	{
			hex1 = removeInitialZeros(hex1);
			hex2 = removeInitialZeros(hex2);
			if(hex1.length() == hex2.length())
			{
				for(int charIndex = 0; charIndex < hex1.length(); charIndex++)
				{
					char c1 = hex1.charAt(charIndex);
					char c2 = hex2.charAt(charIndex);
					
					if(Character.getNumericValue(c1) != Character.getNumericValue(c2))
					{
						return false;
					}
				}
				return true;
			}
			else
			{
				return false;
			}
	}
	/**
	 * 
	 * @param hex1
	 * @param hex2
	 * @return true if hex1 is less than hex2 else false 
	 */
	boolean isLesser(String hex1, String hex2)
	{
		hex1 = removeInitialZeros(hex1);
		hex2 = removeInitialZeros(hex2);
		if(hex1.length() < hex2.length())
		{
			return true;
		}
		
		if(hex1.length() == hex2.length())
		{
			for(int charIndex = 0; charIndex < hex1.length(); charIndex++)
			{
				char c1 = hex1.charAt(charIndex);
				char c2 = hex2.charAt(charIndex);
				
				if(Character.getNumericValue(c1) < Character.getNumericValue(c2))
				{
					return true;
				}
			}
			return false;
		}
		else
		{
			return false;
		}	
	}
	/**
	 * 
	 * @param hex1
	 * @param hex2
	 * @return true if hex1 is grater than hex2 else false 
	 */
	boolean isGreater(String hex1, String hex2)
	{
		hex1 = removeInitialZeros(hex1);
		hex2 = removeInitialZeros(hex2);
		if(hex1.length() > hex2.length())
		{
			return true;
		}
		
		if(hex1.length() == hex2.length())
		{
			for(int charIndex = 0; charIndex < hex1.length(); charIndex++)
			{
				char c1 = hex1.charAt(charIndex);
				char c2 = hex2.charAt(charIndex);
				
				if(Character.getNumericValue(c1) > Character.getNumericValue(c2))
				{
					return true;
				}
			}
			return false;
		}
		else
		{
			return false;
		}
}
				
	/**
	 * 
	 * @param hex1
	 * @return hex1 string without any initial zeros
	 */
	
	static String removeInitialZeros(String hex1)
	{
		String updated_hex1 = new String();
		for(int itreater = 0; itreater < hex1.length(); itreater++)
		{
			char c = hex1.charAt(itreater);
			if(( c == '0' ) && ( itreater != (hex1.length() - 1) ))
			{
				updated_hex1 = hex1.substring(itreater + 1);
			}
			else
			{
				break;
			}
		}
		return updated_hex1;
	}

	

}
