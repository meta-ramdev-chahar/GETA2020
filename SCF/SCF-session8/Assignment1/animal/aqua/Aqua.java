package animal.aqua;

import animal.Animal;
/**
 * 
 * @author Ramdev
 * Subclass of Animal class which defines the Aqua category of a Animal
 */
public abstract class Aqua extends Animal
{
	/**
	 * Constructor to assign category of animal
	 */
	protected Aqua()
	{
		super.category = "Aqua";
	}
}
