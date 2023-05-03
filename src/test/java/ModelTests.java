

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleDoubleProperty;
import model.CalcModel;

class ModelTests
{
	CalcModel calcModel;
	
	@BeforeEach
	void setUp() throws Exception
	{
		calcModel = new CalcModel();
	}

	@Test
	void testAdd()
	{
		// adding positive ints
		calcModel.setNum1(new SimpleDoubleProperty(11));
		calcModel.setNum2(new SimpleDoubleProperty(11));
		calcModel.add();
		assertEquals(22, calcModel.getResult().doubleValue());
		
		// adding negative ints
		calcModel.setNum1(new SimpleDoubleProperty(-10));
		calcModel.setNum2(new SimpleDoubleProperty(5));
		calcModel.add();
		assertEquals(-5, calcModel.getResult().doubleValue());
		
	}
	
	@Test
	void testSubtract()
	{
		// subtracting positive ints
		calcModel.setNum1(new SimpleDoubleProperty(8));
		calcModel.setNum1(new SimpleDoubleProperty(4));
		calcModel.subtract();
		assertEquals(4, calcModel.getResult().doubleValue());
		
		// subtract to get a negative int
		calcModel.setNum1(new SimpleDoubleProperty(2));
		calcModel.setNum2(new SimpleDoubleProperty(7));
		calcModel.subtract();
		assertEquals(-5, calcModel.getResult().doubleValue());
	}
	
	@Test
	void testMultiply()
	{
		// multiplying positive ints
		calcModel.setNum1(new SimpleDoubleProperty(4));
		calcModel.setNum2(new SimpleDoubleProperty(4));
		calcModel.multiply();
		assertEquals(16, calcModel.getResult().doubleValue());
		
		// multiplying negative ints
		calcModel.setNum1(new SimpleDoubleProperty(1));
		calcModel.setNum2(new SimpleDoubleProperty(-8));
		calcModel.multiply();
		assertEquals(-8, calcModel.getResult().doubleValue());
		
	}
	
	@Test
	void testDivide()
	{
		//dividing positive ints
		calcModel.setNum1(new SimpleDoubleProperty(80));
		calcModel.setNum2(new SimpleDoubleProperty(10));
		calcModel.divide();
		assertEquals(8, calcModel.getResult().doubleValue());
		
		// dividing negative ints
		calcModel.setNum1(new SimpleDoubleProperty(-50));
		calcModel.setNum2(new SimpleDoubleProperty(10));
		calcModel.divide();
		assertEquals(-5, calcModel.getResult().doubleValue());
}
	
	
		

}
