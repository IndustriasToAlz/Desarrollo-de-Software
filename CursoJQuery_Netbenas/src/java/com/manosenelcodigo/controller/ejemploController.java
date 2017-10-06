
package com.manosenelcodigo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONArray;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class ejemploController {
    
    @RequestMapping(value = "ejemplo.htm" ,method = RequestMethod.GET)
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName").trim();
        
        if (userName == null || "".equals(userName)) {
            userName = "invitado";
        }
        
        String saludos = "Hola " + userName;
        
        response.setContentType("text/plain");
        response.getWriter().write(saludos);
    }
    
    @RequestMapping(value = "ejemplo.htm" ,method = RequestMethod.POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("nombre").trim();
        String metodo = request.getParameter("metodo").trim();
        
        String saludos = "Hola " + userName + " el metodo Spring " + metodo;
        
        response.setContentType("text/plain");
        response.getWriter().write(saludos);
    }
    
    @RequestMapping(value = "ejemploJSON.htm", method = RequestMethod.GET)
    public void doGetJson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("application/json;charset=utf-8");
        
        JSONObject json = new JSONObject();
        ArrayList list = new ArrayList();
        
        list.add(request.getParameter("nombre"));
        list.add(request.getParameter("metodo"));       

        json.put("jsonArray", list);        

        PrintWriter pw = response.getWriter(); 
        pw.print(json.toString());
        pw.close();
    }
    
    @RequestMapping(value = "ejemploAJAX.htm" ,method = RequestMethod.POST)
    public void doPostAJAX(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType( "text/html; charset=iso-8859-1" );
        int resultado = Integer.parseInt(request.getParameter("val1")) + Integer.parseInt(request.getParameter("val2")) ;
        PrintWriter out = response.getWriter();
        
        out.print(resultado);
        out.close();
    }
}
