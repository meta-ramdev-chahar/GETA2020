package animal.bird.omniverousBird;

/**
 * @author Ramdev
 * Implements the Attributes of a Peacock
 */
public class Peacock extends OmnivorousBird
{
	/**
	 * Constructor To initialize basic attributes of a Peacock
	 * @param uniqueName : unique name of a particular Peacock
	 * @param age : age of Peacock
	 * @param weight : weight of Peacock
	 */
	public Peacock(String uniqueName, double age, double weight)
	{ 
		super();
		this.species = "Peacock";
		this.uniqueName = uniqueName;
		this.age = age;
		this.weight = weight;
		
	}
	/**
	 * To get the sound of Peacock
	 */
	public String getSound()
	{
		return "Peacock Sound";
	}

}
