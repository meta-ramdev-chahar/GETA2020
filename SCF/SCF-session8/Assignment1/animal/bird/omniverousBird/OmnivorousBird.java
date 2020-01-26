package animal.bird.omniverousBird;

import animal.bird.Bird;

/**
 * @author Ramdev
 * Subclass of Bird which defines Omnivorous Bird Sub category of animal
 */
public abstract class OmnivorousBird extends Bird 
{
	/**
	 * Constructor to assign Sub category of animal
	 */
	protected OmnivorousBird()
	{
		super.subCategory = "Omnivorous Bird";
	}
}
