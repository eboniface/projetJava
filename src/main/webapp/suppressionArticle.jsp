<%@ page import="com.example.ProjetJEE.Article" %><%--
  Created by IntelliJ IDEA.
  User: edbon
  Date: 17/12/2020
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<jsp:include page="header.jsp"/>

<body>
<% Article articleASupprimer = (Article) request.getAttribute("article");%>

Code barre:<%=articleASupprimer.getCodeBarre() %>
Libelle:<%=articleASupprimer.getLibelle() %>
prix HT:<%=articleASupprimer.getPrixHT() %>
Taux TVA: <%=articleASupprimer.getTauxTVA() %>
<form method="post">
    <input hidden name="codeBarre" value="<%=articleASupprimer.getCodeBarre() %>">
    <button type="submit">Supprimer</button>
</form>
</body>
</html>
