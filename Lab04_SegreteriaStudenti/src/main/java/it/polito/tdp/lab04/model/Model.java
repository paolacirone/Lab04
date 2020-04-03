package it.polito.tdp.lab04.model;

import java.util.List;
import java.util.Map;
import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;
import javafx.collections.ObservableList;

public class Model {

	private CorsoDAO cdao; 
	private StudenteDAO sdao; 
	
	public Model() {
		cdao = new CorsoDAO();
		sdao= new StudenteDAO();
	}
	
	public List<Corso> getTuttiICorsi(){
		return  cdao.getTuttiICorsi(); 
	}
	
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso){
		return cdao.getStudentiIscrittiAlCorso(corso);
	}
	
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		return cdao.inscriviStudenteACorso(studente, corso);
	}
	
	public Map<Integer,Studente> getTuttiGliStudenti() {
		return sdao.getTuttiGliStudenti();
	}
	
	public List<Corso> cercaCorsiStudente(int matricola) {
		return cdao.cercaCorsiStudente(matricola);
	}
}
