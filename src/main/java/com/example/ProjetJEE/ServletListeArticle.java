package com.example.ProjetJEE;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/ServletListeArticle")
public class ServletListeArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = this.getServletContext();
        HashMap<Long,Article> listeArticle = new HashMap<>();

        Cookie[] cookies = request.getCookies();
        boolean isConnecte = false;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("OK")) {
                isConnecte = true;
            }
        }
        if(context.getAttribute("listeArticle") == null){

            Article article = new Article(987456131, "pdffra98", "Pot de fleur ", 20, 550);
            listeArticle.put(article.getCodeBarre(),article);

            Article article2 = new Article(456987123, "bafra45", "Barquette de fraises", 3, 550);
            listeArticle.put(article2.getCodeBarre(),article2);

            Article article3 = new Article(714896574, "balcfra71", "Bouteille de bière", 7, 2000);
            listeArticle.put(article3.getCodeBarre(),article3);

            context.setAttribute("listeArticle",listeArticle);
        }
        listeArticle = (HashMap<Long,Article>) context.getAttribute("listeArticle");
        request.setAttribute("listeArticle",listeArticle);
        request.setAttribute("isConnecte",isConnecte);

        RequestDispatcher rd= this.getServletContext().getRequestDispatcher("/listeArticle.jsp");
        rd.forward(request, response);
    }
}
