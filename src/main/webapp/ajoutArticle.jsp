<%@ page import="com.example.ProjetJEE.Article" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%

    Article article =
%>
<head>
    <title>Title</title>
</head>
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
        Prix HT : <input type="text" name="prixHT" placeholder="Entrez un prix HT"><br><br>

        Taux TVA : <select name="tauxTVA">
        <% for (taux:
                ) {
            
        } %>
    </select>





        <input type="text" name="tauxTVA" placeholder="Entrez un taux de TVA">
        <button type="submit">Valider</button>
    </form>
</div>
</body>
</html>
