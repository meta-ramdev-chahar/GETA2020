package graphicsLibrary;

import java.util.Date;
import java.util.List;

/**
 * @author Ramdev
 * Implements The Shape Interface For Rectangle
 */
public class Rectangle implements Shape
{
	private double xCordinateOfOrigin;
	private double yCordinateOfOrigin;
	private double base;
	private double height;
	private Date dateOfCreation;
	private String shapeType;

	public Rectangle(Point point, List<Integer> listOfParameter)
	{
		this.xCordinateOfOrigin = point.xCordinate;
		this.yCordinateOfOrigin = point.yCordinate;
		this.base = listOfParameter.get(0);
		this.height = listOfParameter.get(1);
		this.dateOfCreation = new Date();
		this.shapeType = "Rectangle";
	}

	/**
	 * To get the Area of Rectangle
	 * @return Area of Rectangle
	 */
	@Override
	public double getArea() 
	{

		return Math.pow(this.base, 2) * Math.pow(this.height, 2);
	}

	/**
	 * To get Perimeter of Rectangle 
	 * @return Perimeter of Rectangle
	 */
	@Override
	public double getPerimeter() 
	{
		return 2 * (this.base + this.height);
	}

	/**
	 * To get origin Point of Rectangle
	 * @return Point Class's object
	 */
	@Override
	public Point getOrigin() 
	{
		return new Point(xCordinateOfOrigin, yCordinateOfOrigin);
	}

	/**
	 * To check if a point in enclosed in a Rectangle or not
	 * @return true if a point is enclosed in a Rectangle else false
	 */
	@Override
	public boolean isPointEnclosed(Point point) 
	{

		double xCordinateOfEnd = this.xCordinateOfOrigin + this.base;
		double yCordinateOfEnd = this.yCordinateOfOrigin + this.height;

		double xCordinateOfGivenPoint = point.xCordinate;
		double yCordinateOfGivenPoint = point.yCordinate;

		if( ( xCordinateOfGivenPoint > xCordinateOfOrigin && xCordinateOfGivenPoint < xCordinateOfEnd ) && ( yCordinateOfGivenPoint > yCordinateOfOrigin && yCordinateOfGivenPoint < yCordinateOfEnd ) )
			return true;
		return false;
	}

	/**
	 * To get the date of creation of this Rectangle
	 * @return Current TimeStamp of System
	 */
	@Override
	public Date getDate() 
	{
		return dateOfCreation;
	}

	/**
	 * To get Shape Type
	 * @return "Rectangle"
	 */
	@Override
	public String getShapeType() 
	{
		return this.shapeType;
	}
	/**
	 * To get Distance From Origin Of Rectangle
	 * @return distance from origin of Rectangle
	 */
	@Override
	public double getOriginDistance() 
	{
		return Math.pow( (Math.pow(this.getOrigin().xCordinate, 2) + Math.pow(this.getOrigin().yCordinate, 2) ),  .5);	
	}
}
