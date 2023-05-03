

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.CalcModel;
import model.Operation;
import view.MainController;


@ExtendWith(ApplicationExtension.class)

class ViewTests
{

	@Start
	public void start(Stage stage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainController.class.getResource("main.fxml"));
		Pane view = loader.load();
		MainController cont = loader.getController();
		CalcModel model = new CalcModel();
		cont.setModel(model);
		
		Scene s = new Scene(view);
		stage.setScene(s);
		stage.show();
	}
	
	// using the FXrobot to simulate the interactions
	// when input1 click -> types in value of input 1 same with input 2
	public void roboinputs(FxRobot robot, String input1, String input2)
	{
		robot.clickOn("#input1");
		robot.write(input1);
		robot.clickOn("#input2");
		robot.write(input2);
	}
	
	// using the assertThat to check the label object that matches the value of total
	public void result(FxRobot robot, String total)
	{
		Assertions.assertThat(robot.lookup("#total").queryAs(Label.class)).hasText(total);
	}
	
	public void checkingOutcome(FxRobot robot, String button, String before,
			String input1, String input2, String after)
	{
		// verifying that the inital value matches the before 
		result(robot, before);
		// inputs the values of input1 & input2
		roboinputs(robot, input1, input2);
		robot.clickOn(button);
		// verifying that the inital value matches the after
		result(robot, after);
		
	}
	
	// want the robot to find the listview object with button
	// and return it as a liewview of operation objects
	@SuppressWarnings("unchecked")
	ListView<Operation> getOperations(FxRobot robot)
	{
		return(ListView<Operation>) robot.lookup("#previousAnswers").queryAll().iterator().next();
		
	}
	
	@Test
	public void Test(FxRobot robot)
	{
		// expection array defines the operations with all 4 combos
		// each operation has its expected result already calculated
		Operation[] expection = {
				new Operation(1.0, " + ", 1.0, 2.0),
				new Operation(10.0, " - ", 5.0, 5.0),
				new Operation(4.0, " * ", 4.0, 16.0),
				new Operation(100.0, " / ", 2.0, 50.0),
				
				new Operation(-1.0, " + ", 0.5, -0.5),
				new Operation(-10.0, " - ", 1.0, -11.0),
				new Operation(-5.0, " * ", 5.0, -25.0),
				new Operation(-50.0, " / ", 10.0, -5.0),
				
		};

		// need getOperations called with the robot object to retrive the listview 
		// which contains the operation objects
		ListView<Operation> operations = getOperations(robot);
		// used to verify that the operations list is empty 
		Assertions.assertThat(operations).isEmpty();
		
		checkingOutcome(robot, "#addButton", "0", "1", "1", "2");
		checkingOutcome(robot, "#subtractButton", "2", "10", "5", "5");
		checkingOutcome(robot, "#multiplyButton", "5", "4", "4", "16");
		checkingOutcome(robot, "#divideButton", "16", "100", "2", "50");

		checkingOutcome(robot, "#addButton", "50", "-1", "0.5", "-0.5");
		checkingOutcome(robot, "#subtractButton", "-0.5", "-10", "1", "-11");
		checkingOutcome(robot, "#multiplyButton", "-11", "-5", "5", "-25");
		checkingOutcome(robot, "#divideButton", "-25", "-50", "10", "-5");

		// operations list of operations objects is checked using the assertThat
		// to verify that it has exactly the same number of items as the expection 
		// of the array that was created above
		Assertions.assertThat(operations).hasExactlyNumItems(expection.length);
		
		// comparing both lists
		Assertions.assertThat(operations.getItems().contains(expection[0]));
		Assertions.assertThat(operations.getItems().contains(expection[1]));
		Assertions.assertThat(operations.getItems().contains(expection[2]));
		Assertions.assertThat(operations.getItems().contains(expection[3]));
		Assertions.assertThat(operations.getItems().contains(expection[4]));
		Assertions.assertThat(operations.getItems().contains(expection[5]));
		Assertions.assertThat(operations.getItems().contains(expection[6]));
		Assertions.assertThat(operations.getItems().contains(expection[7]));

		
		
		}
	}

