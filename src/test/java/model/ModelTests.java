package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		calcModel.getNum1().setValue(2.0);	
		calcModel.getNum2().setValue(3.0);
		calcModel.add();
		assertEquals(5.0, calcModel.getResult().get(), 0.0);
	}
	
	@Test
	void testSubtract()
	{
		calcModel.getNum1().setValue(5.0);
		calcModel.getNum2().setValue(2.0);
		calcModel.subtract();
		assertEquals(3.0, calcModel.getResult().get(), 0.0);
	}
	
	@Test
	void testMultiply()
	{
		calcModel.getNum1().setValue(4.0);
		calcModel.getNum2().setValue(3.0);
		calcModel.multiply();
		assertEquals(12.0, calcModel.getResult().get(), 0.0);
	}
	
	@Test
	void testDivide()
	{
		calcModel.getNum1().setValue(10.0);
		calcModel.getNum2().setValue(5.0);
		calcModel.divide();
		
		assertEquals(2.0, calcModel.getResult().get(), 0.0);
	}
		

}
