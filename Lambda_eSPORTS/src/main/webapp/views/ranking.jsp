<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Classifica - Lambda Esports</title>
<link rel="stylesheet" href="/style/amministration.css">
<link rel="stylesheet" href="/style/footer.css">
</head>
<body>
	<!-- Intestazione della pagina con logo e navigazione -->
	<header class="header">
		<h1 class="logo">
			<a href="home.jsp">
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
                <li><a href="home.jsp" class="nav-item">HOME</a></li>
                <li><p class="separator">|</p></li>
                <li><a href="ranking.jsp" class="nav-item">CLASSIFICA</a></li>
                <li><p class="separator">|</p></li>
                <li><a href="tournaments.jsp" class="nav-item">TORNEI</a></li>
                <li><p class="separator">|</p></li>
                <li><a href="areaPersonale.jsp" class="nav-item">AREA PERSONALE</a></li>
            </ul>
		</nav>

		
	</header>
	<main class="ranking-panel">
		<div class="rank">
			<h1>Classifica Generale</h1>
		</div>
		<table>
			<thead>
				<tr>
					<th>Posizione</th>
					<th>Giocatore</th>
					<th>Punteggio</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="player" items="${players}" varStatus="status">
					<tr class="${status.index == 0 ? 'first-rank' : (status.index == 1 ? 'second-rank' : (status.index == 2 ? 'third-rank' : ''))}">
						<td>${status.index + 1}</td>
						<%-- Mostra il numero della posizione --%>
						<td>${player.username}</td>
						<td>${player.score}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
	<%@ include file="footer.jsp" %>
</body>
<script>
    function togglePassword(fieldId, iconId) {
        var field = document.getElementById(fieldId);
        var icon = document.getElementById(iconId);

        if (field.type === "password") {
            field.type = "text";
            icon.src = "https://cdn-icons-png.flaticon.com/512/159/159604.png"; // Occhio aperto
        } else {
            field.type = "password";
            icon.src = "https://cdn-icons-png.flaticon.com/512/2767/2767146.png"; // Occhio chiuso
        }
    }

    let hideTimeout;
    const userIcon = document.querySelector(".user-icon img");
    const dropdownMenu = document.querySelector(".dropdown-menu");

    userIcon.addEventListener("mouseenter", () => {
        clearTimeout(hideTimeout);
        dropdownMenu.style.display = "block";
    });

    userIcon.addEventListener("mouseleave", () => {
        hideTimeout = setTimeout(() => {
            dropdownMenu.style.display = "none";
        }, 3000);
    });

    dropdownMenu.addEventListener("mouseenter", () => {
        clearTimeout(hideTimeout);
    });

    dropdownMenu.addEventListener("mouseleave", () => {
        hideTimeout = setTimeout(() => {
            dropdownMenu.style.display = "none";
        }, 3000);
    });
</script>
</html>