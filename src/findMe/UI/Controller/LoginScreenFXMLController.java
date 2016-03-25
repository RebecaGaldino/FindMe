package findMe.UI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Interpolatable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class LoginScreenFXMLController implements Initializable {
	
	@FXML
	private ImageView logoSupervisor;
	@FXML
	private ImageView logoManager;
	@FXML
	private ImageView logoMonitor;
	@FXML
	private Text textPerson;
	@FXML
	private Button btCancel;
	@FXML
	private Button btLogin;
	@FXML
	private TextField txtNameUser;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private ImageView logoUser;
	@FXML
	private String choice = InitialScreenFXMLController.choice;
	
	
	@FXML
	public void btLogin() throws IOException{
		
		if(choice.equals("Professor")){
			Parent root = FXMLLoader.load(getClass().getResource("/findMe/UI/FXML/InitialScreen.fxml"));
		}
		else if(choice.equals("Gerente")){
			Parent root = FXMLLoader.load(getClass().getResource("/findMe/UI/FXML/ManagersScreen.fxml"));
		}
		else if(choice.equals("Monitor")){
			Parent root = FXMLLoader.load(getClass().getResource("/findMe/UI/FXML/InitialScreen.fxml"));
		}
		
	}
	
	
	@FXML
	public void btCancel() throws IOException{
		
		Parent root = FXMLLoader.load(getClass().getResource("/findMe/UI/FXML/InitialScreen.fxml"));
		
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle("Initial Screen");
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
	}
	
	
	private void choice(){
		if(choice.equals("Professor")){
			logoSupervisor.setVisible(true);
		}
		else if(choice.equals("Gerente")){
			logoManager.setVisible(true);
		}
		else if(choice.equals("Monitor")){
			logoMonitor.setVisible(true);
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		textPerson.setText("Área do "+ choice);
		choice();		
		  
        
		
	}
}
