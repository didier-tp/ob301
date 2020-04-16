package com.ib.tp.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		CalculEmprunt calculEmprunt = new CalculEmprunt();
		String sMontant = request.getParameter("montant"); calculEmprunt.setsMontant(sMontant);
		String sTaux = request.getParameter("taux");calculEmprunt.setsTaux(sTaux);
		String sNbMois = request.getParameter("nbMois");calculEmprunt.setsNbMois(sNbMois);
		String page=null;
		try {
			int nbMois = (sNbMois==null)?0:Integer.parseInt(sNbMois);
			double taux = (sTaux==null)?0:Double.parseDouble(sTaux);
			int montant = (sMontant==null)?0:Integer.parseInt(sMontant);
			calculEmprunt.setNbMois(nbMois);calculEmprunt.setMontant(montant);calculEmprunt.setTaux(taux);
			calculEmprunt.calculerMensualite();
			page="/res_emprunt_mvc.jsp";
		} catch (NumberFormatException e) {
			//e.printStackTrace();
			calculEmprunt.setMessage("erreur:"+e.getMessage());
			page="/param_emprunt_mvc.jsp";
		}
		HttpSession session = request.getSession();
		request.setAttribute("calculEmprunt", calculEmprunt); //stocké un acces au bean dans l'objet request
		//session.setAttribute("calculEmprunt", calculEmprunt); //stocké un acces au bean dans l'objet session
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher(page);
        rd.forward(request, response); //redirection vers page jsp
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
