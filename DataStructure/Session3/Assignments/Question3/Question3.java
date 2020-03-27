package question3;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Ramdev
 * 
 */
public class Question3 
{
	/**
	 * To generate order of bowlers
	 * @param remainingBallsOfVirat
	 * @param noOfBowlers
	 * @param remainingBallsArr
	 * @return
	 */
    public static List<Integer> orderOfBowlers(int remainingBallsOfVirat, int noOfBowlers, int[] remainingBallsArr) 
    {
        List<Integer> bowlerOrder = new ArrayList<Integer>();
        Queue queue = new PriorityQueue();
        try {
            	for (int i = 0; i < noOfBowlers; i++) 
            	{
            		queue.enqueue(new Element(i + 1, remainingBallsArr[i]));
            	}
                Element tempElement;
                while (remainingBallsOfVirat > 0 && !queue.isEmpty()) 
                {
                	tempElement = queue.dequeue();
                	bowlerOrder.add(tempElement.getElementName());
                	if (tempElement.getPriority() > 0) 
                	{
                		tempElement.setPriority(tempElement.getPriority() - 1);
                		queue.enqueue(tempElement);
                	}
                	remainingBallsOfVirat--;
                }
        	} 
        	catch (Exception e) 
        	{
        		e.printStackTrace();
        	}
        return bowlerOrder;
    }

     public static void main(String[] args) 
     {
        int remainingBallsOfVirat = 10;
        int noOfBowlers = 5;
        int[] remainingBallsArr = { 3, 4, 6, 7, 5 };
        List<Integer> order = orderOfBowlers(remainingBallsOfVirat, noOfBowlers, remainingBallsArr);
        for (Integer i : order) 
        {
            System.out.println(i);
        }
    }
}
