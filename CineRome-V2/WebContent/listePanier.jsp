<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<a href="ListDesArticles">Revenir à la liste des articles</a><br/>

<title>Mon panier</title>

<p> Voici la liste de votre panier : </p>

<p> Le panier :  ${sessionScope.panier}</p>
<p> La liste du panier :  ${sessionScope.panier.listPanier}</p>

<c:forEach var="object_panier" items="${sessionScope.panier.listPanier}">
			<tr>
				<td>${object_panier.prixHt}</td>
				<td>${object_panier.stock}</td>
				<td>${object_panier.designation}</td>
				<td>${object_panier.reference}</td>
				<%-- <td>${object_panier.realisateur}</td> --%>
				<td>${object_panier.titre}</td>
				<td>${object_panier.auteur}</td>
				<td>${object_panier.editeur}</td>
				<td>${object_panier.genre}</td>
				<td><form action="PanierCineRomeV2Controller" method="POST">
					<p>
						<label> Qté : </label> <input type="text" value="" name="Qty"/>
						<input type="hidden" name="reference" value="${object_article.reference}" />
						<input type="submit" value="Retirer" name="rmItem"/>
					</p>
					</form>
				</td>
			</tr>
		</c:forEach>
		

		
<form action="PanierCineRomeV2Controller" method="POST">
<p>Valider votre panier </p>
<input type="submit" value= "validation" name="paniervalide"><br/>
</form>
</head>
<body>

</body>
</html>