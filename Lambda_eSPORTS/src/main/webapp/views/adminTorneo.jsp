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

	<h1>SCHEMA AD ALBERO</h1>
	<!-- Sezione per la gestione degli utenti -->
	<section class="moderazione">
		<div class="GU">
			<h2>Gestione Utenti Torneo</h2>
		</div>
		<table>
			<thead>
				<tr>
					<th>Nome Utente</th>
					<th>Email</th>
					<th>Azione</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Gamer123</td>
					<td>gamer123@mail.com</td>
					<td><button class="ban">Banna</button></td>
				</tr>
				<tr>
					<td>peppino24</td>
					<td>peppino24@mail.com</td>
					<td><button class="ban">Banna</button></td>
				</tr>
				<tr>
					<td>lello4563</td>
					<td>meorili@mail.com</td>
					<td><button class="ban">Banna</button></td>
				</tr>
				<tr>
					<td>Gamer8976</td>
					<td>gamer8976@mail.com</td>
					<td><button class="ban">Banna</button></td>
				</tr>
				<tr>
					<td>alebrest</td>
					<td>poppella23@mail.com</td>
					<td><button class="ban">Banna</button></td>
				</tr>
			</tbody>
		</table>
	</section>
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

document.querySelectorAll(".ban").forEach(button => {
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
	<div id="popup-conferma" class="popup">
		<p>Vuoi bannare questo giocatore dal torneo?</p>
		<button id="confirm-yes">Sì</button>
		<button id="confirm-no">No</button>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>