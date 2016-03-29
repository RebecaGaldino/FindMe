package findMe.UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class ManagerScreenFXMLController implements Initializable{
	@FXML
	private Button btLogout;
	
	/**
	 * Supervisor
	 */
	@FXML
	private Button btShowSupervisors;
	@FXML
	private Button btRemoveSupervisor;
	@FXML
	private Button btRegisterSupervisor;
	
	/**
	 * Monitor
	 */
	@FXML
	private Button btShowMonitores;
	@FXML
	private Button btRegisterMonitor;
	@FXML
	private Button btRemoveMonitor;
	/**
	 * Subject
	 */
	@FXML
	private Button btShowDisciplina;
	@FXML
	private Button btRemoveDisciplina;
	@FXML
	private Button btRegisterDisciplina;


	/**
	 * Supervisor
	 */
	
	public void btShowSupervisors(){
		
	}
	
	public void btRemoveSupervisors(){
		
	}
	
	public void btRegisterSupervisor(){
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/findMe/UI/FXML/RegisterSupervisor.fxml"));
			Scene loginRegisterSupervisor = new Scene(root);
			Main.primaryStage.setTitle("Monitor Manager");
			Main.primaryStage.setScene(loginRegisterSupervisor);
			Main.primaryStage.show(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Monitor
	 */
	
	public void btShowMonitores(){
		
	}
	
	public void btRemoveMonitores(){
		
	}
	
	public void btRegisterMonitor(){
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/findMe/UI/FXML/RegisterMonitor.fxml"));
			Scene loginRegisterMonitor = new Scene(root);
			Main.primaryStage.setTitle("Monitor Manager");
			Main.primaryStage.setScene(loginRegisterMonitor);
			Main.primaryStage.show(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Subject
	 */
	
	public void btShowDisciplina(){
		
	}
	
	public void btRemoveDisciplina(){
		
	}
	
	public void btRegisterDisciplina(){
		
	}
	
	/**
	 * Logout
	 */
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}