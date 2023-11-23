<%@ page import="io.github.azizndao.vieterrestre.models.User" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light container">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Vie Terrestre</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/">Home <span
                        class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/deforestation">Deforestation</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/biodiversite">Biodiversite</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        <% User user = (User) request.getSession().getAttribute("user"); %>


        <div class="mx-4">
            <% if (user != null) { %>
            <a class="btn btn-danger" href="${pageContext.request.contextPath}/alert">Alerter
            </a>
            <a class="btn btn-light" href="${pageContext.request.contextPath}/me"><%= user.getFirstName() %>
            </a>
            <% } else { %>
            <a href="${pageContext.request.contextPath}/register" class="btn btn btn-outline-danger mr-4">Sign
                up</a>
            <a href="${pageContext.request.contextPath}/login" class="btn btn btn-primary">Login</a>
            <% }%>
        </div>

    </div>
</nav>