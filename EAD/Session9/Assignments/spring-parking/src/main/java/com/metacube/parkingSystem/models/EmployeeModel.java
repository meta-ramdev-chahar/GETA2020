package com.metacube.parkingSystem.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EmployeeModel {
	
	@NotBlank
	private String username;

	@NotBlank
	@Email(message = "{badEmail}")
	private String email;
	
	@NotBlank 
	@Size(min = 6, max =  10)
	private String password;

	
	@NotBlank
	private String contactNo;
	
	@NotBlank
	private String organization;
	
	private int id=0;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
