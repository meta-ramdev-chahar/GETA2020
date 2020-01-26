package animal.bird;

import animal.Animal;

/**
 * @author Ramdev
 * Subclass of Animal class which defines the Bird category of a Animal
 */
public abstract class Bird extends Animal
{
	/**
	 * Constructor to assign category of animal
	 */
	protected Bird()
	{
		super.category = "Bird";
	}
}
