package facade;

import dao.PlanDAO;
import dto.PlanDTO;

/**
 * 
 * @author Ramdev
 * This is facade class for Plan
 */
public class PlanFacade {

	//Singleton object of PlanFacade
	private static PlanFacade planFacade = null;

	/**
	 * This method return object of PlanFacade class
	 * @return object of PlanFacade class
	 */
	public static PlanFacade getInstance(){

		if(planFacade == null){
			planFacade = new PlanFacade();
		}
		return planFacade;
	}
	
	/**
	 * This method add plan details 
	 * @param plan object of Plan containing details of plan
	 * @param empId employee id
	 * @return true if plan is added else false
	 * @throws exception related to database,Exception other general exception
	 */
	public boolean addPlan(PlanDTO plan ,int empId) throws Exception
	{
		double totalCost = plan.getPrice();
		if("YEN".equals(plan.getCurrency()))
		{
			totalCost = totalCost * 0.0091;
		}
		else if("INR".equals(plan.getCurrency()))
		{
			totalCost /= 72;
		}
		plan.setPrice(totalCost);
		PlanDAO planDAO = PlanDAO.getInstance();
		try{
			return planDAO.addPlan(plan,empId);
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * This method find and return id of plan
	 * @param empId employee id
	 * @return integer plan id
	 * @throws Exception exception related to database,other general exception
	 */
	public int getPlanId(String email) throws Exception{
		
		PlanDAO planDAO = PlanDAO.getInstance();
		try{
			EmployeeFacade employeeFacade = EmployeeFacade.getInstance();
			int empId = employeeFacade.getEmployeeId(email);
			return planDAO.getPlanId(empId);
		}catch(Exception e){
			throw e;
		}
	}
}