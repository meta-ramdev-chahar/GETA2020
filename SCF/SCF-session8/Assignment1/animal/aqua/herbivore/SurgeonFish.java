package animal.aqua.herbivore;

/**
 * @author Ramdev
 * Implements the Attributes of a SurgeonFish
 */
public class SurgeonFish extends HerbivoreAqua
{
	/**
	 * Constructor To initialize basic attributes of a SurgeonFish
	 * @param uniqueName : unique name of a particular SurgeonFish
	 * @param age : age of SurgeonFish
	 * @param weight : weight of SurgeonFish
	 */
	public SurgeonFish(String uniqueName, double age, double weight)
	{ 
		super();
		this.species = "SurgeonFish";
		this.uniqueName = uniqueName;
		this.age = age;
		this.weight = weight;
		
	}
	/**
	 * To get the sound of SurgeonFish
	 */
	public String getSound()
	{
		return "SurgeonFish Sound";
	}
}
