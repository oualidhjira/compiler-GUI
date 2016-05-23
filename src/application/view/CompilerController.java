package application.view;

import java.io.IOException;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class CompilerController {
	private Main main;
	
	ObservableList<String> switchType=FXCollections.observableArrayList("OvS","NoviBoard");
	
	
		
	
	@FXML
	private ComboBox switchs;
	
	@FXML
	private void goswitch() throws IOException{
		main.switchShow();
		
	}
	@FXML
	private void choiceSwitch() throws IOException {
		switchs.setValue("OvS");
		switchs.setItems(switchType);
		
		
	}
	
	@FXML
	private void goConstraint() throws IOException{
		main.constraintShow();
	}

	@FXML
	private void contraintPerfItems() throws IOException{
		
		main.constraintPerformanceItems();
		
	}
}