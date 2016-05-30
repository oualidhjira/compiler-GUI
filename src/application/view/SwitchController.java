package application.view;

import java.awt.image.PixelInterleavedSampleModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.Main;
import application.struct.RessourcesConstraints;
import application.struct.Switch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;

public class SwitchController {
	//public static Switch swt=new Switch();
	ObservableList<String> switchs=FXCollections.observableArrayList("OvS","Novi");
	public static RessourcesConstraints rc;
	static String IpAddr;
	static String switchType;
	public static TreeItem<Object> rootItem ;
	
    Main main=new Main();
    @FXML
    private TextField Ip;
	@FXML
	private ComboBox<String> switchtype;
	@FXML
	private ListView<String> listConstraints=new ListView<>();
	@FXML
	private Button but;
	//public static constraintsResourceItemController c;
	
	@FXML
	private void initialize(){
		//c=new constraintsResourceItemController();
		rootItem = new TreeItem<Object>();
		//System.out.println(CompilerController.c);
		//c.setListview(Arrays.asList(c.getConstraints().toString()));
		
		listConstraints.setItems(CompilerController.c.list_Constraints);
		
		//c.setListview(Arrays.asList(c.getConstraints().toString()));
		rootItem.setExpanded(true);
		
		//constraintsResourceItemController.setListview(Arrays.asList(constraintsResourceItemController.getConstraints().toString()));
		//swt.addConstraints(CompilerController.c.getConstraints().getClass().getName(),constraintsResourceItemController.getConstraints());
		//System.out.println(swt.toString());
		//listConstraints.setItems(constraintsResourceItemController.list_Constraints);
		//set switch type items
		switchtype.setItems(switchs);
		
	}
	
	

	@FXML
	private void goConstraint() throws IOException{
		rc=new RessourcesConstraints();
		main.constraintShow();
	}
	@FXML
	private void getIpAddr(){
		System.out.println(Ip.getText());
		IpAddr=Ip.getText();	
	}
	@FXML
	private void getType(){
		switchType=switchtype.getValue();
	}
	
	@FXML
	private void submitSwitch() throws IOException{	
		rootItem.setValue("switchs");
		Switch swti=new Switch();
		swti.setIpAddress(Ip.getText());
		swti.setSwitchType(switchType);
		//System.out.println("dddddddsdsdsdsd");
		//swti.addConstraints(constraintsResourceItemController.getConstraints().getClass().getName(),constraintsResourceItemController.getConstraints());
		//System.out.println(CompilerController.s.toString());
		swti.setConstraint(CompilerController.s.getConstraint());
		//System.out.println(swti.toString());
		TreeItem<Object> switchIP = new TreeItem<Object>(swti.getIpAddress());
		TreeItem<Object> switchTypes = new TreeItem<Object>(swti.getSwitchType());
		TreeItem<Object> switchconsts = new TreeItem<Object>(swti.getConstraint());
		
		
		//System.out.println(switchs.toString());
		rootItem.getChildren().add(switchIP);
		switchIP.getChildren().add(switchTypes);
		switchTypes.getChildren().add(switchconsts);
		
		
		//System.out.println(swt.toString());
		main.complierShow();
		//main.swt.close();
	}
	@FXML
	private void validate(){
		Main.swt.close();
	}
	
}
