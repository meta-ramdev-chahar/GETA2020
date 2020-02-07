package triangle;

/**
 * 
 * @author Ramdev
 * Implement the method for Area of triangle
 */
public class Triangle {
	
	public String area(int firstSide,int secondSide,int thirdSide)
	{
		double semiPerimeter = (firstSide+secondSide+thirdSide)/2.0;
		double areaSquare = semiPerimeter * (semiPerimeter - firstSide) * (semiPerimeter - secondSide) * (semiPerimeter - thirdSide);
		double area = Math.sqrt(areaSquare);
		return String.valueOf((int)area);
	}

}
