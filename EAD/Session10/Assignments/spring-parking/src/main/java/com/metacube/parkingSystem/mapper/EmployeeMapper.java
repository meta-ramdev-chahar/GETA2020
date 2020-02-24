package com.metacube.parkingSystem.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.parkingSystem.models.EmployeeModel;

public class EmployeeMapper implements RowMapper<EmployeeModel> {

	@Override
	public EmployeeModel mapRow(ResultSet resultSet, int i) throws SQLException {

		EmployeeModel user = new EmployeeModel();
		user.setId(resultSet.getInt("id"));
		user.setUsername(resultSet.getString("username"));
		user.setPassword(resultSet.getString("password"));
		user.setEmail(resultSet.getString("email"));
		user.setContactNo(resultSet.getString("contactNo"));
		user.setOrganization(resultSet.getString("organization"));
		return user;
	}
}
