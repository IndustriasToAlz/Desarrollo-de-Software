
package com.manosenelcodigo.controller;

import com.manosenelcodigo.modelos.Conectar;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    
    private JdbcTemplate jdbc_template;

    public HomeController() {
        
        Conectar con = new Conectar();
        this.jdbc_template = new JdbcTemplate(con.conectar());
    }
    
    
    
    @RequestMapping("home.htm")
    public ModelAndView home(){
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        
        String sql = "SELECT * FROM DBO.CLIENTE";
        List datos = this.jdbc_template.queryForList(sql);
        
        mav.addObject("datos",datos);
        
        return mav;
    }
}
