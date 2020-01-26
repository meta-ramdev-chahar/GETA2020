package animal.mammal.carnivorousMammal;

/**
* @author Ramdev
* Implements the Attributes of a Lion
*/
public class Tiger extends CarnivorousMammal
{
	/**
	 * Constructor To initialize basic attributes of a Tiger
	 * @param uniqueName : unique name of a particular Tiger
	 * @param age : age of Tiger
	 * @param weight : weight of Tiger
	 */
	public Tiger(String uniqueName, double age, double weight)
	{ 
		super();
		this.species = "Tiger";
		this.uniqueName = uniqueName;
		this.age = age;
		this.weight = weight;
		
	}
	/**
	 * To get the sound of Tiger
	 */
	public String getSound()
	{
		return "Tiger Sound";
	}

}
