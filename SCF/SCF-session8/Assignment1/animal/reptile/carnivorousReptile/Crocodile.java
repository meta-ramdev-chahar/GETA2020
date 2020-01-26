package animal.reptile.carnivorousReptile;
/**
* @author Ramdev
* Implements the Attributes of a Crocodile
*/
public class Crocodile extends CarnivorousReptile
{
	/**
	 * Constructor To initialize basic attributes of a Crocodile
	 * @param uniqueName : unique name of a particular Crocodile
	 * @param age : age of Crocodile
	 * @param weight : weight of Crocodile
	 */
	public Crocodile(String uniqueName, double age, double weight)
	{ 
		super();
		this.species = "Crocodile";
		this.uniqueName = uniqueName;
		this.age = age;
		this.weight = weight;
		
	}
	/**
	 * To get the sound of Crocodile
	 */
	public String getSound()
	{
		return "Crocodile Sound";
	}

}
