<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Supermarché</title>

</head>
<style><%@include file="/WEB-INF/css/home.css"%></style>
<jsp:include page="header.jsp"/>


<body>

<div class="splash-container">
    <div class="splash">
        <h1 class="splash-head">Votre supermarché</h1>
    </div>
</div>

<div class="content-wrapper">
    <div class="content">
        <h2 class="content-head is-center">Découvrez tous nos articles</h2>
        <br>
        <p align="center" >
            <a href="<%=request.getContextPath()%>/ServletListeArticle" class="pure-button pure-button-primary">Voir la page des articles</a>
        </p>
    </div>
</div>

</body>
</html>