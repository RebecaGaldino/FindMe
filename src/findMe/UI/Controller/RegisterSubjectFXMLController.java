package findMe.UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import findMe.actions.ManagerActions;
import findMe.dataBase.SupervisorDAO;
import findMe.domain.SchoolSubject;
import findMe.domain.Supervisor;
import findMe.extraMethods.Methods;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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

public class RegisterSubjectFXMLController implements Initializable {

	@FXML
	private Button btRegister;
	@FXML
	private Button btCancel;
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtId;
	
	
	private Methods method = new Methods();
	

	@FXML
	public void btRegister(){
		
		try {
			SchoolSubject subject = new SchoolSubject();
			subject.setName(txtName.getText());
			subject.setId(txtId.getText());
			ManagerActions mac = new ManagerActions();
			mac.registerSubject(subject);
			method.setAndShowOnPrimaryStage("/findMe/UI/FXML/ManagerScreen.fxml", "Monitor Manager");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public void btCancel(){
		try {
			method.setAndShowOnPrimaryStage("/findMe/UI/FXML/ManagerScreen.fxml", "Monitor Manager");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
	}
	

   
    
  
	
}