package findMe.UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.TextFields;

import findMe.actions.ManagerActions;
import findMe.dataBase.MonitorDAO;
import findMe.dataBase.SchoolSubjectDAO;
import findMe.dataBase.SupervisorDAO;
import findMe.domain.Monitor;
import findMe.domain.Person;
import findMe.domain.SchoolSubject;
import findMe.domain.Supervisor;
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
	private  Button btDelete;
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtId;
	
	private int posSchoolSubject;
	
	ObservableList<SchoolSubject> list = FXCollections.observableArrayList();
	Methods method = new Methods();
	public static SchoolSubject schoolSubjectView = new SchoolSubject();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		SchoolSubjectDAO s = new SchoolSubjectDAO();
		list = FXCollections.observableArrayList(s.getInfoAllSubject());
		
		tcName.setCellValueFactory(new PropertyValueFactory<SchoolSubject, String>("name"));
        tcId.setCellValueFactory(new PropertyValueFactory<SchoolSubject, String>("id"));
        
        ObservableList<SchoolSubject> tableSchoolSubjectSel = tvTableView.getSelectionModel().getSelectedItems();
        tableSchoolSubjectSel.addListener(selectorTableSchoolSubject);
		
        
        initFilter();
        putSchoolSubjectSelected();
		
	}
	
	@FXML
	public void btBack() throws IOException{
		
		method.setAndShowOnPrimaryStage("/findMe/UI/FXML/ManagerScreen.fxml", "Manager Screen");
		
	}
	
	@FXML
	public void btShow() throws IOException{
		
		if(schoolSubjectView != null){
			
			method.setAndShowOnPrimaryStage("/findMe/UI/FXML/SchoolSubjectView.fxml", "Monitor Manager");
		}
	}
	
	@FXML
	public void btDelete(){
		if(schoolSubjectView != null){
			ManagerActions mact = new ManagerActions();
			mact.deleteSchoolSubject(schoolSubjectView);
			SchoolSubjectDAO s = new SchoolSubjectDAO();
			list = FXCollections.observableArrayList(s.getInfoAllSubject());
			schoolSubjectView = null;
			initFilter();
			putSchoolSubjectSelected();
		}
	}
	
	/*-----------------------------------------------------------------------------------------------*/
	
	
	/**
	 * Listener da Tabela tvTableView
	 * @author RicardoMoya - https://github.com/jarroba/Tablas-JavaFX--FXML-
	 */
	private final ListChangeListener<SchoolSubject> selectorTableSchoolSubject =
            new ListChangeListener<SchoolSubject>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends SchoolSubject> c) {
                    putSchoolSubjectSelected();
                }
	};
	
	
	
	/**
     * Método que retorna o monitor selecionado
     * @author RicardoMoya - https://github.com/jarroba/Tablas-JavaFX--FXML-
     */
    public SchoolSubject getTableSchoolSubjectSelected() {
        if (tvTableView != null) {
            List<SchoolSubject> table = tvTableView.getSelectionModel().getSelectedItems();
            if (table.size() == 1) {
                final SchoolSubject SchoolSubjectSelected = table.get(0);
                schoolSubjectView = SchoolSubjectSelected;
                return SchoolSubjectSelected;
            }
        }
        schoolSubjectView = null;
        return null;
    }
    
    
    

    /**
     * Método que coloca as informações selecionadas nos textFields
     * @author RicardoMoya - https://github.com/jarroba/Tablas-JavaFX--FXML-
     */
    private void putSchoolSubjectSelected() {
        final SchoolSubject schoolSubject = getTableSchoolSubjectSelected();
        posSchoolSubject = list.indexOf(schoolSubject);

        if (schoolSubject != null) {

            // Pongo los textFields con los datos correspondientes
            txtName.setText(schoolSubject.getName());
            txtId.setText(schoolSubject.getId());

        }
        else{
        	txtName.setText("");
            txtId.setText("");
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
		FilteredList<SchoolSubject> filteredData = new FilteredList<>(list, p -> true);
				
		txtFilter.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(schoolSubject -> {
		
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
							
				String lowerCaseFilter = newValue.toLowerCase();
							
				if (schoolSubject.getId().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				} else if (schoolSubject.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				return false;
				});
			});
					
		SortedList<SchoolSubject> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(tvTableView.comparatorProperty());
				
		tvTableView.setItems(sortedData);
	}
    
}
