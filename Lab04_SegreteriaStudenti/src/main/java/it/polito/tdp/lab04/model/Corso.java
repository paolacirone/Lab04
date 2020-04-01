package it.polito.tdp.lab04.model;

public class Corso {

	private String codins; 
	private int crediti; 
	private String nome; 
	private int pd;
	
	
	public Corso(String codins, int crediti, String nome, int pd) {
		
		this.codins = codins;
		this.crediti = crediti;
		this.nome = nome;
		this.pd = pd;
	}


	public String getCodins() {
		return codins;
	}


	public void setCodins(String codins) {
		this.codins = codins;
	}


	public int getCrediti() {
		return crediti;
	}


	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getPd() {
		return pd;
	}


	public void setPd(int pd) {
		this.pd = pd;
	}


	@Override
	public String toString() {
		return nome;
	} 
	
	
	
	
}
