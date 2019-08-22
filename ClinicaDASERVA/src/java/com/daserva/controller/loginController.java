
package com.daserva.controller;

import com.daserva.conexion.ConexionDB;
import com.daserva.sql.IconsultasSQL;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class loginController implements IconsultasSQL{
    
    @RequestMapping(value = "login.htm", method = RequestMethod.GET)
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        
        response.setContentType("application/json;charset=utf-8");
        
        ConexionDB cone = new ConexionDB();
        
        Connection con = cone.obtener();
        CallableStatement callableStatement = null;
        ResultSet resulSet = null;     
        JSONObject json = new JSONObject();
        
        try {
            callableStatement = con.prepareCall(IconsultasSQL.VALIDAR_LOGIN);
            callableStatement.setString("login",request.getParameter("login"));
            callableStatement.setString("password",request.getParameter("password"));
            resulSet = callableStatement.executeQuery();

            while(resulSet.next()){
                json.put("resultado", resulSet.getString("RESPUESTA"));
            }
        } catch (SQLException | JSONException e) {
            System.out.println(e);
            json.put("error", e);
        }
        

        PrintWriter pw = response.getWriter(); 
        pw.print(json.toString());
        pw.close();
    }
    
}
