<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>emprunt</title>
</head>
<%
String sMontant = request.getParameter("montant");
int montant = (sMontant==null)?0:Integer.parseInt(sMontant);
String sTaux = request.getParameter("taux");
double taux = (sTaux==null)?0:Double.parseDouble(sTaux);
String sNbMois = request.getParameter("nbMois");
int nbMois = (sNbMois==null)?0:Integer.parseInt(sNbMois);
double tauxMens = (taux/100) / 12;
double mensualite = montant * tauxMens / ( 1 - Math.pow(1+tauxMens,-nbMois) );
%>
<body>
	<form >
	   montant: <input name="montant" value="<%=montant%>"/> <br/>
	   taux: <input name="taux" value="<%=taux%>"/> <br/>
	   duree (nbMois): <input name="nbMois" value="<%=nbMois%>"/> <br/>
	   <input type="submit" value="calculer mensualite" /> 
	</form>
	mensualite=<b><%=mensualite %></b><br/>
</body>
</html>