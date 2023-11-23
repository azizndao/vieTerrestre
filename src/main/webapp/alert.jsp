<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="includes/head.jsp"/>
    <script src="${pageContext.request.contextPath}/js/alert.js" defer></script>
</head>
<body>
<jsp:include page="includes/nav-bar.jsp"/>
<main class="container">
    <form action="${pageContext.request.contextPath}/alert" method="post">
        <section class="form-group">
            <label for="type">Type d'alerte</label>
            <input type="text" class="form-control" name="type" id="type" placeholder="Incendie">
        </section>
        <section class="form-group">
            <label for="description">Description</label>
            <textarea name="description" class="form-control" id="description" cols="30" rows="10"></textarea>
        </section>
        <input type="text" name="latitude" id="latitude" hidden>
        <input type="text" name="longitude" id="longitude" hidden>
        <section>
            <button type="reset" class="btn btn-danger">Annuler</button>
            <button type="submit" class="btn btn-primary">Envoyer</button>
        </section>
    </form>
</main>
<jsp:include page="includes/footer.jsp"/>
</body>
</html>
