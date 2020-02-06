package facade;

import dao.LoginDAO;
import dto.EmployeeDTO;

/**
 * 
 * @author Ramdev
 * This is facade class for login management
 */
public class LoginFacade {

	//Singleton object of LoginFacade
	private static LoginFacade loginFacade = null;
	
	/**
	 * This method return object of LoginFacade
	 * @return object of LoginFacade
	 */
	public static LoginFacade getInstance(){
		
		if(loginFacade == null){
			loginFacade = new LoginFacade();
		}
		return loginFacade;
	}
	
	/**
	 * This method authenticate user details 
	 * @param user object of Employee class
	 * @return true if employee details are correct else false
	 * @throws Exception exception related to database,other general exception
	 */
	public boolean login(EmployeeDTO employee) throws Exception{
		
		LoginDAO loginDAO = LoginDAO.getInstance();
		try{
		 return loginDAO.login(employee);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
}