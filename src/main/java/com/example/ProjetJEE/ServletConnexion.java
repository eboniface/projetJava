package com.example.ProjetJEE;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session= request.getSession(true);
        String login =request.getParameter("login");
        String password = request.getParameter("password");
        ServletContext context = this.getServletContext();
        HashMap<String,String> listUser = (HashMap<String, String>) context.getAttribute("listUser");
        for (Map.Entry<String,String> user:listUser.entrySet()) {
            if( user.getKey().equals(login) && user.getValue().equals(password)){
                Cookie cookie = new Cookie("login","OK");
                response.addCookie(cookie);
                boolean isConnected = true;
                session.setAttribute("isConnected",isConnected);
            }else {
                this.doGet(request,response);
            }
        }

        RequestDispatcher rd= this.getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd= this.getServletContext().getRequestDispatcher("/connexion.jsp");
        rd.forward(request, response);
    }
}
