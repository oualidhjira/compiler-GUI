package application.view;

import java.awt.image.PixelInterleavedSampleModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import application.Main;
import application.struct.RessourcesConstraints;
import application.struct.Switch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.TextFieldListCell;

public class SwitchController {
	//public static Switch swt=new Switch();
	ObservableList<String> switchs=FXCollections.observableArrayList("OvS","Novi");
	public static String matchfield;
	public static String tableId;
	public static String entries;
	public static RessourcesConstraints rc;
	static String IpAddr;
	static String switchType;
	public static TreeItem<Object> rootItem ;
	public static int i=0;
	public static int flag=0;
    Main main=new Main();
    @FXML
    private Label ipfield;
    @FXML
    private TextField Ip;
	@FXML
	private ComboBox<String> switchtype;
	@FXML
	private  ListView<String> listConstraints=new ListView<>();
	@FXML
	private Button but;
	//public static constraintsResourceItemController c;
	private static final Pattern PATTERN = Pattern.compile(
	        "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

	public static boolean validate(final String ip) {
	    return PATTERN.matcher(ip).matches();
	}
	@FXML
	private void initialize(){
		listConstraints.setEditable(true);
		//listConstraints.setCellFactory(TextFieldListCell.forListView());	
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
		System.out.println(rc);
		CompilerController.c.list_Constraints=FXCollections.observableArrayList();
		SwitchController.i=0;
		CompilerController.s.i=0;
		//CompilerController.c.setListview(Arrays.asList(rc.toString()));
		main.constraintShow();
	}
	@FXML
	private void getIpAddr(){
		//System.out.println(Ip.getText());
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
		
	    if(!validate(Ip.getText())){
	    
	    ipfield.setVisible(true);
	    return;
		   }
	    swti.setIpAddress(Ip.getText());
		//swti.setIpAddress(Ip.getText());
		swti.setSwitchType(switchType);
		//System.out.println("dddddddsdsdsdsd");
		//swti.addConstraints(constraintsResourceItemController.getConstraints().getClass().getName(),constraintsResourceItemController.getConstraints());
		//System.out.println(CompilerController.s.toString());
		//System.out.println(CompilerController.s.getConstraint());
		swti.setConstraint(CompilerController.s.getConstraint());
		//System.out.println(swti.toString());
		TreeItem<Object> switchIP = new TreeItem<Object>(swti.getIpAddress());
		TreeItem<Object> switchTypes = new TreeItem<Object>(swti.getSwitchType());
		//TreeItem<Object> switchconsts = new TreeItem<Object>(swti.getConstraint());
		//System.out.println(swti.getConstraint());
		
		//TreeItem<Object> switchconstype = new TreeItem<Object>(swti.getRessourcesConstraints(CompilerController.s.getConstraint()).get(0).getClass().getSimpleName());
		//TreeItem<Object> switchtabID = new TreeItem<Object>(swti.getRessourcesConstraints(CompilerController.s.getConstraint()).get(0).getTableId());
		//TreeItem<Object> switchMatch = new TreeItem<Object>(swti.getRessourcesConstraints(CompilerController.s.getConstraint()).get(0).getMatchfield());
		//TreeItem<Object> switchCapa = new TreeItem<Object>(swti.getRessourcesConstraints(CompilerController.s.getConstraint()).get(0).getCapacity());
		TreeItem<Object> switchconstype;
		TreeItem<Object> switchtabID;
		TreeItem<Object> switchMatch;
		TreeItem<Object> switchCapa;
		rootItem.getChildren().add(switchIP);
		//switchIP.getChildren().add(switchTypes);
		//rootItem.getChildren().add(switchTypes);
		//switchconstype = new TreeItem<Object>(swti.getRessourcesConstraints(CompilerController.s.getConstraint()).get(i).getClass().getSimpleName());
		
		int i;
		for (i=0;i<swti.getRessourcesConstraints(CompilerController.s.getConstraint()).size();i++){
			 switchconstype = new TreeItem<Object>(swti.getRessourcesConstraints(CompilerController.s.getConstraint()).get(i).getClass().getSimpleName());
			 switchtabID = new TreeItem<Object>(swti.getRessourcesConstraints(CompilerController.s.getConstraint()).get(i).getTableId());
			 switchMatch = new TreeItem<Object>(swti.getRessourcesConstraints(CompilerController.s.getConstraint()).get(i).getMatchfield());
			 switchCapa = new TreeItem<Object>(swti.getRessourcesConstraints(CompilerController.s.getConstraint()).get(i).getCapacity());
			 //rootItem.getChildren().add(switchconstype);
			 //switchTypes.getChildren().add(switchconstype);
			 rootItem.getChildren().add(switchconstype);
			 switchconstype.getChildren().add(switchtabID);
			 switchtabID.getChildren().add(switchMatch);
			 switchtabID.getChildren().add(switchCapa);
		}
		//System.out.println(switchs.toString());	
		//System.out.println(swt.toString());
		main.complierShow();
		//main.swt.close();
	}
	@FXML
	private void onEdit() throws IOException {
				System.out.println(listConstraints.getEditingIndex());
				System.out.println(listConstraints.getItems().get(listConstraints.getEditingIndex()));
				flag=listConstraints.getEditingIndex()+1;
				matchfield=listConstraints.getItems().get(listConstraints.getEditingIndex()).split(",")[2].split("=")[1];
				tableId=listConstraints.getItems().get(listConstraints.getEditingIndex()).split(",")[0].split("=")[1];
				entries=listConstraints.getItems().get(listConstraints.getEditingIndex()).split(",")[1].split("=")[1];
				System.out.println(matchfield);
				System.out.println(tableId);
				System.out.println(entries);
		        main.constraintShow();
		        main.constraintPerformanceItems();
				//constraintsResourceItemController cri=new constraintsResourceItemController();
	}
	@FXML
	private void validate(){
		Main.swt.close();
	}
	
}
