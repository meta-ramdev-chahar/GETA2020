package com.metacube.parkingSystem.dao;

import java.util.List;

import com.metacube.parkingSystem.models.EmployeeModel;
import com.metacube.parkingSystem.models.LoginModel;

public interface EmployeeDAO
{

	int addEmpolyee(EmployeeModel employeeModel);

	EmployeeModel getEmpolyee(int id);

	boolean deleteEmployee(int id);

	boolean updateEmployee(EmployeeModel employeeModel);

	public List<EmployeeModel> getAllEmployees();

	boolean checkLogin(LoginModel loginModel);

	List<EmployeeModel> getAllEmployee2(String org);
	EmployeeModel getAllEmployee3(String email);

}
