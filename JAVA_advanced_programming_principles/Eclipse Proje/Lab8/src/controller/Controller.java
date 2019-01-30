package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modell.Modell;

public class Controller {

	private Modell modell;
	
	@FXML
	TextField nameTextField;
	
	@FXML
	Label helloLabel;
	
	public Controller() {
		modell = new Modell();
	}
	
	public void helloName() {
		String name = nameTextField.getText();
		String helloName = modell.helloName(name);
		helloLabel.setText(helloName);
	}

}
