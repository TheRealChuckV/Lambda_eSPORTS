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

    <main class="profile-container">
        <div class="AP"><h1>Area Personale</h1></div>
        <table class="stats-table">
            <thead>
                <tr>
                    <th>Statistiche</th>
                    <th>Valore</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Tornei Conclusi</td>
                    <td>12</td>
                </tr>
                <tr>
                    <td>Tornei Attivi</td>
                    <td>3</td>
                </tr>
                <tr>
                    <td>Vittorie</td>
                    <td>7</td>
                </tr>
                <tr>
                    <td>Sconfitte</td>
                    <td>5</td>
                </tr>               
            </tbody>
            </table>
            <a href="amministrazione.jsp">
                <button class="adimn-btn">Gestisci i tuoi Tornei</button>
            </a>
        </table>
    </main>
    <main class="opzioni-profilo">
        <div class="AP1"><h1>Opzioni Profilo</h1></div>

        <div class="menu-item">
            <button class="menu-button" onclick="toggleMenu('menu1')">
                Cambia Immagine Del Profilo
                <span class="arrow">▶</span>
            </button>
            <div id="menu1" class="submenu">
                <div class="cambia-img-box">
                    
                        <button class="submenu-button"><img src="https://steamuserimages-a.akamaihd.net/ugc/1747939657394338324/FDFD5DB7953891BFEBE7B07934CA912E6C9DA07F/?imw=128&imh=128&ima=fit&impolicy=Letterbox&imcolor=%23000000&letterbox=true" alt="User img" class="user-img"></button>
                        <button class="submenu-button"><img src="https://discover.therookies.co/content/images/2024/08/11-2.jpg" alt="User img" class="user-img"></button>
                        <button class="submenu-button"><img src="https://mmonster.co/media/86/9a/cb/1720545549/Ghost%202.webp" alt="User img" class="user-img"></button>
                        <button class="submenu-button"><img src="https://cdn.buymeacoffee.com/uploads/rewards/2024-10-05/1/010925_image_20241005_090846.png@1200w_0e.png" alt="User img" class="user-img"></button>
                        <button class="submenu-button"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/SSC_Napoli_2007.svg/1200px-SSC_Napoli_2007.svg.png" alt="User img" class="user-img"></button>
                        <button class="submenu-button"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT40FgGaqeEWlQOdPuV6fda_slV-2Hg3oKRvw&s" alt="User img" class="user-img"></button>
                        <button class="submenu-button"><img src="https://d2sj0xby2hzqoy.cloudfront.net/kenwood_italy/attachments/data/000/007/298/original/pisarei-e-faso.jpg" alt="User img" class="user-img"></button>
                        <button class="submenu-button"><img src="https://www.crispoconfetti.com/wp-content/uploads/2020/06/gianduiotti_500.png" alt="User img" class="user-img"></button>
                        <button class="submenu-button"><img src="https://media-assets.lacucinaitaliana.it/photos/62541d6b730f42fd1361798d/16:9/w_1280,c_limit/271888375_1806730932845452_6147063218737332404_n.jpg" alt="User img" class="user-img"></button>
                    <form id="cambia-img-profilo">    
                        <br><button class="conferma-img">Conferma </button>
                    </form>
                </div>

            </div>
        </div>

        <!-- Sezione 2 -->
        <div class="menu-item">
            <button class="menu-button" onclick="toggleMenu('menu2')">
                Cambia Username
                <span class="arrow">▶</span>
            </button>
            <div id="menu2" class="submenu">
                <div class="cambia-username-cont">
                    <div class="cambia-username-box">
                        <h2>Inserisci il nuovo Username!</h2>
                        <form id="usn-form">
                            <div class="input-usn">
                                <label for="name">Nuovo Username</label>
                                <input type="text" id="username" placeholder="Inserisci il nuovo Username" oninput="checkInput()">
                            </div>
                            <button id="submitButton" disabled>Conferma nuovo Username</button>
                        </form>    
                    </div>
                </div>
            </div>
        </div>

        <!-- Sezione 3 -->
        <div class="menu-item">
            <button class="menu-button" onclick="toggleMenu('menu3')">
                Cambia Password
                <span class="arrow">▶</span>
            </button>
            <div id="menu3" class="submenu">
                <div class="cambia-pw-cont">
                    <div class="cambia-pw-box">
                        <h2>Cambia Password</h2>
                        <form id="reg-form">
                            <div class="input-pw">
                                <label for="current-password">Password Corrente</label>
                                <div class="pw-container">
                                    <input type="password" id="current-password" placeholder="Inserisci la Password Attuale" required>
                                    <span class="toggle-pw" onclick="togglePassword('current-password', 'eye-icon3')">
                                        <img id="eye-icon3" src="https://cdn-icons-png.flaticon.com/512/2767/2767146.png" alt="Mostra password">
                                    </span>
                                </div>
                            </div>
                            
                            <div class="input-pw">
                                <label for="new-password">Nuova Password</label>
                                <div class="pw-container">
                                    <input type="password" id="new-password" placeholder="Inserisci la Nuova Password" required>
                                    <span class="toggle-pw" onclick="togglePassword('new-password', 'eye-icon1')">
                                        <img id="eye-icon1" src="https://cdn-icons-png.flaticon.com/512/2767/2767146.png" alt="Mostra password">
                                    </span>
                                </div>
                            </div>
                            
                            <div class="input-pw">
                                <label for="confirm-password">Conferma Password</label>
                                <div class="pw-container">
                                    <input type="password" id="confirm-password" placeholder="Conferma la Nuova Password" required>
                                    <span class="toggle-pw" onclick="togglePassword('confirm-password', 'eye-icon2')">
                                        <img id="eye-icon2" src="https://cdn-icons-png.flaticon.com/512/2767/2767146.png" alt="Mostra password">
                                    </span>
                                </div>
                                <small id="password-error" style="color: red; display: none;">⚠️ Le password non coincidono!</small>
                            </div>
                                
                            
                            
                            <button type="submit" id="register-btn" disabled>Cambia Password</button>
                        </form>    
                    </div>
                </div>
            </div>
        </div>

        
        <button class="disconnetti">Disconnetti Account</button>

        

    </main>
        <%@ include file="footer.jsp" %>
