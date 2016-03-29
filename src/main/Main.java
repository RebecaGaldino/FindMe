package main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import findMe.UI.FXML.*;
/**
 * 
 * @author thayanneLuiza, ViniFarias, RebecaGaldino
 *
 */
public class Main extends Application {
	
	public static Stage primaryStage;
	public static Object stage;
	public static Scene scene;
	
	public void start(Stage primaryStage) throws Exception{
		try {

			this.primaryStage = primaryStage;
			
			Parent root = FXMLLoader.load(getClass().getResource("/findMe/UI/FXML/ShowAllMonitorsScreen.fxml"));
			
			this.scene = new Scene(root);
			scene.getStylesheets().add("/styles/Styles.css");
			
			primaryStage.setTitle("Monitor Manager");
			primaryStage.setScene(scene);
			primaryStage.setMaximized(false);
			primaryStage.show();

		} catch (Exception e) {

		    // generic exception handling
		    e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		launch(args);
	}
}


