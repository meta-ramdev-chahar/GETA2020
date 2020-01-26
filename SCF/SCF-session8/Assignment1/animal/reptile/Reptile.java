package animal.reptile;
import animal.Animal;

/**
 * @author Ramdev
 * Subclass of Animal class which defines the Reptile category of a Animal
 */
public abstract class Reptile extends Animal
{
	/**
	 * Constructor to assign category of animal
	 */
	protected Reptile()
	{
		super.category = "Reptile";
	}
}