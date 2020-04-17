<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>addInCaddy</title>
</head>
<%
String message="";
String nomProd = request.getParameter("nomProd");
List<String> caddy = (List<String>)session.getAttribute("caddy");
if(caddy==null){
	caddy = new ArrayList<String>();
	session.setAttribute("caddy",caddy);
}
if(nomProd!=null){
	caddy.add(nomProd);
	message="le produit " + nomProd +  " a ete ajouté au caddy";
}
%>
<body>
		<form action='<%=response.encodeURL("addInCaddy.jsp")%>'>
		   nomProd: <input name="nomProd" /> <br/>
		   <input type="submit" value="ajouter au panier" /><br/>
		</form>
		<%=message%>
		<hr/>
		<a href='<%=response.encodeURL("visuCaddy2.jsp")%>' >visuCaddy</a>
</body>
</html>