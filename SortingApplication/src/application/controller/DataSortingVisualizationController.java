package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class DataSortingVisualizationController {

    @FXML
    private TextArea resultTextArea;
    
    @FXML
    private Button btnBack;

 @FXML
 private void switchToMainMenu(ActionEvent event) {
	 try {
         Stage stage = (Stage) btnBack.getScene().getWindow();
         Parent root = FXMLLoader.load(getClass().getResource("/application/view/MainMenu.fxml"));
         Scene scene = new Scene(root);
         stage.setTitle("Main Menu");
         stage.setScene(scene);
     } catch (IOException e) {
         e.printStackTrace();
     }
 }
}
