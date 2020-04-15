package com.ib.tp.test;

import com.ib.tp.dao.ProduitDao;
import com.ib.tp.dao.ProduitDaoJdbc;

public class TestProduitDao {

	public static void main(String[] args) {
		//ProduitDao produitDao = ProduitDaoMemMap.getInstance();
		ProduitDao produitDao = ProduitDaoJdbc.getInstance();
		System.out.println("produit_2="+produitDao.findProduitByNum(2L));
		System.out.println("produits de categorie cd="+produitDao.findProduitByCategorie("cd"));
	}

}
