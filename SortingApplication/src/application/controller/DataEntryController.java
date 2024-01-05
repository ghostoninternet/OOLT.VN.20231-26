package application.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

public class DataEntryController {
	
	private int arrayOfNums[];
	private String typeOfAlgorithm;
	private int lengthOfArray;
	
	@FXML
    private TextField lengthOfArrayField;
	
	@FXML
    private Button saveArrayLengthBtn;

    @FXML
    private TextField valueField;
    
    @FXML
    private Button saveValuesBtn;

    @FXML
    private Button startSortAlgoButton;

    @FXML
    private TextArea resultBeforeTextArea;

    @FXML
    private TextArea resultAfterTextArea;
    
    @FXML
    private Button btnBack;
    
    @FXML
    private Button createRandomArrayBtn;
        
    public DataEntryController(String typeOfAlgorithm) {
    	this.typeOfAlgorithm = typeOfAlgorithm;
    }

	@FXML
    void saveArrayLength(ActionEvent event) {
    	try {
    		lengthOfArray = Integer.parseInt(lengthOfArrayField.getText());
    		if (lengthOfArray <= 0) {
        		JOptionPane.showMessageDialog(null, "Please enter value greater than 0!", "Error", JOptionPane.ERROR_MESSAGE);
        	} else {
        		arrayOfNums = new int[lengthOfArray];
        		saveArrayLengthBtn.setDisable(true);
        		saveValuesBtn.setDisable(false);
        	}
    	} catch (NumberFormatException error) {
    		JOptionPane.showMessageDialog(null, "Please enter integer value only!", "Error", JOptionPane.ERROR_MESSAGE);
    	}
    }

    @FXML
    void saveValues(ActionEvent event) {
    	int errorFlag = 0;
    	String[] valueArray = valueField.getText().split(" ", 0);
    	if (valueArray.length < lengthOfArray) {
    		JOptionPane.showMessageDialog(null, "Please enter " + (lengthOfArray - valueArray.length) + " more value(s)" , "Error", JOptionPane.WARNING_MESSAGE);
    	} else if (valueArray.length > lengthOfArray) {
    		JOptionPane.showMessageDialog(null, "You have entered " + (valueArray.length - lengthOfArray) + " more value(s) than the current number of values" , "Error", JOptionPane.ERROR_MESSAGE);
    	} else {
    		for (int i = 0; i < valueArray.length; i++) {
    			try {
    				arrayOfNums[i] = Integer.parseInt(valueArray[i]);
    	    	} catch (NumberFormatException error) {
    	    		errorFlag = 1;
    	    		JOptionPane.showMessageDialog(null, "Please enter integer value only!", "Error", JOptionPane.ERROR_MESSAGE);
    	    		break;
    	    	}
    		}
    		if (errorFlag == 0) {
    			try {
    	    		final String DATA_FXML_FILE_PATH = "/application/view/DataSortingVisualization.fxml";
    	        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(DATA_FXML_FILE_PATH));
    	        	fxmlLoader.setController(new DataSortingVisualizeController(valueField, typeOfAlgorithm, arrayOfNums, lengthOfArray, 0));
    	        	Parent root = fxmlLoader.load();
    	        	Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
    	        	stage.setScene(new Scene(root));
    	        	stage.setTitle("Data Sorting Visualize");
    	        	stage.show();
    	    	} catch (IOException e) {
    	    		e.printStackTrace();
    	    	}
    		}
    	}
    	
    }
    
    @FXML
    void createRandomArray(ActionEvent event) {
    	try {
    		final String DATA_FXML_FILE_PATH = "/application/view/DataSortingVisualization.fxml";
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(DATA_FXML_FILE_PATH));
        	fxmlLoader.setController(new DataSortingVisualizeController(typeOfAlgorithm, lengthOfArray, 1));
        	Parent root = fxmlLoader.load();
        	Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        	stage.setScene(new Scene(root));
        	stage.setTitle("Data Sorting Visualize");
        	stage.show();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    @FXML
    public void initialize() {
    	saveValuesBtn.setDisable(true);
    }
}
