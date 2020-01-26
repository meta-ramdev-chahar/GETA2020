package zoo;
import animal.Animal;
/**
 * 
 * @author Ramdev
 * Implements the methods like addZone , addAnimal , remove animal
 */
public class Zoo 
{
	private Zone zones[];
	
	//count of All the available zones
	public int totalZones;
	
	//Maximum numbers of zones that a zoo can have
	private final int MAX_ZONE_LIMIT;
	
	private String[] allAnimalsNamesInZoo;
	private int totalAnimalsCountInZoo;
	/**
	 * Constructor to initialize Zoo instance variables
	 * @param maxZoneLimit : Maximum numbers of zones that a zoo can have
	 */
	public Zoo(int maxZoneLimit)
	{
		this.MAX_ZONE_LIMIT = maxZoneLimit;
		this.totalZones = 0;
		this.totalAnimalsCountInZoo = 0;
		this.zones = new Zone[MAX_ZONE_LIMIT];
		this.allAnimalsNamesInZoo = new String[1000];
	}
	/**
	 * To Add a new Zone in to the Zoo
	 * @param maxCageLimit : Maximum numbers of cage that a zone can have
	 * @param zoneCategory : Category of animal that a zone can have
	 * @param zoneSubCategory : Sub Category of animal that a zone can have
	 * @return true if a zone is successfully added 
	 * @throws AssertionError if zone can not successfully added 
	 */
	public boolean addZone(Zone newZone) throws AssertionError
	{
		if( this.totalZones < this.MAX_ZONE_LIMIT )
		{
			zones[totalZones] = newZone;
			totalZones += 1;
			return true;
		}
		throw new AssertionError("Can not add more zone");
	}
	/**
	 * To add a new animal to the zoo
	 * @param animal : The object of animal which you want to add to the zoo
	 * @return True if It is successfully added else false 
	 */
	public boolean addAnimalToZoo(Animal animal)throws AssertionError
	{
		if(animalIdInZoo(animal.uniqueName) == -1)
		{
			Zone suitableZone = findSuitableZone(animal);
			boolean animalAddedSuccesfully =  suitableZone.addAnimalToZone(animal);
			if(animalAddedSuccesfully)
			{
				allAnimalsNamesInZoo[totalAnimalsCountInZoo] = animal.uniqueName;
				totalAnimalsCountInZoo += 1;
				return true;
			}
			return false;
		}
		throw new AssertionError("Animal with this name is already present in zoo");
	}
	/**
	 * To remove any existing animal from the zoo
	 * @param animal : The object of animal which you want to remove from  the zoo
	 * @return True if It is successfully removed else false
	 */
	public boolean removeAnimalFromZoo(Animal animal)throws AssertionError
	{
		if(animalIdInZoo(animal.uniqueName) == -1)
			throw new AssertionError("No Such animal Exists in this Zoo");
		Zone suitableZone = findSuitableZone(animal);
		boolean animalRemovedSuccessfully = suitableZone.removeAnimalFromZone(animal);
		if(animalRemovedSuccessfully)
		{
			int animalIdInZoo = animalIdInZoo(animal.uniqueName);
			
			totalAnimalsCountInZoo--;

			for(int i = animalIdInZoo; i < totalAnimalsCountInZoo; i++)
				allAnimalsNamesInZoo[i] = allAnimalsNamesInZoo[i + 1];
			return true;
		}
		return false;
	}
	/**
	 * To find the suitable zone for a animal
	 * @param animal : Object if Animal Class 
	 * @return The suitable zone's object
	 * @throws AssertionError if No zone found
	 */
	private Zone findSuitableZone(Animal animal) throws AssertionError
	{
		for(int i = 0; i < totalZones; i++)
		{
			if(zones[i].getZoneCategory() == animal.category && zones[i].getZoneSubCategory() == animal.subCategory)
				return zones[i];
		}
		throw new AssertionError("No zone available for this");
	}
	/**
	 * To check the name of new animal is unique or not
	 * @return animalIdInZoo if name is unique else -1
	 */
	private int animalIdInZoo(String animalName)
	{
		for(int i = 0; i < totalAnimalsCountInZoo; i++)
		{
			if(allAnimalsNamesInZoo[i] == animalName)
				return i;
		}
		return -1;
	}
}
