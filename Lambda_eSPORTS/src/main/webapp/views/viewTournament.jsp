<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Crea Torneo - Lambda Esports</title>
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
	<main class="view-tournament">
		<div>
		
			<form action="/teams/create" method="get">
				<button type="submit">Crea Team</button>
				<input  type="hidden" name="teamSize"
					value="${tournament.teamSize}" />
			</form>
		</div>
		<div>
			<h2>Lista Team</h2>
			<table class="lista-partecipazioni">
				<thead>
					<tr>
						<th>Icona</th>
						<th>Nome Team</th>
						<th>Gestisci</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="team" items="${tournament.teams}">
						<tr>
							<td><img src="${team.logo}" alt="Icona Team"></td>
							<td>${team.name}</td>
							<td>
								<ul class="player-list">
									<c:forEach var="player" items="${team.players}">
										<li>${player.username}</li>
									</c:forEach>
								</ul>
							</td>
							<td>
								<form action="/teams/${team.id}" method="get"
									style="display: inline;">
									<button class="edit" type="submit">Entra</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</main>

</body>
</html>