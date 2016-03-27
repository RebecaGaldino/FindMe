package findMe.UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import findMe.actions.ManagerActions;
import findMe.domain.Monitor;
import findMe.domain.Person;
import findMe.domain.Supervisor;
import findMe.validate.CpfValidate;
import findMe.validate.CustomException;
import findMe.validate.DateValidate;
import findMe.validate.EmailValidate;
import findMe.validate.GradeValidate;
import findMe.validate.IdValidate;
import findMe.validate.MonitorValidate;
import findMe.validate.NameValidate;
import findMe.validate.NumberValidate;
import findMe.validate.PasswordValidate;
import findMe.validate.RgValidate;
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
			
			
			Monitor monitor = new Monitor();
			monitor.setName(txtName.getText());
			monitor.setId(txtId.getText());
			monitor.setBirth_dt(txtBirth_dt.getText());
			monitor.setCpf(txtCpf.getText());
			monitor.setRg(txtRg.getText());
			monitor.setEmail(txtEmail.getText());
			monitor.setPassword(txtPassword.getText());
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
		if(NameValidate.validate(monitor.getName()) != null){
			System.out.println(NameValidate.validate(monitor.getName()));
			valid = false;
			txtName.setStyle("-fx-border-color: red;");
			nameError.setVisible(true);
			//pessoalPane.add("oi", 2, 0);
		}
		
		/**
		 * PASSWORD
		 */
		if((PasswordValidate.validate(monitor.getPassword())) != null){
			valid = false;
			txtPassword.setStyle("-fx-border-color: red;");
			passwordError.setVisible(true);
			//pessoalPane.add(new ImageView("file:///lib/media/Error.png"), 2, 0);	
		}
		/**
		 * CPF
		 */
		if((CpfValidate.validate(monitor.getCpf())) != null){
			valid = false;
			txtCpf.setStyle("-fx-border-color: red;");
			cpfError.setVisible(true);
			//pessoalPane.add(new ImageView("file:///lib/media/Error.png"), 2, 0);	
		}
		/**
		 * CPF
		 */
		if((RgValidate.validate(monitor.getRg())) != null ){
			valid = false;
			txtRg.setStyle("-fx-border-color: red;");
			rgError.setVisible(true);
			//pessoalPane.add(new ImageView("file:///lib/media/Error.png"), 2, 0);	
		}
		/**
		 * DATE
		 */
		if((DateValidate.validate((monitor.getBirth_dt()))) != null){
			valid = false;
			txtBirth_dt.setStyle("-fx-border-color: red;");
			dateError.setVisible(true);
			//pessoalPane.add(new ImageView("file:///lib/media/Error.png"), 2, 0);	
		}
		/**
		 * EMAIL
		 */
		if((EmailValidate.validate((monitor.getEmail()))) != null){
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
		if((GradeValidate.validate((monitor.getGrade()))) != null){
			valid = false;
			txtGrade.setStyle("-fx-border-color: red;");
			gradeError.setVisible(true);
			//pessoalPane.add(new ImageView("file:///lib/media/Error.png"), 2, 0);	
		}
		
		
		/**
		 * NUMBER
		 */
		if( (NumberValidate.validate((monitor.getBankAccount().getAccountNumber() ))) != null){
			valid = false;
			txtNumberAccount.setStyle("-fx-border-color: red;");
			numberError.setVisible(true);
			//pessoalPane.add(new ImageView("file:///lib/media/Error.png"), 2, 0);	
		}
		
		/**
		 * NUMBER
		 */
		if( (NumberValidate.validate((monitor.getBankAccount().getAccountNumber() ))) != null){
			valid = false;
			txtNumberAccount.setStyle("-fx-border-color: red;");
			numberError.setVisible(true);
		}
		
		return valid;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbSex.setItems(optionsCBSEX);
		
		
	}

}
