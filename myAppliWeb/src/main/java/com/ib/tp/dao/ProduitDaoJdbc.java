package com.ib.tp.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ib.tp.entity.Produit;

public class ProduitDaoJdbc implements ProduitDao {
	
    private static ProduitDaoJdbc uniqueInstance = null;
    
    private DataSource ds = null;
	
	public static ProduitDaoJdbc getInstance() {
		if(uniqueInstance==null) uniqueInstance = new ProduitDaoJdbc();
		return uniqueInstance;
	}
	
	public ProduitDaoJdbc() {
		String dbName = "java:comp/env/jdbc/myDB";
		try {
			// Nom logique JNDI
			// Obtention via JNDI de l'objet DataSource:
			InitialContext ic = new InitialContext();
			this.ds = (DataSource) ic.lookup(dbName);
		} catch (NamingException e) {
			e.printStackTrace();
		} 
	}
	
	Connection etablirConnectionViaTomcat() {
		Connection cn=null;
		try {
			cn = ds.getConnection();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}
	
	Connection etablirConnection() {
		Connection cn=null;
		//valeurs par défaut
		String driverClassName="org.h2.Driver";
		String url="jdbc:h2:~/test";
		String username="sa";
		String password="";
		try {
			//chargement des valeurs depuis db.properties
			Properties props = new Properties();
			props.load(Thread.currentThread().getContextClassLoader()
					   .getResourceAsStream("db.properties"));
			driverClassName=props.getProperty("ds.driverClassName");
			url=props.getProperty("ds.url");System.out.println("url="+url);
			username=props.getProperty("ds.username");
			password=props.getProperty("ds.password");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			Class.forName(driverClassName);
			cn=DriverManager.getConnection(url, username, password);
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
	
	static void closeCn(Connection cn) {
		try {
			cn.close();
		} catch (SQLException e) {
			//try catch obligatoire meme pour simple .close()
			e.printStackTrace();
		}
	}


	@Override
	public List<Produit> findProduitByCategorie(String categorie) {
		List<Produit> listeProd=new ArrayList<>();
		Connection cn = null;
		try {
			cn=this.etablirConnectionViaTomcat();//this.etablirConnection();
			//cn.setAutoCommit(true);
			PreparedStatement pstmt = cn.prepareStatement( "SELECT * FROM Produit WHERE categorie=?");
			pstmt.setString(1,categorie);//remplacer ? numero 1 par valeur de num
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())	{
				listeProd.add(new Produit(rs.getLong("num"),
					                	rs.getString("label"),
					                	rs.getString("categorie"),
					                	rs.getDouble("prix")));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeCn(cn);
		}
		return listeProd;
	}

	@Override
	public Produit findProduitByNum(Long num) {
		Produit produit=null;
		Connection cn = null;
		try {
			cn=this.etablirConnectionViaTomcat();//this.etablirConnection();
			PreparedStatement pstmt = cn.prepareStatement( "SELECT * FROM Produit WHERE num=?");
			pstmt.setLong(1,num);//remplacer ? numero 1 par valeur de num
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())	{
			  produit = new Produit(num,
					                rs.getString("label"),
					                rs.getString("categorie"),
					                rs.getDouble("prix"));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeCn(cn);
		}
		return produit;
	}

}
