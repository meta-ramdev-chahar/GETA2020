package com.metacube.student.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.student.model.StudentModel;
import com.metacube.student.service.StudentService;

/**
 * 
 * @author Ramdev
 */
@Controller
public class HomeController 
{

	@Autowired
	private StudentService studentService;	
	@Value("${home.message}")
	private String message;
	
	
	@GetMapping({"/","/home"})
	public String home(Model model) 
	{
		model.addAttribute("msg",message);		
		return "home";
	}
	
	@GetMapping("/signup")
	public String signup(Model model)
	{
		model.addAttribute("student",new StudentModel());	
		return "signup";
	}
	
	@PostMapping("/signup")
	public String doSignup(@Validated @ModelAttribute("student") StudentModel newStudent, BindingResult bindingResult ) 
	{
		if(bindingResult.hasErrors()) 
		{			
			return "signup";
		}
		else 
		{			
			if(newStudent.getId() == null) 
			{				
				studentService.addStudent(newStudent);	
			}
			else 
			{
				studentService.updateStudent(newStudent);
			}			
			return "redirect:/students";
		}		
	}	
}
