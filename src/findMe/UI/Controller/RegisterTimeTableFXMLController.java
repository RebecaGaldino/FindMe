package findMe.UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

import findMe.dataBase.MonitorDAO;
import findMe.domain.Monitor;
import findMe.domain.TimeTable;
import findMe.extraMethods.Methods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import findMe.actions.*;

public class RegisterTimeTableFXMLController implements Initializable{
	
	@FXML
	private Button btCancel;
	@FXML
	private Button btRegister;
	@FXML
	private TextField txtBegin_time;
	@FXML
	private TextField txtEnd_time;
	@FXML
	private ComboBox cbDay;
	
	ObservableList<String> optionsCBDAY = 
		    FXCollections.observableArrayList("Segunda","Terça","Quarta","Quinta","Sexta");
	
	Methods method = new Methods();
	private MonitorActions mact = new MonitorActions();
	private String userId = TimeTableMonitorFXMLController.useridEx;
	
	
	public void btCancel() throws IOException{
		
		method.setAndShowOnPrimaryStage("/findMe/UI/FXML/TimeTableMonitor.fxml", "Monitor Manager");
	}
	
	
	public void btRegister() throws ParseException{
		MonitorDAO mdao = new MonitorDAO();
		Monitor m = mdao.getMonitorById(userId);
		
		TimeTable t = new TimeTable();
		t.setMonitor(m);
		System.out.println(method.convertHourToSqlString(txtBegin_time.getText()).toString());
		System.out.println(method.convertHourToSqlString(txtEnd_time.getText()).toString());
		t.setBegin_time(method.convertHourToSqlString(txtBegin_time.getText()));
		t.setEnd_time(method.convertHourToSqlString(txtEnd_time.getText()));
		System.out.println(cbDay.getSelectionModel().getSelectedItem().toString());
		t.setDayName(cbDay.getSelectionModel().getSelectedItem().toString());
		mact.insertTimeTable(t);
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbDay.setItems(optionsCBDAY);
		
	}
}
