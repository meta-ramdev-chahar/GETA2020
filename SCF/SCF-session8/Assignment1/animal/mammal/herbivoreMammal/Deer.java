package animal.mammal.herbivoreMammal;
/**
* @author Ramdev
* Implements the Attributes of a Deer
*/
public class Deer extends HerbivoreMammal
{
	/**
	 * Constructor To initialize basic attributes of a Deer
	 * @param uniqueName : unique name of a particular Deer
	 * @param age : age of Deer
	 * @param weight : weight of Deer
	 */
	public Deer(String uniqueName, double age, double weight)
	{ 
		super();
		this.species = "Deer";
		this.uniqueName = uniqueName;
		this.age = age;
		this.weight = weight;
		
	}
	/**
	 * To get the sound of Deer
	 */
	public String getSound()
	{
		return "Deer Sound";
	}
}
