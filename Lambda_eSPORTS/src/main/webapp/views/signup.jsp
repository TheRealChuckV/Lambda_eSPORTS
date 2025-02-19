<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrazione</title>
    <link rel="stylesheet" href="/style/signup.css"> <!-- Collegamento al CSS -->
</head>
<body>
    <script>
    function togglePassword(fieldId, iconId) {
    	console.log("ciao");
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
    document.addEventListener("DOMContentLoaded", function() {
        let today = new Date();
        let minAge = 16;
        let maxDate = new Date(today.getFullYear() - minAge, today.getMonth(), today.getDate());
        document.getElementById("dob").setAttribute("max", maxDate.toISOString().split("T")[0]);

        const password = document.getElementById("password");
        const confirmPassword = document.getElementById("confirm-password");
        const registerBtn = document.getElementById("register-btn");
        const form = document.getElementById("reg-form");
        const passwordError = document.getElementById("password-error");
        
        

        function validateForm() {
            const inputs = form.querySelectorAll("input[required]");
            let allFilled = true;

            // Verifica che tutti i campi obbligatori siano riempiti
            inputs.forEach(input => {
                if (!input.value.trim()) {
                    allFilled = false;
                }
            });

            // Verifica se le password corrispondono e se tutti i campi obbligatori sono riempiti
            if (password.value !== confirmPassword.value || !allFilled) {
                registerBtn.disabled = true; // Disabilita il pulsante
                passwordError.style.display = (password.value !== confirmPassword.value) ? "block" : "none";
            } else {
                registerBtn.disabled = false; // Abilita il pulsante
                passwordError.style.display = "none";
            }
        }

        // Ascolta gli eventi di input su password, confirmPassword e sugli altri input
        password.addEventListener("input", validateForm);
        confirmPassword.addEventListener("input", validateForm);
        form.addEventListener("input", validateForm);

        // Funzione per togglare la visibilità della password
        
        // Gestione del dropdown menu
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
    });
	
        </script>
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
            <a href="login" class="nav-item">Login</a>
            <div class="user-icon">
                <a href="login.html">
                    <img src="https://www.iconpacks.net/icons/2/free-user-icon-3296-thumb.png" alt="User Icon">
                </a>
                <div class="dropdown-menu">
                    <form id="login-form">
                        <label for="email">Email:</label>
                        <input type="email" id="email1" placeholder="Inserisci email" required>
    
                        <label for="password">Password:</label>
                        <input type="password" id="password1" placeholder="Inserisci password" required>
    
                        <button type="submit">Accedi</button>
                    </form>
                </div>
            </div>
        </div>
    </header>
    

    <div class="reg-container">
        <div class="reg-box">
            <h2>Registrati!</h2>
            <form:form id="reg-form" action="/players/signup" modelAttribute="playerForm" method="post">
                <div class="input-group">
                    <label for="email">Email</label>
                    <form:input path="email" type="email" id="email" placeholder="Inserisci la tua email" required="true" />
                </div>
                <div class="input-group">
                    <label for="name">Nome</label>
                    <form:input path="firstName" type="text" id="name" placeholder="Inserisci il tuo nome" required="true" />
                </div>
                <div class="input-group">
                    <label for="surname">Cognome</label>
                    <form:input path="lastName" type="text" id="surname" placeholder="Inserisci il tuo cognome" required="true" />
                </div>
                <div class="input-group">
                    <label for="username">Username</label>
                    <form:input path="username" type="text" id="username" placeholder="Inserisci il tuo username" required="true" />
                </div>
                <div class="input-group">
                    <label for="dob">Data di nascita:</label>
                    <form:input path="dateOfBirth" type="date" id="dob" required="true" />
                </div>
                <div class="input-group">
                    <label for="password">Password</label>
                    <div class="password-container">
                        <form:input path="password" type="password" id="password" placeholder="Inserisci la tua password" required="true" />
                        <span class="toggle-password" onclick="togglePassword('password', 'eye-icon1')">
                            <img id="eye-icon1" src="https://cdn-icons-png.flaticon.com/512/2767/2767146.png" alt="Mostra password">
                        </span>
                    </div>
                </div>
                <div class="input-group">
                    <label for="confirm-password">Conferma Password</label>
                    <div class="password-container">
                        <input type="password" id="confirm-password" placeholder="Conferma la tua password" required>
                        <span class="toggle-password" onclick="togglePassword('confirm-password', 'eye-icon2')">
                            <img id="eye-icon2" src="https://cdn-icons-png.flaticon.com/512/2767/2767146.png" alt="Mostra password">
                        </span>
                    </div>
                    <small id="password-error" style="color: red; display: none;">⚠️ Le password non coincidono!</small>
                </div>
                
                <button type="submit" id="register-btn" disabled>Registra Account</button>
            </form:form>    
        </div>
    </div>

    </body>
    </html>