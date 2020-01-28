package graphicsLibrary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Iterator;

/**
 * @author Ramdev
 * Implements the methods Like addShape, removeShape, removeAllShapesOfSpecificType,
 * sortAllShapesByArea, sortAllShapesByPerimeter, sortAllShapesByTimestamp, sortAllShapesByOriginDistance
 */
public class Screen 
{
	private List<Shape> shapes = new ArrayList<Shape>();
	
	/**
	 * To add a shape to the screen
	 * @param shape : Object of Shape class
	 * @return True if SuccessFully Added
	 */
	public boolean addShape(Shape shape)
	{
		shapes.add(shape);
		return true;
	}
	
	/** 
	 * To remove a Shape from Screen
	 * @param shape : Object of Shape class
	 * @return True if Successfully  removed
	 * @throws AssertionError If shape do not found in Screen
	 */
	public boolean removeShape(Shape shape)throws AssertionError
	{
		Iterator<Shape> iterator = shapes.iterator();
		
		while(iterator.hasNext())
		{
			if(iterator.next().getDate().compareTo(shape.getDate()) == 0 )
			{
				shapes.remove(iterator.next());
				return true;
			}
		}
		throw new AssertionError("No shape found");
	}
	
	/**
	 * To remove all shapes of a specific type from the screen
	 * @param shapeType
	 * @return true if successfully removed
	 */
	public boolean removeAllShapesOfSpecificType(String shapeType)
	{
		List<Shape> copyShapes = new ArrayList<Shape>(shapes);
	
		Iterator<Shape> iterator = copyShapes.iterator();
		
		while(iterator.hasNext())
		{
			if(iterator.next().getShapeType().equalsIgnoreCase(shapeType))
			{
				shapes.remove(iterator.next());
			}
		}
		return true;
	}
	
	/**
	 * To sort All the Shapes of Screen by Area
	 * @return Sorted List of Shapes
	 */
	public List<Shape> sortAllShapesByArea()
	{
		List<Shape> newShapesObject = new ArrayList<Shape>(this.shapes);
		
		Collections.sort(newShapesObject, Screen.shortByArea);
		
		return newShapesObject;
	}
	
	/**
	 * To sort All the Shapes of Screen by Perimeter
	 * @return Sorted List of Shapes
	 */
	public List<Shape> sortAllShapesByPerimeter()
	{
		List<Shape> newShapesObject = new ArrayList<Shape>(this.shapes);
		
		Collections.sort(newShapesObject, Screen.shortByPerimeter);
		
		return newShapesObject;
	}
	
	/**
	 * To sort All the Shapes of Screen by Time stamp
	 * @return Sorted List of Shapes
	 */
	public List<Shape> sortAllShapesByTimestamp()
	{
		List<Shape> newShapesObject = new ArrayList<Shape>(this.shapes);
		
		Collections.sort(newShapesObject, Screen.shortByTimestamp);
		
		return newShapesObject;
	}
	
	/**
	 * To sort All the Shapes of Screen by OriginDistance
	 * @return Sorted List of Shapes
	 */
	public List<Shape> sortAllShapesByOriginDistance()
	{
		List<Shape> newShapesObject = new ArrayList<Shape>(this.shapes);
		
		Collections.sort(newShapesObject, Screen.shortByOriginDistance);
		
		return newShapesObject;
	}
	
	/**
	 * @param point
	 * @return The List of Shapes which enclosed in the given point
	 */
	public List<Shape> allTheShapesWhichArePointEnclosed(Point point)
	{
		List<Shape> newShapesObject = new ArrayList<Shape>(this.shapes);
		Iterator<Shape> iterator = this.shapes.iterator();
		
		while(iterator.hasNext())
		{
			if(iterator.next().isPointEnclosed(point))
				newShapesObject.add(iterator.next());
		}
		return newShapesObject;
	}
	
	//---------------------------ALL PRIVATE METHODS BELOW----------------------------------------------
	/**
	 * Array List Comparator By Area
	 */
	private static Comparator<Shape> shortByArea = new Comparator<Shape>()
	{
		public int compare(Shape shapeOne, Shape shapeTwo) 
		{
		   if(shapeOne.getArea() > shapeTwo.getArea())
			   return 1;
		   else
			   return -1;
		}
	};
	
	/**
	 * Array List Comparator By Perimeter
	 */
	private static Comparator<Shape> shortByPerimeter = new Comparator<Shape>()
	{
		public int compare(Shape shapeOne, Shape shapeTwo) 
		{
			if(shapeOne.getPerimeter() > shapeTwo.getPerimeter())
				   return 1;
			   else
				   return -1;
		}
	};
	
	/**
	 * Array List Comparator By time stamp
	 */
	private static Comparator<Shape> shortByTimestamp = new Comparator<Shape>()
	{
		public int compare(Shape shapeOne, Shape shapeTwo) 
		{
			return shapeOne.getDate().compareTo(shapeTwo.getDate());
		}
	};
	
	/**
	 * Array List Comparator By OriginDistance
	 */
	private static Comparator<Shape> shortByOriginDistance = new Comparator<Shape>()
	{
		public int compare(Shape shapeOne, Shape shapeTwo) 
		{
			 if(shapeOne.getOriginDistance() > shapeTwo.getOriginDistance())
				 return 1;
			else
				return -1;
		}
	};
}