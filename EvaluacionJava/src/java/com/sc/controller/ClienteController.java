
package com.sc.controller;

import com.sc.datos.clientesDatos;
import com.sc.modelos.ThomCliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.json.JSONObject;

public class ClienteController {
    
    @RequestMapping(value = "getCliente.htm", method = RequestMethod.GET, produces = "application/json")
    public void getCliente(HttpServletResponse response) throws ServletException, IOException, SQLException {
        
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        response.setContentType("application/json;charset=utf-8");
        
        clientesDatos cliDatos = new clientesDatos();
        PrintWriter pw = response.getWriter(); 
        
        JSONObject json = null;
        
        if(request.getParameter("CedulaCliente") == null || request.getParameter("CedulaCliente").equals("")){
            
            json.put("Status", "FAIL");
            json.put("StatusDetail", "No existe el rut");
            
            pw.print(json);
        }

        ArrayList<ThomCliente> clientes = cliDatos.getCliente(request.getParameter("CedulaCliente"));
        
        if(!clientes.isEmpty()){
            ThomCliente c = clientes.get(0);
            if(c != null){
                json = new JSONObject( c );
                json.put("Status", "OK");
            }else{
                json.put("Status", "FAIL");
                json.put("StatusDetail", "No existe el rut");
            
                pw.print(json);
            }
        }
        pw.print(json);
        pw.close();
    }
    
    @RequestMapping(value = "getClientes.htm", method = RequestMethod.GET, produces = "application/json")
    public void getClientes(HttpServletResponse response) throws ServletException, IOException, SQLException {
        
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        response.setContentType("application/json;charset=utf-8");
        
        clientesDatos cliDatos = new clientesDatos();
        PrintWriter pw = response.getWriter(); 
        
        JSONObject json = null;
        
        if(request.getParameter("CedulaCliente") == null || request.getParameter("CedulaCliente").equals("")){
            
            json.put("Status", "FAIL");
            json.put("StatusDetail", "No existe el rut");
            
            pw.print(json);
        }

        ArrayList<ThomCliente> clientes = cliDatos.getClientes();
        
        if(!clientes.isEmpty()){
            ThomCliente c = clientes.get(0);
            if(c != null){
                json = new JSONObject( c );
                json.put("Status", "OK");
            }else{
                json.put("Status", "FAIL");
                json.put("StatusDetail", "No existe el rut");
            
                pw.print(json);
            }
        }
        pw.print(json);
        pw.close();
    }
    
    @RequestMapping(value = "cruCliente.htm", method = RequestMethod.POST, produces = "application/json")
    public void cruCliente(HttpServletResponse response) throws ServletException, IOException, SQLException {
        
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        response.setContentType("application/json;charset=utf-8");
        ThomCliente cliente = new ThomCliente();
        clientesDatos cliDatos = new clientesDatos();
        PrintWriter pw = response.getWriter();
        JSONObject json = null;
        
        cliente.setCdcliente(request.getParameter("CedulaCliente"));
        cliente.setDsnombre(request.getParameter("NombreCliente"));
        cliente.setDsdireccion(request.getParameter("Direccion"));
        cliente.setDsmail(request.getParameter("Email"));
        cliente.setCdusuario(request.getParameter("CedulaUsuario"));
        cliente.setSnactivo(request.getParameter("Activo"));
        cliente.setCdtelefono(request.getParameter("Telefono"));
        cliente.setDscontacto(request.getParameter("Contacto"));
        cliente.setDslogo(request.getParameter("Logo"));
        
        ArrayList resultado = cliDatos.cruCliente(cliente, Integer.parseInt(request.getParameter("Accion")));
        
        if(!resultado.isEmpty()){
            Object r = resultado.get(0);
            if(r != null){
                json = new JSONObject( r );
                json.put("Status", "OK");
                
                if (Integer.parseInt(request.getParameter("Accion")) == 1) {
                    json.put("resultado", r);
                } else {
                    json.put("resultado", r);
                }
            }else{
                json.put("Status", "FAIL");
                json.put("StatusDetail", r);
            
                pw.print(json);
            }
        }
        pw.print(json);
        pw.close();
    }
}
