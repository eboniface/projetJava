<%--
  Created by IntelliJ IDEA.
  User: Hugo
  Date: 17/12/2020
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String uri = request.getRequestURI();
    String pageName = uri.substring(uri.lastIndexOf("/")+1);
%>

<html>
<head>
    <style><%@include file="/WEB-INF/css/header.css"%></style>
</head>

<div class="topnav">
    <a <% if (pageName.equals("")) {%>class="active"<%}%> href="<%=request.getContextPath()%>">Accueil</a>
    <a <% if (pageName.equals("ajoutArticle.jsp")) {%>class="active"<%}%> href="<%=request.getContextPath()%>/ServletAjoutArticle">Ajout</a>
    <a <% if (pageName.equals("listeArticle.jsp")) {%>class="active"<%}%> href="<%=request.getContextPath()%>/ServletListeArticle">Liste</a>
    <a <% if (pageName.equals("listeArticle.jsp")) {%>class="active"<%}%> href="<%=request.getContextPath()%>/ServletPanier">Panier</a>
</div>

</html>
