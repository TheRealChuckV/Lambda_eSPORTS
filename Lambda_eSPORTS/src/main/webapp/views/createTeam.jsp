<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crea il team</title>
<link rel="stylesheet" href="/style/amministration.css">
</head>
<body>

	<!-- Intestazione della pagina con logo e navigazione -->
	<header class="header">
		<h1 class="logo">
			<a href="home.html">
				<div class="logo-img">
					<img
						src="https://upload.wikimedia.org/wikipedia/commons/5/5c/Amazon_Lambda_architecture_logo.svg"
						alt="Lambda Esports Logo" class="logo-img-img">
					<div class="logo-text">
						<h2>LAMBDA ESPORTS</h2>
					</div>
				</div>
			</a>
		</h1>
		<nav>
			<ul class="nav-links">
				<li><a href="home.html" class="nav-item">HOME</a></li>
				<li><p class="separator">|</p></li>
				<li><a href="classifica.html" class="nav-item">CLASSIFICA</a></li>
				<li><p class="separator">|</p></li>
				<li><a href="tornei.html" class="nav-item">TORNEI</a></li>
				<li><p class="separator">|</p></li>
				<li><a href="areaPersonale.html" class="nav-item">AREA
						PERSONALE</a></li>
			</ul>
		</nav>

		<div class="user">
			<a href="login.html" class="nav-item">Login</a>
			<div class="user-icon">
				<a href="login.html"> <img
					src="https://www.iconpacks.net/icons/2/free-user-icon-3296-thumb.png"
					alt="User Icon">
				</a>
				<div class="dropdown-menu">
					<form id="login-form">
						<label for="email">Email:</label> <input type="email" id="email"
							placeholder="Inserisci email" required> <label
							for="password">Password:</label> <input type="password"
							id="password" placeholder="Inserisci password" required>

						<button type="submit">Accedi</button>
					</form>
				</div>
			</div>
		</div>
	</header>
	<main class="create-tournament">
		<div class="CT">
			<h1>Crea un nuovo Team</h1>
		</div>
		<div class="form-container">
			<form:form action="/teams/create" modelAttribute="teamForm"
				method="post">
				<label for="team-name">Nome Team</label>
				<form:input path="name" type="text" id="team-name"
					name="team-name" required="true" />
				<label for="url-name">URL immagine</label>
				<form:input path="logo" type="text" id="url-name"
					name="url-name" required="true" />
				<button type="submit">Crea Team</button>
			</form:form>
		</div>
	</main>
	</body>
</html>