package com.Yusuke.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class WindowController {
	@FXML private Label label;
	@FXML private TextArea inputText;
	@FXML private TextArea outputText;
	
	@FXML
	protected void buttonAction(ActionEvent event) {
		String str = inputText.getText();
		str = str.replace("\n", " ");
		outputText.setText(str);
	}
}
