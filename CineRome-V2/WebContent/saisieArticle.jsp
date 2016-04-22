<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Saisie des informations</title>

<!-- <script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="Climatisation.js"></script> -->

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
		<form action="PanierCineRomeV2Controller" method="GET">
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
		<br />

	<br />
	<br />

	<form action="CineRomeV2Controller" method="POST" class="form-horizontal">
	<fieldset>
		<legend>Saisie d'un article</legend>
		<div class="form-group">

			<label class="col-md-4 control-label" for="category">Choisissez le type d'article</label>
			<%-- <input id="sourceNbId" type="text" value="${nom}" name="nom"/> --%>
			<%-- <span style="color:red">${nomErreur}</span>
	<span id="nbId" style="color:blue"></span> --%>
			<div class="col-md-4">
				<select name="typeArticle" id="category" class="form-control">
					<optgroup label="discographie">
						<option value="Livre">Livre</option>
						<option value="DVD">DVD</option>
						<option value="BluRay">BluRay</option>
					</optgroup>
				</select> 
				</div>
		</div>
		<div class="form-group">
				<br/> 
				<label class="col-md-4 control-label" for="price">prix (HT)</label>
				<div class="col-md-4">
				<input id="price" type="text" placeholder="entrez le prix" class="form-control input-md" required="" value="" name="prixHT" /><span style="color: red">${prixHTErreur}</span>
				</div>
		</div>
		<div class="form-group">		
				<label class="col-md-4 control-label" for="stock">stock</label>
				<div class="col-md-4">
				<input id="stock" type="text" placeholder="Entrez le stock" class="form-control input-md" required="" value="" name="stock" /><span	style="color: red">${stockErreur}</span>
				</div>
		</div>
		<div class="form-group">		
				<label class="col-md-4 control-label" for="designation">designation</label>
				<div class="col-md-4">
				<input id="designation" type="text" placeholder="Entrez la designationé" class="form-control input-md" required="" value="${designation}" name="designation"><span style="color: red">${designationErreur}</span>
				</div>
		</div>
		<div class="form-group">
				 <label class="col-md-4 control-label" for="reference">reference</label>
				 <div class="col-md-4">
				 <input id="reference" type="text" placeholder="Entrez la reference" class="form-control input-md" required="" value="${reference}" name="reference"><span style="color: red">${referenceErreur}</span>
				 </div>
		</div>
		<div class="form-group">
				<%-- <c:if test="${not empty Bluray}">  --%>
				<label class="col-md-4 control-label" for="realisateur">realisateur </label>
				<div class="col-md-4">
				<input id=realisateur type="text" placeholder="Entrez le realisateur" class="form-control input-md" required="" value="${realisateur}" name="realisateur"><span style="color: red">${realisateurErreur}</span>
				<%-- </c:if> --%>
				</div>
		</div>
		<div class="form-group">
				<label class="col-md-4 control-label" for="titre">titre </label>
				<div class="col-md-4">
				<input id="titre" type="text" placeholder="Entrez le titre" class="form-control input-md" required="" value="${titre}"	name="titre"><span style="color: red">${titreErreur}</span>
				</div>
		</div>
		
		<div class="form-group">
				<label class="col-md-4 control-label" for="auteur">auteur </label>
				<div class="col-md-4">
				<input id="auteur" type="text" placeholder="Entrez l'auteur" class="form-control input-md" required="" value="${auteur}" name="auteur"><span style="color: red">${auteurErreur}</span>
				</div>
		</div>
		
		<div class="form-group">
				<label class="col-md-4 control-label" for="editeur">editeur </label>
				<div class="col-md-4">
				<input id="editeur" type="text" placeholder="Entrez l'editeur" class="form-control input-md" required="" value="${editeur}"	name="editeur"><span style="color: red">${editeurErreur}</span>
				</div>
		</div>
		
		<div class="form-group">
				<label class="col-md-4 control-label" for="genre">genre </label>
				<div class="col-md-4">
				<input type="text" placeholder="Entrez le genre" class="form-control input-md" required="" value="${genre}" name="genre"><span style="color: red">${genreErreur}</span>
				</div>
		</div>
				<button type="submit" value="Valider" name="action"
					class="btn btn-lg btn-primary btn block">Valider</button>
	
	</fieldset>
	</form>


</body>

<footer>
 <script src="JS/imageJS.js"></script>
 <script src="bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</footer>
</html>