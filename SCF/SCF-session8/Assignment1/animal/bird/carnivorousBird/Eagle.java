package animal.bird.carnivorousBird;

/**
 * @author Ramdev
 * Implements the Attributes of a Eagle
 */
public class Eagle extends CarnivorousBird
{
	/**
	 * Constructor To initialize basic attributes of a Eagle
	 * @param uniqueName : unique name of a particular Eagle
	 * @param age : age of Eagle
	 * @param weight : weight of Eagle
	 */
	public Eagle(String uniqueName, double age, double weight)
	{ 
		super();
		this.species = "Eagle";
		this.uniqueName = uniqueName;
		this.age = age;
		this.weight = weight;
		
	}
	/**
	 * To get the sound of Eagle
	 */
	public String getSound()
	{
		return "Eagle Sound";
	}

}
