package findMeUI;

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


public class InitialScreenFXMLController implements Initializable{

	@FXML
	private Button btMonitor;
	@FXML
	private Button btSupervisor;
	@FXML
	private Button btManager;

	@FXML
	private void btMonitor() throws IOException{

		Parent root2 = FXMLLoader.load(getClass().getResource("LoginMonitor.fxml"));
		
		Scene loginMonitorScreen = new Scene(root2, 541, 131);
		Stage stage = new Stage();
		stage.setTitle("Monitor Manager");
		stage.setScene(loginMonitorScreen);
		stage.show();
	}
	
	@FXML
	private void btSupervisor() throws IOException{
		Parent root2 = FXMLLoader.load(getClass().getResource("LoginSupervisor.fxml"));
		
		Scene loginSupervisorScreen = new Scene(root2, 541, 131);
		Stage stage = new Stage();
		stage.setTitle("Monitor Manager");
		stage.setScene(loginSupervisorScreen);
		stage.show();
	}
	
	@FXML
	private void btManager() throws IOException{
		Parent root2 = FXMLLoader.load(getClass().getResource("LoginManager.fxml"));
		
		Scene loginManagerScreen = new Scene(root2, 541, 131);
		Stage stage = new Stage();
		stage.setTitle("Monitor Manager");
		stage.setScene(loginManagerScreen);
		stage.show();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
