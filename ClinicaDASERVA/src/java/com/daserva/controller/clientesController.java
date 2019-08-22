
package com.daserva.controller;

import com.daserva.dao.clientesDAO;
import com.daserva.dto.ClienteDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


public class clientesController{
    
    JSONObject json = null;
    
    @RequestMapping(value = "getCliente.htm", method = RequestMethod.GET, produces = "application/json")
    public void getCliente(HttpServletResponse response) throws ServletException, IOException, SQLException {
        
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        response.setContentType("application/json;charset=utf-8");
        
        clientesDAO cliDatos = new clientesDAO();
        PrintWriter pw = response.getWriter(); 
        
        json = null;
        
        if(request.getParameter("rut") == null || request.getParameter("rut").equals("")){
            
            json.put("Status", "FAIL");
            json.put("StatusDetail", "No existe el rut");
            
            pw.print(json);
        }

        ArrayList<ClienteDTO> clientes = cliDatos.getClienteDatos(request.getParameter("rut"));
        
        if(!clientes.isEmpty()){
            ClienteDTO c = clientes.get(0);
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
    
    @RequestMapping(value = "CRUCliente.htm", method = RequestMethod.POST, produces = "application/json")
    public void CRUCliente(HttpServletResponse response) throws ServletException, IOException, SQLException {
        
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        response.setContentType("application/json;charset=utf-8");
        
        json = null;
        
        clientesDAO cliDatos = new clientesDAO();
        PrintWriter pw = response.getWriter(); 
        
        ClienteDTO cliente = new ClienteDTO();
        
        cliente.setRut(request.getParameter("rut"));
        cliente.setPrimerNombre(request.getParameter("primer_nombre"));
        cliente.setSegundoNombre(request.getParameter("segundo_nombre"));
        cliente.setPrimerApellido(request.getParameter("primer_apellido"));
        cliente.setSegundoApellido(request.getParameter("segundo_apellido"));
        cliente.setDireccionResidencia(request.getParameter("direccion"));
        cliente.setComuna(request.getParameter("comuna"));
        cliente.setTelefonoParticular(request.getParameter("tel_particular"));
        cliente.setTelefonoTrabajo(request.getParameter("tel_trabajo"));
        cliente.setTelefonoMovil(request.getParameter("tel_movil"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setFechaNacimiento(request.getParameter("fechaNacimiento"));
        
        ArrayList resultado = cliDatos.CRUCliente(Integer.parseInt(request.getParameter("accion")),cliente);
        
        if(!resultado.isEmpty()){
            Object r = resultado.get(0);
            if(r != null){
                json = new JSONObject( r );
                json.put("Status", "OK");
                
                if (Integer.parseInt(request.getParameter("accion")) == 1) {
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
