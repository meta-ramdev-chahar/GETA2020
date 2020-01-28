package graphicsLibrary;

import java.util.Date;
import java.util.List;

/**
 * @author Ramdev
 * Implements The Shape Interface For Square
 */
public class Square implements Shape
{
	//X and Y coordinates of Left corner of Square 
	private double xCordinateOfOrigin;
	private double yCordinateOfOrigin;
	private double side;
	private Date dateOfCreation;
	private String shapeType;

	public Square(Point point, List<Integer> listOfParameter)
	{
		this.xCordinateOfOrigin = point.xCordinate;
		this.yCordinateOfOrigin = point.yCordinate;
		this.side = listOfParameter.get(0);
		this.dateOfCreation = new Date();
		this.shapeType = "Square";
	}

	/**
	 * To get the Area of Square
	 * @return Area of Square
	 */
	@Override
	public double getArea() 
	{
		return Math.pow(this.side, 2);
	}

	/**
	 * To get Perimeter of Square 
	 * @return Perimeter of Square
	 */
	@Override
	public double getPerimeter() 
	{
		return this.side * 4;
	}

	/**
	 * To get origin Point of Square
	 * @return Point Class's object
	 */
	@Override
	public Point getOrigin() 
	{
		return new Point(xCordinateOfOrigin, yCordinateOfOrigin);
	}

	/**
	 * To check if a point in enclosed in a Square or not
	 * @return true if a point is enclosed in a Square else false
	 */
	@Override
	public boolean isPointEnclosed(Point point) 
	{

		double xCordinateOfEnd = this.xCordinateOfOrigin + this.side;
		double yCordinateOfEnd = this.yCordinateOfOrigin + this.side;

		double xCordinateOfGivenPoint = point.xCordinate;
		double yCordinateOfGivenPoint = point.yCordinate;

		if( ( xCordinateOfGivenPoint > xCordinateOfOrigin && xCordinateOfGivenPoint < xCordinateOfEnd ) && ( yCordinateOfGivenPoint > yCordinateOfOrigin && yCordinateOfGivenPoint < yCordinateOfEnd ) )
			return true;
		return false;
	}

	/**
	 * To get the date of creation of this Square
	 * @return Current TimeStamp of System
	 */
	@Override
	public Date getDate() 
	{
		return dateOfCreation;
	}

	/**
	 * To get Shape Type
	 * @return "Square"
	 */
	@Override
	public String getShapeType() 
	{
		return this.shapeType;
	}
	/**
	 * To get Distance From Origin Of Square
	 * @return distance from origin of Square
	 */
	@Override
	public double getOriginDistance() 
	{
		return Math.pow( (Math.pow(this.getOrigin().xCordinate, 2) + Math.pow(this.getOrigin().yCordinate, 2) ),  .5);	
	}
}
