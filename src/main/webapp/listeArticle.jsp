<%@ page import="com.example.ProjetJEE.Article" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: edbon
  Date: 17/12/2020
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% ArrayList<Article> articleListe = (ArrayList<Article>) ServletContext().getAttribute("")%>
<div align="center">
    <table border="1">
        <thead>
        <th>Nom</th><th>Prenom</th><th>Age</th><th>Numero de vol</th><th>Date d'enregistrement</th>
        </thead>
        <% for (Article article:listePassagerHtml) {%>
        <tr>
            <th><%=article.getCodeBarre() %></th><th><%=article.getLibelle() %></th><th><%=article.getPrixHT() %></th><th><%=article.getTauxTVA() %></th>
        </tr>
        <% } %>
    </table>
</div>
<br>
<br>
<div align="center">
    <a href="<%=request.getContextPath()%>">Accueil</a>
</div>
</body>
</html>
