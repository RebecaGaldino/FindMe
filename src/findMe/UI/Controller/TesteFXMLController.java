package findMe.UI.Controller;

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

public class TesteFXMLController implements Initializable{
	
	@FXML
	private TableView tvTableView;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		MonitorDAO m = new MonitorDAO();
		TableColumn tcName = new TableColumn<>("Nome");
		TableColumn tcId = new TableColumn<>("ID");
		
		tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		tvTableView.setItems(FXCollections.observableArrayList(m.getMonitoresAndIds()));
		tvTableView.getColumns().addAll(tcName, tcId);
		
	}

	

}
