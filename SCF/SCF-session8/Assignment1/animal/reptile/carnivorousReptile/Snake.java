package animal.reptile.carnivorousReptile;
/**
* @author Ramdev
* Implements the Attributes of a Snake
*/
public class Snake extends CarnivorousReptile
{
	/**
	 * Constructor To initialize basic attributes of a Snake
	 * @param uniqueName : unique name of a particular Snake
	 * @param age : age of Snake
	 * @param weight : weight of Snake
	 */
	public Snake(String uniqueName, double age, double weight)
	{ 
		super();
		this.species = "Snake";
		this.uniqueName = uniqueName;
		this.age = age;
		this.weight = weight;
		
	}
	/**
	 * To get the sound of Snake
	 */
	public String getSound()
	{
		return "Snake Sound";
	}

}

