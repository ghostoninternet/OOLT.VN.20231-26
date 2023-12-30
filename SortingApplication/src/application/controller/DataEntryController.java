package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DataEntryController {

    @FXML
    private TextField numField;

    @FXML
    private TextField numberField;

    @FXML
    private Button btnSave;
   
    @FXML
    private void switchToDataSortingVisualization(ActionEvent event) {
        if (isValidInput()) {
            
        	 try {
                 Stage stage = (Stage) btnSave.getScene().getWindow();
                 Parent root = FXMLLoader.load(getClass().getResource("/application/view/DataSortingVisualization.fxml"));
                 Scene scene = new Scene(root);
                 stage.setTitle("Data Sorting Visualization");
                 stage.setScene(scene);
             } catch (IOException e) {
                 e.printStackTrace();
             }
         
        } else {
        	 showAlert("Error", "Invalid Input", "The number of elements in the array is not correct.");
        }
    }

    // Kiểm tra dữ liệu nhập vào có hợp lệ hay không
    private boolean isValidInput() {
        return true;  // Nhập điều kiện
    }


private void showAlert(String title, String headerText, String contentText) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(headerText);
    alert.setContentText(contentText);
    alert.showAndWait();
}
}
