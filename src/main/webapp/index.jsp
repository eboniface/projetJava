<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
    <body>
        <div align="center">
            <h1><%= "Supermarché!" %>
            </h1>
            <br/>
            <a href="<%=request.getContextPath()%>/ServletAjoutArticle">Ajouter un article</a>
            <a href="<%=request.getContextPath()%>/ServletListeArticle">Liste des article</a>
        </div>
    </body>
</html>