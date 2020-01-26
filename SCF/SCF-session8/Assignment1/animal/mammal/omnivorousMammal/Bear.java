package animal.mammal.omnivorousMammal;

/**
* @author Ramdev
* Implements the Attributes of a Bear
*/
public class Bear extends OmnivorousMammal
{
	/**
	 * Constructor To initialize basic attributes of a Bear
	 * @param uniqueName : unique name of a particular Bear
	 * @param age : age of Bear
	 * @param weight : weight of Bear
	 */
	public Bear(String uniqueName, double age, double weight)
	{ 
		super();
		this.species = "Bear";
		this.uniqueName = uniqueName;
		this.age = age;
		this.weight = weight;
		
	}
	/**
	 * To get the sound of Bear
	 */
	public String getSound()
	{
		return "Bear Sound";
	}
}
