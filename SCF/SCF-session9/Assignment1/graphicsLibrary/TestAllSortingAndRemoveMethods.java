package graphicsLibrary;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

public class TestAllSortingAndRemoveMethods
{	
	private Screen newScreen = new Screen(); 
	private List<Shape> input = new ArrayList<Shape>();

	@Before
	public void createAScreen()
	{
		Shape shape1 = ShapeFactory.create("Square", new Point(1, 1), new ArrayList<Integer>(){{ add(2); }});
		newScreen.addShape(shape1);
		input.add(shape1);

		Shape shape2 = ShapeFactory.create("Square", new Point(5, 5), new ArrayList<Integer>(){{ add(2); }});
		newScreen.addShape(shape2);
		input.add(shape2);

		Shape shape3 = ShapeFactory.create("Circle", new Point(3, 3), new ArrayList<Integer>(){{ add(8); }});
		newScreen.addShape(shape3);
		input.add(shape3);

		Shape shape4 = ShapeFactory.create("Rectangle", new Point(4, 4), new ArrayList<Integer>(){{ add(1); add(2); }});
		newScreen.addShape(shape4);
		input.add(shape4);

		Shape shape5 = ShapeFactory.create("RegularPolygon", new Point(2, 2), new ArrayList<Integer>(){{ add(15); add(20); }});
		newScreen.addShape(shape5);
		input.add(shape5);
	}
	@Test
	public void test_SortByArea()
	{
		List<Double> expectedOutput = new ArrayList<Double>();
		expectedOutput.add(input.get(3).getArea());
		expectedOutput.add(input.get(0).getArea());
		expectedOutput.add(input.get(1).getArea());
		expectedOutput.add(input.get(2).getArea());
		expectedOutput.add(input.get(4).getArea());

		List<Double> output = new ArrayList<Double>();
		List<Shape> outputShapes = newScreen.sortAllShapesByArea();

		output.add(outputShapes.get(0).getArea());
		output.add(outputShapes.get(1).getArea());
		output.add(outputShapes.get(2).getArea());
		output.add(outputShapes.get(3).getArea());
		output.add(outputShapes.get(4).getArea());

		for(int i = 0; i < 5; i++ )
			assertEquals(expectedOutput.get(i), output.get(i));		
	}
	@Test
	public void test_SortByPerimeter()
	{
		List<Double> expectedOutput = new ArrayList<Double>();
		expectedOutput.add(input.get(3).getPerimeter());
		expectedOutput.add(input.get(0).getPerimeter());
		expectedOutput.add(input.get(1).getPerimeter());
		expectedOutput.add(input.get(2).getPerimeter());
		expectedOutput.add(input.get(4).getPerimeter());

		List<Double> output = new ArrayList<Double>();
		List<Shape> outputShapes = newScreen.sortAllShapesByPerimeter();

		output.add(outputShapes.get(0).getPerimeter());
		output.add(outputShapes.get(1).getPerimeter());
		output.add(outputShapes.get(2).getPerimeter());
		output.add(outputShapes.get(3).getPerimeter());
		output.add(outputShapes.get(4).getPerimeter());

		for(int i = 0; i < 5; i++ )
			assertEquals(expectedOutput.get(i), output.get(i));

	}
	@Test
	public void test_SortByOriginDistance()
	{
		List<Double> expectedOutput = new ArrayList<Double>();
		expectedOutput.add(input.get(0).getOriginDistance());
		expectedOutput.add(input.get(4).getOriginDistance());
		expectedOutput.add(input.get(2).getOriginDistance());
		expectedOutput.add(input.get(3).getOriginDistance());
		expectedOutput.add(input.get(1).getOriginDistance());

		List<Double> output = new ArrayList<Double>();
		List<Shape> outputShapes = newScreen.sortAllShapesByOriginDistance();

		output.add(outputShapes.get(0).getOriginDistance());
		output.add(outputShapes.get(1).getOriginDistance());
		output.add(outputShapes.get(2).getOriginDistance());
		output.add(outputShapes.get(3).getOriginDistance());
		output.add(outputShapes.get(4).getOriginDistance());

		for(int i = 0; i < 5; i++ )
			assertEquals(expectedOutput.get(i), output.get(i));

	}
	@Test
	public void test_SortByTimeStamp()
	{
		List<Date> expectedOutput = new ArrayList<Date>();
		expectedOutput.add(input.get(0).getDate());
		expectedOutput.add(input.get(1).getDate());
		expectedOutput.add(input.get(2).getDate());
		expectedOutput.add(input.get(3).getDate());
		expectedOutput.add(input.get(4).getDate());

		List<Date> output = new ArrayList<Date>();
		List<Shape> outputShapes = newScreen.sortAllShapesByTimestamp();

		output.add(outputShapes.get(0).getDate());
		output.add(outputShapes.get(1).getDate());
		output.add(outputShapes.get(2).getDate());
		output.add(outputShapes.get(3).getDate());
		output.add(outputShapes.get(4).getDate());

		for(int i = 0; i < 5; i++ )
			assertEquals(0, expectedOutput.get(i).compareTo(output.get(i)));
	}
	@Test
	public void test_PointEnclosed()
	{
		Point point = new Point(2, 2);
		List<Boolean> expectedOutput = new ArrayList<Boolean>();
		
		expectedOutput.add(input.get(0).isPointEnclosed(point));
		expectedOutput.add(input.get(2).isPointEnclosed(point));
		
		List<Boolean> output = new ArrayList<Boolean>();
		List<Shape> outputShapes = newScreen.allTheShapesWhichArePointEnclosed(point);
		
		output.add(outputShapes.get(0).isPointEnclosed(point));
		output.add(outputShapes.get(1).isPointEnclosed(point));
		
		for(int i = 0; i < 2; i++)
			assertEquals(expectedOutput.get(i), output.get(i));
	}
	
	@Test
	public void test_RemoveAndRemoveAllMethod()
	{
		assertEquals(true, newScreen.removeShape(input.get(2)));
		assertEquals(true, newScreen.removeAllShapesOfSpecificType("Square"));
	}
}