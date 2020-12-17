<%@ page import="com.example.ProjetJEE.Panier" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.example.ProjetJEE.Article" %>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%--
  Created by IntelliJ IDEA.
  User: edbon
  Date: 17/12/2020
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="header.jsp"/>
    <style><%@include file="/WEB-INF/css/panier.scss"%></style>

    <meta charset="utf-8">
    <title>Supermarché : Panier</title>

    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600" rel="stylesheet">
    <link rel="stylesheet" href="style.css" charset="utf-8">
</head>
<body>


<div class="paypal" style="margin-top: 10%">


    <div class="paypal__header">
        <div class="paypal__logo-wrapper">
            <img src="https://i.ibb.co/DrvmW5y/paypal.png" alt="Paypal" class="paypal__logo">
        </div>

        <div class="paypal__header-info">
            <span class="paypal__date"><%
                Date date = new Date();
                out.print(date.toString());
            %></span>
            <span class="paypal__ref">0f-113</span>
        </div>
    </div>

    <div class="paypal__subheader-wrapper">
        <div class="paypal__subheader">
            <h1 class="paypal__username">Bonjour,</h1>
            <% if (request.getAttribute("panier")!= null){
                Panier panier = (Panier)request.getAttribute("panier");
                if(panier.getlistArticlePanier().size() ==1 ){%>
                    <span class="paypal__help-text">Vous avez actuellement <%=panier.getlistArticlePanier().size()%> article dans votre panier:</span>
                <%}else if(panier.getlistArticlePanier().size() ==0){%>
                    <span class="paypal__help-text">Vous n'avez aucun article dans votre panier:</span>
                <%}else if(panier.getlistArticlePanier().size() >1){%>
                    <span class="paypal__help-text">Vous avez actuellement <%=panier.getlistArticlePanier().size()%> articles dans votre panier:</span>
                <%}%>
            <%}%>


            <form method="POST">
                <span class="paypal__help-text">Ajouter un nouvel article par son code barre:</span>
                <input class="paypal__help-text" style="width: 15%;" type="number" name="codeBarre" placeholder="code">
            </form>
        </div>


    </div>
    <% if (request.getAttribute("panier")!= null){
        Panier panier = (Panier)request.getAttribute("panier");
    %>

    <div class="paypal__cart">
        <h2 class="paypal__cart-title">Ticket:</h2>

        <ul class="paypal__cart-list">

            <%
                int index = 0;
                for (Map.Entry<Long, Article> articleDansPanier: panier.getlistArticlePanier().entrySet()) {
                    index++;
            %>

            <li class="paypal__cart-item">
                <span class="paypal__index"><%=index%></span>
                <span class="paypal__item-name"><%=articleDansPanier.getValue().getLibelle()%></span>
                <span class="paypal__item-price"><%=panier.getListPrixUnitaireTTC().get(articleDansPanier.getKey())%>€</span>
            </li>

            <%}%>

        </ul>
    </div>
    <%}%>

    <div class="paypal__footer">
        <img src="https://i.ibb.co/c8CQvBq/barcode.png" alt="Paypal Barcode" class="paypal__barcode">
        <% if (request.getAttribute("panier")!= null){
            Panier panier = (Panier)request.getAttribute("panier");
        %>
        <span class="paypal__barcode">Montant total: <%=panier.getTotalTTC()%>€</span>
        <%}%>
    </div>
</div>


</body>
</html>
