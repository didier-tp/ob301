<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List,java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>visuCaddy</title>
</head>
<body>
  <table border="1">
     <c:forEach var="nP" items="${caddy}">
         <tr><td>${nP}</td></tr>
     </c:forEach>
  </table>	
  nomEnSession=${sessionScope.nom}
  <hr/>
  <a href="index.html">retour accueil</a>
</body>
</html>