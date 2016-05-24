package application.view;

import java.io.IOException;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class CompilerController {
	private Main main;
		
	@FXML
	public void goswitch() throws IOException{
		main.switchShow();
		
	}
	
	
}