<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>res_emprunt_mvc</title>
</head>
<body>
montant : <%=((com.ib.tp.web.model.CalculEmprunt)request.getAttribute("calculEmprunt")).getMontant()%> <br/>
taux : ${calculEmprunt.taux} <br/>
nbMois : ${calculEmprunt.nbMois} <br/>
mensualite : ${requestScope.calculEmprunt.mensualite} <br/>
</body>
</html>