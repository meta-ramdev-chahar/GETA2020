package animal.mammal;
import animal.Animal;

/**
 * @author Ramdev
 * Subclass of Animal class which defines the Mammal category of a Animal
 */
public abstract class Mammal extends Animal
{
	/**
	 * Constructor to assign category of animal
	 */
	protected Mammal()
	{
		super.category = "Mammal";
	}
}

