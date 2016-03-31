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

public class ManagerScreenFXMLController implements Initializable{
	
	Methods method = new Methods();
	
	
	@FXML
	private Button btLogout;
	
	
	/**
	 * Supervisor
	 */
	@FXML
	private Button btShowSupervisors;
	@FXML
	private Button btRegisterSupervisor;
	
	
	
	/**
	 * Monitor
	 */
	@FXML
	private Button btShowMonitors;
	@FXML
	private Button btRegisterMonitor;
	
	
	
	/**
	 * Subject
	 */
	@FXML
	private Button btShowSchoolSubjects;
	@FXML
	private Button btRegisterSchoolSubject;


	
	/**
	 * Supervisor
	 * @throws IOException 
	 */
	public void btShowSupervisors() throws IOException{
		method.setAndShowOnPrimaryStage("/findMe/UI/FXML/ShowAllSupervisorsScreen.fxml", "Manager Screen");
	}
	
	
	public void btRemoveSupervisor(){
		
	}
	
	
	public void btRegisterSupervisor(){
		try {
			method.setAndShowOnPrimaryStage("/findMe/UI/FXML/RegisterSupervisor.fxml", "Manager Screen");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Monitor
	 * @throws IOException 
	 */
	public void btShowMonitors() throws IOException{
		method.setAndShowOnPrimaryStage("/findMe/UI/FXML/ShowAllMonitorsScreen.fxml", "Manager Screen");
		
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
	 * @throws IOException 
	 */
	public void btShowSchoolSubjects() throws IOException{
		method.setAndShowOnPrimaryStage("/findMe/UI/FXML/ShowAllSchoolSubjectScreen.fxml", "Monitor Manager");
	}
	
	
	public void btRegisterSchoolSubject(){
		try {
			method.setAndShowOnPrimaryStage("/findMe/UI/FXML/RegisterSubject.fxml", "Monitor Manager");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
