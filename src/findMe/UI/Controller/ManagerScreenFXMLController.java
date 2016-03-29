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
	private Button btShowMonitors;
	@FXML
	private Button btRegisterMonitor;
	@FXML
	private Button btRemoveMonitor;
	/**
	 * Subject
	 */
	@FXML
	private Button btShowSchoolSubjects;
	@FXML
	private Button btRemoveSubject;
	@FXML
	private Button btRegisterSchoolSubject;


	/**
	 * Supervisor
	 * @throws IOException 
	 */
	
	public void btShowSupervisors() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("/findMe/UI/FXML/ShowAllSupervisorsScreen.fxml"));	
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("Initial Screen");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}
	
	public void btRemoveSupervisor(){
		
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
	 * @throws IOException 
	 */
	
	public void btShowMonitors() throws IOException{
			
		Parent root = FXMLLoader.load(getClass().getResource("/findMe/UI/FXML/ShowAllMonitorsScreen.fxml"));	
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("Initial Screen");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
		
	}
	
	public void btRemoveMonitor(){
		
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
			
		Parent root = FXMLLoader.load(getClass().getResource("/findMe/UI/FXML/ShowAllSchoolSubjectScreen.fxml"));	
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("Initial Screen");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}
	
	public void btRemoveSchoolSubject(){
		
	}
	
	public void btRegisterSchoolSubject(){
		
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
