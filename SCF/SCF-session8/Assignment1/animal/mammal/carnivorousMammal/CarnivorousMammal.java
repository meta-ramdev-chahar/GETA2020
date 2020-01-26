package animal.mammal.carnivorousMammal;

import animal.mammal.Mammal;

/**
 * @author Ramdev
 * Subclass of Mammal which defines Carnivorous Mammal Sub category of animal
 */
public abstract class CarnivorousMammal extends Mammal
{
	/**
	 * Constructor to assign Sub category of animal
	 */
	protected CarnivorousMammal()
	{
		super.subCategory = "Carnivorous Mammal";
	}

}
