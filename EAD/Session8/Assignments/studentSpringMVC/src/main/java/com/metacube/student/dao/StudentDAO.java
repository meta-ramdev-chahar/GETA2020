package com.metacube.student.dao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.metacube.student.model.StudentModel;

@Repository
public class StudentDAO 
{

	static List<StudentModel> students = new ArrayList<StudentModel>();
	static int counter = 1;

	public int addStudent(StudentModel student) 
	{
		student.setId(counter);
		students.add(student);
		counter++;
		return 0;
	}

	public StudentModel getStudent(int id) 
	{
		StudentModel student = null;
		for (StudentModel studentIntreator : students) 
		{
			if (studentIntreator.getId() == id) 
			{
				student = studentIntreator;
				break;
			}
		}
		return student;
	}

	public boolean deleteStudent(int id) 
	{
		return false;
	}

	public boolean updateStudent(StudentModel student)
	{
		StudentModel oldStudent = getStudent(student.getId());
		int index =  students.indexOf(oldStudent);
		students.remove(index);
		students.add(student); 
		return true;
	}

	public List<StudentModel> getAllStudents() 
	{
		return students;
	}
}
