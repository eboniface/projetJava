package com.example.ProjetJEE;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "ServletInscription")
public class ServletInscription extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login =request.getParameter("login");
        String password = request.getParameter("password");
        ServletContext context = this.getServletContext();
        HashMap<String,String> listUser = new HashMap<>();
        if (context.getAttribute("listUser") != null){
            listUser = (HashMap<String, String>) context.getAttribute("listUser");
            listUser.put(login,password);
        }else{
            listUser.put(login,password);
        }
        context.setAttribute("listUser",listUser);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
