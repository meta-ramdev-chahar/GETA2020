package com.metacube.parkingSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.parkingSystem.dao.impl.VehDAO;
import com.metacube.parkingSystem.models.VehicleModel;

@Service
public class VehicleService 
{

	@Autowired
	private VehDAO vehicleDAO;
	public int addVehical(VehicleModel vehicleModel)
	{
		vehicleDAO.addVehical(vehicleModel);
		return 0;
	}
	public boolean deleteVehical(int id) 
	{
		return vehicleDAO.deleteVehical(id);
	}

	public boolean updateVeh(VehicleModel vehicleModel) 
	{

		return vehicleDAO.updateVeh(vehicleModel);
	}

	public List<VehicleModel> getAllVehicles() 
	{
		return vehicleDAO.getAllVehicles();
	}
}
