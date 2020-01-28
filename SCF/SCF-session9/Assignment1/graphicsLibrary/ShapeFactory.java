package graphicsLibrary;

import java.util.List;
/**
 * 
 * @author Ramdev
 * Factory class of Shape Interface which creates the shapes of Square, Rectangle, Circle, Triangle and Regular Polygon.
 */
public class ShapeFactory 
{
	public static Shape create(String shapeType, Point point, List<Integer> listOfParameter)throws AssertionError
	{
		switch (shapeType)
		{
		case "Square":  
			if(listOfParameter.size() != 1 || listOfParameter.get(0) < 0)
				throw new AssertionError("Invaild numbers or value of parameters");
			Shape squareShape = new Square(point, listOfParameter);
			return squareShape;

		case "Rectangle": 
			if(listOfParameter.size() != 2 || listOfParameter.get(0) < 0 || listOfParameter.get(1) < 0)
				throw new AssertionError("Invaild numbers or value of parameters");
			Shape rectShape = new Square(point, listOfParameter);
			return rectShape; 

		case "Circle":  
			if(listOfParameter.size() != 1 || listOfParameter.get(0) < 0)
				throw new AssertionError("Invaild numbers or value of parameters");
			Shape circleShape = new Square(point, listOfParameter);
			return circleShape; 

		case "Triangle":
			if(listOfParameter.size() != 3 || listOfParameter.get(0) < 0 || listOfParameter.get(1) < 0 || listOfParameter.get(2) < 0)
				throw new AssertionError("Invaild numbers or value of parameters");
			Shape triangleShape = new Square(point, listOfParameter);
			return triangleShape;

		case "RegularPolygon": 
			if(listOfParameter.size() != 2 || listOfParameter.get(0) < 3 || listOfParameter.get(1) < 0)
				throw new AssertionError("Invaild numbers or value of parameters");
			Shape regularPolygon = new Square(point, listOfParameter);
			return regularPolygon;
		default:
			throw new AssertionError("Please Specify correct Shape Type");
		}
	}

}
