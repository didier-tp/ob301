package com.ib.tp.web.model;

import java.util.List;

import com.ib.tp.dao.ProduitDaoJdbc;
import com.ib.tp.dao.ProduitDaoMemMap;
import com.ib.tp.entity.Produit;

public class RechercheProduits {
	private String categorie; //categorie de produits recherchés
	private List<Produit> produits;
   //..
	public void rechercherProduits() {
		//produits = ProduitDaoMemMap.getInstance().findProduitByCategorie(categorie);
		produits = ProduitDaoJdbc.getInstance().findProduitByCategorie(categorie);
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	
}
