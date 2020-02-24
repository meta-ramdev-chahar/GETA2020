package com.metacube.parkingSystem.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.metacube.parkingSystem.models.EmployeeModel;

public interface EmployeeService 
{

	int addEmpolyee(EmployeeModel employeeModel);

	EmployeeModel getEmpolyee(int id);

	boolean deleteEmployee(int id);

	boolean updateEmployee(EmployeeModel employeeModel);

	List<EmployeeModel> getAllEmployees();

	List<EmployeeModel> getEmpolyeeByOrganization(String org);
	
	EmployeeModel getEmpolyeeByEmail(String email);
	
	public String saveImage(MultipartFile imageFile)throws IOException;

}
