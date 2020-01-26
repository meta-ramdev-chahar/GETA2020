package zoo;

import animal.Animal;
 /**
  * 
  * @author Ramdev
  * Implements the methods for a Zone's cage like isNotFull , addAnimalToCage and removeAnimalFromCage
  */
public class Cage 
{
	private int cageCapacity;
	private String cageSpeciesType;
	private int totalAnimalsInCage;
	private Animal[] animals;
	
	/**
	 * Constructor to initialize instance variables of Cage
	 * @param cageSpeciesType : the type of species in a cage
	 * @param cageCapacity : The capacity animals in a cage
	 */

	public Cage(String cageSpeciesType, int cageCapacity)
	{
		this.cageCapacity = cageCapacity;
		this.cageSpeciesType = cageSpeciesType;
		this.totalAnimalsInCage = 0;
		this.animals = new Animal[cageCapacity];
	}
	/**
	 * To check if a cage is full or not
	 * @return True if cage is not full else false
	 */
	public boolean isNotFull()
	{
		if( totalAnimalsInCage >= cageCapacity )
			return false;
		else
			return true;
	}
	/**
	 * To add a animal in to the cage
	 * @param animal
	 * @return True if an animal is successfully added else false
	 * @throws AssertionError if there is already animal exists with same unique name
	 */
	public boolean addAnimalToCage(Animal animal) throws AssertionError
	{
		this.animals[totalAnimalsInCage] = animal;
		totalAnimalsInCage += 1;
		return true;
	}
	/**
	 * To remove animal from a cage
	 * @param animal
	 * @return True if successfully removed else AssertionError
	 */
	public boolean removeAnimalFromCage(Animal animal) throws AssertionError
	{
		int animalIdInCage = findAnimalByUniqueName(animal);
		if(animalIdInCage == -1)
			throw new AssertionError("No Such animal is Exists");
		
		totalAnimalsInCage--;
		
		for(int i = animalIdInCage; i < totalAnimalsInCage; i++)
			animals[i] = animals[i + 1];
		
		return true;
	}
	/**
	 * To find the Animal from animals by unique name
	 * @param animal
	 * @return the index of animal if it is found else -1
	 */
	public int findAnimalByUniqueName(Animal animal)
	{
		for(int i = 0; i < this.totalAnimalsInCage; i++ )
		{
			if(animals[i].uniqueName.equalsIgnoreCase(animal.uniqueName))
				return i;
		}
		return -1;
	}
	/**
	 * to get CageSpeciesType
	 * @return CageSpeciesType
	 */
	public String getCageSpeciesType()
	{
		return this.cageSpeciesType;
	}
}

