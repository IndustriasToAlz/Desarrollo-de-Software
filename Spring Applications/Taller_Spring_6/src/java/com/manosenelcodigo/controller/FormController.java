package com.manosenelcodigo.controller;

import com.manosenelcodigo.modelos.Persona;
import com.manosenelcodigo.modelos.PersonaValidar;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("form.htm")
public class FormController {
    
    private PersonaValidar personaValidar;

    public FormController() {
        
        this.personaValidar = new PersonaValidar();
    }
    
    
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView form(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("form");
        mav.addObject("persona",new Persona());
        return mav;
    }
    
    //recibimos y validamos los datos de nuestro formulario
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(@ModelAttribute("persona") Persona p, BindingResult result, SessionStatus status){
        
        this.personaValidar.validate(p, result);
        
        if(result.hasErrors()){
            //aca volmemos al formulario porque los datos 
            //ingresados por el usuario no son correctos 
            //es decir que se ejecuto la validacion
            ModelAndView mav = new ModelAndView();
            mav.setViewName("form");
            mav.addObject("persona",new Persona());
            return mav;
        }else{
            //aca entramos si el usuario ingreso bien los datos
            ModelAndView mav = new ModelAndView();
            mav.setViewName("exito");
            mav.addObject("nombre",p.getNombre());
            mav.addObject("correo",p.getCorreo());
            mav.addObject("pais",p.getPais());
            return mav;
        }
            
    }
    
    //metodo para pblar nuestro select
    @ModelAttribute("paisLista")
    public Map<String,String> listadoPaises(){
        Map<String,String> pais = new LinkedHashMap<>();
        pais.put("1", "Colombia");
        pais.put("2", "Chile");
        pais.put("3", "Japon");
        pais.put("4", "Argentina");
        pais.put("5", "Brazil");
        pais.put("6", "España");
        
        return pais;
    } 
}
