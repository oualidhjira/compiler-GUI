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
	ObservableList<String> tables=FXCollections.observableArrayList("1","2");
	public static RessourcesConstraints rescons;
	int id;
	String field;
	int cap;
	@FXML
	private ComboBox<String> match;
	@FXML
	private ComboBox<String> tablid;
	@FXML
	private TextField capacity;
	
	@FXML
	private void initialize() {
		
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
		SwitchController swt=new SwitchController();
		System.out.println(this.getConstraints().toString());
		List<String> list_constraints = new ArrayList<String>(Arrays.asList(this.getConstraints().toString().split("\\,")));
		swt.setListview(list_constraints);
		System.out.println(swt.list_Constraints);
		CompilerController comp=new CompilerController();
		comp.goswitch();
		Main.cst.close();
		
	}	
	public RessourcesConstraints getConstraints(){
		rescons =new RessourcesConstraints(id,cap,field);
		return rescons;

}
}
