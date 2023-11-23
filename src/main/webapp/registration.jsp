<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vie terrestre • Créer compte</title>
    <jsp:include page="includes/head.jsp"/>
</head>
<body>
<jsp:include page="includes/nav-bar.jsp"/>

<div class="form-wrapper container">
    <form action="${pageContext.request.contextPath}/register" method="post" class="py-5 my-5">
        <section class="form-group">
            <label for="first-name">Votre prenom</label>
            <input type="text" class="form-control" autocapitalize="words" autocomplete="first-name" name="first-name"
                   id="first-name"
                   placeholder="Poula">
        </section>
        <section class="form-group">
            <label for="last-name">Votre nom</label>
            <input type="text" class="form-control" autocapitalize="words" autocomplete="last-name" name="last-name"
                   id="last-name"
                   placeholder="Ba">
        </section>
        <section class="form-group">
            <label for="birthday">Votre date de naissance</label>
            <input type="date" class="form-control" autocapitalize="words" autocomplete="birthday" name="birthday"
                   id="birthday"
                   placeholder="Ba">
        </section>
        <section class="form-group">
            <label for="email">Votre mail</label>
            <input type="email" class="form-control" name="email" id="email" placeholder="exemple@domain.com">
        </section>
        <section class="form-group">
            <label for="password">Votre mot de passe</label>
            <input type="password" class="form-control" name="password" id="password" placeholder="*******">
        </section>
        <section class="form-group">
            <label for="password-confirmation">Confirmer le mot de passe</label>
            <input type="password" class="form-control" name="password-confirmation" id="password-confirmation"
                   placeholder="*******">
        </section>
        <p class="my-5">
            <a href="${pageContext.request.contextPath}/login">Se connecter</a> si vous avez deja un compte
        </p>
        <section>
            <button type="reset" class="btn btn-outline-danger mr-5">Annuler</button>
            <button type="submit" class="btn btn-primary">Créer compte</button>
        </section>
    </form>
</div>
</body>
</html>
