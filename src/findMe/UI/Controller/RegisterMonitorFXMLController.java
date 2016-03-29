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
import findMe.domain.Supervisor;
import findMe.validate.validator.CpfValidator;
import findMe.validate.validator.DateValidator;
import findMe.validate.validator.EmailValidateor;
import findMe.validate.validator.GradeValidator;
import findMe.validate.validator.IdValidate;
import findMe.validate.validator.MonitorValidate;
import findMe.validate.validator.NumberValidator;
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
		    FXCollections.observableArrayList("Informática Integrado","Mineração Integrado", "MSI Integrado", "Petróleo e Gás Integrado");
	
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
	
	
	public void btRegister(){
		try {
			
			BankAccount bankAccount = new BankAccount();
			
			Monitor monitor = new Monitor();
			monitor.setName(txtName.getText());
			monitor.setId(txtId.getText());
			monitor.setBirth_dt(txtBirth_dt.getText());
			monitor.setCpf(txtCpf.getText());
			monitor.setRg(txtRg.getText());
			monitor.setEmail(txtEmail.getText());
			monitor.setPassword(txtPassword.getText());
			
			monitor.setCourse((cBxCourse.getSelectionModel().getSelectedItem().toString());
			monitor.setGrade(grade);
			monitor.setRoomWork(roomWork);
			monitor.setSex(sex);
			monitor.setSubject(subject);
			monitor.setSupervisor(supervisor);
			
			validate(monitor);
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public void btCancel(){
		
		
	}
	
	public  boolean validate(Monitor monitor) throws CustomException{
		boolean valid = true;
		/**
		 * NAME
		 */
		if(StringValidator.onlyLetters(monitor.getName())){
			valid = false;
			txtName.setStyle("-fx-border-color: red;");
			nameError.setVisible(true);
			//pessoalPane.add(new ImageView("file:///lib/media/Error.png"), 2, 0);
			//ImageView im = new ImageView("findMe/media/Error.png");
			//im.setStyle('fitHeight="15.0" fitWidth="17.0" visible="true" GridPane.columnIndex="2" GridPane.halignment="CENTER"');
			//pessoalPane.add(im, 2, 0);
		}
		
		/**
		 * PASSWORD
		 */
		if(StringValidator.password(monitor.getPassword())){
			valid = false;
			txtPassword.setStyle("-fx-border-color: red;");
			passwordError.setVisible(true);
			pessoalPane.add(new ImageView("file:///lib/media/Error.png"), 2, 0);	
		}
		/**
		 * CPF
		 */
		if(CpfValidator.validate(monitor.getCpf())){
			valid = false;
			txtCpf.setStyle("-fx-border-color: red;");
			cpfError.setVisible(true);
			//pessoalPane.add(new ImageView("file:///lib/media/Error.png"), 2, 0);	
		}
		/**
		 * CPF
		 */
		if((RgValidator.validate(monitor.getRg()))  ){
			valid = false;
			txtRg.setStyle("-fx-border-color: red;");
			rgError.setVisible(true);
			//pessoalPane.add(new ImageView("file:///lib/media/Error.png"), 2, 0);	
		}
		/**
		 * DATE
		 */
		if( DateValidator.validate(monitor.getBirth_dt()) )   {
			valid = false;
			txtBirth_dt.setStyle("-fx-border-color: red;");
			dateError.setVisible(true);
			//pessoalPane.add(new ImageView("file:///lib/media/Error.png"), 2, 0);	
		}
		/**
		 * EMAIL
		 */
		if( EmailValidateor.validate(monitor.getEmail())  ){
			valid = false;
			txtEmail.setStyle("-fx-border-color: red;");
			emailError.setVisible(true);
			//pessoalPane.add(new ImageView("file:///lib/media/Error.png"), 2, 0);	
		}
		/**
		 * ID
		 */
		if((IdValidate.validate((monitor.getId()))) != null){
			valid = false;
			txtId.setStyle("-fx-border-color: red;");
			idError.setVisible(true);
			//pessoalPane.add(new ImageView("file:///lib/media/Error.png"), 2, 0);	
		} 
		/**
		 * GRADE
		 */
		if((GradeValidator.validate((monitor.getGrade()))) != null){
			valid = false;
			txtGrade.setStyle("-fx-border-color: red;");
			gradeError.setVisible(true);
			//pessoalPane.add(new ImageView("file:///lib/media/Error.png"), 2, 0);	
		}
		
		
		/**
		 * NUMBER
		 */
		if( (NumberValidator.validate((monitor.getBankAccount().getAccountNumber() ))) ){
			valid = false;
			txtNumberAccount.setStyle("-fx-border-color: red;");
			numberError.setVisible(true);
			//pessoalPane.add(new ImageView("file:///lib/media/Error.png"), 2, 0);	
		}
		
		
		return valid;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbSex.setItems(optionsCBSEX);
		cBxCourse.setItems(optionsCBCOURSE);
		
	}

}
