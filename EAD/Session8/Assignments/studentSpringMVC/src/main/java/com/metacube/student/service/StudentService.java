package com.metacube.student.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.student.dao.StudentDAO;
import com.metacube.student.model.StudentModel;

@Service
public class StudentService {

	@Autowired
	private StudentDAO studentDAO;

	public int addStudent(StudentModel student) 
	{
		studentDAO.addStudent(student);			
		return 0;
	}

	public StudentModel getStudent(int id)
	{
		return studentDAO.getStudent(id);
	}

	public boolean deleteStudent(int id) 
	{
		return false;
	}

	public boolean updateStudent(StudentModel student) 
	{			
		return studentDAO.updateStudent(student);
	}

	public List<StudentModel> getAllStudents() 
	{			
		return studentDAO.getAllStudents();
	}
}