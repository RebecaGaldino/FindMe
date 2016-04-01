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

public class EditTimeTableFXMLController implements Initializable{

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
	//public static String userid = TimeTableMonitorFXMLController.userid;
	private Monitor monitor = mdao.getMonitorById(timeTable.getMonitor().getId());
	Methods method = new Methods();
	ObservableList<String> optionsCBDAY = 
		    FXCollections.observableArrayList("Segunda","Terça","Quarta","Quinta","Sexta");
	/*--------------------------------------------------------------------------------------------*/
	
	public void btCancel() throws IOException{
		
		method.setAndShowOnPrimaryStage("/findMe/UI/FXML/TimeTableMonitor.fxml", "Monitor Manager");
		
	}
	
	
	public void btEdit() throws ParseException{
		
		TimeTable t = new TimeTable();
		t.setId(timeTable.getId());
		t.setMonitor(monitor);
		t.setDayName(cbDay.getSelectionModel().getSelectedItem().toString());
		t.setBegin_time(method.convertStringHourToDate(txtBegin_time.getText()));
		t.setEnd_time(method.convertStringHourToDate(txtEnd_time.getText()));
		
		mact.updateTimeTable(t);
		
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbDay.setItems(optionsCBDAY);
	}

}
