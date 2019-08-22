
package com.daserva.controller;

import com.daserva.dao.agendaDAO;
import com.daserva.dto.CitaDTO;
import com.daserva.dto.DisponibilidadCitaDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class agendaController{
    
    @RequestMapping(value = "getDisponibilidad.htm", method = RequestMethod.GET, produces = "application/json")
    public void getDisponibilidad(HttpServletResponse response) throws ServletException, IOException, SQLException {
        
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        response.setContentType("application/json;charset=utf-8");
        
        agendaDAO ageDatos = new agendaDAO();
        PrintWriter pw = response.getWriter(); 
        
        ArrayList<DisponibilidadCitaDTO> disponibilidad = ageDatos.getDisponibilidadDatos(Integer.parseInt(request.getParameter("cod_cliente")),Integer.parseInt(request.getParameter("cod_doctor")),request.getParameter("fecha"));
        
        JSONArray ja = new JSONArray(disponibilidad);
        
        pw.print(ja);
        pw.close();
    }
    
    @RequestMapping(value = "CRUDagenda.htm", method = RequestMethod.POST, produces = "application/json")
    public void CRUDagenda(HttpServletResponse response) throws ServletException, IOException, SQLException {
        
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        response.setContentType("application/json;charset=utf-8");
        
        agendaDAO ageDatos = new agendaDAO();
        PrintWriter pw = response.getWriter(); 
        JSONObject json = null;        
        
        CitaDTO cita = new CitaDTO();
        agendaDAO agendatos = new agendaDAO();
        
        cita.setCodigoCliente(Integer.parseInt(request.getParameter("cod_cliente")));
        cita.setCodigoDoctor(Integer.parseInt(request.getParameter("cod_doctor")));
        cita.setFecha(request.getParameter("fecha"));
        cita.setHora(request.getParameter("hora"));
        
        ArrayList resultado = agendatos.CRUDcita(Integer.parseInt(request.getParameter("accion")), cita);
        
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
    
    @RequestMapping(value = "validarAgendamiento.htm", method = RequestMethod.GET, produces = "application/json")
    public void validarAgendamiento(HttpServletResponse response) throws ServletException, IOException, SQLException {
        
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        response.setContentType("application/json;charset=utf-8");
        
        agendaDAO ageDatos = new agendaDAO();
        PrintWriter pw = response.getWriter(); 
        JSONObject json = null;
        
        ArrayList resultado = ageDatos.validarAgendamiento(Integer.parseInt(request.getParameter("cod_cliente")),Integer.parseInt(request.getParameter("cod_doctor")),request.getParameter("fecha"));
        
        if(!resultado.isEmpty()){
            Object r = resultado.get(0);
            if(r != null){
                json = new JSONObject( r );
                json.put("Status", "OK");
                
                json.put("resultado", r);
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
