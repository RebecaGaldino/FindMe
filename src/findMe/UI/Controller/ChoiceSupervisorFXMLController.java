package findMe.UI.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import findMe.dataBase.SupervisorDAO;
import findMe.domain.Supervisor;
import findMe.extraMethods.Methods;
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
import javafx.stage.Stage;

public class ChoiceSupervisorFXMLController implements Initializable {
	
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
	private Button btConfirm;
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtId;
	
	/*--------------------------------*/
	private int posSupervisor;
	ObservableList<Supervisor> list = FXCollections.observableArrayList();
	public static Supervisor supervisorView = null;
	public Methods methodsChoice = new Methods();
	/*--------------------------------*/
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		SupervisorDAO s = new SupervisorDAO();
		list = FXCollections.observableArrayList(s.getAllInfoAllSupervisors());
		
		tcName.setCellValueFactory(new PropertyValueFactory<Supervisor, String>("name"));
        tcId.setCellValueFactory(new PropertyValueFactory<Supervisor, String>("id"));
        
        ObservableList<Supervisor> tableSupervisorSel = tvTableView.getSelectionModel().getSelectedItems();
        tableSupervisorSel.addListener(selectorTableSupervisor);
		
        
        initFilter();
        putPersonSelected();
		
	}
	
	
	@FXML
	public void btConfirm(){

		RegisterMonitorFXMLController.supervisor.setId(getTableSupervisorSelected().getId()) ;
		RegisterMonitorFXMLController.method.getStage().close();
	}
	
	@FXML
	public void btBack(){
		RegisterMonitorFXMLController.method.getStage().close();
	}
	
	
/*------------------------------EXIBI��O DOS DADOS-------------------------------------*/
	
	
	/**
	 * Listener da Tabela tvTableView
	 * @author RicardoMoya - https://github.com/jarroba/Tablas-JavaFX--FXML-
	 */
	private final ListChangeListener<Supervisor> selectorTableSupervisor =
            new ListChangeListener<Supervisor>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Supervisor> c) {
                    putPersonSelected();
                }
	};
	
	
	
	/**
     * Metodo que retorna o monitor selecionado
     * @author RicardoMoya - https://github.com/jarroba/Tablas-JavaFX--FXML-
     */
    public Supervisor getTableSupervisorSelected() {
        if (tvTableView != null) {
            List<Supervisor> table = tvTableView.getSelectionModel().getSelectedItems();
            if (table.size() == 1) {
                final Supervisor supervisorSelected = table.get(0);
                supervisorView = supervisorSelected;
                return supervisorSelected;
            }
        }
        supervisorView = null;
        return null;
    }
    
    
    

    /**
     * Metodo que coloca as informa��es selecionadas nos textFields
     * @author RicardoMoya - https://github.com/jarroba/Tablas-JavaFX--FXML-
     */
    private void putPersonSelected() {
        final Supervisor supervisor = getTableSupervisorSelected();
        posSupervisor = list.indexOf(supervisor);

        if (supervisor != null) {

            // Pongo los textFields con los datos correspondientes
            txtName.setText(supervisor.getName());
            txtId.setText(supervisor.getId());
            //txtSchoolSubject.setText(supervisor.getSubject().getName());

        }
        else {
        	txtName.setText("");
            txtId.setText("");
        }
    }
    
    /*-----------------FILTRAGEM DOS DADOS------------------------------------------*/
    /**
     * Metodo que faz a filtragem dos dados
     */
    @FXML
	private void initFilter(){
		/**
         * @author Marco Jakob
         */
		FilteredList<Supervisor> filteredData = new FilteredList<>(list, p -> true);
				
		txtFilter.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(supervisor -> {
		
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
							
				String lowerCaseFilter = newValue.toLowerCase();
							
				if (supervisor.getId().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				} else if (supervisor.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				return false;
				});
			});
					
		SortedList<Supervisor> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(tvTableView.comparatorProperty());
				
		tvTableView.setItems(sortedData);
	}
    
}
