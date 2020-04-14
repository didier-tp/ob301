package com.ib.tp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TvaServlet
 */
@WebServlet("/TvaServlet")
public class TvaServlet extends HttpServlet {
	

	@Override
	public void destroy() {
		super.destroy(); System.out.println("compteur="+compteur);
	}



	@Override
	public void init() throws ServletException {
		super.init();
		this.compteur=0;
		System.out.println("compteur="+compteur);
	}


	private int compteur;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TvaServlet() {
        super();
    }
    
    



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sHt = request.getParameter("ht");
		int ht = Integer.parseInt(sHt);
		String sTaux = request.getParameter("taux");
		double taux = Double.parseDouble(sTaux);
		double tva = ht * taux/100.0;
		double ttc = tva + ht;
		synchronized(this) {
			this.compteur++;
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>tva</title></head>");
		out.println("<body>");
		out.println("<p>ht:"+ht+"</p>");
		out.println("<p>taux:"+taux+"%</p>");
		out.println("<p>tva:<b>"+tva+"</b></p>");
		out.println("<p>ttc:<b>"+ttc+"</b></p>");
		out.println("<p>compteur:<i>"+compteur+"</i></p>");
		out.println("</body></html>");
	}

}
