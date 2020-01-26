package animal.bird.carnivorousBird;

/**
 * @author Ramdev
 * Implements the Attributes of a Owl
 */
public class Owl extends CarnivorousBird
{
	/**
	 * Constructor To initialize basic attributes of a Owl
	 * @param uniqueName : unique name of a particular Owl
	 * @param age : age of Owl
	 * @param weight : weight of Owl
	 */
	public Owl(String uniqueName, double age, double weight)
	{ 
		super();
		this.species = "Owl";
		this.uniqueName = uniqueName;
		this.age = age;
		this.weight = weight;
		
	}
	/**
	 * To get the sound of Owl
	 */
	public String getSound()
	{
		return "Owl Sound";
	}

}
