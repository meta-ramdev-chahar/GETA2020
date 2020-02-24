package com.metacube.parkingSystem.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.parkingSystem.models.VehicleModel;

public class VehicleMapper implements RowMapper<VehicleModel> {

	@Override
	public VehicleModel mapRow(ResultSet resultSet, int i) throws SQLException {

		VehicleModel user = new VehicleModel();
		user.setVid(resultSet.getInt("vid"));
		user.setVehname(resultSet.getString("vehname"));
		user.setVehtype(resultSet.getString("vehtype"));
		user.setVehno(resultSet.getString("vehno"));

		return user;
	}
	
}
