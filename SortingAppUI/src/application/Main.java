package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader; 
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	  @Override
	  public void start(Stage primaryStage) throws Exception {

	    Parent root = FXMLLoader.load(getClass().getResource("SortingApp.fxml"));
	    
	    primaryStage.setWidth(800); 
	    primaryStage.setHeight(600); 
	    primaryStage.setMinWidth(400); 
	    primaryStage.setMinHeight(300);
	    
	    Scene scene = new Scene(root);
	    
	    primaryStage.setScene(scene);
	    primaryStage.show();
	  }

	  public static void main(String[] args) {
	    launch(args);
	  }

	}
