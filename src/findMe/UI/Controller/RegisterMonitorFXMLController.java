package findMe.UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import findMe.actions.ManagerActions;
import findMe.domain.Monitor;
import findMe.domain.Supervisor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * 
 * @author thayanneLuiza, ViniFarias, RebecaGaldino
 *
 */
public class RegisterMonitorFXMLController implements Initializable{
	ObservableList<String> optionsCBSEX = 
		    FXCollections.observableArrayList("Masculino","Feminino");
	
	@FXML
	private TextField txtId;
	@FXML
	private TextField txtGrade;
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtSupervisor;
	@FXML
	private TextField txtSchoolSubject;
	@FXML
	private TextField txtNumberAccount;
	@FXML
	private TextField txtRoomWork;
	@FXML
	private TextField txtCpf;
	@FXML
	private ComboBox cBxCourse;
	@FXML
	private TextField txtAgency;
	@FXML
	private TextField txtTypeAccount;
	@FXML
	private TextArea txtAreaNotes;
	@FXML
	private TextField txtBirth_dt;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private PasswordField txtConfirmPassword;
	@FXML
	private Button btRegister;
	@FXML
	private Button btCancel;
	@FXML
	private TextField txtRg;
	@FXML
	private TextField txtEmail;
	@FXML
	private ComboBox cbSex;
	
	
	
	
	
	public Monitor btRegister(){
		try {
			ManagerActions mAct = new ManagerActions();
			
			Monitor monitor = new Monitor();
			monitor.setName(txtName.getText());
			monitor.setId(txtId.getText());
			monitor.setBirth_dt(txtBirth_dt.getText());
			monitor.setCpf(txtCpf.getText());
			monitor.setRg(txtRg.getText());
			monitor.setEmail(txtEmail.getText());
			monitor.setPassword(txtPassword.getText());
			
			return monitor;
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public void btCancel(){
		
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbSex.setItems(optionsCBSEX);
		
	}

}
