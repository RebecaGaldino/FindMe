package findMe.extraMethods;

import java.io.IOException;

import findMe.UI.Controller.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Methods {
	
	public Methods() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Método que insere o caminho do arquivo fxml no parent, em seguida cria uma scene a partir disso e insere-a no stage
	 * em seguida mostra o stage na tela
	 * @param stage
	 * @param path
	 * @throws IOException
	 * @author ViniFarias
	 */
	public void setAndShowOnStage(Stage stage, String path, String title) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource(path));
		
		Scene scene = new Scene(root);
		stage.setTitle(title);
		stage.setScene(scene);
		stage.show(); 
	}
	
	
	/**
	 * Método que insere o caminho do arquivo fxml no parent, em seguida cria uma scene a partir disso e insere-a no PrimaryStage
	 * em seguida mostra o stage na tela
	 * @param stage
	 * @param path
	 * @throws IOException
	 * @author ViniFarias
	 */
	public void setAndShowOnPrimaryStage(String path, String title) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource(path));
		
		Scene scene = new Scene(root);
		Main.primaryStage.setTitle(title);
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show(); 
	}

}
