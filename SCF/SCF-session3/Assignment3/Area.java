/**
 * 
 * @author Ramdev
 * Area class contains methods to calculate area of different shapes like Triangle, Rectangle, Circle, Square.
 *
 */
public class Area
{
	/**
	 * To find area of Right Angle Triangle
	 * @param  height of a right angle triangle should be > 0
	 * @param width of a right angle triangle should be > 0
	 * @return area of triangle
	 */
	public double getAreaOfTriangle(double height, double base)
	{
		double areaOfTriangle = (height * base ) / 2;
		return areaOfTriangle;
	}
	
	/**
	 * To find area of Rectangle
	 * @param  height of a right angle triangle should be > 0
	 * @param width of a right angle triangle should be > 0
	 * @return area of Rectangle
	 */
	public double getAreaOfRectangle(double height, double base)
	{
		double areaOfRectangle = height * base;
		return areaOfRectangle;
	}
	
	/**
	 * To Find area of Circle
	 * @param radius of a circle should be > 0
	 * @return area of a circle
	 */
	public double getAreaOfCircle(double radius)
	{
		double areaOfCircle = java.lang.Math.PI * java.lang.Math.pow(radius, 2);
		return areaOfCircle;
	}
	/**
	 * To Find area of Square
	 * @param side of a square should be greater than zero
	 * @return area of a square
	 */
	public double getAreaOfSquare(double side)
	{
		double areaOfSquare = java.lang.Math.pow(side, 2);
		return areaOfSquare;
	}
}