package it.polito.tdp.lab04.DAO;

import it.polito.tdp.lab04.model.Corso;

public class TestDB {

	public static void main(String[] args) {

		/*
		 * 	This is a main to check the DB connection
		 */
		
		//verifico che tutti i corsi e studenti siano stati salvati correttamente dal db
		CorsoDAO cdao = new CorsoDAO();
		cdao.getTuttiICorsi();
		
		System.out.println("  ---  ");
		StudenteDAO sdao = new StudenteDAO(); 
		sdao.getTuttiGliStudenti();
		
		System.out.println("---------------------");
		Corso c = new Corso("01KSUPG", 0, null, 0);
		cdao.getStudentiIscrittiAlCorso(c);

		
	}

}
