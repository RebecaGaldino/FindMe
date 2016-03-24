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
	 * Necessario criar um BotãoMenu onde o manager seleciona as disciplinas do supervisor
	 * Necessario validar as informações que são setadas na interface
	 */
	public void btRegister() throws IOException, ParseException, SQLException{
		try {
			
			
			ManagerActions mAct = new ManagerActions();
			
			
			Supervisor supervisor = new Supervisor();
			
			supervisor.setName(txtName.getText());
			supervisor.setId(txtId.getText());
			
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			supervisor.setBirth_dt((java.util.Date)formatter.parse(txtBirth_dt.getText()));
			
			supervisor.setCpf(txtCpf.getText());
			supervisor.setRg(txtRg.getText());
			supervisor.setEmail(txtEmail.getText());
			supervisor.setPassword(txtPassword.getText());
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void btCancel(){
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbSex.setItems(optionsCBSEX);
		
	}

}
