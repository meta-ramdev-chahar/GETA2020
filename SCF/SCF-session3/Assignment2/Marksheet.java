import java.io.IOException;

/**
 * 
 * @author Ramdev 
 * This class include finding maximum,minimum grades or average grades,percentage of pass student
 *
 */
public class Marksheet 
{
	
	public static final int minimumPassingGrade = 40;
	
	/**
	 * 
	 * To Find average grade
	 * @param grades array for containing grades of all students
	 * @param numberOfStudents total number of students.
	 * @return average grade
	 */
	public double getAverageGrade(double grades[],int numberOfStudents) throws IOException
	{		
		if(numberOfStudents <= 0)
		{
			throw new IOException("Invalid Number Of Student!!!");
		}
		if(!gradesValidation(grades, numberOfStudents))
		{
			throw new IOException("Invalid Grades!!!");
		}
		
		double averageGrade = 0.0;
		
		for(int itreator = 0; itreator < numberOfStudents; itreator++)
		{
			averageGrade += grades[itreator];
		}
		averageGrade = (double) averageGrade / numberOfStudents;
		return averageGrade;
	}
	
	/**
	 * 
	 * To Find maximum grade
	 * @param grades array for containing grades of all students
	 * @param numberOfStudents total number of students.
	 * @return maximum grade.
	 */
	public double getMaximumGrade(double grades[],int numberOfStudents) throws IOException
	{	
		if(numberOfStudents <= 0)
		{
			throw new IOException("Invalid Number Of Student!!!");
		}
		if(!gradesValidation(grades, numberOfStudents))
		{
			throw new IOException("Invalid Grades!!!");
		}
						
		double maximumGrade = 0.0;
		for(int itreator = 0; itreator < numberOfStudents; itreator++)
		{
			if(maximumGrade < grades[itreator])
			{
				maximumGrade = grades[itreator];
			}
		}
		return maximumGrade;
	}
	
	/**
	 * 
	 * Find minimum grade
	 * @param grades array for containing grades of all students
	 * @param numberOfStudents total number of students.
	 * @return minimum grade
	 */
	public double getMinimumGrades(double grades[],int numberOfStudents) throws IOException
	{
		if(numberOfStudents <= 0)
		{
			throw new IOException("Invalid Number Of Student!!!");
		}
		if(!gradesValidation(grades, numberOfStudents))
		{
			throw new IOException("Invalid Grades!!!");
		}
								
		double minimumGrade = Double.MAX_VALUE;
		
		for(int itreator = 0; itreator < numberOfStudents; itreator++)
		{
			if(minimumGrade > grades[itreator])
			{
				minimumGrade = grades[itreator];
			}
		}
		return minimumGrade;
	}
	
	/**
	 * 
	 * To Find percentage of students passed
	 * @param grades array for containing grades of all student
	 * @param numberOfStudents total number of students.
	 * @return percentage of students passed
	 */
	public double getPercentageOfPassStudent(double grades[],int numberOfStudents) throws IOException
	{		
		if(numberOfStudents <= 0)
		{
			throw new IOException("Invalid Number Of Student!!!");
		}
		if(!gradesValidation(grades, numberOfStudents))
		{
			throw new IOException("Invalid Grades!!!");
		}
		
		double passStudentPrecentage = 0.0;
		double numberOfPassStudent = 0;
		for(int itreator =0; itreator < numberOfStudents; itreator++)
		{
			if(grades[itreator] >= minimumPassingGrade)
			{
				numberOfPassStudent++;
			}
		}
		passStudentPrecentage = 100 * numberOfPassStudent/numberOfStudents;
		return passStudentPrecentage;
	}
	
	/**
	 * Validate grades of all student
	 * @param grades array containing grades of all student
	 * @param numberOfStudents total number of students.
	 * @return true if grades is in between 0 to 100 inclusive
	 */
	private boolean gradesValidation(double grades[], int numberOfStudents)
	{
		for(int itreator = 0; itreator < numberOfStudents; itreator++)
		{
			if(grades[itreator] < 0 || grades[itreator] > 100)
			{
				return false;
			}
		}
		return true;
	}
	
}
