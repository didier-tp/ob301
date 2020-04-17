<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login jee (FORM)</title>
</head>

<body>
     <%@ include file="entete.jsp" %>
     <form   method="POST"
             action='<%=response.encodeURL("j_security_check") %>'>
        username:<input name="j_username"/><br/>
        password:<input name="j_password"/><br/>
        <input type="submit" value="login" />
     </form>
</body>
</html>