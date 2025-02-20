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

@WebServlet("/ServletSuppressionArticle")
public class ServletSuppressionArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = this.getServletContext();
        Long codeBarreASupp = Long.parseLong(request.getParameter("codeBarre"));
        HashMap<Long,Article> listeArticle;
        listeArticle = (HashMap<Long,Article>) context.getAttribute("listeArticle");
        listeArticle.remove(codeBarreASupp);

        response.sendRedirect(request.getContextPath()+"/ServletListeArticle");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        boolean isConnecte = false;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("OK")) {
                isConnecte = true;
            }
        }
        if (isConnecte) {

            ServletContext context = this.getServletContext();
            Long codeBarreASupp = Long.parseLong(request.getParameter("codeBarre"));
            HashMap<Long, Article> listeArticle;
            listeArticle = (HashMap<Long, Article>) context.getAttribute("listeArticle");
            Article articleAEnvoyer = listeArticle.get(codeBarreASupp);
            request.setAttribute("article", articleAEnvoyer);

            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/suppressionArticle.jsp");
            rd.forward(request, response);
        }else{

            response.sendRedirect(request.getContextPath()+"/ServletListeArticle");
        }
    }
}
