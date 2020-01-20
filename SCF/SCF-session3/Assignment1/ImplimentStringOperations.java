import java.util.*;
/** 
 * @author Ramdev
 * Provide User interaction with String operations class
 */
public class ImplimentStringOperations 
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		int choice;
		String first_string, second_string;
		while(true)
		{
			System.out.println("Enter your choice !");
			System.out.println("1. To Compare two Strings");
			System.out.println("2. To Reverse a String");
			System.out.println("3. To Inverse the case of a String");
			System.out.println("4. To Get Largest Number from a String");
			System.out.println("5. To Exit");
			choice = input.nextInt();
			input.nextLine();
			
			switch( choice )
			{
				case 1: System.out.println("Enter two strings");
						first_string = input.nextLine();
						second_string = input.nextLine();
						System.out.println(StringOperations.compareTwoStrings(first_string, second_string));
						break;
				case 2: System.out.println("Enter a String");
						first_string = input.nextLine();
						System.out.println(StringOperations.revese(first_string));
						break;
				case 3: System.out.println("Enter a String");
						first_string = input.nextLine();
						System.out.println(StringOperations.caseInvertor(first_string));
						break;
				case 4: System.out.println("Enter a String");
						first_string = input.nextLine();
						System.out.println(StringOperations.getMaxLengthWord(first_string));
						break;
				case 5: System.exit(0);
				default: System.out.println("Wrong choice Enter choice again");	
			}
		}
	}

}
