package com.example.ProjetJEE;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletAjoutArticle")
public class ServletAjoutArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Article> listeArticle = new ArrayList<>();
        int codeBarre = Integer.parseInt(request.getParameter("codeBarre"));
        String prenom =request.getParameter("reference");
        String numeroVol = request.getParameter("libelle");
        int prixHT = Integer.parseInt(request.getParameter("prixHT"));
        int tauxTVA = Integer.parseInt(request.getParameter("tauxTVA"));
        Article article = new Article(codeBarre, prenom, numeroVol, prixHT, tauxTVA);
        HttpSession session = request.getSession(true);
        if(session.getAttribute("listeArticle") != null){
            listeArticle = (ArrayList<Article>) session.getAttribute("listeArticle");
            listeArticle.add(article);
            session.setAttribute("listeArticle",listeArticle);
        }else{
            listeArticle.add(article);
            session.setAttribute("listeArticle",listeArticle);
        }

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
