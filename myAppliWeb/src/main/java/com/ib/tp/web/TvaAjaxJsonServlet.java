package com.ib.tp.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ib.tp.dto.ResTva;

/**
 * Servlet implementation class TvaAjaxJsonServlet
 */
@WebServlet("/TvaAjaxJsonServlet")
public class TvaAjaxJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TvaAjaxJsonServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sHt = request.getParameter("ht");
		double ht = Double.parseDouble(sHt);
		String sTaux = request.getParameter("taux");
		double taux = Double.parseDouble(sTaux);
		double tva = ht * taux/100.0;
		double ttc = tva + ht;
		ResTva resTva = new ResTva(ht,taux,tva,ttc);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		//jackson = libraie java open source qui gère le format json
		ObjectMapper objMapperJackson = new ObjectMapper();
		String resConAsJsonString = objMapperJackson.writeValueAsString(resTva);
		out.println(resConAsJsonString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
