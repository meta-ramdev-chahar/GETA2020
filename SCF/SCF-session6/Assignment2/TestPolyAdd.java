import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Test;

public class TestPolyAdd
{


	@Test
	public void test_AdditionOf_TwoPloynomial_With_Positive_Values() 
	{
		try
		{
			Poly inputPoly1 = new Poly(new int[] { 1, 2, 3, 4, 5 });
			Poly inputPoly2 = new Poly(new int[] {3, 4, 5 });
			int[] expectedOutput = new int[] {4, 6, 8, 4, 5};
			assertArrayEquals(expectedOutput, Poly.addPoly(inputPoly1, inputPoly2).toArray());
		}
		catch(IOException io)
		{
			assertEquals("Length Should be Greater than zero", io.getMessage());
		}
	}
	
	@Test
	public void test_AdditionOf_TwoPloynomial_With_Negative_Values() 
	{
		try
		{
			Poly inputPoly1 = new Poly(new int[] { -1, 5, -4});
			Poly inputPoly2 = new Poly(new int[] {3, 4, 5 });
			int[] expectedOutput = new int[] {2, 9, 1};
			assertArrayEquals(expectedOutput, Poly.addPoly(inputPoly1, inputPoly2).toArray());
		}
		catch(IOException io)
		{
			assertEquals("Length Should be Greater than zero", io.getMessage());
		}
	}
	
}