<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>tva</title>
</head>
<%
String sHt = request.getParameter("ht");
int ht = (sHt==null)?0:Integer.parseInt(sHt);
String sTaux = request.getParameter("taux");
double taux = (sTaux==null)?0:Double.parseDouble(sTaux);
double tva = ht * taux/100.0;
double ttc = tva + ht;
%>
<body>
	<form >
	   ht: <input name="ht" value="<%=ht%>"/> <br/>
	   taux: <input name="taux" value="<%=taux%>"/> <br/>
	   <input type="submit" value="calculer tva" /> 
	</form>
	tva=<b><%=tva %></b><br/>
</body>
</html>