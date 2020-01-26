package animal;
/**
 * 
 * @author Ramdev
 * A Base Class for Animals and its sub classes could be various categories
 *  of animals like Mammal, Reptile, Bird, etc
 */
 public abstract class Animal 
{
	public String category;
	public String subCategory;
	public String species;
	public String uniqueName;
	public double age;
	public double weight;
	
	/**
	 * To get the sound of an animal
	 * @return a string representing the sound corresponding to that animal type.
	 */
	abstract public String getSound();
}
