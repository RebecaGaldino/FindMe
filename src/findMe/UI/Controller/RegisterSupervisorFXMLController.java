package findMe.UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import DialogBox.AlertBox;
import findMe.actions.ManagerActions;
import findMe.dataBase.Supervisor_SchoolSubjectDAO;
import findMe.domain.SchoolSubject;
import findMe.domain.Supervisor;
import findMe.domain.Supervisor_SchoolSubject;
import findMe.extraMethods.Methods;
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
	@FXML
	private Button btShowSubject;
	private Methods method = new Methods();
	public static SchoolSubject subject = new SchoolSubject();
	ObservableList<String> optionsCBSEX = 
		    FXCollections.observableArrayList("Masculino","Feminino");
	
	
	/*!!!!!!!!!
	 * Necessario criar um BotaoMenu onde o manager seleciona as disciplinas do supervisor
	 * Necessario validar as informacoes que sao setadas na interface
	 */
	@FXML
	public void btRegister() throws IOException, ParseException, SQLException{
		try {
			
			if(validate()){
				ManagerActions mAct = new ManagerActions();
				
	
				Supervisor supervisor = new Supervisor();
				
				supervisor.setName(txtName.getText());
				 supervisor.setId(txtId.getText());
				supervisor.setSex(cbSex.getSelectionModel().getSelectedItem().toString());
				supervisor.setPassword(txtPassword.getText());
				supervisor.setBirth_dt(Methods.convertStringToSqlString(txtBirth_dt.getText()));
				supervisor.setCpf(txtCpf.getText());
				supervisor.setRg(txtRg.getText());
				supervisor.setEmail(txtEmail.getText());
				
				Supervisor_SchoolSubject supervisorSubject = new Supervisor_SchoolSubject(supervisor, subject);
			
				Supervisor_SchoolSubjectDAO sdao = new Supervisor_SchoolSubjectDAO();
				sdao.insertSupervisor_SchoolSubject(supervisorSubject);
				
				ManagerActions mac = new ManagerActions();
				mac.registerSupervisor(supervisor);
				method.setAndShowOnPrimaryStage("/findMe/UI/FXML/ManagerScreen.fxml", "Monitor Manager");

			}
			
			else{
				 AlertBox.error("Cadastro inválido", "Digite os campos corretamente");
			}
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			AlertBox.error("Cadastro inválido", e.getMessage());
		}
	}
	
	@FXML
	public void btShowSubject(){

		try {
			Stage showSubject= new Stage();
			method.setAndShowOnStage(showSubject,"/findMe/UI/FXML/ChoiceSubject.fxml", "Monitor Manager" );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void btCancel(){
		try {
			method.setAndShowOnPrimaryStage("/findMe/UI/FXML/ManagerScreen.fxml", "Monitor Manager");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean validate(){
		boolean valid = true;
		/**
		 * Name validator
		 */
		if( !(StringValidator.onlyLetters(txtName.getText()) || isNull(txtName.getText()) ) ){
			txtName.setStyle("-fx-border-color: red");
		}
		/**
		 * Birth_dt validator
		 */
		if( !(DateValidator.validate(txtBirth_dt.getText()) || isNull(txtBirth_dt.getText())  ) ){
			valid = false;
			txtBirth_dt.setStyle("-fx-border-color: red");
		}
		/**
		 * CPF validator
		 */
		if( !(CpfValidator.validate(txtCpf.getText()) || isNull(txtCpf.getText())) ){
			valid = false;
			txtCpf.setStyle("-fx-border-color: red");
		}
		/**
		 * Rg validator
		 */
		if( !(RgValidator.validate(txtRg.getText()) || isNull(txtRg.getText())  ) ){
			valid = false;
			txtRg.setStyle("-fx-border-color: red");
		}
		/**
		 * ID validator
		 */
		if( !(NumberValidator.validate( txtId.getText()) || isNull(txtId.getText())) ){
			valid = false;
			txtId.setStyle("-fx-border-color: red");
		}
		/**
		 * Email validator
		 */
		if( !(EmailValidator.validate(txtEmail.getText()) || isNull(txtEmail.getText()) ) ){
			valid = false;
			txtEmail.setStyle("-fx-border-color: red");
		}
		/**
		 * Password validator
		 */
		if( !(StringValidator.password(txtPassword.getText()) || isNull(txtPassword.getText()) ) ){
			valid = false;
			txtPassword.setStyle("-fx-border-color: red");
			
			if( txtConfirmPassword.getText().equals(txtPassword.getText()) ) {
				valid = false;
				txtConfirmPassword.setStyle("-fx-border-color: red");
			}
		}
		
		
		

	
		
		
		
		return valid;
	}
	
	public boolean isNull(String value){
		if(value == null && value == "" && value.equals("") )
			return false;
		return false;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbSex.setItems(optionsCBSEX);
		
	}

}
