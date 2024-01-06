package application.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class MainScreenController {

	@FXML
	private Button btnMergeSort;

	@FXML
	private Button btnCountingSort;

	@FXML
	private Button btnRadixSort;
    
    @FXML 
    void menuAbout(ActionEvent event) {
    	   try {
    	        FXMLLoader fxmlLoader = new FXMLLoader();
    	        fxmlLoader.setLocation(getClass().getResource("/application/view/About.fxml"));
    	        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
    	        Stage newstage = new Stage();
    	        newstage.setTitle("Info");
    	        newstage.setScene(scene);
    	        newstage.show();
    	    } catch (IOException e) {
    	    	e.printStackTrace();
    	    }
    }
    
    @FXML 
    void menuExit(ActionEvent event) {        	
        Stage stage = (Stage)((Node) btnMergeSort).getScene().getWindow();
        stage.close();
    }

    @FXML
    void chooseSortingAlgorithm(ActionEvent event) {
    	String buttonText = ((Labeled) event.getSource()).getText();
    	try {
    		final String DATA_FXML_FILE_PATH = "/application/view/DataEntry.fxml";
        	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(DATA_FXML_FILE_PATH));
        	fxmlLoader.setController(new DataEntryController(buttonText));
        	Parent root = fxmlLoader.load();
        	Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        	stage.setScene(new Scene(root));
        	stage.setTitle("Data Entry");
        	stage.show();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
}
