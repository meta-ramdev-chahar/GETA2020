import java.io.IOException;
/**
 * 
 * @author Ramdev
 * Implement evaluate, degree, addPoly, multiplyPoly methods for a single variable polynomial
 */
final class Poly 
{
	private final int[] polynomial;
	/**
	 * Constructor to initialize polynomial
	 * @param poly : input array whose index denotes the powers and values denotes the cofficients of polynomial 
	 * @throws IOException when try to create null polynomial
	 */
	public Poly(int[] poly ) throws IOException
	{
		if(poly.length == 0)
		{
			throw new IOException("Length Should be Greater than zero");
		}
		this.polynomial = poly;
	
	}
	/**
	 * find the evaluated result of polynomial
	 * @param variableValue : value of variable
	 * @return result : the evaluated result
	 */
	public float evaluate(float variableValue ) 
	{
		float result = 0.0f;
		for(int index = 0; index < polynomial.length; index++)
			result += (polynomial[index] * Math.pow(variableValue, index));
		
		return result;
	}
	/**
	 * find the degree of polynomial
	 * @return degree
	 */
	public int  degree() 
	{
		return polynomial.length - 1;
		
	}
	/**
	 * find the additions of two polynomials
	 * @param firstPolynomial
	 * @param secondPolynomial
	 * @return addition to two polynomials
	 */
	public static Poly addPoly(Poly firstPolynomial, Poly secondPolynomial) throws IOException
	{
		if(secondPolynomial.polynomial.length > firstPolynomial.polynomial.length)
		{
			Poly temp = firstPolynomial;
			firstPolynomial = secondPolynomial;
			secondPolynomial = temp;
		}
		
		int[] newPolynomial = new int[firstPolynomial.polynomial.length];
		
		for(int index = 0; index < newPolynomial.length; index++)
		{
			if(index < secondPolynomial.polynomial.length )
			{
				newPolynomial[index] = firstPolynomial.polynomial[index] + secondPolynomial.polynomial[index];
			}
			else
			{
				newPolynomial[index] = firstPolynomial.polynomial[index];
			}
			
		}
		return new Poly(newPolynomial);
	}
	/**
	 * find the multiplication of two polynomials
	 * @param firstPolynomial
	 * @param secondPolynomial
	 * @return multiplication of two polynomials
	 */
	public static Poly multiplyPoly(Poly firstPolynomial, Poly secondPolynomial) throws IOException
	{
		
		int[] newPolynomial = new int[firstPolynomial.polynomial.length + secondPolynomial.polynomial.length - 1];
		
		for(int i = firstPolynomial.polynomial.length - 1; i >= 0; i--)
		{
			for(int j = secondPolynomial.polynomial.length - 1; j >= 0; j--)
				newPolynomial[i + j] += firstPolynomial.polynomial[i] * secondPolynomial.polynomial[j];
			
		}
		return new Poly(newPolynomial);
	}
	/**
	 * converts a polynomial to array
	 * @return
	 */
	
	public int[] toArray()
    {
    	int[] arr = this.polynomial.clone();
    	return arr;
    	
    }
	
}
