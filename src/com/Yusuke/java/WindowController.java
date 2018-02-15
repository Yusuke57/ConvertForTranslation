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
		
		//改行文字を半角スペースに変換
		str = str.replace("\n", " ");
		
		//引用番号を除去
		str = str.replaceAll(" *\\[[0-9]+\\] *", "%%QUOTATION%%");
		str = str.replaceAll("%%QUOTATION%%\\.", "."); //文末の引用は半角スペース不要
		str = str.replaceAll("%%QUOTATION%%", " ");
		
		//et al. のピリオドを除去
		str = str.replace("et al. ", "et al ");
		
		//単語内の改行部分を修復
		str = str.replaceAll("([a-zA-Z])- ([a-zA-Z])", "$1$2");
		
		outputText.setText(str);
	}
}
