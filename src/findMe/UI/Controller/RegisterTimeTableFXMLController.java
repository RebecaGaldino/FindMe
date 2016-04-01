package findMe.UI.Controller;

import java.io.IOException;
import java.net.URL;
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
	private TextField txtBegin_time;
	@FXML
	private TextField txtEnd_time;
	@FXML
	private ComboBox cbDay;
	@FXML
	private Button btCancel;
	@FXML
	private Button btRegister;
	
	
	/*--------------------------------------------------------------------------------------------*/
	private TimeTable timeTable = TimeTableMonitorFXMLController.timeTableView;
	private MonitorActions mact = new MonitorActions();
	private MonitorDAO mdao = new MonitorDAO();
	private Monitor monitor = mdao.getMonitorById(timeTable.getMonitor().getId());
	Methods method = new Methods();
	ObservableList<String> optionsCBDAY = 
		    FXCollections.observableArrayList("Segunda","Ter�a","Quarta","Quinta","Sexta");
	/*--------------------------------------------------------------------------------------------*/
	
	public void btCancel() throws IOException{
		
		method.setAndShowOnPrimaryStage("/findMe/UI/FXML/TimeTableMonitor.fxml", "Monitor Manager");
		
	}
	
	
	public void btRegister(){
		
		TimeTable t = new TimeTable();
		t.setMonitor(monitor);
		t.setDayName(cbDay.getSelectionModel().getSelectedItem().toString());
		//t.setBegin_time(txtBegin_time);
		//t.setEnd_time(txtEnd_time);
		
		mact.insertTimeTable(t);
		
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbDay.setItems(optionsCBDAY);
	}

}
