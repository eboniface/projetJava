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
        listeArticle = (ArrayList<Article>) context.getAttribute("listeArticle");

        request.setAttribute("listeArticle",listeArticle);

        RequestDispatcher rd= this.getServletContext().getRequestDispatcher("/listeArticle.jsp");

        rd.forward(request, response);




    }
}
