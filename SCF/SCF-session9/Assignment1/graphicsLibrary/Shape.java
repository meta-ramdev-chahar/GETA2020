package graphicsLibrary;

import java.util.Date;

/**
 * @author Ramdev
 * Expose certain basic APIs like getArea, getPerimeter, getOrigin and isPointEnclosed
 */
public interface Shape 
{
	/**
	 * To get the Area of Any specific Shape
	 * @return Area of specific shape
	 */
	public double getArea();

	/**
	 * To get Perimeter of Any specific Shape 
	 * @return Perimeter of specific shape
	 */
	public double getPerimeter();

	/**
	 * To get origin Point of specific shape
	 * @return Point Class's object
	 */
	public Point getOrigin();

	/**
	 * To check if a point in enclosed in a shape or not
	 * @return true if a point is enclosed in a shape else false
	 */
	public boolean isPointEnclosed(Point point);

	/**
	 * To get the date of creation of a Shape
	 * @return Current TimeStamp of System
	 */
	public Date getDate();

	/**
	 * To get Shape Type
	 * @return the type of shape
	 */
	public String getShapeType();

	/**
	 * To get Distance From Origin
	 * @return distance from origin
	 */
	public double getOriginDistance();
}
