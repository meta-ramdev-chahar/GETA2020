package animal.reptile.carnivorousReptile;

import animal.reptile.Reptile;

/**
 * @author Ramdev
 * Subclass of Reptile which defines Carnivorous Reptile Sub category of animal
 */
public abstract class CarnivorousReptile extends Reptile
{
	/**
	 * Constructor to assign Sub category of animal
	 */
	protected CarnivorousReptile()
	{
		super.subCategory = "Carnivorous Reptile";
	}

}
