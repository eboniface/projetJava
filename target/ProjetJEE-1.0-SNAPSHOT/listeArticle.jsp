<%@ page import="com.example.ProjetJEE.Article" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: edbon
  Date: 17/12/2020
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Supermarché - Liste des Articles</title>
</head>
<jsp:include page="header.jsp"/>

<body>

<%HashMap<Long,Article> articleListe = (HashMap<Long,Article>) request.getAttribute("listeArticle");%>
<div align="center">
    <table border="1">
        <thead>
        <th>Code Barre</th><th>Libelle de l'article</th><th>Prix HT</th><th>Taux de TVA</th>
        </thead>
        <% for (Map.Entry<Long,Article> article: articleListe.entrySet()) {%>
        <tr>
            <th><%=article.getValue().getCodeBarre() %></th><th><%=article.getValue().getLibelle() %></th><th><%=article.getValue().getPrixHT() %></th><th><%=article.getValue().getTauxTVA() %></th><th><a href="<%=request.getContextPath()%>/ServletSuppressionArticle?codeBarre=<%=article.getValue().getCodeBarre()%>">Supprimer</a> </th><th><a href="<%=request.getContextPath()%>/ServletModificationArticle?codeBarre=<%=article.getValue().getCodeBarre()%>">Modifier</a> </th>
        </tr>
        <% } %>
    </table>
</div>
<br>
<br>
</body>
</html>
