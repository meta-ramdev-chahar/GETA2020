package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import util.DatabaseQuery;
import dto.EmployeeDTO;
import factory.ConnectionFactory;

/**
 * 
 * @author Ramdev
 * This is dao class for login management
 */
public class LoginDAO {

	//Singleton object of LoginDAO
	private static LoginDAO loginDAO = null;

	/**
	 * This method return object of LoginDAO
	 * @return object of LoginDAO
	 */
	public static LoginDAO getInstance(){

		if(loginDAO == null){
			loginDAO = new LoginDAO();
		}
		return loginDAO;
	}

	/**
	 * This method authenticate user details 
	 * @param user object of User class
	 * @return true if user details are correct else false
	 * @throws SQLExcepion exception related to database
	 * @throws Excepiton other general exception
	 */
	public boolean login(EmployeeDTO employee) throws SQLException, Exception{

		Connection conn = null;
		PreparedStatement preStmt = null;

		try {
			conn = ConnectionFactory.getConnection();
			preStmt = conn.prepareStatement(DatabaseQuery.CHECK_LOGIN);
			preStmt.setString(1, employee.getEmail());
			preStmt.setString(2, employee.getPassword());
			ResultSet result = preStmt.executeQuery();
			if(result.next())
			{
				employee.setId(result.getInt(1));
				return true;
			}else{
					return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}