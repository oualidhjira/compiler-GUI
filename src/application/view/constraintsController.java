package application.view;

import java.io.IOException;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class constraintsController {
	
	private Main main;
	
	@FXML
	private TextField nbrtbl;
	
	@FXML
	private void contraintPerfItems() throws IOException{
		main.pathProcessingConstraint();
		
	}
	
	@FXML
	private void constraintmatch() throws IOException{
		main.constraintPerformanceItems();
	}
	
    
}

