package com.ib.tp.web.model;

public class CalculEmprunt {
	private int montant;
	private double taux;//taux annuel en %
	private int nbMois;
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
	
	
}
