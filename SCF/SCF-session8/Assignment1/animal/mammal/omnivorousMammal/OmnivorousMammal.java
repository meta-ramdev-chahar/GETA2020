package animal.mammal.omnivorousMammal;

import animal.mammal.Mammal;


/**
 * @author Ramdev
 * Subclass of Mammal which defines Omnivore Mammal Sub category of animal
 */
public abstract class OmnivorousMammal extends Mammal
{
	/**
	 * Constructor to assign Sub category of animal
	 */
	protected OmnivorousMammal()
	{
		super.subCategory = "Omnivorous Mammal";
	}

}
