package dto;

/**
 * 
 * @author Ramdev
 * This represent the vehicle
 */
public class VehicleDTO {

	//This represent id of vehicle
	private int id;
	//This represent name of vehicle
	private String name;
	//This represent type of vehicle
	private String type;
	//This represent number of vehicle
	private String number;
	//This represent identification of vehicle
	private String identification;

	/**
	 * This method return the  id of vehicle
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * This method set the id of vehicle
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * This method return the name of vehicle
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method set the name of vehicle
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method return the type of vehicle
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * This method set the type of vehicle
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * This method return the number of vehicle
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * This method set the number of vehicle
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * This method return the identification of vehicle
	 * @return the identification
	 */
	public String getIdentification() {
		return identification;
	}

	/**
	 * This method set the identification of vehicle
	 * @param identification the identification to set
	 */
	public void setIdentification(String identification) {
		this.identification = identification;
	}
}