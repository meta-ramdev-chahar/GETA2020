package animal.bird.herbivoreBird;

/**
 * @author Ramdev
 * Implements the Attributes of a Duck
 */
public class Duck extends HerbivoreBird 
{
	/**
	 * Constructor To initialize basic attributes of a Duck
	 * @param uniqueName : unique name of a particular Duck
	 * @param age : age of Duck
	 * @param weight : weight of Duck
	 */
	public Duck(String uniqueName, double age, double weight)
	{ 
		super();
		this.species = "Duck";
		this.uniqueName = uniqueName;
		this.age = age;
		this.weight = weight;
		
	}
	/**
	 * To get the sound of Duck
	 */
	public String getSound()
	{
		return "Duck Sound";
	}

}
