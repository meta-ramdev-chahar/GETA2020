package graphicsLibrary;

import java.util.Date;
import java.util.List;

/**
 * @author Ramdev
 * Implements The Shape Interface For Triangle
 */
public class Triangle implements Shape
{
	private double xCordinateOfOrigin;
	private double yCordinateOfOrigin;
	private double base;
	private double leftSide;
	private double rightSide;
	private Date dateOfCreation;
	private String shapeType;
	
	public Triangle(Point point, List<Integer> listOfParameter)
	{
		this.xCordinateOfOrigin = point.xCordinate;
		this.yCordinateOfOrigin = point.yCordinate;
		this.base = listOfParameter.get(0);
		this.leftSide = listOfParameter.get(1);
		this.rightSide = listOfParameter.get(2);
		this.dateOfCreation = new Date();
		this.shapeType = "Triangle";
	}

	/**
	 * To get the Area of Triangle
	 * @return Area of Triangle
	 */
	@Override
	public double getArea() 
	{
		//p is the Heron's Parameter
		double p = getPerimeter() / 2;
		double areaOfCircle = Math.pow(p * (p - this.base) * (p - this.leftSide) * (p - this.rightSide), 2);
		return areaOfCircle;
	}

	/**
	 * To get Perimeter of Triangle 
	 * @return Perimeter of Triangle
	 */
	@Override
	public double getPerimeter() 
	{
		return this.base + this.leftSide + this.rightSide;
	}

	/**
	 * To get origin Point of Triangle
	 * @return Point Class's object
	 */
	@Override
	public Point getOrigin() 
	{
		return new Point(xCordinateOfOrigin, yCordinateOfOrigin);
	}
	
	/**
	 * To check if a point in enclosed in a Triangle or not
	 * @return true if a point is enclosed in a Triangle else false
	 */
	@Override
	public boolean isPointEnclosed(Point point) 
	{
		//A Triangle has three Points
		//1st point
		double xCordinateOfFirstPoint = this.xCordinateOfOrigin;
		double yCordinateOfFirstPoint = this.yCordinateOfOrigin;
		//2nd point
		double xCordinateOfSecondPoint = xCordinateOfFirstPoint + this.base;
		double yCordinateOfSecondPoint = yCordinateOfFirstPoint;
		//3rd point
		double xCordinateOfThirdPoint = ( Math.pow(this.leftSide, 2) - Math.pow(this.rightSide, 2) + Math.pow(xCordinateOfSecondPoint, 2) - Math.pow(xCordinateOfFirstPoint, 2) ) / 2 * this.base;
		double yCordinateOfThirdPoint = Math.pow(this.leftSide, 2) + Math.pow(yCordinateOfFirstPoint, 2) - Math.pow(( xCordinateOfSecondPoint - xCordinateOfFirstPoint ), 2);
		
		//take the mode of 3rd points coordinates
		xCordinateOfThirdPoint = Math.abs(xCordinateOfThirdPoint);
		yCordinateOfThirdPoint = Math.abs(yCordinateOfThirdPoint);
		
		double areaOfTrianglePAB = areaOfTriangle(xCordinateOfFirstPoint, yCordinateOfFirstPoint, xCordinateOfSecondPoint, yCordinateOfSecondPoint, point.xCordinate, point.yCordinate);
		double areaOfTrianglePBC = areaOfTriangle(xCordinateOfSecondPoint, yCordinateOfSecondPoint, xCordinateOfThirdPoint, yCordinateOfThirdPoint, point.xCordinate, point.yCordinate);
		double areaOfTrianglePCA = areaOfTriangle(xCordinateOfThirdPoint, yCordinateOfThirdPoint, xCordinateOfFirstPoint, yCordinateOfFirstPoint, point.xCordinate, point.yCordinate);
		
		if(this.getArea() == areaOfTrianglePAB + areaOfTrianglePBC + areaOfTrianglePCA)
			return true;
		return false;
	}

	/**
	 * To get the date of creation of this Triangle
	 * @return Current TimeStamp of System
	 */
	@Override
	public Date getDate() 
	{
		return dateOfCreation;
	}
	
	/**
     * To get Shape Type
     * @return "Triangle"
     */
	@Override
	public String getShapeType() 
	{
			return this.shapeType;
	}
	
	/**
	 * To get Distance From Origin Of Triangle
	 * @return distance from origin of Triangle
	 */
	@Override
	public double getOriginDistance() 
	{
		return Math.pow( (Math.pow(this.getOrigin().xCordinate, 2) + Math.pow(this.getOrigin().yCordinate, 2) ),  .5);	
	}
	
	//-----------------------------------------PRIVATE METHODS BELOW HERE--------------------------------------------
	/**
	 * To get the are of triangle using coordinates
	 * @param x1 : xCordinateOfFirstPoint 
	 * @param y1 : yCordinateOfFirstPoint
	 * @param x2 : xCordinateOfSecondPoint
	 * @param y2 : yCordinateOfSecondPoint
	 * @param x3 : xCordinateOfThirdPoint
	 * @param y3 : yCordinateOfThirdPoint
	 * @return Area of triangle
	 */
	 private double areaOfTriangle(double x1, double y1, double x2, double y2, double x3, double y3) 
	 { 
		 return Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0); 
	 } 
	 
}
