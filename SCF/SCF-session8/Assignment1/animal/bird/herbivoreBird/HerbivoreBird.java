package animal.bird.herbivoreBird;

import animal.bird.Bird;

/**
 * @author Ramdev
 * Subclass of Bird which defines Herbivore Bird Sub category of animal
 */
public abstract class HerbivoreBird extends Bird
{
	/**
	 * Constructor to assign Sub category of animal
	 */
	protected HerbivoreBird()
	{
		super.subCategory = "Herbivore Bird";
	}

}
