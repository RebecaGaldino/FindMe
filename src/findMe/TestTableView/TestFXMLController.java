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

public class TestFXMLController implements Initializable{
	
	@FXML
	private TableView<PersonTest> tvTableView;
	@FXML
	private TableColumn<PersonTest, String> tcId;
	@FXML
	private TableColumn<PersonTest, String> tcName;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		MonitorDAO m = new MonitorDAO();
		ObservableList<PersonTest> list = FXCollections.observableArrayList();
		
		for(Person p : m.getMonitorsAndIds()){
			list.add(new PersonTest(p.getId(), p.getName()));
			
			tcName.setCellValueFactory(new PropertyValueFactory("name"));
	        tcId.setCellValueFactory(new PropertyValueFactory("id"));
		}
		
		 tvTableView.setItems(list);
		
		
		/*for(PersonTest p : list){
			
			tcName.setCellValueFactory(new PropertyValueFactory("name"));
	        tcId.setCellValueFactory(new PropertyValueFactory("id"));
		}
		
		tcName.setCellValueFactory(new PropertyValueFactory<PersonTest, String>("name"));
        tcId.setCellValueFactory(new PropertyValueFactory<PersonTest, String>("id"));
		
		tvTableView.setItems(list);
		//tvTableView.getColumns().addAll(tcName, tcId);*/
	}

	

}
