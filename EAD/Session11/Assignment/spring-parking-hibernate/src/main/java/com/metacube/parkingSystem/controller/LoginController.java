package com.metacube.parkingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.parkingSystem.models.EmployeeModel;
import com.metacube.parkingSystem.models.LoginModel;
import com.metacube.parkingSystem.service.EmployeeService;
import com.metacube.parkingSystem.service.impl.LoginService;

@SuppressWarnings("unused")
@Controller
public class LoginController {
	
	
	public static String org;
	public static String empname;
	public static String email2;
	public static String password;
	public static String conno;
	public static int id;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("login",new LoginModel());		
		return "login";
	}

	@PostMapping("/login")
	public String doSignup(@Validated @ModelAttribute("login") LoginModel loginModel, BindingResult bindingResult,Model model )
	{

		if (bindingResult.hasErrors()) 
		{
			return "login";
		} 
		else 
		{
			loginService.checkLogin(loginModel);
		} 
		 String email = loginModel.getEmail();
		 org = employeeService.getEmpolyeeByEmail(email).getOrganization();
		 /*  empname = employeeService.getEmpolyeeByEmail(email).getUsername(); email2 =
		 * employeeService.getEmpolyeeByEmail(email).getEmail(); password =
		 * employeeService.getEmpolyeeByEmail(email).getPassword(); conno =
		 * employeeService.getEmpolyeeByEmail(email).getContactNo(); id =
		 * employeeService.getEmpolyeeByEmail(email).getId();
		 */
		model.addAttribute("empname",employeeService.getEmpolyeeByEmail(email).getUsername());
		model.addAttribute("email",employeeService.getEmpolyeeByEmail(email).getEmail());
		model.addAttribute("password",employeeService.getEmpolyeeByEmail(email).getPassword());
		model.addAttribute("contactNo",employeeService.getEmpolyeeByEmail(email).getContactNo());
		model.addAttribute("organization",employeeService.getEmpolyeeByEmail(email).getOrganization());
		model.addAttribute("id",employeeService.getEmpolyeeByEmail(email).getId());
		return "employeeHome";
		}
	
	
}
