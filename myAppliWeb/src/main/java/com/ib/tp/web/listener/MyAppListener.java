package com.ib.tp.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyAppListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyAppListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	// terminaison lors de l'arrêt de l'application WEB
    	ServletContext application = sce.getServletContext();
    	Integer objCompteur = (Integer) application.getAttribute("compteurGlobal");
    	System.out.println("compteurGlobal:" + objCompteur.intValue());
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	// initialisation au chargement/démarrage de l'application WEB
    	ServletContext application = sce.getServletContext();
    	Integer objCompteur = 100; //new Integer(100);
    	application.setAttribute("compteurGlobal",objCompteur);
    }
	
}
