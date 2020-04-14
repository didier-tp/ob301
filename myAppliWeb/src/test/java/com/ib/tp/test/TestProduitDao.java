package com.ib.tp.test;

import com.ib.tp.dao.ProduitDao;
import com.ib.tp.dao.ProduitDaoMemMap;

public class TestProduitDao {

	public static void main(String[] args) {
		ProduitDao produitDao = ProduitDaoMemMap.getInstance();
		System.out.println("produit_2="+produitDao.findProduitByNum(2L));
		System.out.println("produits de categorie cd="+produitDao.findProduitByCategorie("cd"));
	}

}
