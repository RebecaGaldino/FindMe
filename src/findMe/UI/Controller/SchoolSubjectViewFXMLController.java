package findMe.UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import findMe.actions.ManagerActions;
import findMe.customExceptions.CustomException;
import findMe.dataBase.SchoolSubjectDAO;
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
public class SchoolSubjectViewFXMLController implements Initializable{
	
	@FXML
	private AnchorPane principal;
	@FXML
	private TextField txtIdMonitor;
	@FXML
	private TextField txtIdSchoolSubject;
	@FXML
	private TextField txtIdSupervisor;
	@FXML
	public TextField txtNameSchoolSubject;
	@FXML
	public TextField txtNameSupervisor;
	@FXML
	public TextField txtNameMonitor;
	@FXML
	private TextField txtRoomWork;
	@FXML
	private Button btBack;
	@FXML
	private TextField txtEmailSupervisor;
	@FXML
	private TextField txtEmailMonitor;
	@FXML
	private GridPane pessoalPane;
	
	private SchoolSubject schoolSubject = ShowAllSchoolSubjectScreenFXMLController.schoolSubjectView;
	private Methods method = new Methods();
	
	
	public void btBack() throws IOException{
		method.setAndShowOnPrimaryStage("/findMe/UI/FXML/ShowAllSchoolSubjectScreen.fxml", "Monitor Manager");
		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		SchoolSubjectDAO ssdao = new SchoolSubjectDAO();
		Monitor m = ssdao.getAllInfoSubject(schoolSubject.getId());
		
		txtIdMonitor.setText(m.getId());
		txtIdSchoolSubject.setText(m.getSubject().getId());
		txtIdSupervisor.setText(m.getSupervisor().getId());
		txtNameSchoolSubject.setText(m.getSubject().getName());
		txtNameSupervisor.setText(m.getSupervisor().getName());
		txtNameMonitor.setText(m.getName());
		txtRoomWork.setText(m.getRoomWork());
		txtEmailSupervisor.setText(m.getSupervisor().getEmail());
		txtEmailMonitor.setText(m.getEmail());
		
	}

}