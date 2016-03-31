package findMe.UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import findMe.domain.SchoolSubject;
import findMe.extraMethods.Methods;
import javafx.scene.control.TextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class RegisterSubjectFXMLController implements Initializable {

	@FXML
	private Button btRegister;
	@FXML
	private Button btCancel;
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtId;
	
	@FXML
	public void btRegister(){
		SchoolSubject subject = new SchoolSubject();
		subject.setName(txtName.getText());
		subject.setId(txtId.getText());
	}
	
	public void btCancel(){
		try {
			Methods method = new Methods();
			method.setAndShowOnPrimaryStage("/findMe/UI/FXML/InitialScreen.fxml", "Monitor Manager");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
}
