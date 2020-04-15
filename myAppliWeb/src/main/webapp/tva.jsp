<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.ib.tp.dto.ResTva"
    %>
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
ResTva resTva = new ResTva(ht,taux,tva,ttc);
pageContext.setAttribute("resTva", resTva);
%>
<body>
    <%@ include file="entete.jsp" %>
	<form >
	   ht: <input name="ht" value="<%=ht%>"/> <br/>
	   taux: <input name="taux" value="<%=taux%>"/> <br/>
	   <input type="submit" value="calculer tva" /> 
	</form>
	tva=<b><%=tva %></b><br/>
	ttc=<b>${resTva.ttc}</b><br/>
	<%@ include file="piedPage.jsp" %>
</body>
</html>