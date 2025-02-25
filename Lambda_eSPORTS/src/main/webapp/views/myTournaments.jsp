<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="/style/amministration.css">

</head>
<body>
	<!-- Intestazione della pagina con logo e navigazione -->
	<header class="header">
		<h1 class="logo">
			<a href="/views/home.jsp">
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
                <li><a href="/views/home.jsp" class="nav-item">HOME</a></li>
                <li><p class="separator">|</p></li>
                <li><a href="/views/ranking.jsp" class="nav-item">CLASSIFICA</a></li>
                <li><p class="separator">|</p></li>
                <li><a href="/views/tournaments.jsp" class="nav-item">TORNEI</a></li>
                <li><p class="separator">|</p></li>
                <li><a href="/views/areaPersonale.jsp" class="nav-item">AREA PERSONALE</a></li>
            </ul>
		</nav>


	</header>

	<div class="partecipazioni">
		<h1>Tornei a cui partecipi</h1>
	</div>
	<table class="lista-partecipazioni">
		<thead>
			<tr>
				<th>Nome Torneo</th>
				<th>Gioco</th>
				<th>Gestisci</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tournament" items="${myTournaments}">
				<tr>
					<td>${tournament.name}</td>
					<td>${tournament.game.name}</td>
					<td><form action="/tournaments/view/${tournament.id}"
							method="get" style="display: inline;">
							<button class="edit" type="submit">
								Visualizza</button>
						</form>
						<form action="/tournaments/leave/${tournament.id}" method="post" style="display:inline;">
                            <button type="submit" onclick="return confirm('Sei sicuro di voler abbandonare il torneo?');">
                                Abbandona
                            </button>
                        </form></td>
			</c:forEach>
			
			
		</tbody>
		
	</table>

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
            const userIcon = document.querySelector(".user-icon");
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
            document.addEventListener("DOMContentLoaded", function () {
    const popup = document.getElementById("popup-conferma");
    const confirmYes = document.getElementById("confirm-yes");
    const confirmNo = document.getElementById("confirm-no");
    let currentButton = null;

    document.querySelectorAll(".delete").forEach(button => {
        button.addEventListener("click", function (event) {
            event.preventDefault();
            currentButton = this;

            // Posiziona il popup vicino al pulsante
            const rect = this.getBoundingClientRect();
            popup.style.top = `${window.scrollY + rect.top + 30}px`;
            popup.style.left = `${window.scrollX + rect.left}px`;

            popup.style.display = "block";
        });
    });

    confirmYes.addEventListener("click", function () {
        if (currentButton) {
            currentButton.closest("tr").remove();
        }
        popup.style.display = "none";
    });

    confirmNo.addEventListener("click", function () {
        popup.style.display = "none";
    });
});
        </script>
</body>

</html>