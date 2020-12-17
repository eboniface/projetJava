<%@ page import="com.example.ProjetJEE.Article" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<jsp:include page="header.jsp"/>
<body>
<% Article articleAModifier = (Article) request.getAttribute("article");%>
<title>Title</title>

<form method="POST">
    Code barre : <input type="number" name="codeBarre" placeholder="<%=articleAModifier.getCodeBarre()%>" value="<%=articleAModifier.getCodeBarre()%>">
    Réference : <input type="text" name="reference" placeholder="<%=articleAModifier.getReference()%>" value="<%=articleAModifier.getReference()%>"><br><br>
    Libelle : <input type="text" name="libelle" placeholder="<%=articleAModifier.getLibelle()%>" value="<%=articleAModifier.getLibelle()%>">
    Prix HT : <input type="number" name="prixHT" placeholder="<%=articleAModifier.getPrixHT()%>" value="<%=articleAModifier.getPrixHT()%>"><br><br>

    Taux TVA : <select name="tauxTVA">
    <option value="<%=articleAModifier.getTauxTVA()%>"> <%=articleAModifier.getTauxTVA()%></option>
    <% for (int taux: Article.getValeurTauxTVA()) { %>
    <% if (articleAModifier.getTauxTVA() != taux){%>
    <option value="<%=taux%>"> <%=taux%></option>
    <% } %><% } %>
</select>

    <input hidden name="codeBarre" value="<%=articleAModifier.getCodeBarre() %>">
    <button type="submit">Modifier</button>
</form>
</body>

<head>
    <title>Supermarché - Modification d'article</title>
    <style><%@include file="/WEB-INF/css/ajoutArticle.scss"%></style>

</head>
<jsp:include page="header.jsp"/>



<div class="container">
    <form id="contact" action="" method="post">
        <h3>ENREGISTRER UN ARTICLE</h3>
        <fieldset>
            <input type="text" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" name="codeBarre" placeholder="<%=articleAModifier.getCodeBarre()%>" value="<%=articleAModifier.getCodeBarre()%>" tabindex="1" required autofocus>
        </fieldset>
        <fieldset>
            <input type="text" name="reference" placeholder="<%=articleAModifier.getReference()%>" value="<%=articleAModifier.getReference()%>" tabindex="2" required>
        </fieldset>
        <fieldset>
            <input type="text" name="libelle" placeholder="<%=articleAModifier.getLibelle()%>" value="<%=articleAModifier.getLibelle()%>" tabindex="3" required>
        </fieldset>
        <fieldset>
            <input type="text" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" name="prixHT" placeholder="<%=articleAModifier.getPrixHT()%>" value="<%=articleAModifier.getPrixHT()%>" tabindex="4" required>
        </fieldset>
        <fieldset>
            TVA : <select name="tauxTVA">
            <option value="<%=articleAModifier.getTauxTVA()%>"> <%=articleAModifier.getTauxTVA()%></option>
            <% for (int taux: Article.getValeurTauxTVA()) { %>
            <% if (articleAModifier.getTauxTVA() != taux){%>
            <option value="<%=taux%>"> <%=taux%></option>
            <% } %><% } %>
        </select>

        </fieldset>
        <fieldset>
            <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Ajouter</button>
        </fieldset>
    </form>
</div>

</html>
