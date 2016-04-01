package findMe.UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.TextFields;

import findMe.actions.ManagerActions;
import findMe.dataBase.MonitorDAO;
import findMe.dataBase.SchoolSubjectDAO;
import findMe.dataBase.TimeTableDAO;
import findMe.domain.Monitor;
import findMe.domain.Person;
import findMe.domain.SchoolSubject;
import findMe.domain.TimeTable;
import findMe.extraMethods.Methods;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Tela que exibe todos os monitores e suas matrículas
 * @author ViniFarias
 *
 */
public class TimeTableMonitorFXMLController implements Initializable{
	
	@FXML
	private TableView<TimeTable> tvTableView;
	@FXML
	private TableColumn<TimeTable, String> tcDay;
	@FXML
	private TableColumn<TimeTable, Date> tcBegin_time;
	@FXML
	private TableColumn<TimeTable, Date> tcEnd_time;
	@FXML
	private TextField txtFilter;
	@FXML
	private Button btBack;
	@FXML
	private Button btDelete;
	@FXML
	private Button btRegister;
	
	
	/*-------------------------------------------*/
	private MonitorDAO mdao = new MonitorDAO();
	private String userid = MonitorScreenFXMLController.UserId;
	private Monitor monitor = mdao.getMonitorById(userid);
	ObservableList<TimeTable> list = FXCollections.observableArrayList();
	private Methods method = new Methods();
	/*-------------------------*/
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		MonitorDAO m = new MonitorDAO();
		list = FXCollections.observableArrayList(m.getMonitorsTimes(monitor.getId()));
		
		tcDay.setCellValueFactory(new PropertyValueFactory<TimeTable, String>("dayName"));
        tcBegin_time.setCellValueFactory(new PropertyValueFactory<TimeTable, Date>("begin_time"));
        tcEnd_time.setCellValueFactory(new PropertyValueFactory<TimeTable, Date>("end_time"));
        
        tvTableView.setItems(list);
        
		initFilter();
	}
	
	@FXML
	public void btBack() throws IOException{
		
		method.setAndShowOnPrimaryStage("/findMe/UI/FXML/MonitorScreen.fxml", "Monitor Manager");
		
	}
	
	
	@FXML
	public void btDelete(){
		
		if(getTimeTableSelected() != null){
			TimeTableDAO tdao = new TimeTableDAO();
			tdao.deleteTimeTable((getTimeTableSelected().getId()));
			MonitorDAO m = new MonitorDAO();
			list = FXCollections.observableArrayList(m.getMonitorsTimes(monitor.getId()));
			initFilter();
		}
		
	}
	
	
	@FXML
	public void btRegister(){
		
		
		
	}
	
	/*-----------------------------------------------------------------------------------------------*/

    
    /**
     * Método que faz a filtragem dos dados
     */
    @FXML
	private void initFilter(){
		/**
         * @author Marco Jakob
         */
		FilteredList<TimeTable> filteredData = new FilteredList<>(list, p -> true);
				
		txtFilter.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(timetable -> {
		
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
							
				String lowerCaseFilter = newValue.toLowerCase();
							
				if (timetable.getDayName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				return false;
				});
			});
					
		SortedList<TimeTable> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(tvTableView.comparatorProperty());
				
		tvTableView.setItems(sortedData);
	}
    
    
    
    public TimeTable getTimeTableSelected() {
        if (tvTableView != null) {
            List<TimeTable> table = tvTableView.getSelectionModel().getSelectedItems();
            if (table.size() == 1) {
                final TimeTable timeTableSelected = table.get(0);
                return timeTableSelected;
            }
        }
        return null;
    }
    
}
