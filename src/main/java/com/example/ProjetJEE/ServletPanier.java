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
import java.util.HashMap;

@WebServlet("/ServletPanier")
public class ServletPanier extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = this.getServletContext();
        HashMap<Long,Article> listeArticle;
        listeArticle = (HashMap<Long,Article>) context.getAttribute("listeArticle");
        Long codeBarre = Long.parseLong(request.getParameter("codeBarre"));
        Panier panier = new Panier();
        if(context.getAttribute("panier") != null){
            panier = (Panier) context.getAttribute("panier");
            panier.getlistArticlePanier().put(codeBarre,listeArticle.get(codeBarre));
            panier.execute();
        }else{
            panier.getlistArticlePanier().put(codeBarre,listeArticle.get(codeBarre));
            panier.execute();
        }
        context.setAttribute("panier",panier);
        request.setAttribute("panier",panier);

        RequestDispatcher rd= this.getServletContext().getRequestDispatcher("/panier.jsp");
        rd.forward(request, response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = this.getServletContext();
        Panier panier;
        if(context.getAttribute("panier") != null){
            panier = (Panier) context.getAttribute("panier");
            request.setAttribute("panier",panier);
        }

        RequestDispatcher rd= this.getServletContext().getRequestDispatcher("/panier.jsp");
        rd.forward(request, response);
    }
}
