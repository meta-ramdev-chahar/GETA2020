import java.util.Scanner;

/**
 * 
 * @author Ramdev
 *
 */
public class TestHexCalc 
{
	public static void main(String[] args)
	{
		
		HexCalc hexcalc = new HexCalc();
		Scanner input = new Scanner(System.in);
		int choice;
		System.out.println("Enter two values");
		String hexString1, hexString2;
		hexString1 = input.nextLine();
		while( !( HexCalc.validHex( hexString1 ) ) )
		{
			System.out.println("wrong value found Enter this value again");
			hexString1 = input.nextLine();
		}
		hexString2 = input.nextLine();
		while( !(HexCalc.validHex(hexString2 ) ) )
		{
			System.out.println("wrong value found Enter this value again");
			hexString2 = input.nextLine();
		}
		
		while (true)
		{	
			System.out.println("Enter the operation you want to perform");
			System.out.println("1. Add");
			System.out.println("2. Subtract");
			System.out.println("3. multiply");
			System.out.println("4. Divide");
			System.out.println("5. Check is equal or not");
			System.out.println("6. Check less than or not");
			System.out.println("7. Check greater than or not");
			System.out.println("8. Enter different values");
			System.out.println("9. Exit");
			choice  = input.nextInt();
			switch(choice)
			{
			   case 1: System.out.println("The Addition is " + hexcalc.addHexa(hexString1, hexString2));
			   			break;
			   case 2: System.out.println("The Subtraction is " + hexcalc.subtractHexa(hexString1, hexString2));
	   			        break;
			   case 3: System.out.println("The Multiplication is " + hexcalc.multiplyHexa(hexString1, hexString2));
			            break;
			   case 4: System.out.println("The Division is " + hexcalc.devideHexa(hexString1, hexString2));
			            break;
			   case 5: System.out.println("Both Values are equals ? " + hexcalc.isEquals(hexString1, hexString2));
			            break;
			   case 6: System.out.println("is 1st value is less than 2nd ? " + hexcalc.isLesser(hexString1, hexString2));
			            break;
			   case 7: System.out.println("is 1st value is Greater than 2nd ? " + hexcalc.isGreater(hexString1, hexString2));
			            break;
			   case 8: 
				       System.out.println("Enter two values");
				       hexString1 = input.next();
				       while( !( HexCalc.validHex( hexString1 ) ) )
				       {
					       System.out.println("wrong value found Enter this value again");
					       hexString1 = input.nextLine();
				       }
				       hexString2 = input.next();
				       while( !(HexCalc.validHex(hexString2 ) ) )
				       {
					       System.out.println("wrong value found Enter this value again");
					       hexString2 = input.nextLine();
				       }
				       break;
			   case 9: input.close();
				   	   System.exit(0);
			   default://in case user enter wrong choice
				       System.out.println("Wrong choice ");
			}
		}
		
	}

}
