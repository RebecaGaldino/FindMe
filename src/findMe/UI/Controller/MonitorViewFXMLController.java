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
public class MonitorViewFXMLController implements Initializable{
	
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
	private TextField txtCourse;
	@FXML
	private TextField txtAgency;
	@FXML
	private TextField txtTypeAccount;
	@FXML
	private TextArea txtAreaNotes;
	@FXML
	private TextField txtBirth_dt;
	@FXML
	private Button btBack;
	@FXML
	private TextField txtRg;
	@FXML
	private TextField txtEmail;
	@FXML
	private TextField txtSex;
	@FXML
	private GridPane pessoalPane;
	
	private Monitor monitor= ShowAllMonitorsScreenFXMLController.monitorView;
	private Methods method = new Methods();
	
	
	public void btBack() throws IOException{
		method.setAndShowOnPrimaryStage("/findMe/UI/FXML/ShowAllMonitorsScreen.fxml", "Monitor Manager");
		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		txtId.setText(monitor.getId());
		txtGrade.setText(monitor.getGrade());
		txtName.setText(monitor.getName());
		txtSupervisor.setText(monitor.getSupervisor().getName());
		txtSchoolSubject.setText(monitor.getSubject().getName());
		txtNumberAccount.setText(monitor.getBankAccount().getAccountNumber());
		txtRoomWork.setText(monitor.getRoomWork());
		txtCpf.setText(monitor.getCpf());
		txtCourse.setText(monitor.getCourse());
		txtAgency.setText(monitor.getBankAccount().getAgency());
		txtTypeAccount.setText(monitor.getBankAccount().getTypeAccount());
		txtAreaNotes.setText(monitor.getBankAccount().getNotes());
		txtBirth_dt.setText(monitor.getBirth_dt());
		txtRg.setText(monitor.getRg());
		txtEmail.setText(monitor.getEmail());
		txtSex.setText(monitor.getSex());
	}

}
