package com.example.ProjetJEE;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ServletListeArticle")
public class ServletListeArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        ArrayList<Article> listeArticle = new ArrayList<>();


        if(context.getAttribute("listeArticle") == null){
            Article article = new Article(987456131, "pdffra98", "Pot de fleur ", 20, 550);
            listeArticle.add(article);

            Article article2 = new Article(456987123, "bafra45", "Barquette de fraises", 3, 550);
            listeArticle.add(article2);

            Article article3 = new Article(714896574, "balcfra71", "Bouteille de bière", 7, 2000);
            listeArticle.add(article3);

            context.setAttribute("listeArticle",listeArticle);
        }
        listeArticle = (ArrayList<Article>) context.getAttribute("listeArticle");


        request.setAttribute("listeArticle",listeArticle);

        RequestDispatcher rd= this.getServletContext().getRequestDispatcher("/listeArticle.jsp");

        rd.forward(request, response);




    }
}
