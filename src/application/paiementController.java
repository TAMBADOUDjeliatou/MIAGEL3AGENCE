package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

public class paiementController {
	@FXML
	private TextField idfacture;
	@FXML
	private TextField date;
	@FXML
	private TextField montant;
	@FXML
	private Button valide;
	@FXML
	private ComboBox paiement;

	// Event Listener on Button[#valide].onAction
	@FXML
	public void valideon(ActionEvent event) {
		// TODO Autogenerated
	}
}
