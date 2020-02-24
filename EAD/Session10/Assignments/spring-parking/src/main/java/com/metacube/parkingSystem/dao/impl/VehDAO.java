package com.metacube.parkingSystem.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.parkingSystem.mapper.EmployeeMapper;
import com.metacube.parkingSystem.mapper.VehicleMapper;
import com.metacube.parkingSystem.models.EmployeeModel;
import com.metacube.parkingSystem.models.VehicleModel;

@Repository
public class VehDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	private final String SQL_DELETE_USER = "delete from vehicle where vid = ?";
	private final String SQL_UPDATE_USER = "update vehicle set vehname = ?, vehtype = ?, vehno = ? where vid = ?";
	private final String SQL_GET_ALL = "select * from vehicle";
	private final String SQL_INSERT_USER = "insert into vehicle(vid,vehname,vehtype,vehno) values(?,?,?,?)";

	@Autowired
	public VehDAO(DataSource dataSource) 
	{	
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int addVehical(VehicleModel vehicle)
	{
		
		System.out.println(vehicle);
		System.out.println("h3");
		return jdbcTemplate.update(SQL_INSERT_USER,vehicle.getVid() ,vehicle.getVehname(),vehicle.getVehtype(), vehicle.getVehno());
	}

	public boolean deleteVehical(int id) 
	{
		return jdbcTemplate.update(SQL_DELETE_USER) > 0;
	}

	public boolean updateVeh(VehicleModel vehCommands) 
	{
		return jdbcTemplate.update(SQL_UPDATE_USER,vehCommands.getVehname(),vehCommands.getVehtype(), vehCommands.getVehno()) > 0;
	}

	public List<VehicleModel> getAllVehicles()
	{
		return jdbcTemplate.query(SQL_GET_ALL, new VehicleMapper());
	}


}
