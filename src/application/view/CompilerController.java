package application.view;

import java.io.IOException;

import application.Main;
import application.struct.Switch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class CompilerController {
	private Main main;
	public static constraintsResourceItemController c;
	public static Switch s;
	public static TreeView<Object> tree=new TreeView<>();
	@FXML
	private  TreeView<Object> treeview;
	@FXML
	private void generateXML(){
		TreeviewXml.xml();
	}
	
	@FXML
	private void initialize(){

	treeview.setRoot(SwitchController.rootItem);
	tree=treeview;
	}
	
	@FXML
	public void goswitch() throws IOException{
		c=new constraintsResourceItemController();
		s=new Switch();
		main.switchShow();
		
	}
	
}