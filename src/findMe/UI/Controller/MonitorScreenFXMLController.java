package findMe.UI.Controller;

import java.io.IOException;

import findMe.extraMethods.Methods;
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
	@FXML
	private Button btTimeTable;
	
	
	private Methods method = new Methods();
	
	public static String UserId = LoginScreenFXMLController.UserId;
	
	public void btLogout(){
		try{
			method.setAndShowOnPrimaryStage("/findMe/UI/FXML/InitialScreen.fxml", "Monitor Manager");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void btEdit() throws IOException{
		method.setAndShowOnPrimaryStage("/findMe/UI/FXML/MonitorEditScreen.fxml", "Monitor Manager");
	}
	
	public void btReport(){
		
	}
	
	public void btTimeTable(){
		
	}
}
