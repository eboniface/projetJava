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
import java.util.HashMap;

@WebServlet("/ServletModificationArticle")
public class ServletModificationArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HashMap<Long,Article> listeArticle;
        int codeBarre = Integer.parseInt(request.getParameter("codeBarre"));
        String reference =request.getParameter("reference");
        String libelle = request.getParameter("libelle");
        int prixHT = Integer.parseInt(request.getParameter("prixHT"));
        int tauxTVA = Integer.parseInt(request.getParameter("tauxTVA"));
        ServletContext context = this.getServletContext();
        listeArticle = (HashMap<Long, Article>) context.getAttribute("listeArticle");
        Article article = new Article(codeBarre,reference,libelle,prixHT,tauxTVA);
        listeArticle.replace((long) codeBarre,article);

        response.sendRedirect(request.getContextPath()+"/ServletListeArticle");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        boolean isConnecte = false;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("OK")) {
                isConnecte = true;
            }
        }if (isConnecte) {
            ServletContext context = this.getServletContext();
            Long codeBarreASupp = Long.parseLong(request.getParameter("codeBarre"));
            HashMap<Long, Article> listeArticle;
            listeArticle = (HashMap<Long, Article>) context.getAttribute("listeArticle");
            Article articleAEnvoyer = listeArticle.get(codeBarreASupp);
            request.setAttribute("article", articleAEnvoyer);

            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/modificationArticle.jsp");
            rd.forward(request, response);
        }else{

            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/connexion.jsp");
            rd.forward(request, response);
        }
    }
}
