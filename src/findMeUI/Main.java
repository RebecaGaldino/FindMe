package findMeUI;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static Stage primaryStage;
	public static Object stage;
	
	public void start(Stage primaryStage) throws Exception{
		try {

			this.primaryStage = primaryStage;
			
			Parent root = FXMLLoader.load(getClass().getResource("InitialScreen.fxml"));
			
			Scene scene1 = new Scene(root);
			
			primaryStage.setTitle("Monitor Manager");
			primaryStage.setScene(scene1);
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
