package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import util.DatabaseQuery;
import dto.PlanDTO;
import factory.ConnectionFactory;

/**
 * 
 * @author Ramdev
 * This is dao class for Plan
 */
public class PlanDAO {

	//Singleton object of PlanDAO
	private static PlanDAO planDAO = null;

	/**
	 * This method return object of PlanDAO class
	 * @return object of PlanDAO class
	 */
	public static PlanDAO getInstance(){

		if(planDAO == null){
			planDAO = new PlanDAO();
		}
		return planDAO;
	}
	
	/**
	 * This method add plan details to database
	 * @param plan object of Plan containing details of plan
	 * @param empId employee id
	 * @return true if plan is added else false
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public boolean addPlan(PlanDTO plan, int empId) throws SQLException,Exception{
		
		Connection conn = null;
		PreparedStatement preStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.ADD_PLAN);
			preStmt.setString(1, plan.getType());
			preStmt.setDouble(2, plan.getPrice());
			preStmt.setInt(3, empId);
			int result = preStmt.executeUpdate();
			if(result > 0){
				conn.setAutoCommit(true);
				return true;
			}else{
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
	 * This method find and return id of plan from database
	 * @param empId employee id
	 * @return integer plan id
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public int getPlanId(int empId) throws SQLException,Exception 
	{	
		Connection conn = null;
		PreparedStatement preStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.GET_PLAN_ID);
			preStmt.setInt(1, empId);
			ResultSet result = preStmt.executeQuery();
			if(result.next())
			{
				return result.getInt(1);
			}
			return -1;
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
}