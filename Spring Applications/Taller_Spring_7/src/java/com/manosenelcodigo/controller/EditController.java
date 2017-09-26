
package com.manosenelcodigo.controller;


import com.manosenelcodigo.modelos.Conectar;
import com.manosenelcodigo.modelos.Clientes;
import com.manosenelcodigo.modelos.ClientesValidaciones;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("edit.htm")
public class EditController {
    
    ClientesValidaciones clientesValidar;
    private JdbcTemplate jdbcTemplate;

    public EditController() {
        
        this.clientesValidar = new ClientesValidaciones();
        Conectar con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request){
        
        ModelAndView mav = new ModelAndView();
        int cod_cliente = Integer.parseInt(request.getParameter("cod_cliente"));
        Clientes datos = this.selectCustomer(cod_cliente);
        mav.setViewName("edit");
        mav.addObject("clientes", new Clientes(cod_cliente,datos.getNom_cliente(),datos.getApe_cliente(),datos.getDir_cliente(),datos.getTelefono_cliente(),datos.getEmail()));
        return mav;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(@ModelAttribute("clientes") Clientes c, BindingResult result, SessionStatus status, HttpServletRequest request){
        
        this.clientesValidar.validate(c, result);
        
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            int cod_cliente = Integer.parseInt(request.getParameter("cod_cliente"));
            Clientes datos = this.selectCustomer(cod_cliente);
            mav.setViewName("edit");
            mav.addObject("clientes", new Clientes(cod_cliente,datos.getNom_cliente(),datos.getApe_cliente(),datos.getDir_cliente(),datos.getTelefono_cliente(),datos.getEmail()));
            return mav;
        }else{
            int cod_cliente = Integer.parseInt(request.getParameter("cod_cliente"));
            String sqlstr = "UPDATE dbo.cliente "
                                    +"SET NOM_CLIENTE = '" + c.getNom_cliente() + "', "
                                    +"APE_CLEINTE = '"+ c.getApe_cliente() +"', "
                                    +"DIR_CLIENTE = '" + c.getDir_cliente() + "', "
                                    +"EMAIL = '"+ c.getEmail() +"', "
                                    +"TELEFONO_CLIENTE = '" + c.getTelefono_cliente() + "' "
                                    +"WHERE COD_CLIENTE = " + cod_cliente + "";
            this.jdbcTemplate.update(sqlstr);
            return new ModelAndView("redirect:/home.htm");
        }
    }
    
    public Clientes selectCustomer(int cod_cliente){
        final Clientes customer = new Clientes();
        String quer = "SELECT * FROM CLIENTE WHERE COD_CLIENTE = " + cod_cliente + "";
        return (Clientes) jdbcTemplate.query
        (quer, new ResultSetExtractor<Clientes>() {
            public Clientes extractData(ResultSet rs) throws SQLException, DataAccessException{
                if (rs.next()) {
                    customer.setNom_cliente(rs.getString("NOM_CLIENTE"));
                    customer.setApe_cliente(rs.getString("APE_CLEINTE"));
                    customer.setDir_cliente(rs.getString("DIR_CLIENTE"));
                    customer.setEmail(rs.getString("EMAIL"));
                    customer.setTelefono_cliente(rs.getString("TELEFONO_CLIENTE"));
                }
                
                return customer;
            }
        });
    }
    
}
