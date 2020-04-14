package com.ib.tp.dto;

public class ResTva {
	private double ht;
	private double taux;
	private double tva;
	private double ttc;
	
	
	public ResTva() {
		super();
	}


	public ResTva(double ht, double taux, double tva, double ttc) {
		super();
		this.ht = ht;
		this.taux = taux;
		this.tva = tva;
		this.ttc = ttc;
	}


	@Override
	public String toString() {
		return "ResTva [ht=" + ht + ", taux=" + taux + ", tva=" + tva + ", ttc=" + ttc + "]";
	}
	
	
	public double getHt() {
		return ht;
	}
	public void setHt(double ht) {
		this.ht = ht;
	}
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	public double getTva() {
		return tva;
	}
	public void setTva(double tva) {
		this.tva = tva;
	}
	public double getTtc() {
		return ttc;
	}
	public void setTtc(double ttc) {
		this.ttc = ttc;
	}
	
	
}
