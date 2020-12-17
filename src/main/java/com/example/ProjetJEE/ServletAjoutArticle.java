package com.example.ProjetJEE;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/ServletAjoutArticle")
public class ServletAjoutArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<Long,Article> listeArticle = new HashMap<>();
        int codeBarre = Integer.parseInt(request.getParameter("codeBarre"));
        String reference =request.getParameter("reference");
        String libelle = request.getParameter("libelle");
        int prixHT = Integer.parseInt(request.getParameter("prixHT"));
        int tauxTVA = Integer.parseInt(request.getParameter("tauxTVA"));
        Article article = new Article(codeBarre, reference, libelle, prixHT, tauxTVA);
        ServletContext context = this.getServletContext();
        if(context.getAttribute("listeArticle") != null){
            listeArticle = (HashMap<Long, Article>) context.getAttribute("listeArticle");
            listeArticle.put(article.getCodeBarre(),article);
            context.setAttribute("listeArticle",listeArticle);
            request.setAttribute("listeArticle",listeArticle);
        }else{
            listeArticle.put(article.getCodeBarre(),article);
            context.setAttribute("listeArticle",listeArticle);
            request.setAttribute("listeArticle",listeArticle);
        }

        context.setAttribute("listeArticleHtml",listeArticle);
        request.setAttribute("listeArticleHtml",listeArticle);

        RequestDispatcher rd =
                this.getServletContext()
                        .getRequestDispatcher("/listeArticle.jsp");

        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd= this.getServletContext().getRequestDispatcher("/ajoutArticle.jsp");

        rd.forward(request, response);
    }
}
