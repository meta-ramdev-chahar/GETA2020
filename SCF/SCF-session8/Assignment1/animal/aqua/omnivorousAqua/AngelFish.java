package animal.aqua.omnivorousAqua;

/**
 * @author Ramdev
 * Implements the Attributes of a AngelFish
 */
public class AngelFish extends OmnivorousAqua
{
	/**
	 * Constructor To initialize basic attributes of a AngelFish
	 * @param uniqueName : unique name of a particular AngelFish
	 * @param age : age of AngelFish
	 * @param weight : weight of AngelFish
	 */
	public AngelFish(String uniqueName, double age, double weight)
	{ 
		super();
		this.species = "AngelFish";
		this.uniqueName = uniqueName;
		this.age = age;
		this.weight = weight;
		
	}
	/**
	 * To get the sound of AngelFish
	 */
	public String getSound()
	{
		return "AngelFish Sound";
	}

}
