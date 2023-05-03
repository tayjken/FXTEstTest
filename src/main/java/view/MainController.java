package view;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import model.CalcModel;
import model.Operation;

public class MainController
{

	@FXML
	private ListView<Operation> HistoryView;

	@FXML
	private TextField NumOneTF;

	@FXML
	private TextField NumTwoTF;

	@FXML
	private Label ResultLabel;
	
	private CalcModel model;
	
	public void setModel(CalcModel model) 
	{
		this.model = model;
		
		
		StringConverter<Number> converter = new NumberStringConverter();
		Bindings.bindBidirectional(NumOneTF.textProperty(), model.getNum1(),converter);
		
		Bindings.bindBidirectional(NumTwoTF.textProperty(), model.getNum2(),converter);
		
		Bindings.bindBidirectional(ResultLabel.textProperty(), model.getResult(),converter);
		
		
		HistoryView.setItems(model.getOperations());	
	}

	// no adjustment
	@FXML
	void onAddButton(ActionEvent event)
	{
		model.add();
	}

	// no adjustment
	@FXML
	void onMultiplyButton(ActionEvent event)
	{
		model.multiply();
	}

	// no adjustment
	@FXML
	void onSubButton(ActionEvent event)
	{
		model.subtract();
	}
	
	// adjustment -> calling divide instead of multiply
	@FXML
    void onDivideButton(ActionEvent event) 
	{
		model.divide();
    }

	// no adjustment
	@FXML
    void onNumOnePressed(MouseEvent event) 
	{
		NumOneTF.clear();
    }
	
	// no adjustment
	 @FXML
	 void onNumTwoPressed(MouseEvent event) 
	 {
		 NumTwoTF.clear();
	 }
	
}
