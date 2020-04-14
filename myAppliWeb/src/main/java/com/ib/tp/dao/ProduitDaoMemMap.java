package com.ib.tp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ib.tp.entity.Produit;

public class ProduitDaoMemMap implements ProduitDao {
	
	private static ProduitDaoMemMap uniqueInstance = null;
	
	public static ProduitDaoMemMap getInstance() {
		if(uniqueInstance==null) uniqueInstance = new ProduitDaoMemMap();
		return uniqueInstance;
	}
	
	private Map<Long,Produit> mapProduits;
	
	public ProduitDaoMemMap(){
		mapProduits=new HashMap<>();
		mapProduits.put(1L, new Produit(1L,"cahier","divers",2.56));
		mapProduits.put(2L, new Produit(2L,"cd1","cd",10.46));
		mapProduits.put(3L, new Produit(3L,"stylo","divers",1.67));
		mapProduits.put(4L, new Produit(4L,"cd2","cd",12.66));
		mapProduits.put(5L, new Produit(5L,"trousse","divers",3.26));
	}

	@Override
	public List<Produit> findProduitByCategorie(String categorie) {
		return mapProduits.values().stream()
				.filter((p)->p.getCategorie().equalsIgnoreCase(categorie))
				.collect(Collectors.toList());
	}

	@Override
	public Produit findProduitByNum(Long num) {
		return mapProduits.get(num);
	}

}
