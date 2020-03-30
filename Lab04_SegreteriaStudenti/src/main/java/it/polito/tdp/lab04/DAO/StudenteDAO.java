package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {


	/*
	 * Ottengo tutti gli studenti salvati nel Db
	 */
	public Map<Integer,Studente> getTuttiGliStudenti() {

		final String sql = "SELECT * FROM studente";

		Map<Integer,Studente> studenti = new TreeMap<Integer,Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				
				int matricola = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String cds = rs.getString("CDS");

				System.out.println(matricola + " " + cognome + " " + nome + " " + cds);

				// Crea un nuovo JAVA Bean Corso
				
				Studente s = new Studente(matricola,cognome, nome, cds);
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				studenti.put(matricola, s);
			}

			conn.close();
			
			return studenti;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
}
