package zoo;

import animal.Animal;
import zoo.Cage;
/**
 * 
 * @author Ramdev
 * implements the methods of Zoo's zone like Add cage,Add animal to zone , remove animals from zone etc
 */
public class Zone
{
	//The maximum number of cages a Zoo can have
	private int maxCageLimit;
	
	//total available cages
	private int totalCages;
	
	//category of animals which a zone can have 
	private String zoneCategory;
	
	//sub category of animals which a zone can have 
	private String zoneSubCategory;
	
	//All the cages of Zone
	private Cage[] cages; 
	/**
	 * Constructor to initialize Zone instance variables 
	 * @param maxCageLimit : The maximum number of cages a Zoo can have 
	 * @param zoneCategory :  category of animals which a zone can have
	 * @param zoneSubCategory : sub category of animals which a zone can have
	 */
	public Zone( int maxCageLimit, String zoneCategory, String zoneSubCategory )
	{
		this.zoneCategory = zoneCategory;
		this.zoneSubCategory = zoneSubCategory;
		this.maxCageLimit = maxCageLimit;
		this.cages = new Cage[maxCageLimit];
		this.totalCages = 0;
	}
	/**
	 * To add a new cage to zone
	 * @param cageSpeciesType : the type of species that a cage can have
	 * @param cageCapacity : total capacity of animals that can be added to a cage
	 * @return true if a cage is successfully added to the zone otherwise Assertion error
	 */
	public boolean addCage(String cageSpeciesType, int cageCapacity) throws AssertionError
	{
		if(this.totalCages < this.maxCageLimit)
		{
			Cage newCage = new Cage(cageSpeciesType, cageCapacity);
			cages[totalCages] = newCage;
			totalCages += 1;
			return true;
		}
		throw new AssertionError("Cage can not be added");
	}
	/**
	 * to add animal to a zone
	 * @param animal : The object of animal class
	 * @return True if animal is successfully added else false
	 */
	public boolean addAnimalToZone(Animal animal) 
	{
		Cage suitableCage = findSuitableCage(animal);
		return suitableCage.addAnimalToCage(animal);
	}
	/**
	 * To remove any animal from a zone
	 * @param animal : The object of animal class
	 * @return True if an animal is successfully removed else false
	 */
	public boolean removeAnimalFromZone(Animal animal)
	{
		Cage suitableCage = findSuitableCage(animal);
		return suitableCage.removeAnimalFromCage(animal);
	}
	/**
	 * To find the suitable cage for an animal is this zone 
	 * @param animal 
	 * @return the object of cage which is suitable for given animal
	 * @throws AssertionError if no suitable cage found
	 */
	public Cage findSuitableCage(Animal animal) throws AssertionError
	{
		for(int i = 0; i < this.totalCages; i++)
		{
			if(cages[i].getCageSpeciesType() == animal.species && cages[i].isNotFull())
				return cages[i];
		}
		throw new AssertionError("No cage available You can Add new cage");
	}
	
	/**
	 * To get the animal category of Zone
	 * @return category animals of zone
	 */
	public String getZoneCategory()
	{
		return this.zoneCategory;
	}
	
	/**
	 * To get the animal Sub category of Zone
	 * @return sub category animals of zone
	 */
	public String getZoneSubCategory()
	{
		return this.zoneSubCategory;
	}

}
