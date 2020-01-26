package zoo;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import animal.Animal;
import animal.aqua.carnivores.Shark;
import animal.aqua.omnivorousAqua.AngelFish;
import animal.bird.carnivorousBird.Eagle;
import animal.mammal.carnivorousMammal.Lion;
import animal.reptile.carnivorousReptile.Crocodile;
import animal.reptile.carnivorousReptile.Snake;

@RunWith(Parameterized.class)
public class TestAddOrRemoveAnimalToZooMethod {
	
	@Before
	public void createAZoo()
	{
		zoo = new Zoo(4);
		Zone aquaCarnivorousZone = new Zone(5, "Aqua", "Carnivorous Aqua");
		aquaCarnivorousZone.addCage("Shark", 5);
		zoo.addZone(aquaCarnivorousZone);
		
		Zone aquaOmnivorousZone = new Zone(5, "Aqua", "Omnivorous Aqua");
		aquaOmnivorousZone.addCage("AngelFish", 5);
		zoo.addZone(aquaOmnivorousZone);
		
		Zone reptileCarnivorousZone = new Zone(5, "Reptile", "Carnivorous Reptile");
		reptileCarnivorousZone.addCage("Crocodile", 5);
		reptileCarnivorousZone.addCage("Snake", 5);
		zoo.addZone(reptileCarnivorousZone);
		
	}
	
	private Animal animal;
	private boolean expectedOutput;
	private Zoo zoo;

	public TestAddOrRemoveAnimalToZooMethod(boolean output, Animal animal)
	{
		this.animal = animal;
		this.expectedOutput = output;
	}
	
	@Parameters
	public static Collection<Object[]> testCases()
	{
		return Arrays.asList(new Object[][]
		{
				{ true, new Shark("Shark1", 23, 345) },
				{ true, new Shark("Shark2", 43, 334) },
				{ true, new AngelFish("AngelFish1", 13, 35) },
				{ true, new Crocodile("Crocodile", 35, 305) },
				{ true, new Snake("Snake", 67, 54) },
				
				
		});	
	}
	
	@Test
	public void test_AddAnimalToZoo_Positive() 
	{
		assertEquals(expectedOutput, zoo.addAnimalToZoo(animal));
	}
	
	@Test(expected = AssertionError.class)
	public void test_AddAnimalToZoo_Negative()
	{
		Animal newAnimal = new Eagle("Eagle1", 45, 54);
		assertEquals(true, zoo.addAnimalToZoo(newAnimal));
	}
	
	@Test(expected = AssertionError.class)
	public void test_AddAnimalToZoo_NegativeAgain()
	{
		Animal newAnimal = new Lion("Lion1", 45, 114);
		assertEquals(true, zoo.addAnimalToZoo(newAnimal));
	}
	
	@Test()
	public void test_RemoveAnimalFromZoo_Positive()
	{
		zoo.addAnimalToZoo(animal);
		assertEquals(expectedOutput, zoo.removeAnimalFromZoo(animal));
	}
	
	@Test(expected = AssertionError.class)
	public void test_RemoveAnimalToZoo_Negative()
	{
		Animal newAnimal = new Eagle("Eagle1", 45, 54);
		assertEquals(true, zoo.removeAnimalFromZoo(newAnimal));
	}
	
	@Test(expected = AssertionError.class)
	public void test_RemoveAnimalToZoo_NegativeAgain()
	{
		Animal newAnimal = new Lion("Lion1", 45, 114);
		assertEquals(false, zoo.removeAnimalFromZoo(newAnimal));
	}
	
}
