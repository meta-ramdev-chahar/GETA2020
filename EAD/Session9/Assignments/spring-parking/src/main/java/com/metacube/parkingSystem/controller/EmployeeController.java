package com.metacube.parkingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.parkingSystem.models.EmployeeModel;
import com.metacube.parkingSystem.models.VehicleModel;
import com.metacube.parkingSystem.service.EmployeeService;
import com.metacube.parkingSystem.service.impl.VehicleService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	

	/*
	 * @GetMapping("/employees") public String employees(Model model) {
	 * List<EmployeeModel> employees = employeeService.getAllEmployees();
	 * model.addAttribute("employees", employees);
	 * 
	 * return "employees"; }
	 */
	
	@GetMapping("/employees/{id}")
	public ModelAndView employees(@PathVariable("id") int id) {
		return new ModelAndView("signup","employee",employeeService.getEmpolyee(id));
	}
	
	@GetMapping("/employees/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
			employeeService.deleteEmployee(id);
		return "redirect:/employees";
	}

}
