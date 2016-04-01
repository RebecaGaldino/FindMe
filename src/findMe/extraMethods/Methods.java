package findMe.extraMethods;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import findMe.UI.Controller.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Methods {
	private Stage stage;
	public Methods() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * M�todo que insere o caminho do arquivo fxml no parent, em seguida cria uma scene a partir disso e insere-a no stage
	 * em seguida mostra o stage na tela
	 * @param stage
	 * @param path
	 * @throws IOException
	 * @author ViniFarias
	 */
	public void setAndShowOnStage(Stage stage, String path, String title) throws IOException{
		this.stage = stage;
		Parent root = FXMLLoader.load(getClass().getResource(path));
		Scene scene = new Scene(root);
		stage.setTitle(title);
		stage.setScene(scene);
		stage.show(); 
	}
	
	
	/**
	 * M�todo que insere o caminho do arquivo fxml no parent, em seguida cria uma scene a partir disso e insere-a no PrimaryStage
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
	
	/**
	 * Convert a string (dd/mm/yyyy) to sql string (yyyy-mm-dd)
	 * @param input
	 * @return
	 * @throws ParseException
	 * @author ViniFarias
	 */
	public static String convertStringToSqlString(String input) throws ParseException{
		SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {

		    String reformattedStr = myFormat.format(fromUser.parse(input));
		    return reformattedStr;
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		return null;

	}
	
	public void setStage(Stage stage){
		this.stage = stage;
	}
	
	public Stage getStage(){
		return(stage);
	}
}
