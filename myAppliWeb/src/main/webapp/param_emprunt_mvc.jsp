<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>param-emprunt_mvc</title>
</head>
<body>
   <form action="./EmpruntMvcServlet" method="GET">
	   montant: <input name="montant" /> <br/>
	   taux: <input name="taux" /> <br/>
	   duree (nbMois): <input name="nbMois" /> <br/>
	   <input type="submit" value="calculer mensualite" /> 
	</form>
</body>
</html>