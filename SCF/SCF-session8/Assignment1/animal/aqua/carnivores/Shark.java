package animal.aqua.carnivores;

/**
 * @author Ramdev
 * Implements the Attributes of a shark
 */
public class Shark extends CarnivorousAqua
{
	/**
	 * Constructor To initialize basic attributes of a shark
	 * @param uniqueName : unique name of a particular Shark
	 * @param age : age of shark
	 * @param weight : weight of shark
	 */
	public Shark(String uniqueName, double age, double weight)
	{ 
		super();
		this.species = "Shark";
		this.uniqueName = uniqueName;
		this.age = age;
		this.weight = weight;
		
	}
	/**
	 * To get the sound of shark
	 */
	public String getSound()
	{
		return "Draughtsboard";
	}

}
