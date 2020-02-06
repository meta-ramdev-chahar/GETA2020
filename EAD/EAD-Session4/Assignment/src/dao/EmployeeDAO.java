package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DatabaseQuery;
import dto.EmployeeDTO;
import factory.ConnectionFactory;

/**
 * 
 * @author Ramdev
 * This dao class of employee
 */
public class EmployeeDAO {

	/**
	 * Singleton object of EmployeeDAO
	 */
	private static EmployeeDAO employeeDAO = null;

	/**
	 * 
	 * This method return object EmployeeDAO
	 * @return object EmployeeDAO
	 */
	public static EmployeeDAO getInstance(){

		if(employeeDAO == null){
			employeeDAO = new EmployeeDAO();
		}
		return employeeDAO;
	}

	/**
	 * 
	 * This method add employee details to database
	 * @param employee object of Employee containing employee details
	 * @param company object of Company containing company details
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public int addEmployee(EmployeeDTO employee) throws SQLException,Exception{

		Connection conn = null;
		PreparedStatement preStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.ADD_EMPLOYEE);
			preStmt.setString(1, employee.getName());
			preStmt.setString(2, employee.getGender());
			preStmt.setString(3, employee.getEmail());
			preStmt.setString(4, employee.getPassword());
			preStmt.setString(5, employee.getPhoneNumber());
			preStmt.setString(6, employee.getOrganization());

			int result = preStmt.executeUpdate();
			if(result > 0)
			{
				preStmt = conn.prepareStatement(DatabaseQuery.GET_ID_OF_ADDED_EMPLOYEE);
				preStmt.setString(1, employee.getEmail());
				ResultSet resultId= preStmt.executeQuery();
				resultId.next();
				return resultId.getInt(1);
			}
			else
			{
				return -1;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw e;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		finally{
			try{
				conn.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				throw e;
			}
		}

	}

	/**
	 * 
	 * This method use to get employee details from database
	 * @param email email of employee
	 * @return object of Employee containing details of employee
	 * @throws SQLException database related exception
	 * @throws Exception other general exception
	 */
	public EmployeeDTO getEmployeeDetail(String email) throws SQLException,Exception
	{
		Connection conn = null;
		PreparedStatement preStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.GET_EMPLOYEE_DETAIL);
			preStmt.setString(1, email);
			ResultSet result = preStmt.executeQuery();
			EmployeeDTO employee = new EmployeeDTO();
			while(result.next()){
				employee.setId(result.getInt(1));
				employee.setName(result.getString(2));
				employee.setGender(result.getString(3));
				employee.setEmail(result.getString(4));
				employee.setPassword(result.getString(5));
				employee.setPhoneNumber(result.getString(6));
				employee.setOrganization(result.getString(7));
			}
			return employee;
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}
		catch(Exception e){
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
	 * 
	 * This method get details of employee friend
	 * @param email email of employee
	 * @return object of employee containing details of friend
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public EmployeeDTO getFriendDetail(String email) throws SQLException,Exception
	{
		Connection conn = null;
		PreparedStatement preStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.GET_EMPLOYEE_DETAIL);
			preStmt.setString(1, email);
			ResultSet result = preStmt.executeQuery();
			EmployeeDTO employee = new EmployeeDTO();
			while(result.next())
			{
				employee.setId(result.getInt(1));
				employee.setName(result.getString(2));
				employee.setGender(result.getString(3));
				employee.setEmail(result.getString(4));
				employee.setPhoneNumber(result.getString(6));
				employee.setOrganization(result.getString(7));
			}
			return employee;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			throw e;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally
		{
				conn.close();
		}
	}

	/**
	 * 
	 * This method is use to update detail of employee in database
	 * @param employee object of Employee containing details of employee
	 * @param email email of employee
	 * @return true if updated else false
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public boolean updateEmployeeDetail(EmployeeDTO employee) throws SQLException,Exception{

		Connection conn = null;
		PreparedStatement preStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.UPDATE_EMPLOYEE_DETAIL);
			preStmt.setString(1, employee.getName());
			preStmt.setString(2, employee.getGender());
			preStmt.setString(3, employee.getEmail());
			preStmt.setString(4, employee.getPassword());
			preStmt.setString(5, employee.getPhoneNumber());
			preStmt.setString(6, employee.getOrganization());
			preStmt.setInt(7, employee.getId());
			int result = preStmt.executeUpdate();
			if(result > 0){
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally{
				conn.close();
			
		}
	}

	/**
	 * 
	 * This method is use to get the list of friends of employee
	 * @param email email of employee
	 * @return List of employee 
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public List<EmployeeDTO> getFriendList(String email, int eid) throws SQLException,Exception
	{
		Connection conn = null;
		PreparedStatement preStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.GET_FRIENDS_LIST);
			preStmt.setString(2, email);
			preStmt.setInt(1, eid);
			ResultSet result = preStmt.executeQuery();
			List<EmployeeDTO> friendList = new ArrayList<EmployeeDTO>();
			while(result.next())
			{
				EmployeeDTO employee = new EmployeeDTO();
				employee.setId(result.getInt(1));
				employee.setName(result.getString(2));
				employee.setEmail(result.getString(4));
				friendList.add(employee);
			}
			return friendList;
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally
		{
			conn.close();
		}
	}

	/**
	 * 
	 * This method is use to get the employee id
	 * @param email email of employee
	 * @return integer id of employee
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public int getEmployeeId(String email) throws SQLException,Exception{

		Connection conn = null;
		PreparedStatement preStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.GET_EMPLOYEE_ID);
			preStmt.setString(1, email);
			ResultSet result = preStmt.executeQuery();
			result.next();
			return result.getInt(1);
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally
		{
			conn.close();
		}
	}
}