package graphicsLibrary;

import java.util.Date;
import java.util.List;
/**
 * @author Ramdev
 * Implements The Shape Interface For Circle
 */
public class Circle implements Shape
{
	private double xCordinateOfOrigin;
	private double yCordinateOfOrigin;
	private double radious;
	private Date dateOfCreation;
	private String shapeType;

	public Circle(Point point, List<Integer> listOfParameter)
	{
		this.xCordinateOfOrigin = point.xCordinate;
		this.yCordinateOfOrigin = point.yCordinate;
		this.radious = listOfParameter.get(0);
		this.dateOfCreation = new Date();
		this.shapeType = "Circle";
	}

	/**
	 * To get the Area of Circle
	 * @return Area of Circle
	 */
	@Override
	public double getArea() 
	{

		return Math.PI * Math.pow(this.radious, 2);
	}

	/**
	 * To get Perimeter of Circle 
	 * @return Perimeter of Circle
	 */
	@Override
	public double getPerimeter() 
	{
		return this.radious * Math.PI * 2;
	}

	/**
	 * To get origin Point of Circle
	 * @return Point Class's Circle
	 */
	@Override
	public Point getOrigin() 
	{
		return new Point(xCordinateOfOrigin, yCordinateOfOrigin);
	}

	/**
	 * To check if a point enclosed in a Circle or not
	 * @return true if a point is enclosed in a Circle else false
	 */
	@Override
	public boolean isPointEnclosed(Point point) 
	{
		double xCordinateOfGivenPoint = point.xCordinate;
		double yCordinateOfGivenPoint = point.yCordinate;

		double distanceBetweenOriginAndPoint = Math.pow(Math.pow(xCordinateOfGivenPoint - xCordinateOfOrigin, 2) + Math.pow(yCordinateOfGivenPoint - yCordinateOfOrigin , 2) , .5); 

		if(distanceBetweenOriginAndPoint > this.radious)
			return false;
		return true;
	}

	/**
	 * To get the date of creation of a Circle
	 * @return Current TimeStamp of System
	 */
	@Override
	public Date getDate() 
	{
		return dateOfCreation;
	}

	/**
	 * To get Shape Type
	 * @return "Circle" 
	 */
	@Override
	public String getShapeType() 
	{
		return this.shapeType;
	}

	/**
	 * To get Distance From Origin Of Circle
	 * @return distance from origin of Circle
	 */
	@Override
	public double getOriginDistance() 
	{
		return Math.pow( (Math.pow(this.getOrigin().xCordinate, 2) + Math.pow(this.getOrigin().yCordinate, 2) ),  .5);	
	}
}
