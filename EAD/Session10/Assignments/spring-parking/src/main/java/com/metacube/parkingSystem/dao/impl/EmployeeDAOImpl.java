package com.metacube.parkingSystem.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.parkingSystem.dao.EmployeeDAO;
import com.metacube.parkingSystem.mapper.EmployeeMapper;
import com.metacube.parkingSystem.models.EmployeeModel;
import com.metacube.parkingSystem.models.LoginModel;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	private final String SQL_FIND_USER = "select * from employee where id = ?";
	private final String SQL_FIND_FRND = "select * from employee where organization = ?";
	private final String SQL_FIND_USER2 = "select * from employee where email = ?";
	private final String SQL_FIND_LOGIN = "select count(*) from employee where email = ? AND password = ?";
	private final String SQL_DELETE_USER = "delete from employee where id = ?";
	private final String SQL_UPDATE_USER = "update employee set username = ?, email = ?, password  = ? ,contactNo = ?,organization = ? where id = ?";
	private final String SQL_GET_ALL = "select * from employee";
	private final String SQL_INSERT_USER = "insert into employee(id, username, email, password, contactNo, organization) values(?,?,?,?,?,?)";


	@Autowired
	public EmployeeDAOImpl(DataSource dataSource) 
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int addEmpolyee(EmployeeModel employeeModel) 
	{
		return jdbcTemplate.update(SQL_INSERT_USER, 
									employeeModel.getId(),
									employeeModel.getUsername(), 
									employeeModel.getEmail(),
									employeeModel.getPassword(),
									employeeModel.getContactNo(),
									employeeModel.getOrganization());
	}

	@Override
	public EmployeeModel getEmpolyee(int id)
	{
		List<EmployeeModel>employeeList = jdbcTemplate.query(SQL_FIND_USER, new Object[] { id }, new EmployeeMapper());
		return employeeList.get(0);
	}

	@Override
	public boolean deleteEmployee(int id)
	{
		return jdbcTemplate.update(SQL_DELETE_USER, id) > 0;
	}

	@Override
	public boolean updateEmployee(EmployeeModel employeeModel) 
	{
		return jdbcTemplate.update(SQL_UPDATE_USER,employeeModel.getUsername(), employeeModel.getEmail(),
				employeeModel.getPassword(),employeeModel.getContactNo(),employeeModel.getOrganization(), employeeModel.getId()) > 0;
	}

	@Override
	public List<EmployeeModel> getAllEmployees() 
	{
		return jdbcTemplate.query(SQL_GET_ALL, new EmployeeMapper());
	}
	
	@Override
	public boolean checkLogin(LoginModel loginModel)
	{
		String loginEmail=loginModel.getEmail();
		String loginPass=loginModel.getPassword();
		int count= jdbcTemplate.queryForObject(SQL_FIND_LOGIN, new Object[] { loginEmail,loginPass}, Integer.class);
		
		if(count > 0)
			return true;
		else
			return false;
	}
	
	@Override
	public List<EmployeeModel> getAllEmployee2(String org) 
	{
		return jdbcTemplate.query(SQL_FIND_FRND, new Object[] { org }, new EmployeeMapper());
	}
	
	@Override
	public EmployeeModel getAllEmployee3(String email) 
	{	
		return jdbcTemplate.query(SQL_FIND_USER2, new Object[] { email }, new EmployeeMapper()).get(0);	
	}
}
