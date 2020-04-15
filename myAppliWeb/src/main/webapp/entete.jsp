<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.Date"
    %>
<%! int compteur=0; %>   
<%
Date d = new Date();
synchronized(this){
  compteur++;
}
%>
<div>
date=<%=d %> , <%=compteur %>
</div>
<hr/>