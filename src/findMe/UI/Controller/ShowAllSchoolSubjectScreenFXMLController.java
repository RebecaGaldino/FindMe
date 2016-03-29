package findMe.UI.Controller;

import java.io.IOException;
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
public class ShowAllSchoolSubjectScreenFXMLController implements Initializable{
	
	@FXML
	private TableView<SchoolSubject> tvTableView;
	@FXML
	private TableColumn<SchoolSubject, String> tcId;
	@FXML
	private TableColumn<SchoolSubject, String> tcName;
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
	
	private int posSubject;
	
	ObservableList<SchoolSubject> list = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		SupervisorDAO s = new SupervisorDAO();
		list = FXCollections.observableArrayList(s.getAllInfoSupervisors());
		
		tcName.setCellValueFactory(new PropertyValueFactory<Supervisor, String>("name"));
        tcId.setCellValueFactory(new PropertyValueFactory<Supervisor, String>("id"));
        
        ObservableList<Supervisor> tableSupervisorSel = tvTableView.getSelectionModel().getSelectedItems();
        tableSupervisorSel.addListener(selectorTableSupervisor);
		
        
        initFilter();
        putPersonSelected();
		
	}
	
	@FXML
	public void btBack() throws IOException{
		
		Parent root = FXMLLoader.load(getClass().getResource("/findMe/UI/FXML/ManagerScreen.fxml"));
		
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("Initial Screen");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
		
	}
	
	@FXML
	public void btShow(){
		
		
	}
	
	/*-----------------------------------------------------------------------------------------------*/
	
	
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
     * Método que retorna o monitor selecionado
     * @author RicardoMoya - https://github.com/jarroba/Tablas-JavaFX--FXML-
     */
    public Supervisor getTableSupervisorSelected() {
        if (tvTableView != null) {
            List<Supervisor> table = tvTableView.getSelectionModel().getSelectedItems();
            if (table.size() == 1) {
                final Supervisor supervisorSelected = table.get(0);
                return supervisorSelected;
            }
        }
        return null;
    }
    
    
    

    /**
     * Método que coloca as informações selecionadas nos textFields
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
    }
    
    
    /**
     * Método que faz a filtragem dos dados
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
