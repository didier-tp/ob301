<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.ib.tp.entity.Produit,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>produits</title>
</head>
<body>
    <!--  formulaire avec categorie (de produits recherchés)
          submit , "rechercher produits"
          action="ProduitMvcServlet"  -->
    <form action="./ProduitMvcServlet" method="GET">
        categorie: <input name="categorie" value="${requestScope.rechercheProduits.categorie}" /> (ex: divers , cd) <br/>
	   <input type="submit" value="rechercher produits" /> <br/>
    </form>      
   <!-- liste des produits trouvés ,
       afficher directement ${requestScope.produits} -->  
     liste produits: ${requestScope.produits} <!-- ou bien requestScope.rechercheProduits.produits  --> 
    <table border="1" >
     <tr><th>num</th><th>label</th><th>prix</th></tr>
     <%
     List<Produit> produits= (List<Produit>)request.getAttribute("produits");
     if(produits!=null){
     for(Produit p :produits){
    	 %>
    	 <tr><td><%=p.getNum()%></td><td><%=p.getLabel()%></td><td><%=p.getPrix()%></td></tr>
     <%}
     }
     %>
     </table>
     
</body>
</html>