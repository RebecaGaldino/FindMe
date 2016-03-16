package main;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

public class TestUI extends Application{

	
	/*Método que dá inicio a toda aplicação*/
	public void start(Stage primaryStage) throws IOException {
		
		/* "root1" diz respeito a tela inicial*/
		Parent root = FXMLLoader.load(getClass().getResource("/findMe.UI/RegisterMonitorScreen.fxml"));

		Scene scene = new Scene(root);
		
		primaryStage.setTitle("---- FIND  ME ----");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args){
		launch(args);
	}

}
