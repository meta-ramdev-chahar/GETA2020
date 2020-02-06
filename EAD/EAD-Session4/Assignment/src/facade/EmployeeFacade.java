package facade;

import java.util.List;
import dao.EmployeeDAO;
import dto.EmployeeDTO;

/**
 * 
 * @author Ramdev
 * This facade class of employee
 */
public class EmployeeFacade {

	//Singleton object of EmployeeFacade
	private static EmployeeFacade employeeFacade = null;

	/**
	 * This method return object EmployeeFacade
	 * @return object EmployeeFacade
	 */
	public static EmployeeFacade getInstance(){

		if(employeeFacade == null){
			employeeFacade = new EmployeeFacade();
		}
		return employeeFacade;
	}

	/**
	 * This method is use to get the employee id
	 * @param email email of employee
	 * @return integer id of employee
	 * @throws Exception exception related to database,exception related to database,other general exception
	 */
	public int getEmployeeId(String email)throws Exception{

		EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		try{
			return employeeDAO.getEmployeeId(email);
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * This method add employee details
	 * @param employee object of Employee containing employee details
	 * @param company object of Company containing company details
	 * @throws Exception exception related to database,other general exception
	 */
	public int addEmployee(EmployeeDTO employee) throws Exception{

		EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		try{
			return employeeDAO.addEmployee(employee);
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * This method use to get employee details
	 * @param email email of employee
	 * @return object of Employee containing details of employee
	 * @throws Exception exception related to database,other general exception
	 */
	public EmployeeDTO getEmployeeDetail(String email) throws Exception{

		EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		try{
			return employeeDAO.getEmployeeDetail(email);
		}catch(Exception e){
			throw e;
		}
	}

	/**
	 * This method get details of employee friend
	 * @param email email of employee
	 * @return object of employee containing details of friend
	 * @throws Exception exception related to database,other general exception
	 */
	public EmployeeDTO getFriendDetail(String email) throws Exception{

		EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		try{
			return employeeDAO.getFriendDetail(email);
		}
		catch(Exception e){
			throw e;
		}
	}

	/**
	 * This method is use to update detail of employee 
	 * @param employee object of Employee containing details of employee
	 * @param email email of employee
	 * @return true if updated else false
	 * @throws Exception exception related to database,other general exception
	 */
	public boolean updateEmployeeDetail(EmployeeDTO employee) throws Exception{

		EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		try{
			return employeeDAO.updateEmployeeDetail(employee);
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * This method is use to get the list of friends of employee
	 * @param email email of employee
	 * @return List of employee 
	 * @throws Exception exception related to database,other general exception
	 */
	public List<EmployeeDTO> getFriendList(String email, int eid) throws Exception{

		EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		try{
			return employeeDAO.getFriendList(email, eid);
		}catch(Exception e){
			throw e;
		}
	}

	/**
	 * This method check if vehicle is register for given employee
	 * @param email email of employee
	 * @return true if register else false
	 * @throws Exception exception related to database,other general exception
	 */
	public boolean isVehicleRegistrationComplete(String email) throws Exception{

		VehicleFacade vehicleFacade = VehicleFacade.getInstance();
		try{
			if(vehicleFacade.getVehicleId(email) > 0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			throw e;
		}
	}

	/**
	 * This method check if plan is register for given employee
	 * @param email email of employee
	 * @return true if register else false
	 * @throws Exception exception related to database,other general exception
	 */
	public boolean isPlanRegistrationComplete(String email) throws Exception{

		PlanFacade planFacade = PlanFacade.getInstance();
		try{
			if(planFacade.getPlanId(email) > 0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			throw e;
		}
	}
}