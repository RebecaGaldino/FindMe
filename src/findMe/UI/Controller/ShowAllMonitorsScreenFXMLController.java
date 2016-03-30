package findMe.UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.TextFields;

import findMe.dataBase.MonitorDAO;
import findMe.domain.Monitor;
import findMe.domain.Person;
import findMe.domain.SchoolSubject;
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
public class ShowAllMonitorsScreenFXMLController implements Initializable{
	
	@FXML
	private TableView<Monitor> tvTableView;
	@FXML
	private TableColumn<Monitor, String> tcId;
	@FXML
	private TableColumn<Monitor, String> tcName;
	@FXML
	private TextField txtFilter;
	@FXML
	private Button btBack;
	@FXML
	private Button btShow;
	@FXML
	private Button btDelete;
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtId;
	@FXML
	private TextField txtSchoolSubject;
	
	/*-------------------------*/
	private int posMonitor;
	public static Monitor monitorView = null;
	ObservableList<Monitor> list = FXCollections.observableArrayList();
	private Methods method = new Methods();
	/*-------------------------*/
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		MonitorDAO m = new MonitorDAO();
		list = FXCollections.observableArrayList(m.getAllInfoMonitors());
		
		tcName.setCellValueFactory(new PropertyValueFactory<Monitor, String>("name"));
        tcId.setCellValueFactory(new PropertyValueFactory<Monitor, String>("id"));
        
        ObservableList<Monitor> tableMonitorSel = tvTableView.getSelectionModel().getSelectedItems();
        tableMonitorSel.addListener(selectorTableMonitor);
		
        
        initFilter();
        putPersonSelected();
		
	}
	
	@FXML
	public void btBack() throws IOException{
		
		method.setAndShowOnPrimaryStage("/findMe/UI/FXML/ManagerScreen.fxml", "Monitor Manager");
		
	}
	
	
	@FXML
	public void btDelete() throws IOException{
		
		
		
	}
	
	
	@FXML
	public void btShow() throws IOException{
		
		if(monitorView != null){
			
			method.setAndShowOnPrimaryStage("/findMe/UI/FXML/MonitorView.fxml", "Monitor Manager");
			
		}
		
	}
	
	
	/*-----------------------------------------------------------------------------------------------*/
	
	
	/**
	 * Listener da Tabela tvTableView
	 * @author RicardoMoya - https://github.com/jarroba/Tablas-JavaFX--FXML-
	 */
	private final ListChangeListener<Monitor> selectorTableMonitor =
            new ListChangeListener<Monitor>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Monitor> c) {
                    putPersonSelected();
                }
	};
	
	
	
	/**
     * Método que retorna o monitor selecionado
     * @author RicardoMoya - https://github.com/jarroba/Tablas-JavaFX--FXML-
     */
    public Monitor getTableMonitorSelected() {
        if (tvTableView != null) {
            List<Monitor> table = tvTableView.getSelectionModel().getSelectedItems();
            if (table.size() == 1) {
                final Monitor monitorSelected = table.get(0);
                monitorView = monitorSelected;
                return monitorSelected;
            }
        }
        monitorView = null;
        return null;
    }
    
    
    

    /**
     * Método que coloca as informações selecionadas nos textFields
     * @author RicardoMoya - https://github.com/jarroba/Tablas-JavaFX--FXML-
     */
    private void putPersonSelected() {
        final Monitor monitor = getTableMonitorSelected();
        posMonitor = list.indexOf(monitor);

        if (monitor != null) {

            // Pongo los textFields con los datos correspondientes
            txtName.setText(monitor.getName());
            txtId.setText(monitor.getId());
            txtSchoolSubject.setText(monitor.getSubject().getName());

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
