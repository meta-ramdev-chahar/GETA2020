package com.metacube.parkingSystem.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.parkingSystem.models.EmployeeModel;
import com.metacube.parkingSystem.models.VehicleModel;
import com.metacube.parkingSystem.service.EmployeeService;
import com.metacube.parkingSystem.service.impl.VehicleService;

@Controller
public class HomeController {

	@Autowired
	private EmployeeService employeeService;

	@Value("${home.message}")
	private String message;
	public static int j;
	private static String empname;
	private static String email;
	private static String password;
	private static String contactNo;
	public static String organization;
	private static int id;

	@GetMapping({"/","/home"})
	public String home(Model model) {
		model.addAttribute("msg",message);

		return "home";
	}

	@GetMapping("/employeeHome")
	public String employeeHome(Model model) 
	{
		//model.addAttribute("msg",message);
		model.addAttribute("empname",empname);
		model.addAttribute("email",email);
		model.addAttribute("password",password);
		model.addAttribute("contactNo",contactNo);
		model.addAttribute("organization",organization);
		model.addAttribute("id",id);	
		return "employeeHome";
	}

	@GetMapping("/signup")
	public String signup(Model model) 
	{
		model.addAttribute("employee",new EmployeeModel());
		return "signup";
	}

	@PostMapping("/signup")
	public ModelAndView doSignup(@Validated @ModelAttribute("employee") EmployeeModel employeeModel,BindingResult bindingResult) 
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("empname",employeeModel.getUsername() );
		mv.addObject("email",employeeModel.getEmail() );
		mv.addObject("password",employeeModel.getPassword() );
		mv.addObject("contactNo",employeeModel.getContactNo() );
		mv.addObject("organization",employeeModel.getOrganization() );

		empname = employeeModel.getUsername() ;
		email = employeeModel.getEmail();
		password = employeeModel.getPassword();
		contactNo = employeeModel.getContactNo();
		organization = employeeModel.getOrganization();
		id = employeeModel.getId();

		if (bindingResult.hasErrors()) 
		{
			mv.setViewName("signup");
			return mv;
		} 
		else 
		{
			if (employeeModel.getId()  ==  0)
			{
				j = (int)(Math.random()*10);
				VehController obj = new VehController();
				obj.send(j);
				System.out.println(j);				
				employeeModel.setId(j);
				employeeService.addEmpolyee(employeeModel);
			}
			else 
			{
				employeeService.updateEmployee(employeeModel);
			}
			mv.setViewName("redirect:/vehicleRegister");
			return mv;
		}
	}

	@GetMapping("/logout")  
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) 
	{  
		HttpSession session  =  request.getSession(false);
		if (session !=  null) 
		{
			System.out.println("before");
			session.invalidate();
			System.out.println("after");
		} 
		return "home";
	}  


}
