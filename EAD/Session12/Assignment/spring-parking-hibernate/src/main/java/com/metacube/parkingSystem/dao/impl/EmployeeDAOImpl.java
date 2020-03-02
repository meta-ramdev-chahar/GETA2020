package com.metacube.parkingSystem.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.parkingSystem.dao.EmployeeDAO;
import com.metacube.parkingSystem.mapper.EmployeeMapper;
import com.metacube.parkingSystem.models.EmployeeModel;
import com.metacube.parkingSystem.models.LoginModel;


@SuppressWarnings("unused")
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	//private final String SQL_UPDATE_USER = "update employee set username = ?, email = ?, password  = ?,cpassword = ?,conno = ?,org = ? where id = ?";
	Session session;
	Transaction tx;

	@Autowired
	public EmployeeDAOImpl(DataSource dataSource) {
		Configuration con=new Configuration().configure().addAnnotatedClass(EmployeeModel.class);
		StandardServiceRegistryBuilder reg=new StandardServiceRegistryBuilder().applySettings(con.getProperties());
		SessionFactory sf=con.buildSessionFactory(reg.build());
		session=sf.openSession();	
		tx=session.beginTransaction();
	}

	@Override
	public int addEmpolyee(EmployeeModel employeeModel) 
	{
		
		session.save(employeeModel);
		
		return 0;
	}

	@Override
	public EmployeeModel getEmpolyee(int id) 
	{
		EmployeeModel emp= ((EmployeeModel)session.get(EmployeeModel.class,id));		
		return emp;
	}

	@Override
	public boolean deleteEmployee(int id) 
	{
		return true;
	}

	@Override
	public boolean updateEmployee(EmployeeModel employeeModel)
	{
		session.save(employeeModel);	
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeModel> getAllEmployees() 
	{
		Query query = session.createQuery("from EmployeeModel");
		List<EmployeeModel> emps = query.list();			
		return emps;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean checkLogin(LoginModel loginModel)
	{
		String lmail = loginModel.getEmail();
		String lpass = loginModel.getPassword();
		Query query = session.createQuery("from EmployeeModel where email = "+"'"+lmail+"' AND password="+"'"+lpass+"'");
		List<EmployeeModel> emps = query.list();		
		if(emps.isEmpty()==true)
			return true;
		else
			return false;
	}
	
	@Override
	public List<EmployeeModel> getAllEmployee2(String org) 
	{
		Query query = session.createQuery("from EmployeeModel where org="+"'"+org+"'");
		@SuppressWarnings("unchecked")
		List<EmployeeModel> emps = query.list();		
		return emps;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public EmployeeModel getAllEmployee3(String email)
	{
		Query query=session.createQuery("from EmployeeModel where email="+"'"+email+"'");
		List<EmployeeModel> emps=query.list();
		return emps.get(0);
	}

}
