package com.metacube.parkingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.parkingSystem.models.EmployeeModel;
import com.metacube.parkingSystem.service.EmployeeService;

@RestController
public class EmployeeRestController {


	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees-rest")
	public List<EmployeeModel> employeesRest()
	{
		return employeeService.getAllEmployees();
	}
}
