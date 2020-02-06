package dto;

/**
 * 
 * @author Ramdev
 * This class represent plan
 */
public class PlanDTO {

	//This represent id of plan
	private int id;
	//This represent type of plan
	private String type;
	//This represent price of plan
	private double price;
	//This represent currency of plan
	private String currency;
	
	/**
	 * 
	 * This method return the currency of plan
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	
	/**
	 * This method set the currency of plan
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	/**
	 * This method return the id of plan
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * This method set the id of plan
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * This method return the type of plan
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * This method set the type of plan
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * This method return the price of plan
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * This method set the price of plan
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
}