package DialogBox;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertBox {
	public static void error(String title, String message){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erro");
		alert.setHeaderText(title);
		alert.setContentText(message);
	
		alert.showAndWait();
	}
}
