package util;

/**
 * 
 * @author Ramdev
 * This class contain database query
 */
public class DatabaseQuery {

	// This is for checking user access
	public static final String CHECK_LOGIN = "SELECT * from employee where email = ? and password = ?";
	// This is for getting employee details
	public static final String GET_EMPLOYEE_DETAIL = "select * from employee where email = ?";
	// This is for updating employee details
	public static final String UPDATE_EMPLOYEE_DETAIL = "update employee set name = ?, gender = ?, email = ?, password = ?, contact = ?, organization = ? where eid = ?";
	// This is for adding employee
	public static final String ADD_EMPLOYEE = "insert into employee(name, gender, email, password, contact, organization) values(?, ?, ?, ?, ?, ?)";
	// This is for getting id of last added employee
	public static final String GET_ID_OF_ADDED_EMPLOYEE = "select * from employee where email = ?";
	// This is for adding vehicle
	public static final String ADD_VEHICLE = "insert into vehicle (name, type, number, identification, eid) values(?, ?, ?, ?, ?)";
	// This is for adding plan
	public static final String ADD_PLAN = "insert into plandetails (plantype, price, eid) values(?, ?, ?)";
	// This is for getting friend list of employee
	public static final String GET_FRIENDS_LIST = "select * from employee where eid != ? and organization = (select organization from employee where email = ?)";
	// This is for getting employee id
	public static final String GET_EMPLOYEE_ID = "SELECT * from employee where email = ?";
	// This is for getting vehicle id
	public static final String GET_VEHICLE_ID = "SELECT * from vehicle where eid = ?";
	// This is for getting plan id
	public static final String GET_PLAN_ID = "SELECT * from plandetails where eid = ?";
	// This is for getting vehicle type
	public static final String GET_VEHICLE_TYPE = "SELECT * from vehicle where eid = ?";

}