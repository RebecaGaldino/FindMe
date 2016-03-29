package findMe.UI.Controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class MonitorScreenFXMLController {
	@FXML
	private Button btEdit;
	
	@FXML 
	private Button btReport;
	
	@FXML
	private Button btLogout;
	
	
	
	public void btLogout(){
		try{
			Parent root = FXMLLoader.load(getClass().getResource("/findMe/UI/FXML/InitialScreen.fxml"));
			
			Scene scene = new Scene(root);
			Main.primaryStage.setTitle("Initial Screen");
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
