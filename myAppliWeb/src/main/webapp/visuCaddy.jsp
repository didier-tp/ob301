<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>visuCaddy</title>
</head>
<body>
<%
List<String> caddy = (List<String>)session.getAttribute("caddy");
if(caddy!=null){
	%>
  <table border="1">
     <%for(String nP : caddy){ %>
         <tr><td><%=nP%> </td></tr>
     <%}%>
  </table>	
<%	
}
%>

</body>
</html>