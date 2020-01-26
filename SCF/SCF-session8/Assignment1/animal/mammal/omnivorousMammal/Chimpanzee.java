package animal.mammal.omnivorousMammal;

/**
* @author Ramdev
* Implements the Attributes of a Chimpanzee
*/
public class Chimpanzee extends OmnivorousMammal
{
	/**
	 * Constructor To initialize basic attributes of a Chimpanzee
	 * @param uniqueName : unique name of a particular Chimpanzee
	 * @param age : age of Chimpanzee
	 * @param weight : weight of Chimpanzee
	 */
	public Chimpanzee(String uniqueName, double age, double weight)
	{ 
		super();
		this.species = "Chimpanzee";
		this.uniqueName = uniqueName;
		this.age = age;
		this.weight = weight;
		
	}
	/**
	 * To get the sound of Chimpanzee
	 */
	public String getSound()
	{
		return "Chimpanzee Sound";
	}
}
