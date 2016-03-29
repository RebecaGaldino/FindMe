package findMe.TestTableView;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import findMe.dataBase.MonitorDAO;
import findMe.domain.Person;
import findMe.domain.TimeTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TimeTableFXMLController implements Initializable{

	@FXML
	private TableColumn<TimeTable, Date> tcTime;
	@FXML
	private TableColumn tcSegunda;
	@FXML
	private TableColumn tcTerca;
	@FXML
	private TableColumn tcQuarta;
	@FXML
	private TableColumn tcQuinta;
	@FXML
	private TableColumn tcSexta;
	@FXML
	private TableView<TimeTable> tbTimeTable;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		MonitorDAO m = new MonitorDAO();
		
		
		ObservableList<TimeTable> list = FXCollections.observableArrayList(m.getMonitorsTimes("20151004018"));
		
		for(TimeTable tb : m.getMonitorsTimes("20151004018")){
			
			if(tb.getDayName() == "Segunda") tcSegunda.
			else if (tb.getDayName() == "Terça") tcTerca.setUserData("X");
			else if (tb.getDayName() == "Quarta") tcQuarta.setUserData("X");
			else if (tb.getDayName() == "Quinta") tcQuinta.setUserData("X");
			else tcSexta.setUserData("X");
			
		}
		
        tcTime.setCellValueFactory(new PropertyValueFactory<TimeTable, Date>("begin_time"));
        
		tbTimeTable.setItems(list);
		
	}

}
