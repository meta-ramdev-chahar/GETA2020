package util;

import dto.EmployeeDTO;
import dto.PlanDTO;
import dto.VehicleDTO;;

/**
 * 
 * @author Ramdev
 * This class contain method for input validation
 */
public class Validation {

	//Error String
	private String error = "";

	/**
	 * This method validate details of employee 
	 * @param employee object of employee containing employee details
	 * @param confirmPassword confirm password String
	 * @return error string
	 */
	public String validateEmployeeDetail(EmployeeDTO employee, String confirmPassword) {

		if (employee.getName().trim().equals("")) {
			this.error = "Name Cannnot Contain Only Spaces";
		} else if (!employee.getName().matches("[a-z A-z]+")) {
			this.error = "Name Should Contain only Aplhabets";
		} else if (!employee.getEmail().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
			this.error = "Invalid Email Entered";
		} else if (employee.getPassword().equals("")) {
			this.error = "Password can't be empty";
		} else if (!employee.getPassword().matches("[0-9]+")) {
			this.error = "Password should only contain number";
		} else if (!employee.getPassword().equals(confirmPassword)) {
			this.error = "Password and Confirm Password are not Same";
		} else if (employee.getPhoneNumber().length() < 8) {
			this.error = "Contact Number should be between 8-10 digits";
		} else if (!employee.getPhoneNumber().matches("[0-9]+")) {
			this.error = "Contact Number should Contain only Numeric Digits";
		} else if (employee.getOrganization().equals("")) {
			this.error = "Company Not Selected";
		}
		return this.error;
	}

	////

	/**
	 * This method validate details of vehicle
	 * @param vehicle object of Vehicle containing detail of vehicle
	 * @param empId employee id
	 * @return error string
	 */
	public String validateVehicleDetail(VehicleDTO vehicle, int empId) {
		if (vehicle.getName().trim().equals("")) {
			this.error = "Vehicle Name Cannnot be blank";
		} else if (vehicle.getNumber().trim().equals("")) {
			this.error = "Vehicle Number Cannnot be blank";
		} else if (vehicle.getType().equals("")) {
			this.error = "Vehicle Type Cannnot be blank";
		} else if (empId <= 0) {
			this.error = "Employee Id Cannnot be blank";
		}
		return this.error;
	}

	/**
	 * This method validate plan detail
	 * @param plan object of Plan
	 * @return error string
	 */
	public String validatePlanDetail(PlanDTO plan) {
		if (plan.getCurrency().equals("")) {
			this.error = "Please select currency";
		} else if (plan.getType().equals("")) {
			this.error = "Please select plan";
		} else if (plan.getPrice() <= 0) {
			this.error = "Total Can't be empty";
		}
		return this.error;
	}
}