package com.ib.tp.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ib.tp.web.model.RechercheProduits;

/**
 * Servlet implementation class ProduitMvcServlet
 */
@WebServlet("/ProduitMvcServlet")
public class ProduitMvcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitMvcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperer la valeur de la catagorie choisie , getParameter()
		String categorie = request.getParameter("categorie");
		//créer une instance de  RechercheProduits
		RechercheProduits rechercheProduits = new RechercheProduits();
		rechercheProduits.setCategorie(categorie);
		rechercheProduits.rechercherProduits();
		request.setAttribute("rechercheProduits", rechercheProduits);
		request.setAttribute("produits", rechercheProduits.getProduits());
		//redirection vers page produits.jsp
		String page="/produits.jsp";
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher(page);
        rd.forward(request, response); //redirection vers page jsp
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
