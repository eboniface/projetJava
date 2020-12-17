<%--
  Created by IntelliJ IDEA.
  User: edbon
  Date: 17/12/2020
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Supermarché - Inscription</title>
    <style><%@include file="/WEB-INF/css/register.scss"%></style>

</head>
<jsp:include page="header.jsp"/>
<body>
<div class="wrapper fadeInDown" style="margin-top: 12%">
    <div id="formContent">

        <h2 class="active"> Inscription </h2>

        <div class="fadeIn first">
            <img style="max-height: 50px; max-width: 50px" src="https://cdn4.iconfinder.com/data/icons/small-n-flat/24/user-alt-512.png" id="icon" alt="User Icon" />
        </div>

        <form method="post">

        <input type="text" id="login" class="fadeIn second" name="login" placeholder="login">
            <input type="password" id="password" class="fadeIn third" name="password" placeholder="mot de passe">
            <input type="submit" class="fadeIn fourth" value="S'inscrire">
        </form>

        <div id="formFooter">
        </div>


    </div>
</div>

</body>
</html>
