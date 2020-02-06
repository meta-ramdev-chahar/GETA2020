package facade;

import dao.VehicleDAO;
import dto.VehicleDTO;

/**
 * 
 * @author Ramdev
 * This is facade class for vehicle
 */
public class VehicleFacade {

	//Singleton object of VehicleFacade
	private static VehicleFacade vehicleFacade = null;

	/**
	 * This method return the object of VehicleFacade
	 * @return object of VehicleFacade
	 */
	public static VehicleFacade getInstance(){

		if(vehicleFacade == null){
			vehicleFacade = new VehicleFacade();
		}
		return vehicleFacade;
	}

	/**
	 * This method add vehicle details
	 * @param vehicle object of Vehicle containing details of vehicle
	 * @param empId employee id
	 * @return true if added else false
	 * @throws Exception exception related to database,other general exception
	 */
	public boolean addVehicle(VehicleDTO vehicle, int empId) throws Exception{

		VehicleDAO vehicleDAO = VehicleDAO.getInstance();
		try{
			return vehicleDAO.addVehicle(vehicle, empId);
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * This method return the vehicle id
	 * @param empId employee id
	 * @return integer vehicle id
	 * @throws Exception exception related to database,other general exception
	 */
	public int getVehicleId(String email) throws Exception{

		VehicleDAO vehicleDAO = VehicleDAO.getInstance();
		try{
			EmployeeFacade employeeFacade = EmployeeFacade.getInstance();
			int empId = employeeFacade.getEmployeeId(email);
			return vehicleDAO.getVehicleId(empId);
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * This method return the type of vehicle
	 * @param empId employee id
	 * @return String containing type of vehicle of employee
	 * @throws Exception exception related to database,other general exception
	 */
	public String getVehicleType(String email) throws Exception{

		VehicleDAO vehicleDAO = VehicleDAO.getInstance();
		try{
			EmployeeFacade employeeFacade = EmployeeFacade.getInstance();
			int empId = employeeFacade.getEmployeeId(email);
			return vehicleDAO.getVehicleType(empId);
		}catch(Exception e){
			throw e;
		}
	}
}