package findMe.UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import findMe.actions.MonitorActions;
import findMe.dataBase.MonitorDAO;
import findMe.dataBase.SchoolSubjectDAO;
import findMe.dataBase.SupervisorDAO;
import findMe.domain.BankAccount;
import findMe.domain.Monitor;
import findMe.domain.SchoolSubject;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MonitorEditScreenFXMLController implements Initializable{
	
	
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
	private TextField txtIdBankAccount;
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
	private Button btConfirm;
	@FXML
	private Button btCancel;
	@FXML
	private TextField txtRg;
	@FXML
	private TextField txtEmail;
	@FXML
	private ComboBox cbSex;
	
	private Methods method = new Methods();
	public static String UserId = MonitorScreenFXMLController.UserId;
	
	MonitorDAO mdao = new MonitorDAO();
	SchoolSubjectDAO ssdao = new SchoolSubjectDAO();
	SupervisorDAO sdao = new SupervisorDAO();
	MonitorActions mact = new MonitorActions();
	
	
	@FXML
	public void btConfirm(){
	
		//validar edi��es
		Monitor m = new Monitor();
		BankAccount ba = new BankAccount();
		
		m.setId(txtId.getText());
		m.setGrade(txtGrade.getText());
		m.setName(txtName.getText());
		m.setCpf(txtCpf.getText());
		m.setBirth_dt(txtBirth_dt.getText());
		m.setRg(txtRg.getText());
		m.setEmail(txtEmail.getText());
		m.setCourse(cBxCourse.getSelectionModel().getSelectedItem().toString());
		m.setSex(cbSex.getSelectionModel().getSelectedItem().toString());
		
		m.setPassword(txtPassword.getText());
		
		m.setSupervisor(sdao.getSupervisorByName(txtSupervisor.getText()));
		
		m.setSubject(ssdao.getSchoolSubjectByName(txtSchoolSubject.getText()));
		
		m.setRoomWork(txtRoomWork.getText());
		
		ba.setId(txtIdBankAccount.getText());
		ba.setAccountNumber(txtNumberAccount.getText());
		ba.setAgency(txtAgency.getText());
		ba.setNotes(txtAreaNotes.getText());
		ba.setTypeAccount(txtTypeAccount.getText());
		m.setBankAccount(ba);
		
		mact.updateMonitor(m);
	}
	
	
	@FXML
	public void btCancel() throws IOException{
		method.setAndShowOnPrimaryStage("/findMe/UI/FXML/MonitorScreen.fxml", "Monitor Manager");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		cBxCourse.setItems(optionsCBCOURSE);
		cbSex.setItems(optionsCBSEX);
		Monitor monitor = new Monitor();
		monitor = mdao.getMonitorById(UserId);
		
		txtId.setText(monitor.getId());
		txtGrade.setText(monitor.getGrade());
		txtName.setText(monitor.getName());
		txtSupervisor.setText(monitor.getSupervisor().getName());
		txtSchoolSubject.setText(monitor.getSubject().getName());
		txtNumberAccount.setText(monitor.getBankAccount().getAccountNumber());
		txtRoomWork.setText(monitor.getRoomWork());
		txtCpf.setText(monitor.getCpf());
		cBxCourse.setValue(monitor.getCourse());
		txtPassword.setText(monitor.getPassword());
		txtConfirmPassword.setText(monitor.getPassword());
		txtAgency.setText(monitor.getBankAccount().getAgency());
		txtIdBankAccount.setText(monitor.getBankAccount().getId());
		txtTypeAccount.setText(monitor.getBankAccount().getTypeAccount());
		txtAreaNotes.setText(monitor.getBankAccount().getNotes());
		txtBirth_dt.setText(monitor.getBirth_dt());
		txtRg.setText(monitor.getRg());
		txtEmail.setText(monitor.getEmail());
		cbSex.setValue(monitor.getSex());
	}

}
