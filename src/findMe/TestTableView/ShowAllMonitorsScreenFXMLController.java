package findMe.TestTableView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import findMe.dataBase.MonitorDAO;
import findMe.domain.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Tela que exibe todos os monitores e suas matrículas
 * @author ViniFarias
 *
 */
public class ShowAllMonitorsScreenFXMLController implements Initializable{
	
	@FXML
	private TableView<Person> tvTableView;
	@FXML
	private TableColumn<Person, String> tcId;
	@FXML
	private TableColumn<Person, String> tcName;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		MonitorDAO m = new MonitorDAO();
		ObservableList<Person> list = FXCollections.observableArrayList(m.getMonitorsAndIds());
		
		tcName.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        tcId.setCellValueFactory(new PropertyValueFactory<Person, String>("id"));
        
		tvTableView.setItems(list);
		
	}

	

}
