/**
 * Todos los Derechos Reservados © 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene información propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgación en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: ClientesController.java
 * Fecha de creacion : Noviembre, 2013
 * @author : Sergio Alberto Cortés Rios
 * @version 1.0
 *
 * Bitácora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripción del cambio
 *---------------------------------------------------------------------------
 */
package com.javarevolutions.spring.web;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javarevolutions.spring.dominio.ClientesBean;
import com.javarevolutions.spring.service.iface.ClientesService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientesController extends ControllerUtil {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private ClientesService service;

    @RequestMapping("/catalogos/clientes/consultaClientes.jr")
    public String consultaClientes(@ModelAttribute("clientesBean") ClientesBean clientesBean,
        @ModelAttribute("listaClientes") ArrayList<ClientesBean> listaClientes, HttpServletRequest request) {
        try {
            listaClientes.addAll(service.consultaClientes());
            return "catalogoClientes";
        } catch(Exception e) {
            String error = "ERROR EN LA INVOCACIÓN AL SERVICIO: "+e;
            request.setAttribute("error", error);
            log.error(error);
            return "error";
        }
    }
	
    @RequestMapping("/catalogos/clientes/showCliente.jr")
    public String showCliente(@ModelAttribute("clientesBean") ClientesBean clientesBean,
                    Model model, HttpServletRequest request) {
        Map<String, String> sexo = new LinkedHashMap<String, String>();
        sexo.put(null, "Seleccionar . . .");
        sexo.put("H", "Hombre");
        sexo.put("M", "Mujer");
        model.addAttribute("listaSexos", sexo);
        if(!clientesBean.getAccion().equals("nuevo")) {
            try {
                clientesBean = service.getClientePorId(clientesBean);
                clientesBean.setFechaNacimientoStr(formatFechaString(clientesBean.getFecha_nacimiento().toString()));
            } catch(Exception e) {
                String error = "ERROR EN LA INVOCACIÓN AL SERVICIO: "+e;
                request.setAttribute("error", error);
                log.error(error);
                return "error";
            }
        }
        return "catalogos/clientes/aaCliente";
    }

    @RequestMapping("/catalogos/clientes/doAACliente.jr")
    public String doAACliente(@ModelAttribute("clientesBean") ClientesBean clientesBean, HttpServletRequest request,
            HttpServletResponse response) {
        if(clientesBean.getAccion().equals("nuevo")) {
            return insertaCliente(clientesBean, request, response);
        } else {
            return actualizaCliente(clientesBean, request);
        }
    }

    @RequestMapping("/catalogos/clientes/insertaCliente.jr")
    public String insertaCliente(@ModelAttribute("clientesBean") ClientesBean clientesBean, HttpServletRequest request,
        HttpServletResponse response) {
        try {
            clientesBean.setFecha_nacimiento(Date.valueOf(formatFechaSQL(clientesBean.getFechaNacimientoStr())));
            service.insertaCliente(clientesBean);
        } catch(Exception e) {
            String error = "ERROR EN LA INVOCACIÓN AL SERVICIO: "+e+" - "+clientesBean.getMensaje();
            clientesBean.setMensaje(error);
            request.setAttribute("error", error);
            log.error(error);
            return "error";
        }
        return "success";
    }

    @RequestMapping("/catalogos/clientes/borraCliente.jr")
    public String borraCliente(@ModelAttribute("clientesBean") ClientesBean clientesBean, HttpServletRequest request) {
        try {
            service.borraCliente(clientesBean);
            request.setAttribute("pathURL", "/catalogos/clientes/consultaClientes.jr");
            return "redirectScreen";
        } catch(Exception e) {
            String error = "ERROR EN LA INVOCACIÓN AL SERVICIO: "+e+" - "+clientesBean.getMensaje();
            clientesBean.setMensaje(error);
            request.setAttribute("error", error);
            log.error(error);
            return "errorCatalogo";
        }
    }

    @RequestMapping("/catalogos/clientes/actualizaCliente.jr")
    public String actualizaCliente(@ModelAttribute("clientesBean") ClientesBean clientesBean, HttpServletRequest request) {
        try {
            clientesBean.setFecha_nacimiento(Date.valueOf(formatFechaSQL(clientesBean.getFechaNacimientoStr())));
            service.actualizaCliente(clientesBean);
            request.setAttribute("pathURL", "/catalogos/clientes/consultaClientes.jr");
            return "success";
        } catch(Exception e) {
            String error = "ERROR EN LA INVOCACIÓN AL SERVICIO: "+e+" - "+clientesBean.getMensaje();
            clientesBean.setMensaje(error);
            request.setAttribute("error", error);
            log.error(error);
            return "error";
        }
    }
}
