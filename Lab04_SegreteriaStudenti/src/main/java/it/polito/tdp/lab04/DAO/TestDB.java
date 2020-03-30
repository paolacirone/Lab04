package it.polito.tdp.lab04.DAO;

public class TestDB {

	public static void main(String[] args) {

		/*
		 * 	This is a main to check the DB connection
		 */
		
		//verifico che tutti i corsi e studenti siano stati salvati correttamente dal db
		CorsoDAO cdao = new CorsoDAO();
		cdao.getTuttiICorsi();
		
		
		StudenteDAO sdao = new StudenteDAO(); 
		sdao.getTuttiGliStudenti();
		
		
	}

}
