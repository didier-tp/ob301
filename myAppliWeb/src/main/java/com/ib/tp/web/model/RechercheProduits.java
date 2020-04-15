package com.ib.tp.web.model;

import java.util.List;

import com.ib.tp.dao.ProduitDaoMemMap;
import com.ib.tp.entity.Produit;

public class RechercheProduits {
	private String categorie; //categorie de produits recherchés
	private List<Produit> produits;
   //+get/set 
   //..
	public void rechercherProduits() {
		produits = ProduitDaoMemMap.getInstance().findProduitByCategorie(categorie);
	}
}
