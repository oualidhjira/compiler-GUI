package application;

	
import java.io.IOException;

import application.struct.RessourcesConstraints;
import application.struct.Switch;
import application.view.SwitchController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private BorderPane mainLayout;
	public static Stage primaryStage;
	public static Stage swt;
	private static Scene scn;
	public static Stage cst;
	private static BorderPane constraintLayout;
	//public static Switch s;
	//public static RessourcesConstraints rc;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("compiler");
		complierShow();
		
		
	}
	public void complierShow() throws IOException{
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/Compiler.fxml"));
		mainLayout= loader.load();
		Scene scene=new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void switchShow() throws IOException{
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/switch.fxml"));
		BorderPane switchLayout=loader.load();
		//s=new Switch();
		Scene scn=new Scene(switchLayout);
		swt=new Stage();
		swt.setTitle("Switch");
		swt.initModality(Modality.WINDOW_MODAL);
		swt.initOwner(primaryStage);
		swt.setScene(scn);
		swt.show();
	}
	public static void constraintShow()throws IOException{
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/constraints.fxml"));
		constraintLayout=loader.load();
		Scene scn=new Scene(constraintLayout);
		cst=new Stage();
		cst.setTitle("constraints");
		cst.initModality(Modality.WINDOW_MODAL);
		cst.initOwner(swt);
		cst.setScene(scn);
		cst.show();
		
	}
	public static void constraintPerformanceItems() throws IOException{
		//rc=new RessourcesConstraints();
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/constraintRessourceItems.fxml"));
		BorderPane con=loader.load();
		constraintLayout.setCenter(con);
			
	}
	public static void pathProcessingConstraint() throws IOException{
		
		FXMLLoader loader=new FXMLLoader();		
		loader.setLocation(Main.class.getResource("view/pathProcessing.fxml"));
		BorderPane tbl=loader.load();
		constraintLayout.setCenter(tbl);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
