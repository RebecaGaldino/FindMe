package findMe.UI.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class RegisterTimeTableFXMLController implements Initializable{

	@FXML
	private TextField txtBegin_time;
	@FXML
	private TextField txtEnd_time;
	@FXML
	private ComboBox cbDay;
	@FXML
	private Button btCancel;
	@FXML
	private Button btRegister;

	
	ObservableList<String> optionsCBDAY = 
		    FXCollections.observableArrayList("Segunda","Terça","Quarta","Quinta","Sexta");
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbDay.setItems(optionsCBDAY);
	}

}
