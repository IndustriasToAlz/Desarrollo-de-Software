
package com.manosenelcodigo.controller;

import com.manosenelcodigo.modelos.Clientes;
import com.manosenelcodigo.modelos.ClientesValidaciones;
import com.manosenelcodigo.modelos.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("add.htm")
public class AddController {
    
    ClientesValidaciones clientesValidar;
    private JdbcTemplate jdbcTemplate;

    public AddController() {
        
        this.clientesValidar = new ClientesValidaciones();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(){
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("add");
        mav.addObject("clientes", new Clientes());
        return mav;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(@ModelAttribute("clientes") Clientes c, BindingResult result, SessionStatus status){
        
        this.clientesValidar.validate(c, result);
        
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("add");
            mav.addObject("clientes", new Clientes());
            return mav;
        }else{
            this.jdbcTemplate.update("INSERT INTO dbo.CLIENTE (NOM_CLIENTE,APE_CLEINTE,DIR_CLIENTE,EMAIL,TELEFONO_CLIENTE) VALUES (?,?,?,?,?)", 
                                     c.getNom_cliente(), c.getApe_cliente(),c.getDir_cliente(),c.getEmail(),c.getTelefono_cliente());
            return new ModelAndView("redirect:/home.htm");
        }
    }
    
    
    
    
    
}
