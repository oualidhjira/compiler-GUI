package application.view;

import java.io.IOException;

import application.Main;
import application.struct.Switch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class constraintsController {
	
	private Main main;
	
	@FXML
	private  TextField nbrtbl;	
	public static int nbrtable;
	public static int i;
	@FXML
	private Label lbl;
	@FXML
	private void contraintPerfItems() throws IOException{
		main.pathProcessingConstraint();	
	}
	
	@FXML
	public void constraintmatch() throws IOException{
		//System.out.println(nbrtbl.getText());
		//nbrtable=Integer.parseInt(nbrtbl.getText());
		try{
			nbrtable=Integer.parseInt(nbrtbl.getText());
			}catch (NumberFormatException e) {
		   lbl.setVisible(true);
		   return;
		   }
		//nbrtable=Integer.parseInt(nbrtbl.getText());
		main.constraintPerformanceItems();
	}
	
	
	@FXML
	private void getnbrTable(){
		//System.out.println(nbrtbl.getText());
		//nbrtable=Integer.parseInt(nbrtbl.getText());
	}
	
    
}

