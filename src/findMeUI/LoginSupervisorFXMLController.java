package findMeUI;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginSupervisorFXMLController  {
	
	@FXML
	private Button btCancel;
	@FXML
	private Button btLogin;
	@FXML
	private TextField txtNameUser;
	@FXML
	private PasswordField txtPassword;
	
	@FXML
	public void btLogin() throws IOException{

		Parent root = FXMLLoader.load(getClass().getResource("LoginSupervisor.fxml"));
		
		Scene loginMonitorScreen = new Scene(root);
		Main.primaryStage.setTitle("Monitor Manager");
		Main.primaryStage.setScene(loginMonitorScreen);
		Main.primaryStage.show();
	}
	
	
	@FXML
	public void btCancel() throws IOException{
		
		Parent root = FXMLLoader.load(getClass().getResource("InitialScreen.fxml"));
		
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("Initial Screen");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}
}
