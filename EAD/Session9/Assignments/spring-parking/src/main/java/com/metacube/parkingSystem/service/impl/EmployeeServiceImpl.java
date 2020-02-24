package com.metacube.parkingSystem.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.metacube.parkingSystem.dao.EmployeeDAO;
import com.metacube.parkingSystem.models.EmployeeModel;
import com.metacube.parkingSystem.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

	@Autowired
	private EmployeeDAO employeeDAO;
	
	
	@Override
	public int addEmpolyee(EmployeeModel employeeModel) 
	{
		employeeDAO.addEmpolyee(employeeModel);	
		return 0;
	}

	@Override
	public EmployeeModel getEmpolyee(int id) {
		return employeeDAO.getEmpolyee(id);
	}

	@Override
	public boolean deleteEmployee(int id) {
		return employeeDAO.deleteEmployee(id);
	}

	@Override
	public boolean updateEmployee(EmployeeModel employeeModel) {
		
		return employeeDAO.updateEmployee(employeeModel);
	}

	@Override
	public List<EmployeeModel> getAllEmployees() {
		
		return employeeDAO.getAllEmployees();
	}

	@Override
	public List<EmployeeModel> getEmpolyeeByOrganization(String org) 
	{
		return employeeDAO.getAllEmployee2(org);
	}
	
	@Override
	public EmployeeModel getEmpolyeeByEmail(String email)
	{
		return employeeDAO.getAllEmployee3(email);
	}
	
	 public String saveImage(MultipartFile imageFile) throws IOException
	 {
	 System.out.println("hello");
	 String folder="/Users/Yash/Desktop/photos/";
	 byte[] bytes= imageFile.getBytes();
	 Path path=Paths.get(folder+imageFile.getOriginalFilename());
	 Files.write(path, bytes);
	 return imageFile.getOriginalFilename();
	 }
	
	

}
