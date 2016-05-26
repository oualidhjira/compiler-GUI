package application.view;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.Main;
import application.struct.RessourcesConstraints;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class constraintsResourceItemController {
	ObservableList<String> matchfields=FXCollections.observableArrayList("Ipsrc","Ipdst","portsrc","portdst","macsrc","macdst","ingressport");
	ObservableList<String> tables=FXCollections.observableArrayList();
	public static RessourcesConstraints rescons;
	static ObservableList<String> list_Constraints = FXCollections.observableArrayList();
	static int id;
	static String field;
	static int cap;
	@FXML
	private ComboBox<String> match;
	@FXML
	private ComboBox<String> tablid;
	@FXML
	private TextField capacity;
	
	@FXML
	private void initialize() {
		int i;
		System.out.println(constraintsController.nbrtable);
		for(i=0;i<constraintsController.nbrtable-1;i++){
			tables.add(Integer.toString(i));
		} 
		match.setItems(matchfields);
	    tablid.setItems(tables);
		
	}
	@FXML
	private void getTableId(){
		id=Integer.parseInt(tablid.getValue());
		
	}
	@FXML
	private void getMatchField(){
		
		field=match.getValue();
		
	}
	@FXML
	private void getCapacity(){
		System.out.println(capacity.getText());
		cap=Integer.parseInt(capacity.getText());	
	}	
	@FXML
	private void submitConstraints() throws IOException{
		//SwitchController swt=new SwitchController();
		//System.out.println(this.getConstraints().toString());
		//List<String> list_constraints = new ArrayList<String>(Arrays.asList(this.getConstraints().toString().split("\\,")));
		//swt.setListview(list_constraints);
		//CompilerController comp=new CompilerController();
		//setListview(Arrays.asList(constraintsResourceItemController.getConstraints().toString()));
		//SwitchController.listConstraints.setItems(list_Constraints);
		CompilerController.c.setListview(Arrays.asList(CompilerController.c.getConstraints().toString()));
		
		CompilerController.s.addConstraints(getConstraints().getClass().getName(),getConstraints() );
		System.out.println(CompilerController.s.toString());
		Main.swt.close();
		//comp.goswitch();
		Main.switchShow();
		Main.cst.close();
		
	}	
	public static RessourcesConstraints getConstraints(){
		//rescons =new RessourcesConstraints(id,cap,field);
		SwitchController.rc.setTableId(id);
		SwitchController.rc.setMatchfield(field);
		SwitchController.rc.setCapacity(cap);
	
		
		return SwitchController.rc;

}
	public static void setListview(List<String> constraint){
		//ObservableList<String> list_Constraints=FXCollections.observableArrayList(); 
		list_Constraints.addAll(constraint);
	}
}
