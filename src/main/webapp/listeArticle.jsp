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
    <style><%@include file="/WEB-INF/css/card.css"%></style>
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
          crossorigin="anonymous">
</head>
<jsp:include page="header.jsp"/>

<body>

<%HashMap<Long,Article> articleListe = (HashMap<Long,Article>) request.getAttribute("listeArticle");%>

<div class="cardDiv">
    <div style="align-items: center;">
    <div class="container">
        <%
            for (Map.Entry<Long,Article> article: articleListe.entrySet()) {

        %>
        <div class="card">
            <div class="face face1">
                <div class="content">
                    <div class="icon">
                        <p class="p"><%=article.getValue().getLibelle() %></p>
                    </div>
                </div>
            </div>
            <div class="face face2">
                <div class="content">
                    <h3>
                        <%=article.getValue().getPrixHT() %>€ HT
                    </h3>
                    <p><%=article.getValue().getCodeBarre() %></p>
                    <p style="margin-bottom: 15px"><%=article.getValue().getTauxTVA() %> TVA</p>
                    <%
                        boolean isConnecte = (boolean) request.getAttribute("isConnecte");
                    if(isConnecte){%>
                    <a href="<%=request.getContextPath()%>/ServletModificationArticle?codeBarre=<%=article.getValue().getCodeBarre()%>">Modifier</a>
                    <a href="<%=request.getContextPath()%>/ServletSuppressionArticle?codeBarre=<%=article.getValue().getCodeBarre()%>">Supprimer</a>
                    <%}%>
                </div>
            </div>
        </div>
        <% } %>
    </div>

</div>



</body>
</html>
