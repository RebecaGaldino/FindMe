package findMe.UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

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
		    FXCollections.observableArrayList("Inform�tica Integrado","Minera��o Integrado", "MSI Integrado", "Petr�leo e G�s Integrado");
	
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
	private ImageView nameError;
	@FXML
	private ImageView dateError;
	@FXML
	private ImageView cpfError;
	@FXML
	private ImageView rgError;
	@FXML
	private ImageView emailError;
	@FXML
	private ImageView passwordError;
	@FXML
	private ImageView gradeError;
	@FXML
	private ImageView sexError;
	@FXML
	private ImageView idError;
	@FXML
	private ImageView confirmError;
	@FXML
	private ImageView courseError;
	@FXML
	private ImageView subjectError;
	@FXML
	private ImageView roomError;
	@FXML
	private ImageView supervisorError;
	@FXML
	private ImageView numberError;
	@FXML
	private ImageView agencyError;
	@FXML
	private ImageView typeError;
	@FXML
	private Button btShowSupervisor;
	@FXML
	private Button btShowSubject;
	public static 	Supervisor supervisor = new Supervisor();
	public static SchoolSubject subject = new SchoolSubject();
	
	public static Methods method = new Methods();

	public void btRegister(){
		try {
			
			System.out.println("oi");
			Monitor monitor = new Monitor();
			monitor.setName(txtName.getText());
			monitor.setId(txtId.getText());
			monitor.setBirth_dt(txtBirth_dt.getText());
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
			ManagerActions actions = new ManagerActions();
			actions.registerMonitor(monitor);
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
	
	public boolean validate(Monitor monitor){
		boolean valid = true;
		/**
		 * Name validator
		 */
		if( !(StringValidator.onlyLetters(monitor.getName()) ) ){
			valid = false;
			txtName.setStyle("-fx-border-color: red;");
		}
		/**
		 * Birth_dt validator
		 */
		if( !(DateValidator.validate(monitor.getBirth_dt())) ){
			valid = false;
			txtBirth_dt.setStyle("-fx-border-color: red;");
		}
		/**
		 * CPF validator
		 */
		if( !(CpfValidator.validate(monitor.getCpf()) ) ){
			valid = false;
			txtCpf.setStyle("-fx-border-color: red;");
		}
		/**
		 * Rg validator
		 */
		if( !(RgValidator.validate(monitor.getRg()) ) ){
			valid = false;
			txtRg.setStyle("-fx-border-color: red;");
		}
		/**
		 * ID validator
		 */
		if( !(NumberValidator.validate(monitor.getId()) ) ){
			valid = false;
			txtId.setStyle("-fx-border-color: red;");
		}
		/**
		 * Email validator
		 */
		if( !(EmailValidator.validate(monitor.getEmail()) ) ){
			valid = false;
			txtEmail.setStyle("-fx-border-color: red;");
		}
		/**
		 * Password validator
		 */
		if( !(StringValidator.password(monitor.getPassword()) ) ){
			valid = false;
			txtEmail.setStyle("-fx-border-color: red;");
			
			if( txtConfirmPassword.getText().equals(txtPassword.getText()) ) {
				valid = false;
				txtConfirmPassword.setStyle("-fx-border-color: red;");
			}
		}
		
		/**
		 * Grade validator
		 */
		if(!(NumberValidator.validate(monitor.getGrade()))){
			 valid = false;
			 txtGrade.setStyle("-fx-border-color: red;");
		}
		
		
		return valid;
	}
	
	
	public boolean isNull(String value){
		if(value == null)
			return true;
		return false;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbSex.setItems(optionsCBSEX);
		cBxCourse.setItems(optionsCBCOURSE);
		
	}

}