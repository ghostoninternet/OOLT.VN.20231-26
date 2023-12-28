package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TabPane;

public class Controller {

    @FXML
    private TextField numField;

    @FXML
    private TextField numberField;

    @FXML
    private Button btnSave;
    
    @FXML
    private TabPane tabPane;
    
    
    public void switchToScreen2() {
       
        tabPane.getSelectionModel().select(1);
    }
    
    public void mergeSortAction() {
       
        tabPane.getSelectionModel().select(2);
    }
    
    public void bubbleSortAction() {
        
        tabPane.getSelectionModel().select(2);
    }
    
    public void radixSortAction() {
        
        tabPane.getSelectionModel().select(2);
    }
    

    
}
