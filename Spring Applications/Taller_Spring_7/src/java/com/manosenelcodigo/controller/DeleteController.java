
package com.manosenelcodigo.controller;

import com.manosenelcodigo.modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class DeleteController {
    
    private JdbcTemplate jdbcTemplate;

    public DeleteController() {
        
        Conectar con = new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar() );
    }
    
   @RequestMapping("delete.htm")
    public ModelAndView form(HttpServletRequest request){
        
        int cod_cliente = Integer.parseInt(request.getParameter("cod_cliente"));
        this.jdbcTemplate.update(
                    "delete from cliente "
                  + "where "
                  + "cod_cliente=? ",
                     cod_cliente);
        return new ModelAndView("redirect:/home.htm");
    }
}
