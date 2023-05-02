package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CalcModel
{

	private DoubleProperty num1 = new SimpleDoubleProperty();
	private DoubleProperty num2 = new SimpleDoubleProperty();
	private DoubleProperty result = new SimpleDoubleProperty();
	
	
	ObservableList<Operation> operations = FXCollections.observableArrayList();
	
	
	
	public void add()
	{
		result.setValue(num1.doubleValue()+num2.doubleValue());
		operations.add(new Operation(num1.doubleValue()," + ",num2.doubleValue(),result.doubleValue()));
	}
	
	public void subtract()
	{
		result.setValue(num1.doubleValue()-num2.doubleValue());
		operations.add(new Operation(num1.doubleValue()," - ",num1.doubleValue(),result.doubleValue()));
	}

	public void multiply()
	{
		result.setValue(num1.doubleValue()*num2.doubleValue());
		operations.add(new Operation(num1.doubleValue()," + ",num2.doubleValue(),result.doubleValue()));
	}
	
//	 public void multiply() {
//	        result.setValue(num1.doubleValue() * num2.doubleValue());
//	        operations.add(new Operation(num1.doubleValue(), " * ", num2.doubleValue(), result.doubleValue()));
//	    }

	public void divide()
	{
		result.setValue(num1.doubleValue()*num2.doubleValue());
		operations.add(new Operation(num1.doubleValue()," / ",num2.doubleValue(),result.doubleValue()));
	}
	
//	 public void divide() {
//	        if (num2.get() == 0) {
//	        	System.out.println("Cannot divide by zero");
//	            throw new ArithmeticException("Cannot divide by zero");
//	        }
//	        result.setValue(num1.doubleValue() / num2.doubleValue());
//	        operations.add(new Operation(num1.doubleValue(), " / ", num2.doubleValue(), result.doubleValue()));
//	    }

	public DoubleProperty getNum1()
	{
		return num1;
	}

	public void setNum1(DoubleProperty num1)
	{
		this.num1 = num1;
	}

	public DoubleProperty getNum2()
	{
		return num2;
	}

	public void setNum2(DoubleProperty num2)
	{
		this.num2 = num2;
	}

	public DoubleProperty getResult()
	{
		return result;
	}

	public void setResult(DoubleProperty result)
	{
		this.result = result;
	}

	public ObservableList<Operation> getOperations()
	{
		return operations;
	}

	public void setOperations(ObservableList<Operation> operations)
	{
		this.operations = operations;
	}

	
	
}
