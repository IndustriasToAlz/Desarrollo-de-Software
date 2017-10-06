
package com.manosenelcodigo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetUserServlet")
public class ejemploServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName").trim();
        
        if(userName == null || "".equals(userName)){
                userName = "Guest";
        }

        String greetings = "Hola " + userName;

        response.setContentType("text/plain");
        response.getWriter().write(greetings);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("nombre").trim();
        String metodo = request.getParameter("metodo").trim();
        
        String saludos = "Hola " + userName + " el metodo Servlet " + metodo;
        
        response.setContentType("text/plain");
        response.getWriter().write(saludos);
    }
}
