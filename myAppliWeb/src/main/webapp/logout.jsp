<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>logout</title>
</head>
<%
String message="";
String logout = request.getParameter("logout");
if(logout!=null){
	session.invalidate();
	response.sendRedirect("./index.html");
	//message="deconnexion effectuee";
}
%>
<body>
     
     <form >
      <input type="hidden" name="logout" value="true" />
      <input type="submit" value="logout / deconnexion" />
     </form>
       <%=message%> <br/>
       numSession= <%=session.getId()%>
       <hr/>
       <a href="index.html">retour accueil</a>
</body>
</html>