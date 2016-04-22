<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des articles</title>
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.6-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.6-dist/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="CSS/style_general.css">

</head>
<header>
<div class="container">
	<div class="row">
	</div>
	<div class="row">
		<div class="col-sm-3">
			<div class="card">
			<canvas class="header-bg" width="250" height="70" id="header-blur"></canvas>
			<div class="avatar">
				<img src="" alt=""/>
				</div>
				<div class="content">
					<c:if test="${not empty sessionScope.nomUser}">
					
					<p>${sessionScope.nomUser} est connecté</p>
					<br/>
				</div>
		</div>
	</div>
</div>

<img class="src-image"  src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMgAAADICAAAAACIM/FCAAAEk0lEQVR42u3bXUsUURjA8b7gmXHd3JU1SOmi9UYSLypbFBEk9sL1wkSqVRBbqBTDwJTNtG0rLBBJIgUzBGVdhMClYYrNefoAUbkzz8vZeP5fYObHvJ1zmHPB/CddUIhCFKIQhShEIQpRiEIUohCFKEQhClGIQhSiEIUoRCEKUYhCFKIQhShEIQpRiEIUohCFND3ESWcflnarPgCAX90tPcymneaDdI2/PYXfOn073tVMkOTExwD+UPBxItkkkPTyd/hr35fTTQBJlwL4Z0EpbTkktXQG5+psKWUzJFeDc1fLWQu59B4a6v0lOyH9X6HBvvbbCJk8g4Y7m7QO4i5CqBZduyDuOoRs3bUJ4pYhdGXXHoizChFadayBPIZIPbYFkoOI5eyA9PyICvnRYwOk7Qgid9RmAeQZIPRMHtIPKPVLQ2KHOJDDmDBkCpCakoW0e1gQr10UUgC0CpKQpIcH8ZKCkDwglpeDOMeYkGNHDJIB1DJikBe4kBdSkFYPF+K1CkEGAblBIcgTbMgTIcgXbMgXGUgiwIYECRHILUDvlgjkHj7knghkGR+yIgLZwodsiUCO8CFHIpBv+JBvEhAXCHIFIO0UkHaFKMQkKCAJAYihgIi8fj18hycCOcSHHIpAPuBDPohACAaNyyKQ+/iQ+yKQAXzIgAgkiT/VTYpAzAE25MDIQJ5iQ54KQQaxIVILdHEf1+HHhSBmDReyZqQgg9bcWREh7gmm48QVg5hpTMi0kYOkEB93PyUIMXN4kDkjCelAuyR+hyjEzGBBZowsJF7BcVTiwhAzhAMZMtIQ8xzDUTTykGQ1uqOatABieutRHfVeYwPE3IkKuWPsgJiFaI4FYwvEKUdxvLLnl3IT2wjv2IgZeyAm9ias4w2KA3EjzEo4x4plG2GMMdMhlrmCaayjY24WG6g16qgNGBsh5nKDvxBsXTYWQi5m8sWdxiA7xXzmol2QqzPbIccp9e2Zq7ZA2iY+Rfuyf5poswDSUahB5GqFDmFIfBZp0u7PxiUhw0gTXQCAyrAYJFUC1EopGUhfFZCr9klARuuAXn2UH/IASHrADZkDouZ4IWSOsJKQkCkgbIoPMhJQQoIRLki3D6T5aR5Iyz4Qt9/CAikAeQUOSO9PesjPa/QQZxcY2nXIIbeBpdvUkFiFB1KJEUNywFSOGPKZC/KZFnIT2LpBCnnJB1mjhLR6fJDGNrw2CBkGxoYJIauckFVCSJUTUqWDdAFrnWSQLC8kSwZ5xAt5RAYp80LKZJA9XsgeGaTGC6mRQQJeSEAFiQNzrUSQFDckRQS5wg25QgTp4Yb0EEFucEOuE0GGuCFDRJAsNyRLBBnnhowTQfLckDwRpMANKRBBFrkhi0SQIjekSAR5zQ0pE0E2uSGbRJAdbsgOEeSAG3JABDnhhpwQQTxuiEcEAfZoIAl+SIIE0skP6SSBdPNDukkgffyQPhJIhh+SIYGM8ENGSCBj/JAxEshdfshdEsgsP2SWBDLPD5kngSzxQ5ZIIOv8kHUSyDt+yAYJZJsfsk0C2eeH7JNAjvkhxySQU37I6blP7hdN51b86z3QIAAAAABJRU5ErkJggg=="/>


		<a href="LogoutCineRomeV2">se déconnecter</a><br/>
		<br />
		<form action="ListDesArticles" method="POST">
			<button type="submit" value="Voir mon panier" name="action" class="btn btn-lg btn-primary btn block">Voir mon Panier</button> <br/>
		</form>
	</c:if>
	<br/>
	<c:if test="${empty sessionScope.nomUser}">
		<a href="LoginController">se connecter</a>
		<br />

	</c:if>

	<a href="ListDesArticles">liste des articles</a> <br/><br/>
	
</header>
<body>
	<div class="container">
		<div class="row col-md-6 col-md-offset-2 custyle">
		<table class="table table-striped custab">
			<tr>
				<th>Type de l'article</th>
				<th>Prix HT</th>
				<th>Stock</th>
				<th>Pdesignation</th>
				<th>Reference</th>
				<!-- <th>Realisateur</th> -->
				<th>Titre</th>
				<th>Auteur</th>
				<th>Editeur</th>
				<th>Genre</th>
				<th class="texte-center">Action</th>
				<th></th>
				</tr>
					<tr>
				
	<fieldset>

		<legend>Articles : </legend>
	
		<c:forEach var="object_article" items="${listArticles}">
			<tr>
				<%-- 				<td>${object_article.getClass()}</td> --%>
				<td>${object_article.getClass().getName()}
				<td>${object_article.prixHt}</td>
				<td>${object_article.stock}</td>
				<td>${object_article.designation}</td>
				<td>${object_article.reference}</td>
				<td>${object_article.titre}</td>
				<%-- <c:if (objet_article instanceof BluRayCineRomeV2) > --%>
				<%-- 	<td>${(BluRayCineRomeV2)object_article.realisateur}</td> --%>
				<%-- 	</c:if> --%>
				<td>${object_article.auteur}</td>
				<td>${object_article.editeur}</td>
				<td>${object_article.genre}</td>
				<!-- <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span>Ajouter au panier</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span>Retirer</a></td> -->
			
				<td>
				
				<!-- <form action="ListDesArticles" method="POST"> -->
				<form action="ListDesArticles" method="POST">
					<p>
						<label> Qté : </label> <input type="text" value="" name="Qty"/>
						<input type="hidden" name="reference" value="${object_article.reference}" />
						<input type="submit" value="Ajouter" name="addItem"/> <!--class="text-center"><a class='btn btn-info btn-xs' href="#"><span class="glyphicon glyphicon-edit"></span>Ajouter au panier</a> -->
					</p>
				</form>
				</td>
				</tr>
				</c:forEach>
				</table>
				</div>
				<BR>
				</div>

		
	</fieldset>

	<div>${rechercheToutErreur}</div>

</body>
</html>