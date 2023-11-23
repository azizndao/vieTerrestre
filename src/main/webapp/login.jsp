<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vie terrestre • Connexion</title>
    <jsp:include page="includes/head.jsp"/>
</head>
<body>
<jsp:include page="includes/nav-bar.jsp"/>
<main class="container my-5 py-5">
    <form action="${pageContext.request.contextPath}/login" method="post">
        <section class="form-group">
            <label for="email">Votre mail</label>
            <input type="email" class="form-control" name="email" id="email" placeholder="exemple@domain.com">
        </section>
        <section class="form-group">
            <label for="password">Votre mot de passe</label>
            <input type="password" class="form-control" name="password" id="password" placeholder="*******">
        </section>
        <section class="py-4">
            <button type="reset" class="btn btn-outline-danger mr-4">Annuler</button>
            <button type="submit" class="btn btn-primary">Connecter</button>
        </section>
    </form>
</main>
</body>
</html>
