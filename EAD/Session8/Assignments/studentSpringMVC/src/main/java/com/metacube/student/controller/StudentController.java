package com.metacube.student.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.student.model.StudentModel;
import com.metacube.student.service.StudentService;
/**
 * 
 * @author Ramdev
 *
 */
@Controller
public class StudentController 
{
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public ModelAndView students() 
	{
		List<StudentModel> students =  studentService.getAllStudents();
		return new ModelAndView("students","students",students);
	}

	@GetMapping("/students/{id}")
	public ModelAndView students(@PathVariable("id") int id) 
	{
		return new ModelAndView("signup","student",studentService.getStudent(id));
	}
}
