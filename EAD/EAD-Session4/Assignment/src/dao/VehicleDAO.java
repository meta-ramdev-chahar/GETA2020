package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import util.DatabaseQuery;
import dto.VehicleDTO;
import factory.ConnectionFactory;

/**
 * 
 * @author Ramdev
 * This is dao class for vehicle
 */
public class VehicleDAO {

	//Singleton object of VehicleDAO
	private static VehicleDAO vehicleDAO = null;

	/**
	 * This method return the object of VehicleDAO
	 * @return object of VehicleDAO
	 */
	public static VehicleDAO getInstance(){

		if(vehicleDAO == null){
			vehicleDAO = new VehicleDAO();
		}
		return vehicleDAO;
	}

	/**
	 * This method add vehicle details to database
	 * @param vehicle object of Vehicle containing details of vehicle
	 * @param empId employee id
	 * @return true if added else false
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public boolean addVehicle(VehicleDTO vehicle, int empId) throws SQLException,Exception{

		Connection conn = null;
		PreparedStatement preStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.ADD_VEHICLE);
			preStmt.setString(1, vehicle.getName());
			preStmt.setString(2, vehicle.getType());
			preStmt.setString(3, vehicle.getNumber());
			preStmt.setString(4, vehicle.getIdentification());
			preStmt.setInt(5, empId);
			int result = preStmt.executeUpdate();
			if(result > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally
		{
				conn.close();
		}
		
	}
	
	/**
	 * This method return the vehicle id from database
	 * @param empId employee id
	 * @return integer vehicle id
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public int getVehicleId(int empId) throws SQLException, Exception{
		
		Connection conn = null;
		PreparedStatement preStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.GET_VEHICLE_ID);
			preStmt.setInt(1, empId);
			ResultSet result = preStmt.executeQuery();
			if(result.next() == false)
			{
				return -1;
			}
			return result.getInt(1);
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally{
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw e;
			}
		}
	}
	
	/**
	 * This method return the type of vehicle
	 * @param empId employee id
	 * @return String containing type of vehicle of employee
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public String getVehicleType(int empId) throws SQLException,Exception{

		Connection conn = null;
		PreparedStatement preStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.GET_VEHICLE_TYPE);
			preStmt.setInt(1, empId);
			ResultSet result = preStmt.executeQuery();
			result.next();
			return result.getString(3);
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally{
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw e;
			}
		}
	}
}