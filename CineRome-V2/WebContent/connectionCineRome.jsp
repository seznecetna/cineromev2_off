<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connection à CineRome</title>
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.6-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="bootstrap-3.3.6-dist/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="CSS/style_general.css">

</head>
<body>
	<div id="fullscrenn_bg" class="fullscreen_bg">
		<div class="container">
			<form action="LoginController" method="POST" class="form-signin">
				<h1 class="form-signin-heading text-muted">Sign In</h1>
				<input type="text" value="" name="nomUser" class="form-control"
					placeholder="Entrez un nom" required="" autofocus="" /><br />
				<button type="submit" value="Connection" name="connect"
					class="btn btn-lg btn-primary btn block">Sign In</button>
			</form>
		</div>
	</div>
</body>
</html>