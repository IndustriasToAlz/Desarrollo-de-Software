package org.heyma.webapp;
  
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
  
/**
 *
 * @author John
 */
@Controller
public class MainController {
  
    @RequestMapping("/saludo.htm")
    public @ResponseBody
    String saludo() {
        return "Hola mundo";
    }
}
