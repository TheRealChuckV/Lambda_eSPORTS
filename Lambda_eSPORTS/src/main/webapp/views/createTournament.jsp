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
	<main class="create-tournament">
		<div class="CT">
			<h1>Crea un nuovo Torneo</h1>
		</div>
		<div class="form-container">
			<form:form action="/tournaments/addTournament"
				modelAttribute="tournamentForm" method="post">
				<label for="tournament-name">Nome Torneo</label>
				<form:input path="name" type="text" id="tournament-name"
					name="tournament-name" required="true" />

				<label for="game">Gioco</label>
				<select id="game" name="game" required onchange="changeSlide()">
					<c:forEach var="game" items="${gameForm}">
						<!-- L'attributo value DEVE corrispondere a data-game-id -->
						<option value="${game.id}" data-game-id="${game.id}"
							data-game-image="${game.image}">${game.name}</option>
					</c:forEach>
				</select>

				<!-- Carosello -->
				<div class="carousel-container">
					<div class="carousel">
						<div class="slides" id="slides-container">
							<c:forEach var="game" items="${gameForm}" varStatus="status">
								<div class="slide ${status.first ? 'active' : ''}"
									data-game-id="${game.id}">
									<input type="hidden" class="game-img-hidden" name="gameImage">
									<img class="game-img" alt="${game.name}" src="${game.image}">
									<div class="game-title">${game.name}</div>
								</div>
							</c:forEach>
						</div>
						<button class="prev-btn">&#10094;</button>
						<button class="next-btn">&#10095;</button>
					</div>
					<div class="carousel-indicators">
						<c:forEach var="game" items="${gameForm}" varStatus="status">
							<span class="indicator" onclick="goToSlide(${status.index})">${status.index + 1}</span>
						</c:forEach>
					</div>
				</div>

				<label for="date">Data</label>
				<form:input path="startDate" type="date" id="date" name="date"
					required="true" />

				<label for="numSquadre">Numero di squadre:</label>
				<select id="numSquadre" onchange="aggiornaPartecipanti()">
					<option value="2">2</option>
					<option value="4">4</option>
					<option value="8">8</option>
					<option value="16">16</option>
				</select>

				<label for="giocatoriPerSquadra">Giocatori per squadra:</label>
				<select id="giocatoriPerSquadra" onchange="aggiornaPartecipanti()">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
				<form:input path="teamSize" type="hidden" id="teamSize"
					name="teamSize" />
				<script type="text/javascript">
    // Recupera il numero di partecipanti dal <span> e imposta il valore del campo nascosto
    					document.getElementById('teamSize').value = document.getElementById('giocatoriPerSquadra').value;
						</script>
				<h3>
					Partecipanti Totali: <span id="partecipantiTotali">2</span>
					<form:input path="nPlayer" type="hidden" id="nPlayer"
						name="nPlayer" />
				</h3>
				<script type="text/javascript">
    // Recupera il numero di partecipanti dal <span> e imposta il valore del campo nascosto
    					document.getElementById('nPlayer').value = document.getElementById('partecipantiTotali').innerText;
						</script>
				<button type="submit" class="submit-btn">Crea Torneo</button>
			</form:form>
		</div>
	</main>

	<!-- SCRIPT PER GESTIRE IL CAROUSEL -->
		<script>
	document.addEventListener("DOMContentLoaded", function () {
	    const carousel = document.querySelector(".carousel .slides");
	    const slides = document.querySelectorAll(".slide");
	    const selectGame = document.getElementById("game");
	    const nextButton = document.querySelector(".next-btn");
	    const prevButton = document.querySelector(".prev-btn");
	    const indicators = document.querySelectorAll(".indicator"); // Aggiungi questa riga per selezionare i pulsanti numerati
	    let currentIndex = 0;

	    function updateCarousel() {
	        slides.forEach((slide, index) => {
	            if (index === currentIndex) {
	                slide.style.opacity = "1";
	                slide.style.zIndex = "1";
	            } else {
	                slide.style.opacity = "0";
	                slide.style.zIndex = "0";
	            }
	        });
	        selectGame.value = slides[currentIndex].dataset.gameId;
	        // Aggiorna l'aspetto dei pulsanti numerati
	        indicators.forEach((indicator, index) => {
	            if (index === currentIndex) {
	                indicator.classList.add("active"); // Aggiungi una classe active al pulsante selezionato
	            } else {
	                indicator.classList.remove("active");
	            }
	        });
	    }

	    selectGame.addEventListener("change", function () {
	        const selectedGame = selectGame.value;
	        slides.forEach((slide, index) => {
	            if (slide.dataset.gameId === selectedGame) {
	                currentIndex = index;
	                updateCarousel();
	            }
	        });
	    });

	    nextButton.addEventListener("click", function () {
	        if (currentIndex < slides.length - 1) {
	            currentIndex++;
	        } else {
	            currentIndex = 0;
	        }
	        updateCarousel();
	    });

	    prevButton.addEventListener("click", function () {
	        if (currentIndex > 0) {
	            currentIndex--;
	        } else {
	            currentIndex = slides.length - 1;
	        }
	        updateCarousel();
	    });

	    // Implementa la funzione goToSlide
	    function goToSlide(index) {
	        currentIndex = index;
	        updateCarousel();
	    }

	    // Collega i pulsanti numerati alla funzione goToSlide
	    indicators.forEach((indicator, index) => {
	        indicator.addEventListener("click", function() {
	            goToSlide(index);
	        });
	    });

	    updateCarousel();
	});
</script>

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
    
    function aggiornaPartecipanti() {
        let numSquadre = document.getElementById("numSquadre").value;
        let giocatoriPerSquadra = document.getElementById("giocatoriPerSquadra").value;
        let partecipantiTotali = numSquadre * giocatoriPerSquadra;
        document.getElementById("partecipantiTotali").textContent = partecipantiTotali;
    }

</script>
</html>