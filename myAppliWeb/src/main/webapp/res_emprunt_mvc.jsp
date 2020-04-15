<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>res_emprunt_mvc</title>
</head>
<body>
montant : ${requestScope.calculEmprunt.montant} <br/>
taux : ${requestScope.calculEmprunt.taux} <br/>
nbMois : ${requestScope.calculEmprunt.nbMois} <br/>
mensualite : ${requestScope.calculEmprunt.mensualite} <br/>
</body>
</html>