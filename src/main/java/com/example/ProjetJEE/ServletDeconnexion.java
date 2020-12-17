package com.example.ProjetJEE;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ServletDeconnexion")
public class ServletDeconnexion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies=request.getCookies();

        HttpSession session= request.getSession(true);
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("OK")) {
                Cookie cookieSupp= new Cookie(cookie.getName(),"");
                cookieSupp.setMaxAge(0);
                response.addCookie(cookieSupp);
                boolean isConnected;
                isConnected = false;
                session.setAttribute("isConnected",isConnected);

            }
        }
        RequestDispatcher rd= this.getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
}
