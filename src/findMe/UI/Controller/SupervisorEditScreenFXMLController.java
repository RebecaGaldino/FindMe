package findMe.UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import findMe.dataBase.SupervisorDAO;
import findMe.domain.Supervisor;
import findMe.extraMethods.Methods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Labeled;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SupervisorEditScreenFXMLController implements Initializable{
	
	
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
	private Button btConfirm;
	@FXML
	private Button btCancel;
	@FXML
	private TextField txtRg;
	@FXML
	private TextField txtEmail;
	@FXML
	private ComboBox cbSex;
	
	ObservableList<String> optionsCBSEX = FXCollections.observableArrayList("Masculino","Feminino");
	private Methods method = new Methods();
	public static String UserId = SupervisorScreenFXMLController.UserId;
	
	SupervisorDAO s = new SupervisorDAO();
	
	
	@FXML
	public void btConfirm(){
	
		Supervisor sp = new Supervisor();
		
		sp.setId(txtId.getText());
		sp.setName(txtName.getText());
		//txtSchoolSubject.setText(supervisor);
		sp.setCpf(txtCpf.getText());
		sp.setBirth_dt(txtBirth_dt.getText());
		sp.setRg(txtRg.getText());
		sp.setEmail(txtEmail.getText());
		sp.setSex(cbSex.getSelectionModel().getSelectedItem().toString());
		
		s.updateSupervisor(sp);
		
	}
	
	
	@FXML
	public void btCancel() throws IOException{
		method.setAndShowOnPrimaryStage("/findMe/UI/FXML/SupervisorScreen.fxml", "Monitor Manager");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		cbSex.setItems(optionsCBSEX);
		Supervisor supervisor = new Supervisor();
		supervisor = s.getSupervisorById(UserId);
		
		txtId.setText(supervisor.getId());
		txtName.setText(supervisor.getName());
		//txtSchoolSubject.setText(supervisor);
		txtCpf.setText(supervisor.getCpf());
		txtBirth_dt.setText(supervisor.getBirth_dt());
		txtRg.setText(supervisor.getRg());
		txtEmail.setText(supervisor.getEmail());
		cbSex.setValue(supervisor.getSex());
	}

}
