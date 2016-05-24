package application.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class SwitchController {
	ObservableList<String> switchs=FXCollections.observableArrayList("OvS","Novi");
	ObservableList<String> list_Constraints = FXCollections.observableArrayList(); 
	
    Main main;
	@FXML
	private ComboBox switchtype;
	@FXML
	private ListView<String> listConstraints=new ListView<>();
	
	@FXML
	private void initialize(){	
		switchtype.setItems(switchs);
		listConstraints.setItems(list_Constraints);
		
	}
	
	public void setListview(List<String> constraint){
		list_Constraints.addAll(constraint);
	}

	@FXML
	private void goConstraint() throws IOException{
		main.constraintShow();
	}
	
	
}
