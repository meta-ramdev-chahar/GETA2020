import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Test;

public class TestMultiplyPoly
{


	@Test
	public void test_MultiplyOf_TwoPloynomial_With_Positive_Values() 
	{
		try
		{
			Poly inputPoly1 = new Poly(new int[] { 1, 2, 3, 4, 5 });
			Poly inputPoly2 = new Poly(new int[] {3, 4, 5 });
			int[] expectedOutput = new int[] {3, 10, 22, 34, 46, 40, 25 };
			assertArrayEquals(expectedOutput, Poly.multiplyPoly(inputPoly1, inputPoly2).toArray());
		}
		catch(IOException io)
		{
			assertEquals("Length Should be Greater than zero", io.getMessage());
		}
	}
	
	@Test
	public void test_MultiplyOf_TwoPloynomial_With_Negative_Values_1() 
	{
		try
		{
			Poly inputPoly1 = new Poly(new int[] { -1});
			Poly inputPoly2 = new Poly(new int[] {3, 4, 5 });
			int[] expectedOutput = new int[] {-3, -4, -5};
			assertArrayEquals(expectedOutput, Poly.multiplyPoly(inputPoly1, inputPoly2).toArray());
		}
		catch(IOException io)
		{
			assertEquals("Length Should be Greater than zero", io.getMessage());
		}
	}
	
	@Test
	public void test_MultiplyOf_TwoPloynomial_With_Negative_Values_2() 
	{
		try
		{
			Poly inputPoly1 = new Poly(new int[] { 1, 2});
			Poly inputPoly2 = new Poly(new int[] {-7, 8, 9 });
			int[] expectedOutput = new int[] {-7, -6, 25, 18};
			assertArrayEquals(expectedOutput, Poly.multiplyPoly(inputPoly1, inputPoly2).toArray());
		}
		catch(IOException io)
		{
			assertEquals("Length Should be Greater than zero", io.getMessage());
		}
	}

}