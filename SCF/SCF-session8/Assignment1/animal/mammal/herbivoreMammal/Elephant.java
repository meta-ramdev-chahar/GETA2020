package animal.mammal.herbivoreMammal;
/**
* @author Ramdev
* Implements the Attributes of a Elephant
*/
public class Elephant extends HerbivoreMammal
{
	/**
	 * Constructor To initialize basic attributes of a Elephant
	 * @param uniqueName : unique name of a particular Elephant
	 * @param age : age of Elephant
	 * @param weight : weight of Elephant
	 */
	public Elephant(String uniqueName, double age, double weight)
	{ 
		super();
		this.species = "Elephant";
		this.uniqueName = uniqueName;
		this.age = age;
		this.weight = weight;
		
	}
	/**
	 * To get the sound of Elephant
	 */
	public String getSound()
	{
		return "Elephant Sound";
	}
}
