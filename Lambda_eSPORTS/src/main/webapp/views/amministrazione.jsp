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
                    <img src="https://upload.wikimedia.org/wikipedia/commons/5/5c/Amazon_Lambda_architecture_logo.svg" alt="Lambda Esports Logo" class="logo-img-img">
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
          <!-- Contenuto principale della pagina amministrativa -->
        <main class="admin-panel">
            <div class="PA"><h1>Pannello di Amministrazione Tornei</h1></div>
             <!-- Sezione per la gestione dei tornei -->
            <section class="tornei">
                <div class="GT"><h2>Gestione Tornei</h2></div>
                <table>
                    <thead>
                        <tr>
                            <th>Nome Torneo</th>
                            <th>Gioco</th>
                            <th>Data</th>
                            <th>Partecipanti</th>
                            <th>Stato</th>
                            <th>Azioni</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>FIFA Champions</td>
                            <td>FIFA 24</td>
                            <td>20/02/2025</td>
                            <td>16</td>
                            <td>Attivo</td>
                            <td>
                                <a href="adminTorneo.html">
                                    <button>Modifica</button>
                                </a>
                                <button class="delete">Elimina</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </section>
            
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
    <div id="popup-conferma" class="popup">
        <p>Vuoi davvero eliminare il torneo?</p>
        <button id="confirm-yes">SÃ¬</button>
        <button id="confirm-no">No</button>
    </div>
    </html>
