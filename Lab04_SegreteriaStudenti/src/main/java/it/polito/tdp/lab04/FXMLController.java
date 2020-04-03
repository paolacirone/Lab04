package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class FXMLController {

	private Model model;

	private ObservableList<Corso> choiceBoxList;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ChoiceBox<Corso> choiceBox;

	@FXML
	private Button btnCercaIscritti;

	@FXML
	private TextField lblMatricola;

	@FXML
	private Button btnCompletamento;

	@FXML
	private TextField lblNome;

	@FXML
	private TextField lblCognome;

	@FXML
	private Button btnCercaCorsi;

	@FXML
	private Button btnIscrivi;

	@FXML
	private TextArea txtResult;

	@FXML
	private Button btnReset;

	@FXML
	void doCercaCorsi(ActionEvent event) {
		
		this.txtResult.clear();

		Map<Integer, Studente> studenti = this.model.getTuttiGliStudenti();

		int matricola=0; 
		try{
			matricola= Integer.valueOf(this.lblMatricola.getText());
		}catch(NumberFormatException e) {
			this.txtResult.setText("Inserire un numero di matricola valido.");
		}

		// inserire try catch per controllare il formato

		if (!studenti.containsKey(matricola)) {
			this.txtResult.setText("Inserire un numero di matricola esistente.");
			return;
		}

		List<Corso> corsi = this.model.cercaCorsiStudente(matricola);

		for (Corso c : corsi) {
			txtResult.appendText(c.toString() + "\n");
		}

	}

	@FXML
	void doCercaIscritti(ActionEvent event) {

		this.txtResult.clear(); 
		String corso = this.choiceBox.getValue().toString();

		// controllo che sia stato selezionato un corso valido
		if (corso == null) {
			this.txtResult.setText("Selezionare un corso.");
			return;
		}

		List<Corso> corsi = this.model.getTuttiICorsi();

		Corso d = null;
		for (Corso c : corsi) {
			if (corso.compareTo(c.getNome()) == 0)
				d = new Corso(c.getCodins(), c.getCrediti(), c.getNome(), c.getPd());
		}

		List<Studente> studenti = this.model.getStudentiIscrittiAlCorso(d);
		for (Studente s : studenti) {
			this.txtResult.appendText(s.toString() + "\n");
		}
	}

	@FXML
	void doCompletamento(ActionEvent event) {

		Map<Integer, Studente> studenti = this.model.getTuttiGliStudenti();

		
		
		int matricola=0; 
		try{
			matricola= Integer.valueOf(this.lblMatricola.getText());
		}catch(NumberFormatException e) {
			this.txtResult.setText("Inserire un numero di matricola valido.");
		}

		// inserire try catch per controllare il formato

		if (studenti.containsKey(matricola)) {
			this.lblNome.setText(studenti.get(matricola).getNome());
			this.lblCognome.setText(studenti.get(matricola).getCognome());
		} else {
			this.txtResult.setText("Inserire un numero di matricola valido.");
			return;
		}
	}

	@FXML
	void doIscrivi(ActionEvent event) {

		this.txtResult.clear();
		
		Map<Integer, Studente> studenti = this.model.getTuttiGliStudenti();

		int matricola = Integer.valueOf(this.lblMatricola.getText());

		// inserire try catch per controllare il formato

		if (!studenti.containsKey(matricola)) {
			this.txtResult.setText("Inserire un numero di matricola valido.");
			return;
		}

		String corso = this.choiceBox.getValue().toString();

		// controllo che sia stato selezionato un corso valido
		if (corso == null) {
			this.txtResult.setText("Selezionare un corso.");
			return;
		}
		
		
		List<Corso> corsi = this.model.cercaCorsiStudente(matricola);
		List<Corso> tutti = this.model.getTuttiICorsi(); 
		
		for(Corso c: corsi) {
			if(c.getNome().compareTo(corso)==0) {
				this.txtResult.setText("Studente già iscritto al corso");
				return;
			}
		}
	
		 Corso d = null; 
	    	for(Corso c: tutti) {
	    		if(corso.compareTo(c.getNome())==0)
	    		d= new Corso(c.getCodins(), c.getCrediti(), c.getNome(),c.getPd());
	    	}
	    	


		// boolean iscritto = false;
		if (this.model.inscriviStudenteACorso(studenti.get(matricola), d)) {
			this.txtResult.setText("Studente iscritto al corso correttamente");
		} else {
			this.txtResult.setText("Errore nell'iscrizione");
		}

	}

	@FXML
	void doReset(ActionEvent event) {

		this.txtResult.clear();
		this.lblNome.clear();
		this.lblCognome.clear();
		this.lblMatricola.clear();
		this.choiceBox.setValue(null);
	}

	@FXML
	void initialize() {
		assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'Scene.fxml'.";
		assert lblMatricola != null : "fx:id=\"lblMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnCompletamento != null : "fx:id=\"btnCompletamento\" was not injected: check your FXML file 'Scene.fxml'.";
		assert lblNome != null : "fx:id=\"lblNome\" was not injected: check your FXML file 'Scene.fxml'.";
		assert lblCognome != null : "fx:id=\"lblCognome\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

	}

	public void setModel(Model model) {
		this.model = model;
		choiceBoxList = FXCollections.observableArrayList(model.getTuttiICorsi());
		// campo vuoto per quando non si scegli nessun corso
		choiceBoxList.add(new Corso(null, 0, null, 0));
		choiceBox.setItems(choiceBoxList);
	}
}
