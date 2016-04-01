package findMe.UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import findMe.extraMethods.Methods;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class SupervisorScreenFXMLController implements Initializable{
	
	@FXML
	private Button btEdit;
	@FXML 
	private Button btAskMonitor;
	@FXML
	private Button btLogout;
	
	Methods method = new Methods();
	public static String UserId = LoginScreenFXMLController.UserId;
	
	
	public void btEdit() throws IOException{
		
		method.setAndShowOnPrimaryStage("/findMe/UI/FXML/SupervisorEditScreen.fxml", "Monitor Manager");
		
	}
	
	
	public void btAskMonitor(){
		
		
	}
	
	
	public void btLogout(){
		
		try{
			method.setAndShowOnPrimaryStage("/findMe/UI/FXML/InitialScreen.fxml", "Monitor Manager");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
