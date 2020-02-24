package com.metacube.parkingSystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.parkingSystem.models.VehicleModel;
import com.metacube.parkingSystem.service.EmployeeService;

@Controller
public class FriendController {
	
	@Autowired
	private EmployeeService employeeService;


	@GetMapping("/friend")
	public ModelAndView employees2() 
	{
		String org = HomeController.organization;
		String org2 = LoginController.org;
		System.out.println(org +" "+ org2);
		if(org2 == null)
		    return new ModelAndView("friend","employee2",employeeService.getEmpolyeeByOrganization(org));
		else
			return new ModelAndView("friend","employee2",employeeService.getEmpolyeeByOrganization(org2));
	}
}
