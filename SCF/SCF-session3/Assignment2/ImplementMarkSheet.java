import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Ramdev
 * 
 */
public class ImplementMarkSheet {

	public static void main(String[] args)
	{
		Marksheet marksheet = new Marksheet();
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Enter Number Of Students : ");
		int numberOfStudent = userInput.nextInt();
		
		double studentGrades[] = new double[numberOfStudent];
		
		for(int studentIndex = 0; studentIndex < numberOfStudent; studentIndex++)
		{
			System.out.print("Enter Grade Of "+ (studentIndex+1)+" Student : ");
			studentGrades[studentIndex] = userInput.nextDouble();
		}
		
		while(true)
		{
			System.out.println("1. To Print Average Grade");
			System.out.println("2. To Print Maximum Grade");
			System.out.println("3. To Print Minimum Grade");
			System.out.println("4. To Print Precentage Of Pass Student");
			System.out.println("5. Exit");
			
			int userChoice = userInput.nextInt();
			
			if(userChoice == 5)
			{
				System.out.println("Thank You");
				System.exit(0);
			}
			
			switch(userChoice)
			{
				case 1:
					try
					{
						double averageGradesOfAllStudent = marksheet.getAverageGrade(studentGrades, numberOfStudent);
						System.out.printf("Average Grade is : %.2f \n", averageGradesOfAllStudent);
					}
					catch(IOException io)
					{
						System.out.println(io);
					}
					
					break;
				case 2:
					try
					{
						double maximumGradesOfAllStudent = marksheet.getMaximumGrade(studentGrades, numberOfStudent);
						System.out.printf("Maximum Grade is : %.2f \n", maximumGradesOfAllStudent);
					}
					catch(IOException io)
					{
						System.out.println(io);
					}
					
					break;
				case 3:
					try
					{
						double minimumGradesOfAllStudent = marksheet.getMinimumGrades(studentGrades, numberOfStudent);
						System.out.printf("Minimum Grades is :%.2f \n", minimumGradesOfAllStudent);
					}
					catch(IOException io)
					{
						System.out.println(io);
					}
					
					break;
				case 4:
					try
					{
						double precentageOfPassStudent = marksheet.getPercentageOfPassStudent(studentGrades, numberOfStudent);
						System.out.printf("Precentage Of Pass Students is : %.2f \n", precentageOfPassStudent);
					}
					catch(IOException io)
					{
						System.out.println(io);
					}
					
					break;
				default:
					System.out.println("Invalid Choice");
			}
		}
	}
}