</body>
<script>
document.addEventListener("DOMContentLoaded", function () {
    let newPassword = document.getElementById("new-password");
    let confirmPassword = document.getElementById("confirm-password");
    let errorMessage = document.getElementById("password-error");
    let submitButton = document.getElementById("register-btn");

    function checkPasswords() {
        if (newPassword.value !== confirmPassword.value) {
            errorMessage.style.display = "block"; // Mostra il messaggio di errore
            submitButton.disabled = true; // Disabilita il pulsante
        } else {
            errorMessage.style.display = "none"; // Nasconde il messaggio di errore
            submitButton.disabled = false; // Abilita il pulsante
        }
    }

    // Controlla ogni volta che l'utente digita
    newPassword.addEventListener("input", checkPasswords);
    confirmPassword.addEventListener("input", checkPasswords);
});
function checkInput() {
    let input = document.getElementById("username");
    let button = document.getElementById("submitButton");

    if (input.value.trim() !== "") {
        button.disabled = false; // Abilita il pulsante
    } else {
        button.disabled = true; // Disabilita se il campo è vuoto
    }
}

function togglePassword(fieldId, iconId) {
    let field = document.getElementById(fieldId);
    let icon = document.getElementById(iconId);

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
    function toggleMenu(menuId) {
    let menu = document.getElementById(menuId);
    let button = menu.previousElementSibling; // Pulsante della sezione

    menu.classList.toggle("active"); // Mostra/nasconde il menu
    button.classList.toggle("active"); // Ruota la freccetta
}
document.addEventListener("DOMContentLoaded", function () {
    // Seleziona tutti i bottoni delle opzioni
    let buttons = document.querySelectorAll(".submenu-button");

    buttons.forEach(button => {
        button.addEventListener("click", function () {
            // Rimuove la classe 'selected' da tutti i bottoni
            buttons.forEach(btn => btn.classList.remove("selected"));

            // Aggiunge la classe 'selected' al bottone cliccato
            this.classList.add("selected");
        });
    });
});
</script>
</html>