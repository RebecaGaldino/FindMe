package findMe.UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import findMe.dataBase.ManagerDAO;
import findMe.dataBase.MonitorDAO;
import findMe.dataBase.SupervisorDAO;
import findMe.extraMethods.Methods;
import javafx.animation.Interpolatable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class LoginScreenFXMLController implements Initializable {
	
	@FXML
	private ImageView logoSupervisor;
	@FXML
	private ImageView logoManager;
	@FXML
	private ImageView logoMonitor;
	@FXML
	private Text textPerson;
	@FXML
	private Button btCancel;
	@FXML
	private Button btLogin;
	@FXML
	private TextField txtNameUser;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private ImageView logoUser;
	@FXML
	private Label txtAccountInvalid;
	
	
	private String choice = InitialScreenFXMLController.choice;
	
	private String rootFXML;
	
	private boolean userChecksResult;
	Methods method = new Methods();
	public static String UserId;
	
	private MonitorDAO mDAO = new MonitorDAO();
	private SupervisorDAO sDAO = new SupervisorDAO();
	private ManagerDAO mgDAO = new ManagerDAO();
	
	
	@FXML
	public void btLogin() throws IOException{
		if(choice.equals("Professor")){
			userChecksResult = sDAO.userChecksSupervisor(txtNameUser.getText(), txtPassword.getText());
		}
		else if(choice.equals("Gerente")){
			userChecksResult = mgDAO.userChecksManager(txtNameUser.getText(), txtPassword.getText());
		}
		else if(choice.equals("Monitor")){
			userChecksResult = mDAO.userChecksMonitor(txtNameUser.getText(), txtPassword.getText());
		}
		
		
		if(userChecksResult){
			UserId = txtNameUser.getText();
			method.setAndShowOnPrimaryStage("/findMe/UI/FXML/"+rootFXML, "Monitor Manager");
		}
		else{
			txtNameUser.setStyle("-fx-border-color: red");
			txtPassword.setStyle("-fx-border-color: red");
			txtAccountInvalid.setVisible(true);
		}
	}
	
	
	@FXML
	public void btCancel() throws IOException{
		method.setAndShowOnPrimaryStage("/findMe/UI/FXML/InitialScreen.fxml", "Monitor Manager");
	}
	
	
	private void choice(){
		if(choice.equals("Professor")){
			logoSupervisor.setVisible(true);
			rootFXML = "SupervisorScreen.fxml";
		}
		else if(choice.equals("Gerente")){
			logoManager.setVisible(true);
			rootFXML = "ManagerScreen.fxml";
		}
		else if(choice.equals("Monitor")){
			logoMonitor.setVisible(true);
			rootFXML = "MonitorScreen.fxml";
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		textPerson.setText("Área do "+ choice);
		choice();		
		  
	}
}
