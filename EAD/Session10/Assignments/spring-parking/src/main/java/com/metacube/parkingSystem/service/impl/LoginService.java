package com.metacube.parkingSystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.parkingSystem.dao.impl.EmployeeDAOImpl;
import com.metacube.parkingSystem.dao.impl.VehDAO;
import com.metacube.parkingSystem.models.LoginModel;

@Service
public class LoginService {
	
	@Autowired
	private EmployeeDAOImpl empDAO;
	
	public void checkLogin(LoginModel loginModel)
	{
		boolean result=empDAO.checkLogin(loginModel);
		if(result==true)
			System.out.println("TRUE");
		else
			System.out.println("FALSE");
	}

}
