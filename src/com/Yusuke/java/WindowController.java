package com.Yusuke.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.CheckBox;

public class WindowController {
	@FXML private Label label;
	@FXML private TextArea inputText;
	@FXML private TextArea outputText;
	@FXML private CheckBox checkbox;
	@FXML
	protected void buttonAction(ActionEvent event) {
		String str = inputText.getText();
		
		//段落の最後の改行を退避
		str = str.replaceAll("\\.\n+ *([A-Z|0-9])", ".%%PARAGRAPH_END%%$1");
		
		//改行文字を半角スペースに変換
		str = str.replace("\n", " ");
		
		//段落の最後の改行は2つ分
		str = str.replace("%%PARAGRAPH_END%%", "\n\n");
		
		//引用番号を除去
		if(checkbox.isSelected()) {
			str = str.replaceAll("( *\\[[0-9]+\\] *)+", "%%QUOTATION%%");
			str = str.replaceAll("%%QUOTATION%%\\.", "."); //ピリオド直前の引用は半角スペース不要
			str = str.replaceAll("%%QUOTATION%%,", ","); //カンマ直前の引用は半角スペース不要
			str = str.replaceAll("%%QUOTATION%%", " ");
		}
		
		//et al. のピリオドを除去
		str = str.replace("et al. ", "et al ");
		
		//単語内の改行部分を修復
		str = str.replaceAll("([a-zA-Z])- ([a-zA-Z])", "$1$2");
		
		//無駄な半角スペースを除去
		str = str.replaceAll(" +", " ");
		
		//全角スペースを半角スペースに変換
		str = str.replaceAll("　", " ");
		
		outputText.setText(str);
		outputText.selectAll();
		outputText.copy();
	}
}
