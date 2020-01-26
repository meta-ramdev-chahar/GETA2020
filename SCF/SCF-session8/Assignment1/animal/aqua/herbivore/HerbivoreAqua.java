package animal.aqua.herbivore;

import animal.aqua.Aqua;
/**
 * @author Ramdev
 * Subclass of Aqua which defines Herbivore aqua Sub category of animal
 */
public abstract class HerbivoreAqua extends Aqua
{
	/**
	 * Constructor to assign Sub category of animal
	 */
	protected HerbivoreAqua()
	{
		super.subCategory= "Herbivore Aqua";
	}
}
