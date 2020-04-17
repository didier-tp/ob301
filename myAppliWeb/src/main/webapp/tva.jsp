<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.ib.tp.dto.ResTva,java.util.List,java.util.ArrayList"
    %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>tva</title>
</head>
<%
List<Double> listeTaux = null;
synchronized(application){
   listeTaux = (List<Double>) application.getAttribute("listeTaux");
   if(listeTaux==null){
	  System.out.println("simulation acces base de donnees");
	  listeTaux = new ArrayList<>();
      listeTaux.add(33.33);listeTaux.add(20.0);listeTaux.add(10.0);listeTaux.add(5.0);
      //ou bien une recherche (couteuse en temps) dans une base de donnees
      application.setAttribute("listeTaux", listeTaux);
      //mettre en cache
     
   }else{
	   System.out.println("valeur récupée en chache dans objet application");
   }
}

String sHt = request.getParameter("ht");
int ht = (sHt==null)?0:Integer.parseInt(sHt);
String sTaux = request.getParameter("taux");
double taux = (sTaux==null)?0:Double.parseDouble(sTaux);
pageContext.setAttribute("taux", taux); //pour que taux soit visible plus bas avec syntaxe ${taux} 
double tva = ht * taux/100.0;
pageContext.setAttribute("tva", tva);
double ttc = tva + ht;
ResTva resTva = new ResTva(ht,taux,tva,ttc);
pageContext.setAttribute("resTva", resTva);
%>
<body>
    <%@ include file="entete.jsp" %>
	<form >
	   ht: <input name="ht" value="<%=ht%>"/> <br/>
	  <!--  taux (sans jstl): <select >
	         <%for(Double t : listeTaux) {%>
	   			<option <%if (taux == t) {%> selected<%} %> > <%=t %></option>
	   			<%} %>
	         </select> <br/> -->
	   taux (avec jstl): <select name="taux" >
	         <c:forEach var="t" items="${listeTaux}">
	           <c:choose>
	              <c:when test="${t == taux}">
	                   <option selected> ${t} </option>
	              </c:when>
	              <c:otherwise>
	                   <option > ${t} </option> 
	              </c:otherwise>
	           </c:choose>
	   		</c:forEach>
	         </select> <br/>
	   <input type="submit" value="calculer tva" /> 
	</form>
	tva=<b><fmt:formatNumber value="${tva}" pattern=".00"/></b><br/>
	ttc=<b>${resTva.ttc}</b><br/>
	<%@ include file="piedPage.jsp" %>
</body>
</html>