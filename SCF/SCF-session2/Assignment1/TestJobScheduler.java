import java.util.*;
import java.io.IOException;

/**
 * 
 * @author Ramdev
 * This class designed for test methods of JobSchedular class.
 */

public class TestJobScheduler 
{
	
	public static void main(String[] args)
	{
		//creating Scanner object for user inputs.
		Scanner input = new Scanner(System.in);
		
		//taking no of process from user;
		System.out.println("Enter Number of processes-");
		int noOfProcess = input.nextInt();
		
		//creating 2D array for store arrival time and burst time.
		int[][] process = new int[noOfProcess][2];
		
		//taking inputs from user and storing them into 2D array @process.
		for(int index = 0; index < noOfProcess; index++)
		{
			System.out.println("Enter arrival time of process " + (index + 1) + ":-" );
			process[index][0] = input.nextInt();
			System.out.println("Enter burst time of process " + (index + 1) + ":-" );
			process[index][1] = input.nextInt();			
		}
		
		//For store user's choice.
		int userChoice;
		
		//for control the loop.
		boolean flag = true;
		
		while(flag)
		{
			System.out.println("Enter 1 for calculate Completion Time Of each process");
			System.out.println("Enter 2 for calculate Waiting Time of each process");
			System.out.println("Enter 3 for calculate Turn Around Time Of each process");
			System.out.println("Enter 4 for calculate Avrage Waiting Time");
			System.out.println("Enter 5 for calculate Maximum Waiting Time");
			System.out.println("Enter 6 for Exit");
			System.out.println("Enter your Choice :-");
			
			//taking user's choice.
			userChoice = input.nextInt();
			
			switch(userChoice)
			{
				case 1:
					try
					{
						int[] completionTime = JobScheduler.getCompletionTime(process, noOfProcess);
						int[][] sortedProcess = JobScheduler.sortProcessByArrivalTime(process, noOfProcess);
						
						System.out.println("Arrival Time\tBurst Time\tCompletion Time");
						for(int index = 0; index < noOfProcess; index++)
						{
							System.out.println(sortedProcess[index][0] +"\t\t" + sortedProcess[index][1] + "\t\t" + completionTime[index]);
						}
					}
					catch(IOException io)
					{
						System.out.println(io);
						return;
					}
					break;
				
				case 2:
					try
					{
						int[] waitingTime = JobScheduler.getWaitingTime(process, noOfProcess);
						int[][] sortedProcess = JobScheduler.sortProcessByArrivalTime(process, noOfProcess);
						
						System.out.println("Arrival Time\tBurst Time\tWaiting Time");
						for(int index = 0; index < noOfProcess; index++)
						{
							System.out.println(sortedProcess[index][0] +"\t\t" + sortedProcess[index][1] + "\t\t" + waitingTime[index]);
						}
					}
					catch(IOException io)
					{
						System.out.println(io);
						return;
					}
					break;
					
				case 3:
					try
					{
						int[] turnAroundTime = JobScheduler.getTurnAroundTime(process, noOfProcess);
						int[][] sortedProcess = JobScheduler.sortProcessByArrivalTime(process, noOfProcess);
						
						System.out.println("Arrival Time\tBurst Time\tTurn Around Time");
						for(int index = 0; index < noOfProcess; index++)
						{
							System.out.println(sortedProcess[index][0] +"\t\t" + sortedProcess[index][1] + "\t\t" + turnAroundTime[index]);
						}
					}
					catch(IOException io)
					{
						System.out.println(io);
						return;
					}
					break;
				
				case 4:
					try
					{
						double averageWaitingTime = JobScheduler.getAverageWaitingTime(process, noOfProcess);						
						System.out.printf("Average Waiting Time : %.2f \n", averageWaitingTime);
						
					}
					catch(IOException io)
					{
						System.out.println(io);
						return;
					}
					break;
					
				case 5:
					try
					{
						double maximumWaitingTime = JobScheduler.getMaximumWaitingTime(process, noOfProcess);						
						System.out.println("Maximum Waiting Time : " + maximumWaitingTime);
						
					}
					catch(IOException io)
					{
						System.out.println(io);
						return;
					}
					break;
					
				case 6:
					System.out.println("Thank You!");
					flag = false;
					break;
				
				default :
					System.out.println("Please enter a valid choice");
					break;					
			
			}
		}
		
		input.close();

	}

}
