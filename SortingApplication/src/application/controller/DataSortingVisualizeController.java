package application.controller;

import java.io.IOException;

import application.algorithms.CountingSort;
import application.algorithms.MergeSort;
import application.algorithms.RadixSort;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DataSortingVisualizeController {

	private TextField valueField;
	private String typeOfAlgorithm;
	private int arrayOfNums[];
	private int lengthOfArray;
	
    @FXML
    private TextArea resultBeforeTextArea;

    @FXML
    private Button backToMainMenuBtn;

    @FXML
    private TextArea resultAfterTextArea;

    @FXML
    private Button startSortAlgorithmBtn;

    public DataSortingVisualizeController (TextField valueField, String typeOfAlgorithm, int arrayOfNums[], int lengthOfArray) {
    	this.valueField = valueField;
    	this.typeOfAlgorithm = typeOfAlgorithm;
    	this.arrayOfNums = arrayOfNums;
    	this.lengthOfArray = lengthOfArray;
    }
    
    @FXML
    void backToMainMenu(ActionEvent event) {
    	try {
    		final String MENU_FXML_FILE_PATH = "/application/view/MainMenu.fxml";
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(MENU_FXML_FILE_PATH));
        	Parent root = fxmlLoader.load();
        	Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        	stage.setScene(new Scene(root));
        	stage.setTitle("Data Entry");
        	stage.show();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void startSortAlgorithm(ActionEvent event) {
    	if (typeOfAlgorithm.equals("Merge Sort")) {
    		MergeSort mergeSort = new MergeSort(arrayOfNums, lengthOfArray);
    		mergeSort.Sort();
    	} else if (typeOfAlgorithm.equals("Counting Sort")) {
    		CountingSort countingSort = new CountingSort(arrayOfNums, lengthOfArray);
    		countingSort.Sort();
    	} else if (typeOfAlgorithm.equals("Radix Sort")) {
    		RadixSort radixSort = new RadixSort(arrayOfNums, lengthOfArray);
    		radixSort.Sort();
    	}
    	String result = "";
    	for (int i = 0; i < lengthOfArray; i++) {
    		result += arrayOfNums[i] + " ";
    	}
    	resultAfterTextArea.setText(result);
    }

    @FXML
    void initialize() {
    	resultBeforeTextArea.setText(valueField.getText());
    }
}

