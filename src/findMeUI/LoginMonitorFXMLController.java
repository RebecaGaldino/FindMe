package findMeUI;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LoginMonitorFXMLController  {
	
	private void btLogin() throws IOException{

		Parent root = FXMLLoader.load(getClass().getResource("LoginMonitor.fxml"));
		
		Scene loginMonitorScreen = new Scene(root, 600, 400);
		Main.primaryStage.setTitle("Monitor Manager");
		Main.primaryStage.setScene(loginMonitorScreen);
		Main.primaryStage.show();
	}
	
	private void btCancel() throws IOException{

		Parent root = FXMLLoader.load(getClass().getResource("InitialScreen.fxml"));
		
		Scene loginMonitorScreen = new Scene(root, 600, 400);
		Main.primaryStage.setTitle("Monitor Manager");
		Main.primaryStage.setScene(loginMonitorScreen);
		Main.primaryStage.show();
	}
}
