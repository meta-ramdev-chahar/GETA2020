package animal.aqua.carnivores;

import animal.aqua.Aqua;

/**
 * 
 * @author Ramdev
 * Subclass of Aqua which defines carnivorous aqua Sub category of animal
 */

public abstract class CarnivorousAqua extends Aqua 
{
	/**
	 * Constructor to assign Sub category of animal
	 */
	protected CarnivorousAqua()
	{
		super.subCategory= "Carnivorous Aqua";
	}
}
