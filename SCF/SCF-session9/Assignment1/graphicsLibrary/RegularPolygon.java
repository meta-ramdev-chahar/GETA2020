package graphicsLibrary;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author Ramdev
 * Implements The Shape Interface For RegularPolygon
 */
public class RegularPolygon implements Shape 
{
	private double xCordinateOfOrigin;
	private double yCordinateOfOrigin;
	private double side;
	private double numberOfSides;
	private Date dateOfCreation;
	private String shapeType;

	public RegularPolygon(Point point, List<Integer> listOfParameter)
	{
		this.xCordinateOfOrigin = point.xCordinate;
		this.yCordinateOfOrigin = point.yCordinate;
		this.side = listOfParameter.get(1);
		this.numberOfSides = listOfParameter.get(0);
		this.dateOfCreation = new Date();
		this.shapeType = "RegularPolygon";
	}

	/**
	 * To get the Area of RegularPolygon
	 * @return Area of RegularPolygon
	 */
	@Override
	public double getArea() 
	{
		double angle = Math.toRadians(180 / this.numberOfSides); 
		double tangentOfangle = Math.tan(angle);
		double area = ((this.side * this.side * this.numberOfSides) / (4 * tangentOfangle));
		return area;
	}

	/**
	 * To get Perimeter of RegularPolygon 
	 * @return Perimeter of RegularPolygon
	 */
	@Override
	public double getPerimeter() 
	{
		return this.side * this.numberOfSides;
	}

	/**
	 * To get origin Point of RegularPolygon
	 * @return Point Class's object
	 */
	@Override
	public Point getOrigin()
	{
		return new Point(xCordinateOfOrigin, yCordinateOfOrigin);
	}

	/**
	 * To check if a point in enclosed in a RegularPolygon or not
	 * @return true if a point is enclosed in a RegularPolygon else false
	 */
	@Override
	public boolean isPointEnclosed(Point point) 
	{
		return false;
	}

	/**
	 * To get the date of creation of this RegularPolygon
	 * @return Current TimeStamp of System
	 */
	@Override
	public Date getDate() 
	{
		return dateOfCreation;
	}

	/**
	 * To get Shape Type
	 * @return "RegularPolygon"
	 */
	@Override
	public String getShapeType() 
	{
		return this.shapeType;
	}

	/**
	 * To get Distance From Origin Of RegularPolygon
	 * @return distance from origin of RegularPolygon
	 */
	@Override
	public double getOriginDistance() 
	{
		return Math.pow( (Math.pow(this.getOrigin().xCordinate, 2) + Math.pow(this.getOrigin().yCordinate, 2) ),  .5);	
	}

}
