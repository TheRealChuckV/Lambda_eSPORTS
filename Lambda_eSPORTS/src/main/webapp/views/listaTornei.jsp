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
            <a href="home.html">
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
                <li><a href="home.html" class="nav-item">HOME</a></li>
                <li><p class="separator">|</p></li>
                <li><a href="classifica.html" class="nav-item">CLASSIFICA</a></li>
                <li><p class="separator">|</p></li>
                <li><a href="tornei.html" class="nav-item">TORNEI</a></li>
                <li><p class="separator">|</p></li>
                <li><a href="areaPersonale.html" class="nav-item">AREA PERSONALE</a></li>
            </ul>
        </nav>
    
        <div class="user">
            <a href="login.html" class="nav-item">Login</a>
            <div class="user-icon">
                <a href="login.html">
                    <img src="https://www.iconpacks.net/icons/2/free-user-icon-3296-thumb.png" alt="User Icon">
                </a>
                <div class="dropdown-menu">
                    <form id="login-form">
                        <label for="email">Email:</label>
                        <input type="email" id="email" placeholder="Inserisci email" required>

                        <label for="password">Password:</label>
                        <input type="password" id="password" placeholder="Inserisci password" required>

                        <button type="submit">Accedi</button>
                    </form>
                </div>
            </div>
        </div>
    </header>
    
    <main class="tournament-list">
        <div class="Disp"><h1>Tornei Disponibili</h1></div>
        <table class="tournament-table">
            <thead>
                <tr>
                    <th>Nome Torneo</th>
                    <th>Gioco</th>
                    <th>Data</th>
                    <th>Posti Disponibili</th>
                    <th>Azioni</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Torneo CoD</td>
                    <td>Call Of Duty</td>
                    <td>20/02/2025</td>
                    <td>22/30</td>
                    <td><button class="join-btn">Iscriviti</button></td>
                </tr>
                <tr>
                    <td>Torneo FIFA</td>
                    <td>FIFA 2025</td>
                    <td>22/02/2025</td>
                    <td>8/32</td>
                    <td><button class="join-btn">Iscriviti</button></td>
                </tr>
                <tr>
                    <td>Torneo Valorant</td>
                    <td>Valorant</td>
                    <td>24/02/2025</td>
                    <td>10/10</td>
                    <td><button class="join-btn">Iscriviti</button></td>
                </tr>
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