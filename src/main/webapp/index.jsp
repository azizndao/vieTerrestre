<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Vie terrrestre • Home</title>
    <jsp:include page="includes/head.jsp"/>

    <style>
        .messages {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 42px;
            padding-bottom: 32px;
        }

        a:has(>.message) {
            text-decoration: none;
            color: currentColor;
        }

        .message {
            padding: 16px 24px;
            border: 2px solid grey;
            box-shadow: 12px 12px #5ad313;
            transition: all ease 0.3s;
        }

        .message:hover {
            box-shadow: 6px 6px #5ad313;
            transform: translate(6px, 6px);
        }
    </style>
</head>
<body>
<jsp:include page="includes/nav-bar.jsp"/>
<main class="main-content">
    <header class="header">
        <img src="images/pexels-pok-rie-1268068.jpg" alt="Image">
    </header>
    <section class="content container">
        <h1 class="text-lg-center my-5">Lutte contre la Déforestation</h1>
        <section class="messages">
            <a href="#">
                <div class="message">
                    <h2>Notre Mission</h2>
                    <p>Notre mission est de protéger les forêts et de lutter contre la déforestation mondiale.</p>
                </div>
            </a>
            <a href="#">
                <div class="message">
                    <h2>Pourquoi Agir</h2>
                    <p>La déforestation contribue au changement climatique, à la perte de biodiversité et menace la vie
                        sur
                        Terre.</p>
                </div>
            </a>
            <a href="#">
                <div class="message">
                    <h2>Comment Vous Pouvez Aider</h2>
                    <p>Rejoignez notre cause, plantez des arbres, soutenez des projets de conservation et sensibilisez
                        votre
                        communauté.</p>
                </div>
            </a>
        </section>

    </section>
</main>
<jsp:include page="includes/footer.jsp"/>
</body>
</html>