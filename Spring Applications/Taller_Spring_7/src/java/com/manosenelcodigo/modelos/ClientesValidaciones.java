
package com.manosenelcodigo.modelos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class ClientesValidaciones implements Validator {
    
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    private Pattern pattern;
    private Matcher matcher;

    @Override
    public boolean supports(Class<?> type) {
        
        return Clientes.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        
        Clientes persona = (Clientes)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom_cliente", "required.nom_cliente","El campo nombre es obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ape_cliente", "required.ape_cliente","El campo apellido es obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dir_cliente", "required.dir_cliente","El campo direccion es obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email","El campo E-Mail es obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono_cliente", "required.telefono_cliente","El campo telefono es obligatorio.");
        
        if (!(persona.getEmail()!= null && !persona.getEmail().isEmpty())){
            
            this.pattern = Pattern.compile(EMAIL_PATTERN);
            this.matcher = pattern.matcher(persona.getEmail());
            if (!matcher.matches()) {
                errors.rejectValue("email", "email.incorrect","El E-Mail " + persona.getEmail()+ " ingresado no es valido");
            }
        }
        
        /*
        if(persona.getPais() == 0) {
            errors.rejectValue("pais", "pais.incorrect","El Pais seleccionado no es valido por favor selecciona una de la lista");
        }
        */
    }
    
}
