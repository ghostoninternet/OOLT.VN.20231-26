package application.controller;

import java.io.IOException;

import application.algorithms.CountingSort;
import application.algorithms.MergeSort;
import application.algorithms.RadixSort;
import application.algorithms.SortingAlgorithm;
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
	private int isRandomArray;
	private SortingAlgorithm sortingAlgorithm;
	private StringBuffer[] sortingProcessArray = new StringBuffer[10000];
	
    @FXML
    private TextArea resultBeforeTextArea;

    @FXML
    private Button backToMainMenuBtn;
    
    @FXML
    private TextArea sortingProcessArea;

    @FXML
    private TextArea resultAfterTextArea;

    @FXML
    private Button startSortAlgorithmBtn;

    public DataSortingVisualizeController (TextField valueField, String typeOfAlgorithm, int arrayOfNums[], int lengthOfArray, int isRandomArray) {
    	this.valueField = valueField;
    	this.typeOfAlgorithm = typeOfAlgorithm;
    	this.arrayOfNums = arrayOfNums;
    	this.lengthOfArray = lengthOfArray;
    	this.isRandomArray = isRandomArray;
    }
    
    public DataSortingVisualizeController(String typeOfAlgorithm, int lengthOfArray, int isRandomArray) {
    	this.typeOfAlgorithm = typeOfAlgorithm;
    	this.lengthOfArray = lengthOfArray;
    	this.isRandomArray = isRandomArray;
    }
    
    @FXML
    void backToMainMenu(ActionEvent event) {
    	try {
    		final String MENU_FXML_FILE_PATH = "/application/view/MainMenu.fxml";
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(MENU_FXML_FILE_PATH));
        	Parent root = fxmlLoader.load();
        	Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        	stage.setScene(new Scene(root));
        	stage.setTitle("Sorting Application");
        	stage.show();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void startSortAlgorithm(ActionEvent event) {
    	sortingProcessArray = sortingAlgorithm.Sort();
    	String result = "";
    	for (int i = 0; i < lengthOfArray; i++) {
    		result += arrayOfNums[i] + " ";
    	}
    	String sortingProcess = "";
    	for (StringBuffer process: sortingProcessArray) {
    		try {
    			sortingProcess += process.toString();
    			System.out.println(process);
    		}catch (NullPointerException e) {
    			continue;
    		}
    	}
    	System.out.println(sortingProcess);
    	sortingProcessArea.setText(sortingProcess);
    	resultAfterTextArea.setText(result);
    }

    @FXML
    void initialize() {
    	if (isRandomArray != 1) {
    		resultBeforeTextArea.setText(valueField.getText());
    		if (typeOfAlgorithm.equals("Merge Sort")) {
    			sortingAlgorithm = new MergeSort(arrayOfNums, lengthOfArray);
        	} else if (typeOfAlgorithm.equals("Counting Sort")) {
        		sortingAlgorithm = new CountingSort(arrayOfNums, lengthOfArray);
        	} else if (typeOfAlgorithm.equals("Radix Sort")) {
        		sortingAlgorithm = new RadixSort(arrayOfNums, lengthOfArray);
        	}
    	} else {
    		if (typeOfAlgorithm.equals("Merge Sort")) {
    			sortingAlgorithm = new MergeSort(lengthOfArray);
        	} else if (typeOfAlgorithm.equals("Counting Sort")) {
        		sortingAlgorithm = new CountingSort(lengthOfArray);
        	} else if (typeOfAlgorithm.equals("Radix Sort")) {
        		sortingAlgorithm = new RadixSort(lengthOfArray);
        	}
    		arrayOfNums = sortingAlgorithm.getArray();
    		String arrayOfNumString = "";
    		for (int i = 0; i < lengthOfArray; i++) {
    			arrayOfNumString += arrayOfNums[i] + " ";
    			System.out.println(arrayOfNums[i]);
    		}
    		resultBeforeTextArea.setText(arrayOfNumString);
    	}
    }
}

