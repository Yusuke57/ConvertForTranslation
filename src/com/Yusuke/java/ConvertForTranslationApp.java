package com.Yusuke.java;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;


public class ConvertForTranslationApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("window.fxml"));
		Scene scene = new Scene(root, 640, 480);
		stage.setScene(scene);
		stage.setTitle("ConvertForTranslation");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
