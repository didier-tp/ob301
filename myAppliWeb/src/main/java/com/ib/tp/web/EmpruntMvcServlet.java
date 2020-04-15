package com.ib.tp.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ib.tp.web.model.CalculEmprunt;

/**
 * Servlet implementation class EmpruntMvcServlet
 */
@WebServlet("/EmpruntMvcServlet")
public class EmpruntMvcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpruntMvcServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sMontant = request.getParameter("montant");
		int montant = (sMontant==null)?0:Integer.parseInt(sMontant);
		String sTaux = request.getParameter("taux");
		double taux = (sTaux==null)?0:Double.parseDouble(sTaux);
		String sNbMois = request.getParameter("nbMois");
		int nbMois = (sNbMois==null)?0:Integer.parseInt(sNbMois);
		
		CalculEmprunt calculEmprunt = new CalculEmprunt(montant,taux,nbMois);
		calculEmprunt.calculerMensualite();
		
		request.setAttribute("calculEmprunt", calculEmprunt); //stocké un acces au bean dans l'objet request
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/res_emprunt_mvc.jsp");
        rd.forward(request, response); //redirection vers page jsp
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
