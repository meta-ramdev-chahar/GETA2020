import java.util.Scanner;

/**
 * 
 * @author Ramdev
 *
 */
public class ImplementArea 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		Area area = new Area();
		while( true )
		{	System.out.print("Please Enter Your Choice : ");
			System.out.println("1. To Find Area Of Rightangle Triangle");
			System.out.println("2. To Find Area Of Rectangle");
			System.out.println("3. To Find Area Of Square");
			System.out.println("4. To Find Area Of Circle");
			System.out.println("5. Exit");
			int choice = input.nextInt();
			if(choice == 5)
			{
				
			}
			
			switch ( choice )
			{
				case 1:
					try
					{
						System.out.print("Enter Height Of Right Angle Triangle : ");
						double heightOfRightAngleTriangle = input.nextDouble();
						System.out.print("Enter Base Of Right Angle Triangle : ");
						double baseOfRightAngleTriangle = input.nextDouble();
						
						double areaOfRightAngleTriangle = area.getAreaOfTriangle(heightOfRightAngleTriangle, baseOfRightAngleTriangle);
						System.out.printf("Area Of Right Angle Triangle is : %.2f \n", areaOfRightAngleTriangle);
						
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
					
					break;				
				case 2:
					try
					{
						System.out.print("Enter Height Of Rectangle : ");
						double heightOfRectangle = input.nextDouble();
						System.out.print("Enter Base Of Rectangle : ");
						double baseOfRectangle = input.nextDouble();
						
						double areaOfRectangle = area.getAreaOfRectangle(heightOfRectangle, baseOfRectangle);
						System.out.printf("Area Of Rectangle is : %.2f \n", areaOfRectangle);
						
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
					break;
				case 3:
					try
					{				
						System.out.print("Enter Base Of Square : ");
						double baseOfSquare = input.nextDouble();
						
						double areaOfSquare = area.getAreaOfSquare(baseOfSquare);
						System.out.printf("Area Of Square is : %.2f \n",areaOfSquare);
						
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
					break;
				case 4:
					try
					{
						System.out.print("Enter Radius Of Circle : ");
						double radiusOfCircle = input.nextDouble();
						
						double areaOfCircle = area.getAreaOfCircle(radiusOfCircle);
						System.out.printf("Area Of Circle is : %.2f \n" , areaOfCircle);
						
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
					break;
				case 5:
					System.out.println("Thank You");
					System.exit(0);
				default:
					System.out.println("Invalid Option!!!");
			}
		}

	}
}