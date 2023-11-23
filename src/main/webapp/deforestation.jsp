<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vie terrestre • Deforestation</title>
    <jsp:include page="includes/head.jsp"/>
    <link href='${pageContext.request.contextPath}/mapbox/mapbox.css' rel='stylesheet'/>
</head>
<body>
<jsp:include page="includes/nav-bar.jsp"/>
<div id="map" style="min-height: 720px"></div>
<main class="container">
</main>
<script defer type="module">
    import './mapbox/mapbox.js'

    L.mapbox.accessToken = 'pk.eyJ1IjoiYXppem5kYW8iLCJhIjoiY2tsdHVveHRjMDB2OTJucGx2ZXFtdWRuZiJ9.-5kaZgWHIuMROBeSu6yjyw'
    L.mapbox.map('map', 'mapbox.streets');
    const layer = L.mapbox.tileLayer('mapbox.streets');

    layer.on('ready', function () {
        console.log("the layer has been fully loaded now, and you can")
    });
    layer.on('error', function (err) {
        console.error(err)
    });
</script>
</body>
</html>
