package findMe.UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * 
 * @author thayanneLuiza, ViniFarias, RebecaGaldino
 *
 */
public class InitialScreenFXMLController implements Initializable{
	
	public static String choice;
	
	@FXML
	private Button btMonitor;
	@FXML
	private Button btSupervisor;
	@FXML
	private Button btManager;
	
	@FXML
	private void btMonitor() throws IOException{
		choice = "Monitor";
		
		Parent root2 = FXMLLoader.load(getClass().getResource("/findMe/UI/FXML/LoginScreen.fxml"));
		
		Scene loginMonitorScreen = new Scene(root2);
		Main.primaryStage.setTitle("Monitor Manager");
		Main.primaryStage.setScene(loginMonitorScreen);
		Main.primaryStage.show(); 
	}
	
	@FXML
	private void btSupervisor() throws IOException{
		choice = "Professor";
		
		Parent root2 = FXMLLoader.load(getClass().getResource("/findMe/UI/FXML/LoginScreen.fxml"));
		
		Scene loginSupervisorScreen = new Scene(root2);
		
		Main.primaryStage.setTitle("Monitor Manager");
		Main.primaryStage.setScene(loginSupervisorScreen);
		Main.primaryStage.show();
	}
	
	@FXML
	private void btManager() throws IOException{
		choice = "Gerente";

		Parent root2 = FXMLLoader.load(getClass().getResource("/findMe/UI/FXML/LoginScreen.fxml"));
		
		Scene loginManagerScreen = new Scene(root2);
		
		Main.primaryStage.setTitle("Monitor Manager");
		Main.primaryStage.setScene(loginManagerScreen);
		Main.primaryStage.show();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
