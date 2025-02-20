<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lambda eSports</title>
    <link rel="stylesheet" href="/style/home.css">
</head>
<body class="bg-gray-900 text-white">

    <!-- HEADER -->
    <header class="header">
        <h1 class="logo">
            <a href="home.jsp">
                <div class="logo-img">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/5/5c/Amazon_Lambda_architecture_logo.svg" 
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
                    <form id="login-form" action="/auth/login" modelAttribute="playerForm" method="post">
                        <label for="email">Username/Email:</label>
                        <input type="email" id="email" placeholder="Inserisci email" required>

                        <label for="password">Password:</label>
                        <input type="password" id="password" placeholder="Inserisci password" required>

                        <button type="submit">Accedi</button>
                    </form>
                </div>
            </div>
        </div>
    </header>

    <!-- HERO SECTION -->
    <section class="hero">
        <div>
            <img src="https://media4.giphy.com/media/v1.Y2lkPTc5MGI3NjExMGFkNjExc2Fhem1peHN4cnhhbzkzN24zY2g5Y3Jxc2R3YWRuOHFteiZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/cqu4FuRXlQPI97IJ6G/giphy.gif" 
                 class="hero-bg" alt="Background GIF">
        </div>
        <div class="hero-text">
            <h2 class="hero-title">
                CREA IL TUO CONCORSO A PREMI DI ESPORT & GAMING
            </h2>
            <p class="hero-description">
                Sfrutta concorsi a premi, tornei e giveaway come strumenti efficaci per evolvere il tuo business, coinvolgendo e fidelizzando la tua community.
            </p>
        </div>
    </section>

    <!-- SEZIONE DIVISA 50/50 -->
    <div class="container">
        <div class="square">
            <div class="left-content">
                <h2>CREA IL TUO ESPORT</h2>
                <p>Con la nostra piattaforma, puoi progettare e organizzare eventi Esport personalizzati, 
                    dai tornei online ai concorsi di abilità. Offriamo soluzioni creative per premiare i 
                    partecipanti con giveaway e premi, aiutandoti a far crescere la tua comunità e raggiungere 
                    i tuoi obiettivi di marketing.</p>
            </div>
            <div class="right-content">
                <h2>PARTECIPA AD UN TORNEO</h2>
                <p>Unisciti a tornei emozionanti e sfida altri giocatori per vincere premi esclusivi! 
                    Sia che tu sia un principiante o un esperto, i nostri tornei offrono un'opportunità 
                    unica per metterti alla prova e dimostrare le tue abilità. Non perdere l'occasione di 
                    conquistare il primo posto e guadagnare ricompense fantastiche.</p>
            </div>
        </div>
    </div>

    <!-- SEZIONE CHI SIAMO -->
    <div class="about-us">
        <div class="about-content">
            <h3>CHI SIAMO</h3>
            <p>La nostra missione è creare esperienze coinvolgenti nel mondo degli esport. Aiutiamo brand e organizzazioni a realizzare 
               concorsi e tornei online, puntando a costruire una comunità attiva e appassionata. Con il nostro supporto, puoi trasformare 
               ogni evento in un'opportunità unica per far crescere il tuo marchio e interagire con i tuoi utenti.</p>
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