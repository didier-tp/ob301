package com.ib.tp.web.model;

public class CalculEmprunt {
	private String message="";
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String sMontant;
	private int montant;
	private String sTaux;
	private double taux;//taux annuel en %
	private int nbMois;
	private String sNbMois;
	private double mensualite; //à calculer
	
	
	public CalculEmprunt(int montant, double taux, int nbMois) {
		super();
		this.montant = montant;
		this.taux = taux;
		this.nbMois = nbMois;
	}
	
	public void calculerMensualite() {
		double tauxMens = (taux/100) / 12;
		this.mensualite = montant * tauxMens / ( 1 - Math.pow(1+tauxMens,-nbMois) );
	}
	
	public CalculEmprunt() {
		super();
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	public int getNbMois() {
		return nbMois;
	}
	public void setNbMois(int nbMois) {
		this.nbMois = nbMois;
	}
	public double getMensualite() {
		return mensualite;
	}
	public void setMensualite(double mensualite) {
		this.mensualite = mensualite;
	}

	public String getsMontant() {
		return sMontant;
	}

	public void setsMontant(String sMontant) {
		this.sMontant = sMontant;
	}

	public String getsTaux() {
		return sTaux;
	}

	public void setsTaux(String sTaux) {
		this.sTaux = sTaux;
	}

	public String getsNbMois() {
		return sNbMois;
	}

	public void setsNbMois(String sNbMois) {
		this.sNbMois = sNbMois;
	}
	
	
}
