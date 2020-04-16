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
String nomEnSession=null;
try{
   nomEnSession=(String) session.getAttribute("nom");
}catch(Exception ex){
}
String messageNomEnSession="nomEnSession=" + nomEnSession;
Integer compteurGlobal = null;
synchronized(application){
	compteurGlobal = (Integer) application.getAttribute("compteurGlobal");
	if(compteurGlobal==null){
		compteurGlobal=1; //new Integer(1);
	}else{
		compteurGlobal=compteurGlobal+1;
		              /* =new Integer(compteurGlobal.intValue()+1); */
	}
	application.setAttribute("compteurGlobal", compteurGlobal);
}
%>
<div>
date=<%=d %> , compteurPage<%=compteur %> , <%=nomEnSession %> , compteurGlobal=<%=compteurGlobal %>
</div>
<hr/>