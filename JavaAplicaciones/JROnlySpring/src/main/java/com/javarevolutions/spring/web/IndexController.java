/**
 * Todos los Derechos Reservados © 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene información propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgación en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: IndexController.java
 * Fecha de creacion : Noviembre, 2013
 * @author : Sergio Alberto Cortés Rios
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 *---------------------------------------------------------------------------
 */
package com.javarevolutions.spring.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javarevolutions.spring.dominio.IndexBean;
import com.javarevolutions.spring.service.iface.IndexService;
import java.io.IOException;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private IndexService service;

    @RequestMapping("/home.jr")
    public String validaLogin() {
        return "welcome";
    }
    
    @RequestMapping("/login.jr")
    public String validaLogin(@RequestParam("j_username") String j_username, @RequestParam("j_password") String j_password,
        HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IndexBean bean = new IndexBean();
        bean.setUsuario(j_username);
        bean.setPassword(j_password);
        System.out.println("User : "+bean.getUsuario());
        System.out.println("Password : "+bean.getPassword());
        try {
            bean.setStatus(service.validaLogin(bean));
        } catch(Exception e) {
            bean.setStatus(false);
            bean.setMensaje("ERROR en la invocación al servicio: "+e);
            log.error(bean.getMensaje());
        }
        if(bean.getStatus()) {
            HttpSession session = request.getSession(true);
            session.setAttribute("userInSession", bean);
            log.info("Bienvenido : "+bean.getUsuario());
            return "welcome";
        } else {
            request.setAttribute("error", bean.getMensaje());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        return "index";
    }
    
    @RequestMapping("/catalogos/usuarios/consultaUsuarios.jr")
    public String consultaUsuarios(@ModelAttribute("usuariosBean") IndexBean usuariosBean,
        @ModelAttribute("listaUsuarios") ArrayList<IndexBean> listaUsuarios, HttpServletRequest request) {
        try {
            listaUsuarios.addAll(service.consultaUsuarios());
            return "catalogoUsuarios";
        } catch(Exception e) {
            String error = "ERROR EN LA INVOCACIÓN AL SERVICIO: "+e;
            request.setAttribute("error", error);
            log.error(error);
            return "error";
        }
    }
	
    @RequestMapping("/catalogos/usuarios/showUsuario.jr")
    public String showUsuario(@ModelAttribute("usuariosBean") IndexBean usuariosBean, HttpServletRequest request) {
        if(!usuariosBean.getAccion().equals("nuevo")) {
            try {
                usuariosBean = service.getUsuarioPorId(usuariosBean);
            } catch(Exception e) {
                String error = "ERROR EN LA INVOCACIÓN AL SERVICIO: "+e;
                request.setAttribute("error", error);
                log.error(error);
                return "error";
            }
        }
        return "catalogos/usuarios/aaUsuario";
    }
    
    @RequestMapping("/catalogos/usuarios/doAAUsuario.jr")
    public String doAAUsuario(@ModelAttribute("usuariosBean") IndexBean usuariosBean, HttpServletRequest request,
        HttpServletResponse response) {
        if(usuariosBean.getAccion().equals("nuevo")) {
            return insertaUsuario(usuariosBean, request, response);
        } else {
            return actualizaUsuario(usuariosBean, request);
        }
    }
    
    @RequestMapping("/catalogos/usuarios/insertaUsuario.jr")
    public String insertaUsuario(@ModelAttribute("usuariosBean") IndexBean usuariosBean, HttpServletRequest request,
        HttpServletResponse response) {
        try {
            service.insertaUsuario(usuariosBean);
        } catch(Exception e) {
            String error = "ERROR EN LA INVOCACIÓN AL SERVICIO: "+e+" - "+usuariosBean.getMensaje();
            usuariosBean.setMensaje(error);
            request.setAttribute("error", error);
            log.error(error);
            return "error";
        }
        return "success";
    }
	
    @RequestMapping("/catalogos/usuarios/borraUsuario.jr")
    public String borraUsuario(@ModelAttribute("usuariosBean") IndexBean usuariosBean, HttpServletRequest request) {
        try {
            service.borraUsuario(usuariosBean);
            request.setAttribute("pathURL", "/catalogos/usuarios/consultaUsuarios.jr");
            return "redirectScreen";
        } catch(Exception e) {
            String error = "ERROR EN LA INVOCACIÓN AL SERVICIO: "+e+" - "+usuariosBean.getMensaje();
            usuariosBean.setMensaje(error);
            request.setAttribute("error", error);
            log.error(error);
            return "errorCatalogo";
        }
    }
    
    @RequestMapping("/catalogos/usuarios/actualizaUsuario.jr")
    public String actualizaUsuario(@ModelAttribute("usuariosBean") IndexBean usuariosBean, HttpServletRequest request) {
        try {
            service.actualizaUsuario(usuariosBean);
            request.setAttribute("pathURL", "/catalogos/usuarios/consultaUsuarios.jr");
            return "success";
        } catch(Exception e) {
            String error = "ERROR EN LA INVOCACIÓN AL SERVICIO: "+e+" - "+usuariosBean.getMensaje();
            usuariosBean.setMensaje(error);
            request.setAttribute("error", error);
            log.error(error);
            return "error";
        }
    }
}
