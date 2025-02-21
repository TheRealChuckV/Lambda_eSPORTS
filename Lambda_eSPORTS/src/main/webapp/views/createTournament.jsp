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
				<select id="game" name="game" required onchange="cambiaImmagine()">
					<c:forEach var="game" items="${gameForm}">
						<option value="${game.id}"
							data-game='{"id":"${game.id}", "name":"${game.name}", "image":"${game.image}"}'>
							${game.name}</option>
					</c:forEach>
				</select>

				<!-- Carosello -->
				<div class="carousel">
					<div class="slides" id="slides-container">
						<c:forEach var="game" items="${gameForm}" varStatus="status">
							<div class="slide ${status.first ? 'active' : ''}"
								data-game-id="${game.id}">
								<input type="hidden" class="game-img-hidden" name="gameImage">
								<img class="game-img" alt="${game.id}" src="${game.image}">
								<div class="game-title">${game.name}</div>
							</div>
						</c:forEach>
					</div>

					<!-- Pulsanti di navigazione -->
					<div class="prev-btn" onclick="moveSlide(-1)">&#10094;</div>
					<div class="next-btn" onclick="moveSlide(1)">&#10095;</div>

					<!-- Indicatori numerati -->
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
let currentSlide = 0;
let slides = [];
let indicators = [];
let gameValues = [];

// **LEGGE I DATI DIRETTAMENTE DALLA JSP**
let games = [
    <c:forEach var="game" items="${gameForm}" varStatus="status">
        { id: "${game.id}", name: "${game.name}", image: "${game.image}" }<c:if test="${!status.last}">,</c:if>
    </c:forEach>
];



// **Funzione per inizializzare i dati dinamicamente**
function initCarousel() {
    slides = document.querySelectorAll(".slide");
    indicators = document.querySelectorAll(".indicator");

    // **Recupera i valori dei giochi dalla select**
    gameValues = Array.from(document.querySelectorAll("#game option")).map(option => option.value);

    showSlide(0); // Mostra la prima slide
}

function updateImageAndInput() {
    // Trova la slide attiva
    const activeSlide = slides[currentSlide];
    
    // Trova l'immagine e l'input all'interno della slide attiva
    const gameImg = activeSlide.querySelector("img");
    const gameInput = document.getElementById('selected-game-img');

    // Aggiorna l'immagine
    const imageSrc = gameImg.getAttribute('src');
    document.getElementById('game-img').src = imageSrc;
    
    // Aggiorna il valore dell'input nascosto
    const gameId = gameImg.getAttribute('alt');
    gameInput.value = gameId;
}

// **Mostra la slide corretta**
function showSlide(index) {
    if (index >= slides.length) { currentSlide = 0; }
    else if (index < 0) { currentSlide = slides.length - 1; }
    else { currentSlide = index; }

    document.querySelector(".slides").style.transform = `translateX(${-currentSlide * 100}%)`;

    indicators.forEach((indicator, i) => {
        indicator.classList.toggle("active", i === currentSlide);
    });

    aggiornaLabelGioco(); // Aggiorna la select
}

// **Aggiorna la select in base alla slide attuale**
function aggiornaLabelGioco() {
    const gameSelect = document.getElementById("game");
    if (gameValues[currentSlide]) {
        gameSelect.value = gameValues[currentSlide];
    }
}

// **Sposta avanti/indietro le slide**
function moveSlide(step) {
    currentSlide = (currentSlide + step + slides.length) % slides.length; // Calcola l'indice della slide corrente
    showSlide(currentSlide); // Mostra la slide corretta
}

// **Vai direttamente a una slide specifica**
function goToSlide(index) {
    if (index >= slides.length) index = 0;
    if (index < 0) index = slides.length - 1;

    currentSlide = index;

    slides.forEach((slide, i) => {
        slide.classList.toggle("active", i === currentSlide);
    });

    indicators.forEach((indicator, i) => {
        indicator.classList.toggle("active", i === currentSlide);
    });

    // Trova la slide attiva
    const activeSlide = slides[currentSlide];
    const gameId = activeSlide.getAttribute("data-game-id");
    const gameImg = activeSlide.querySelector(".game-img").src;
    
    // Aggiorna la select
    document.getElementById("game").value = gameId;

    // Aggiorna l'input nascosto
    document.querySelector(".game-img-hidden").value = gameImg;
}

// **Quando cambia la select, aggiorna il carousel**
function cambiaImmagine() {
    const selectedOption = document.getElementById('game').selectedOptions[0];
    const gameId = selectedOption.value;

    // Trova l’indice della slide corrispondente
    const gameIndex = games.findIndex(game => game.id === gameId);

    if (gameIndex !== -1) {
        goToSlide(gameIndex); // Cambia la slide nel carosello
    }
}


function updateCarousel(gameId) {
    // Trova l'indice del gioco selezionato
    const gameImages = document.querySelectorAll('.carousel img');
    const slides = document.querySelectorAll('.slide');
    
    // Reset della classe 'active' a tutte le slide
    slides.forEach(slide => slide.classList.remove('active'));

    gameImages.forEach((img, index) => {
        // Identifica la slide del gioco selezionato in base al gameId
        if (img.alt.toLowerCase() === gameId.toLowerCase()) {
            slides[index].classList.add('active'); // Aggiungi la classe active alla slide selezionata
        }
    });
}


// **Avvia il tutto quando la pagina è caricata**
window.onload = initCarousel;
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