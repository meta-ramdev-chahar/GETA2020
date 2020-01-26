package animal.bird.carnivorousBird;

import animal.bird.Bird;

/**
 * @author Ramdev
 * Subclass of Bird which defines Carnivorous Bird Sub category of animal
 */
public abstract class CarnivorousBird extends Bird 
{
	/**
	 * Constructor to assign Sub category of animal
	 */
	protected CarnivorousBird()
	{
		super.subCategory = "Carnivorous Bird";
	}

}
