package dto;

/**
 * 
 * @author Ramdev
 * This class represent employee
 */
public class EmployeeDTO {

	//This represent id of employee
	private int id;
	//This represent name of employee
	private String name;
	//This represent gender of employee
	private String gender;
	//This represent email of employee
	private String email;
	//This represent password of employee
	private String password;
	//This represent phone number of employee
	private String phoneNumber;
	//This represent organization of employee
	private String organization;
	
	/**
	 * This method return id of employee
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * This method set the id of employee
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * This method return name of employee
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method set the name of employee
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method return gender of employee
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * This method set the gender of employee
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * This method return email of employee
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * This method set the email of employee
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * This method return password of employee
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * This method set the password of employee
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * This method return phone number of employee
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * This method set the phone number of employee
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * This method return organization of employee
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}
	
	/**
	 * This method set the organization of employee
	 * @param organization the organization to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

}