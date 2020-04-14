package com.ib.tp.entity;

public class Produit {
	private Long num;
	private String label;
	private String categorie;
	private Double prix;
	//...
	
	public Produit(Long num, String label, String categorie, Double prix) {
		super();
		this.num = num;
		this.label = label;
		this.categorie = categorie;
		this.prix = prix;
	}
	
	public Produit() {
		super();
	}
	
	

	@Override
	public String toString() {
		return "Produit [num=" + num + ", label=" + label + ", categorie=" + categorie + ", prix=" + prix + "]";
	}

	public Long getNum() {
		return num;
	}
	
	public void setNum(Long num) {
		this.num = num;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
	

}
