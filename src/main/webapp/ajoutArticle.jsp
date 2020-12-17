<%@ page import="com.example.ProjetJEE.Article" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Supermarché - Ajout d'article</title>
</head>
<jsp:include page="header.jsp"/>

<body>
<div align="center">
    <h1>Enregistrer un Article</h1>
    <br>
    <br>
    <br>

    <form method="POST">
        Code barre : <input type="number" name="codeBarre" placeholder="Entrez un codeBarre">
        Réference : <input type="text" name="reference" placeholder="Entrez une reference"><br><br>
        Libelle : <input type="text" name="libelle" placeholder="Entrez un libelle">
        Prix HT : <input type="number" name="prixHT" placeholder="Entrez un prix HT"><br><br>

        Taux TVA : <select name="tauxTVA">
        <% for (int taux: Article.getValeurTauxTVA()) { %>
            <option value="<%=taux%>"> <%=taux%></option>
       <% } %>
    </select>






        <button type="submit">Valider</button>
    </form>
</div>
</body>
</html>
