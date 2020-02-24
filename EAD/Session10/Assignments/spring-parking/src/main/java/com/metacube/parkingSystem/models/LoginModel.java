package com.metacube.parkingSystem.models;

import javax.validation.constraints.NotBlank;

public class LoginModel {
	
	
	@NotBlank
	private String email;
	@NotBlank
	private String password;
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getPassword() 
	{
		return password;
	}
	@Override
	public String toString() 
	{
		return "LoginCommands [email=" + email + ", password=" + password + "]";
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}

}
