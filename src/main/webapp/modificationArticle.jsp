<%@ page import="com.example.ProjetJEE.Article" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<jsp:include page="header.jsp"/>
<body>
<% Article articleAModifier = (Article) request.getAttribute("article");%>
<title>Title</title>

<form method="POST">
    Code barre : <input type="number" name="codeBarre" placeholder="<%=articleAModifier.getCodeBarre()%>" value="<%=articleAModifier.getCodeBarre()%>">
    Réference : <input type="text" name="reference" placeholder="<%=articleAModifier.getReference()%>" value="<%=articleAModifier.getReference()%>"><br><br>
    Libelle : <input type="text" name="libelle" placeholder="<%=articleAModifier.getLibelle()%>" value="<%=articleAModifier.getLibelle()%>">
    Prix HT : <input type="number" name="prixHT" placeholder="<%=articleAModifier.getPrixHT()%>" value="<%=articleAModifier.getPrixHT()%>"><br><br>

    Taux TVA : <select name="tauxTVA">
    <option value="<%=articleAModifier.getTauxTVA()%>"> <%=articleAModifier.getTauxTVA()%></option>
    <% for (int taux: Article.getValeurTauxTVA()) { %>
    <% if (articleAModifier.getTauxTVA() != taux){%>
    <option value="<%=taux%>"> <%=taux%></option>
    <% } %><% } %>
</select>

    <input hidden name="codeBarre" value="<%=articleAModifier.getCodeBarre() %>">
    <button type="submit">Modifier</button>
</form>
</body>
</html>
