<%@ page import="com.example.ProjetJEE.Article" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Supermarché - Ajout d'article</title>
    <style><%@include file="/WEB-INF/css/ajoutArticle.scss"%></style>

</head>
<jsp:include page="header.jsp"/>


<div class="container">
    <form id="contact" action="" method="post">
        <h3>ENREGISTRER UN ARTICLE</h3>
            <fieldset>
            <input type="text" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" name="codeBarre" placeholder="Entrez un codeBarre" tabindex="1" required autofocus>
        </fieldset>
        <fieldset>
            <input type="text" name="reference" placeholder="Entrez une reference" tabindex="2" required>
        </fieldset>
        <fieldset>
            <input type="text" name="libelle" placeholder="Entrez un libelle" tabindex="3" required>
        </fieldset>
        <fieldset>
            <input type="text" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" name="prixHT" placeholder="Entrez un prix HT" tabindex="4" required>
        </fieldset>
        <fieldset>
            TVA: <select name="tauxTVA">
                <% for (int taux: Article.getValeurTauxTVA()) { %>
                <option value="<%=taux%>"> <%=taux%></option>
                <% } %>
            </select>
        </fieldset>
        <fieldset>
            <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Ajouter</button>
        </fieldset>
    </form>
</div>