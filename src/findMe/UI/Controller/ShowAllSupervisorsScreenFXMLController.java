package findMe.UI.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.TextFields;

import findMe.dataBase.MonitorDAO;
import findMe.dataBase.SupervisorDAO;
import findMe.domain.Monitor;
import findMe.domain.Person;
import findMe.domain.SchoolSubject;
import findMe.domain.Supervisor;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class ShowAllSupervisorsScreenFXMLController implements Initializable{
	
	@FXML
	private TableView<Supervisor> tvTableView;
	@FXML
	private TableColumn<Supervisor, String> tcId;
	@FXML
	private TableColumn<Supervisor, String> tcName;
	@FXML
	private TextField txtFilter;
	@FXML
	private Button btBack;
	@FXML
	private Button btShow;
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtId;
	@FXML
	private TextField txtSchoolSubject;
	
	private int posMonitor;
	
	ObservableList<Supervisor> list = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		SupervisorDAO s = new SupervisorDAO();
		list = FXCollections.observableArrayList(s.getAllInfoSupervisors());
		
		tcName.setCellValueFactory(new PropertyValueFactory<Supervisor, String>("name"));
        tcId.setCellValueFactory(new PropertyValueFactory<Supervisor, String>("id"));
        
        ObservableList<Supervisor> tableMonitorSel = tvTableView.getSelectionModel().getSelectedItems();
        tableMonitorSel.addListener(selectorTableMonitor);
		
        
        initFilter();
        putPersonSelected();
		
	}
	
	@FXML
	public void btBack(){
		
		
	}
	
	@FXML
	public void btShow(){
		
		
	}
	
	/*-----------------------------------------------------------------------------------------------*/
	
	
	/**
	 * Listener da Tabela tvTableView
	 * @author RicardoMoya - https://github.com/jarroba/Tablas-JavaFX--FXML-
	 */
	private final ListChangeListener<Supervisor> selectorTableMonitor =
            new ListChangeListener<Supervisor>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Supervisor> c) {
                    putPersonSelected();
                }
	};
	
	
	
	/**
     * Método que retorna o monitor selecionado
     * @author RicardoMoya - https://github.com/jarroba/Tablas-JavaFX--FXML-
     */
    public Monitor getTableMonitorSelected() {
        if (tvTableView != null) {
            List<Supervisor> table = tvTableView.getSelectionModel().getSelectedItems();
            if (table.size() == 1) {
                final Supervisor monitorSelected = table.get(0);
                return monitorSelected;
            }
        }
        return null;
    }
    
    
    

    /**
     * Método que coloca as informações selecionadas nos textFields
     * @author RicardoMoya - https://github.com/jarroba/Tablas-JavaFX--FXML-
     */
    private void putPersonSelected() {
        final Supervisor supervisor = getTableMonitorSelected();
        posMonitor = list.indexOf(supervisor);

        if (supervisor != null) {

            // Pongo los textFields con los datos correspondientes
            txtName.setText(supervisor.getName());
            txtId.setText(supervisor.getId());
            txtSchoolSubject.setText(supervisor.getSubject().getName());

        }
    }
    
    
    /**
     * Método que faz a filtragem dos dados
     */
    @FXML
	private void initFilter(){
		/**
         * @author Marco Jakob
         */
		FilteredList<Monitor> filteredData = new FilteredList<>(list, p -> true);
				
		txtFilter.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(monitor -> {
		
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
							
				String lowerCaseFilter = newValue.toLowerCase();
							
				if (monitor.getId().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				} else if (monitor.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				return false;
				});
			});
					
		SortedList<Monitor> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(tvTableView.comparatorProperty());
				
		tvTableView.setItems(sortedData);
	}
    
}
