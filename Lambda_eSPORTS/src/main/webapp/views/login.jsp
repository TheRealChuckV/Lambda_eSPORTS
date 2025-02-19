<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="/style/login.css"> <!-- Collegamento al CSS -->
</head>
<body>

    <div class="container">
        <header class="header">
            <h1 class="logo">
                <a href="/views/home.jsp">
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
                    <li><a href="classifica.html" class="nav-item">CLASSIFICA</a></li>
                    <li><p class="separator">|</p></li>
                    <li><a href="tornei.html" class="nav-item">TORNEI</a></li>
                    <li><p class="separator">|</p></li>
                    <li><a href="areaPersonale.html" class="nav-item">AREA PERSONALE</a></li>
                </ul>
            </nav>
            <div class="user">
                <a href="login" class="nav-item">Login</a>
                <div class="user-icon">
                    <a href="login">
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

        <!-- Contenitore per il form di login -->
        <div class="login-container">
            <div class="login-box">
                <h2>Login</h2>
                <form id="login-form">
                    <div class="input-group">
                        <label for="username">Username</label>
                        <input type="text" id="username" placeholder="Inserisci il tuo username" required>
                    </div>
                    <div class="input-group">
                        <label for="password">Password</label>
                        <input type="password" id="password" placeholder="Inserisci la tua password" required>
                    </div>
                    <button type="submit">Accedi</button>
                    <a href="/players/preSignup" class="nav-item"><small>Se non hai un account Registrati qui.</small></a>
                </form>    
            </div>
        </div>

    </div>
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
</script>
</body>
</html>