<%@ page import="io.github.azizndao.vieterrestre.models.User" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <jsp:include page="includes/head.jsp"/>
</head>
<body>
<jsp:include page="includes/nav-bar.jsp"/>
<main class="container">
    <% User user = (User) request.getSession().getAttribute("user"); %>
    <h1><%= user.getFirstName() %>
    </h1>
    <h2><%= user.getLastName() %>
    </h2>
    <h3><%= user.getEmail() %>
    </h3>
</main>
</body>
</html>