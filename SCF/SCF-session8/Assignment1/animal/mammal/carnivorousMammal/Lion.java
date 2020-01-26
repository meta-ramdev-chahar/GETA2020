package animal.mammal.carnivorousMammal;

/**
* @author Ramdev
* Implements the Attributes of a Lion
*/
public class Lion extends CarnivorousMammal
{
	/**
	 * Constructor To initialize basic attributes of a Lion
	 * @param uniqueName : unique name of a particular Lion
	 * @param age : age of Lion
	 * @param weight : weight of Lion
	 */
	public Lion(String uniqueName, double age, double weight)
	{ 
		super();
		this.species = "Lion";
		this.uniqueName = uniqueName;
		this.age = age;
		this.weight = weight;
		
	}
	/**
	 * To get the sound of Lion
	 */
	public String getSound()
	{
		return "Lion Sound";
	}

}
