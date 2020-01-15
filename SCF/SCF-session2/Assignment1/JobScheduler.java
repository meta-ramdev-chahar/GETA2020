import java.util.*;
import java.io.IOException;

/**
 * 
 * @author Nilesh Patel
 * JobScheduler class created for implement First Come First Serve(FCFS) job scheduling algorithm.
 * It contain methods for calculating waiting time, completion time, turn around time, average waiting time, maximum waiting time etc.
 */

public class JobScheduler 
{
	
	/**
	 * 
	 * @param process : two dimension array which contain arrival time and burst time of n process.
	 * @param noOfProcess : total no. of process.
	 * @return an array which contain completion time for each process.
	 */
	public static int[] getCompletionTime(final int process[][], final int noOfProcess) throws IOException
	{
		
		//input validation.
		boolean isValidInput = inputValidation(process, noOfProcess);
		if( ! isValidInput)
		{
			throw new IOException("Please enter valid inputs!");			
		}
		
		//it will contain completion time for each process.
		int[] completionTime = new int[noOfProcess];
		
		//sorting the process according arrival time by calling sortProcessByArrivalTime method.
		int[][] sortedProcess = sortProcessByArrivalTime(process, noOfProcess);
		
		for(int index = 0; index < noOfProcess; index++)
		{
			int processArrivalTime = sortedProcess[index][0];
			int processBurstTime = sortedProcess[index][1];
			
			if(index == 0)
			{
				completionTime[index] = processArrivalTime + processBurstTime;
				continue;
			}
			else{
			    int completionTimeOfPreviousProcess = completionTime[index-1];
			    
			    if(completionTimeOfPreviousProcess > processArrivalTime)
			    {	
			        completionTime[index] = completionTimeOfPreviousProcess + processBurstTime;
			    }
			    else
			    {
			    	completionTime[index] = processArrivalTime + processBurstTime;
			    }
			    
			}
			
		}
		return completionTime;
	}
	
	/**
	 * 
	 * @param process : two dimension array which contain arrival time and burst time of n process.
	 * @param noOfProcess : total no. of process.
	 * @return an array which contain waiting time for each process.
	 */
	public static int[] getWaitingTime(final int process[][], final int noOfProcess) throws IOException
	{
		
		//input validation.
		boolean isValidInput = inputValidation(process, noOfProcess);
		if( ! isValidInput)
		{
			throw new IOException("Please enter valid inputs!");			
		}
				
		//it will contain waiting time for each process.
		int[] waitingTime = new int[noOfProcess];
				
		//sorting the process according arrival time by calling sortProcessByArrivalTime method.
		int[][] sortedProcess = sortProcessByArrivalTime(process, noOfProcess);
		
		//calling getTurnAroundTime method to get turn around time of processes.
		int[] turnAroundTime = getTurnAroundTime(process, noOfProcess);
		
		for(int index = 0; index < noOfProcess; index++)
		{
			if(index==0)
			{
				//for first process waiting time will be 0.
				waitingTime[index] = 0;
				continue;
			}
			
			int processTurnAroundTime = turnAroundTime[index];
			int processBurstTime = sortedProcess[index][1];
			waitingTime[index] = processTurnAroundTime - processBurstTime; 
		}
		return waitingTime;
	}
	
	/**
	 * 
	 * @param process : two dimension array which contain arrival time and burst time of n process.
	 * @param noOfProcess : total no. of process.
	 * @return an array which contain turn around time for each process.
	 */
	public static int[] getTurnAroundTime(final int process[][], final int noOfProcess) throws IOException
	{
		
		//input validation.
		boolean isValidInput = inputValidation(process, noOfProcess);
		if( ! isValidInput)
		{
			throw new IOException("Please enter valid inputs!");			
		}
				
		//it will contain turn around time for each process.
		int[] turnAroundTime = new int[noOfProcess];
				
		//sorting the process according arrival time by calling sortProcessByArrivalTime method.
		int[][] sortedProcess = sortProcessByArrivalTime(process, noOfProcess);
		
		//calling getCompletionTime method to get completion time of processes.
		int[] completionTime = getCompletionTime(process, noOfProcess);
		
		for(int index = 0; index < noOfProcess; index++)
		{
			int processCompletionTime = completionTime[index];
			int processArrivalTime = sortedProcess[index][0];
			turnAroundTime[index] = processCompletionTime - processArrivalTime;
		}
		return turnAroundTime;
	}
	
