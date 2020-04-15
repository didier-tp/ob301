package com.ib.tp.dao;

import java.util.List;

import com.ib.tp.entity.Produit;

public interface ProduitDao {
	List<Produit> findProduitByCategorie(String categorie);
	Produit findProduitByNum(Long num);
	//...
}
