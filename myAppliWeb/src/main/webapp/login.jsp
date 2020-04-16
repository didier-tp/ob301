<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<%
String message="";
String logout = request.getParameter("logout");
if(logout!=null){
	session.invalidate();
	response.sendRedirect("./login.jsp");
	//message="deconnexion effectuee";
}else{
	String username=request.getParameter("username");
	if(username!=null){
		session.setAttribute("nom", username);
	}
	String nomEnSession= (String) session.getAttribute("nom");
	message="nomEnSession=" + nomEnSession;
}
%>
<body>
     <%@ include file="entete.jsp" %>
     <form>
        username:<input name="username"/><br/>
        password: ...<br/>
        <input type="submit" value="login" />
     </form>
     <hr/>
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