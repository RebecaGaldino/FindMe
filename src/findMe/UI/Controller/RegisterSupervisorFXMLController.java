package findMe.UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import findMe.actions.ManagerActions;
import findMe.domain.Supervisor;
import findMe.validate.validator.CpfValidator;
import findMe.validate.validator.DateValidator;
import findMe.validate.validator.EmailValidator;
import findMe.validate.validator.NumberValidator;
import findMe.validate.validator.PersonValidate;
import findMe.validate.validator.RgValidator;
import findMe.validate.validator.StringValidator;
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
public class RegisterSupervisorFXMLController implements Initializable{
		
	@FXML
	private TextField txtId;
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtSchoolSubject;
	@FXML
	private TextField txtCpf;
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
	
	ObservableList<String> optionsCBSEX = 
		    FXCollections.observableArrayList("Masculino","Feminino");
	
	
	/*!!!!!!!!!
	 * Necessario criar um BotaoMenu onde o manager seleciona as disciplinas do supervisor
	 * Necessario validar as informacoes que sao setadas na interface
	 */
	public Supervisor btRegister() throws IOException, ParseException, SQLException{
		try {
			
			
			ManagerActions mAct = new ManagerActions();
			
			
			Supervisor supervisor = new Supervisor();
			
			supervisor.setName(txtName.getText());
			supervisor.setId(txtId.getText());
			supervisor.setSex(cbSex.getSelectionModel().getSelectedItem().toString());
			supervisor.setPassword(txtPassword.getText());
			supervisor.setBirth_dt(txtBirth_dt.getText());
			
			supervisor.setCpf(txtCpf.getText());
			supervisor.setRg(txtRg.getText());
			supervisor.setEmail(txtEmail.getText());
			supervisor.setPassword(txtPassword.getText());
			if(PersonValidate.validate(supervisor) == null){
				mAct.registerSupervisor(supervisor);
			}
			else{
				
			}
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void btCancel(){
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource("/findMe/UI/FXML/ManagersScreen.fxml"));
			Scene managerScreen = new Scene(root);
			Main.primaryStage.setTitle("Monitor Manager");
			Main.primaryStage.setScene(managerScreen);
			Main.primaryStage.show(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean validate(Supervisor supervisor){
		boolean valid = true;
		
		if( !(StringValidator.onlyLetters(supervisor.getName()) ) ){
			valid = false;
			txtName.setStyle("-fx-border-color: red;");
		}
		
		if( !(DateValidator.validate(supervisor.getBirth_dt())) ){
			valid = false;
			txtBirth_dt.setStyle("-fx-border-color: red;");
		}
		
		if( !(CpfValidator.validate(supervisor.getCpf()) ) ){
			valid = false;
			txtCpf.setStyle("-fx-border-color: red;");
		}
		
		if( !(RgValidator.validate(supervisor.getRg()) ) ){
			valid = false;
			txtRg.setStyle("-fx-border-color: red;");
		}
		
		if( !(NumberValidator.validate(supervisor.getId()) ) ){
			valid = false;
			txtId.setStyle("-fx-border-color: red;");
		}
		
		if( !(EmailValidator.validate(supervisor.getEmail()) ) ){
			valid = false;
			txtEmail.setStyle("-fx-border-color: red;");
		}
		
		if( !(StringValidator.password(supervisor.getPassword()) ) ){
			valid = false;
			txtEmail.setStyle("-fx-border-color: red;");
			
			if( txtConfirmPassword.getText().equals(txtPassword.getText()) ) {
				valid = false;
				txtConfirmPassword.setStyle("-fx-border-color: red;");
			}
		}
		
		
		return valid;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbSex.setItems(optionsCBSEX);
		
	}

}
