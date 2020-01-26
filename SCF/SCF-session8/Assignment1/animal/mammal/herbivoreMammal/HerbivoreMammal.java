package animal.mammal.herbivoreMammal;

import animal.mammal.Mammal;

/**
 * @author Ramdev
 * Subclass of Mammal which defines Herbivore Mammal Sub category of animal
 */
public abstract class HerbivoreMammal extends Mammal
{
	/**
	 * Constructor to assign Sub category of animal
	 */
	protected HerbivoreMammal()
	{
		super.subCategory = "Herbivore Mammal";
	}
}
