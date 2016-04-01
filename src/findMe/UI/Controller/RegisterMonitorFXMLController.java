package findMe.UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import DialogBox.AlertBox;
import findMe.actions.ManagerActions;
import findMe.customExceptions.CustomException;
import findMe.domain.BankAccount;
import findMe.domain.Monitor;
import findMe.domain.Person;
import findMe.domain.SchoolSubject;
import findMe.domain.Supervisor;
import findMe.extraMethods.Methods;
import findMe.validate.validator.CpfValidator;
import findMe.validate.validator.DateValidator;
import findMe.validate.validator.EmailValidator;
import findMe.validate.validator.GradeValidator;
import findMe.validate.validator.MonitorValidate;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 * @author thayanneLuiza, ViniFarias, RebecaGaldino
 *
 */
public class RegisterMonitorFXMLController implements Initializable{
	ObservableList<String> optionsCBCOURSE = 
		    FXCollections.observableArrayList("Informática Integrado","Mineraçãoo Integrado", "MSI Integrado", "Petróleo e Gás Integrado","Telemática", "Engenharia da Computação");
	
	ObservableList<String> optionsCBSEX = 
		    FXCollections.observableArrayList("Masculino","Feminino");
	@FXML
	private AnchorPane principal;
	@FXML
	private TextField txtId;
	@FXML
	private TextField txtGrade;
	@FXML
	public TextField txtName;
	@FXML
	public static TextField txtSupervisor;
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
	@FXML
	private GridPane pessoalPane;
	@FXML
	public static Text Supervisor;
	@FXML
	private Button btShowSupervisor;
	@FXML
	private Button btShowSubject;
	public static 	Supervisor supervisor = new Supervisor();
	public static SchoolSubject subject = new SchoolSubject();
	
	public static Methods method = new Methods();

	public void btRegister(){
		try {
			if(validate()){
				BankAccount bank = new BankAccount();
				bank.setId(txtNumberAccount.getText());
				bank.setAccountNumber(txtNumberAccount.getText());
				bank.setAgency(txtAgency.getText());
				bank.setTypeAccount(txtTypeAccount.getText());
				bank.setNotes(txtAreaNotes.getText());
	
				
	
	
				Monitor monitor = new Monitor();
				monitor.setName(txtName.getText());
				monitor.setId(txtId.getText());
				monitor.setBirth_dt(Methods.convertStringToSqlString(txtBirth_dt.getText()));
				monitor.setCpf(txtCpf.getText());
				monitor.setRg(txtRg.getText());
				monitor.setEmail(txtEmail.getText());
				monitor.setPassword(txtPassword.getText());
				monitor.setCourse((cBxCourse.getSelectionModel().getSelectedItem().toString()));
				monitor.setGrade(txtGrade.getText());
				monitor.setRoomWork(txtRoomWork.getText());
				monitor.setSex(cbSex.getSelectionModel().getSelectedItem().toString());
				monitor.setSubject(subject);
				monitor.setSupervisor(supervisor);
				monitor.setBankAccount(bank);
	
				ManagerActions actions = new ManagerActions();
				actions.registerMonitor(monitor);
			}
			else{
				 AlertBox.error("Cadastro inválido", "Digite os campos corretamente");
			}
			
			//validate(monitor);
			
			
			
			
		} catch (Exception e) {
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
	
	@FXML
	public void btShowSupervisor(){
		try {
			Stage showSupervisor = new Stage();
			method.setAndShowOnStage(showSupervisor,"/findMe/UI/FXML/ChoiceSupervisor.fxml", "Monitor Manager" );
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
		if( !(StringValidator.onlyLetters(txtName.getText()) && isNull(txtName.getText()) ) ){
			txtName.setStyle("-fx-border-color: red");
		}
		/**
		 * Birth_dt validator
		 */
		if( !(DateValidator.validate(txtBirth_dt.getText()) && isNull(txtBirth_dt.getText())  ) ){
			valid = false;
			txtBirth_dt.setStyle("-fx-border-color: red");
		}
		/**
		 * CPF validator
		 */
		if( !(CpfValidator.validate(txtCpf.getText()) && isNull(txtCpf.getText())) ){
			valid = false;
			txtCpf.setStyle("-fx-border-color: red");
		}
		/**
		 * Rg validator
		 */
		if( !(RgValidator.validate(txtRg.getText()) && isNull(txtRg.getText())  ) ){
			valid = false;
			txtRg.setStyle("-fx-border-color: red");
		}
		/**
		 * ID validator
		 */
		if( !(NumberValidator.validate( txtId.getText()) && isNull(txtId.getText())) ){
			valid = false;
			txtId.setStyle("-fx-border-color: red");
		}
		/**
		 * Email validator
		 */
		if( !(EmailValidator.validate(txtEmail.getText()) && isNull(txtEmail.getText()) ) ){
			valid = false;
			txtEmail.setStyle("-fx-border-color: red");
		}
		/**
		 * Password validator
		 */
		if( !(StringValidator.password(txtPassword.getText()) && isNull(txtPassword.getText()) ) ){
			valid = false;
			txtPassword.setStyle("-fx-border-color: red");
			
			if( txtConfirmPassword.getText().equals(txtPassword.getText()) ) {
				valid = false;
				txtConfirmPassword.setStyle("-fx-border-color: red");
			}
		}
		
		/**
		 * Grade validator
		 */
		if(!(NumberValidator.validate(txtGrade.getText()) && isNull(txtGrade.getText()) )){
			 valid = false;
			 txtGrade.setStyle("-fx-border-color: red");
		}
		/**
		 * Supervisor validate
		 */
		/*
		if( isNull(txtSupervisor.getText()) ){
			 valid = false;
			 txtSupervisor.setStyle("-fx-border-color: red");
		} */
		/**
		 * Subject validate
		 */
		/*
		if( isNull(txtSchoolSubject.getText()) ){
			 valid = false;
			 txtSchoolSubject.setStyle("-fx-border-color: red");
		} */
		/**
		 * NumberAccount validate
		 */
		if(!(NumberValidator.validate(txtNumberAccount.getText()) && isNull(txtNumberAccount.getText()) )){
			 valid = false;
			 txtNumberAccount.setStyle("-fx-border-color: red");
		}
		/**
		 * Type Account validate
		 */
		if(!(NumberValidator.validate(txtTypeAccount.getText()) && isNull(txtTypeAccount.getText()) )){
			 valid = false;
			 txtTypeAccount.setStyle("-fx-border-color: red");
		}
		
		/**
		 * Agency Account validate
		 */
		if(!(NumberValidator.validate(txtAgency.getText()) && isNull(txtAgency.getText()) )){
			 valid = false;
			 txtAgency.setStyle("-fx-border-color: red");
		}
		

		/**
		 * Room work validate
		 */
		if( isNull(txtRoomWork.getText()) ){
			 valid = false;
			 txtRoomWork.setStyle("-fx-border-color: red");
		}
		
		/**
		 * Sex validate
		 */
		if( isNull(cbSex.getSelectionModel().getSelectedItem().toString()) ){
			System.out.println("sexo invalido");
			 valid = false;
			 cbSex.setStyle("-fx-border-color: red");
		}
		
		/**
		 * Course validate
		 */
		if( isNull(cBxCourse.getSelectionModel().getSelectedItem().toString()) ){
			 valid = false;
			 cBxCourse.setStyle("-fx-border-color: red");
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
		cBxCourse.setItems(optionsCBCOURSE);
		
	}

}