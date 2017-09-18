
package com.manosenelcodigo.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    
    @RequestMapping("home.htm")
    public ModelAndView home(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home/home");
        String id = request.getParameter("id");
        String id2 = request.getParameter("id2");
        mav.addObject("id",id);
        mav.addObject("id2",id2);
        return mav;
    }
    
    @RequestMapping("nosotros.htm")
    public ModelAndView nosotros(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home/nosotros");
        return mav;
    }
    
}
