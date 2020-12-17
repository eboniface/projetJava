<%@ page import="com.example.ProjetJEE.Panier" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.example.ProjetJEE.Article" %><%--
  Created by IntelliJ IDEA.
  User: edbon
  Date: 17/12/2020
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<jsp:include page="header.jsp"/>

<body>
<form method="POST">
    Code barre : <input type="number" name="codeBarre" placeholder="Entrez un codeBarre">

</form>

<% if (request.getAttribute("panier")!= null){
    Panier panier = (Panier)request.getAttribute("panier");
%>
<% for (Map.Entry<Long, Article> articleDansPanier: panier.getlistArticlePanier().entrySet()) {%>
<%=articleDansPanier.getValue().getLibelle()%> :::::::::::<%=panier.getListPrixUnitaireTTC().get(articleDansPanier.getKey())%>
<%}%>
<%}%>
</body>
</html>
