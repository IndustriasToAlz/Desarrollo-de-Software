
package com.daserva.controller;

import com.daserva.modelos.Doctor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class doctorController{
    
    JSONObject json = null;
    
    @RequestMapping(value = "getDoctor.htm", method = RequestMethod.GET, produces = "application/json")
    public void getDoctor(HttpServletResponse response) throws ServletException, IOException, SQLException {
        
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        response.setContentType("application/json;charset=utf-8");
        
        doctorControllerDatos docDatos = new doctorControllerDatos();
        PrintWriter pw = response.getWriter(); 
        
        json = null;
        
        if(request.getParameter("rut") == null || request.getParameter("rut").equals("")){
            
            json.put("Status", "FAIL");
            json.put("StatusDetail", "No existe el rut");
            
            pw.print(json);
        }

        ArrayList<Doctor> doctor = docDatos.getDoctorDatos(request.getParameter("rut"));
        
        if(!doctor.isEmpty()){
            Doctor c = doctor.get(0);
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
    
    @RequestMapping(value = "getDoctoresLista.htm", method = RequestMethod.GET, produces = "application/json")
    public void getDoctoresLista(HttpServletResponse response) throws ServletException, IOException, SQLException {
        
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        response.setContentType("application/json;charset=utf-8");
        
        doctorControllerDatos docDatos = new doctorControllerDatos();
        PrintWriter pw = response.getWriter(); 

        ArrayList<Doctor> doctor = docDatos.getDoctoresListaDatos();
        
        JSONArray ja = new JSONArray(doctor);
        
        pw.print(ja);
        pw.close();
    }
    
    @RequestMapping(value = "CRUDoctor.htm", method = RequestMethod.POST, produces = "application/json")
    public void CRUDoctor(HttpServletResponse response) throws ServletException, IOException, SQLException {
        
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        response.setContentType("application/json;charset=utf-8");
        
        json = null;
        
        doctorControllerDatos docDatos = new doctorControllerDatos();
        PrintWriter pw = response.getWriter(); 
        
        Doctor doctor = new Doctor();
        
        doctor.setRut(request.getParameter("rut"));
        doctor.setPrimerNombre(request.getParameter("primer_nombre"));
        doctor.setSegundoNombre(request.getParameter("segundo_nombre"));
        doctor.setPrimerApellido(request.getParameter("primer_apellido"));
        doctor.setSegundoApellido(request.getParameter("segundo_apellido"));
        doctor.setDireccionResidencia(request.getParameter("direccion"));
        doctor.setComuna(request.getParameter("comuna"));
        doctor.setTelefonoParticular(request.getParameter("tel_particular"));
        doctor.setTelefonoTrabajo(request.getParameter("tel_trabajo"));
        doctor.setTelefonoMovil(request.getParameter("tel_movil"));
        doctor.setEmail(request.getParameter("email"));
        doctor.setFechaNacimiento(request.getParameter("fechaNacimiento"));
        
        ArrayList resultado = docDatos.CRUDoctor(Integer.parseInt(request.getParameter("accion")),doctor);
        
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