	/**
	 * 
	 * @param process : two dimension array which contain arrival time and burst time of n process.
	 * @param noOfProcess : total no. of process.
	 * @return double value which contain average waiting time of processes.
	 */
	public static double getAverageWaitingTime(final int process[][], final int noOfProcess) throws IOException
	{
		
		//input validation.
		boolean isValidInput = inputValidation(process, noOfProcess);
		if( ! isValidInput)
		{
			throw new IOException("Please enter valid inputs!");			
		}
				
		//it will contain turn around time for each process.
		double averageWaitingTime = 0.0;
		
		//calling getWaitingTime method to get waiting time of processes.
		int[] waitingTime = getWaitingTime(process, noOfProcess);
		
		int totalWaitingTime = 0;
		
		//calculating total waiting time of all processes.
		for(int index = 0; index < noOfProcess; index++)
		{
			totalWaitingTime += waitingTime[index]; 
		}
		
		averageWaitingTime = (double) totalWaitingTime / noOfProcess;
		return averageWaitingTime;
	}
	
	/**
	 * 
	 * @param process : two dimension array which contain arrival time and burst time of n process.
	 * @param noOfProcess : total no. of process.
	 * @return integer value which contain maximum waiting time of processes.
	 */
	public static int getMaximumWaitingTime(final int process[][], final int noOfProcess) throws IOException
	{
		
		//input validation.
		boolean isValidInput = inputValidation(process, noOfProcess);
		if( ! isValidInput)
		{
			throw new IOException("Please enter valid inputs!");			
		}
		
		//calling getWaitingTime method to get waiting time of processes.
		int[] waitingTime = getWaitingTime(process, noOfProcess);
		
		int maximumWaitingTime = 0;
		
		//calculating maximum waiting time.
		for(int index = 0; index < noOfProcess; index++)
		{
			if(waitingTime[index] > maximumWaitingTime)
			{
				maximumWaitingTime = waitingTime[index];
			}
		}
		
		return maximumWaitingTime;		
	}
	
	/**
	 * 
	 * This method will sort the array by their arrival time.
	 * @see {@link https://codippa.com/how-to-sort-a-two-dimensional-array-on-column-values-in-java/}
	 * @param process : two dimension integer array which contain arrival time and burst time of n process.
	 * @param noOfProcess : total no. of process.
	 * @return 2D array which contain sorted form of process by their arrival time.
	 */
	public static int[][] sortProcessByArrivalTime(final int[][] process, int noOfProcess)
	{
		int[][] sortedProcess = process;
		Arrays.sort(sortedProcess, new Comparator<int[]>()
				{    
	        @Override              
	        public int compare(final int[] entry1, final int[] entry2)
	        { 
	            if(entry1[0] >= entry2[0])
	            {
	            	return 1;
	            } 
	            else
	            {
	            	return -1;
	            } 
	        } 
	        });
		
		return sortedProcess;
	}
	
	/**
	 * 
	 * @param process take a two dimension integer array containing arrival time and burst time of n process
	 * @param numberOfProcess take a integer value containing number of Process
	 * @return true if number of process is greater than 0 and arrival time and burst time of each process is not less than 0 and 1 else return false
	 */
	public static boolean inputValidation(int process[][], int numberOfProcess)
	{
		
		if(numberOfProcess <= 0)
		{
			return false;
		}
		else
		{
			for(int index = 0; index <numberOfProcess; index++)
			{
				int processArrivalTime = process[index][0];
				int processBurstTime = process[index][1];
				
				if(processArrivalTime < 0 || processBurstTime < 1)
				{
					return false;
				}
			}
		}
		return true;
	}
}
