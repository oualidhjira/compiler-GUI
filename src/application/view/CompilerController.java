package application.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
	private void generateXML() throws FileNotFoundException, UnsupportedEncodingException{
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
		//System.out.println(c.list_Constraints);
		c.list_Constraints = FXCollections.observableArrayList();
		s=new Switch();
		main.switchShow();
		
	}
	@FXML
	public void newproject() throws IOException{
		SwitchController.rootItem = new TreeItem<Object>();
		main.primaryStage.close();
		main.complierShow();
	}
	
}