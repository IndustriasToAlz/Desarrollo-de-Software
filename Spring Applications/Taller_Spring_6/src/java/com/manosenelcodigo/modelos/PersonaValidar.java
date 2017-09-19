
package com.manosenelcodigo.modelos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class PersonaValidar implements Validator {
    
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$";
    
    private Pattern pattern;
    private Matcher matcher;

    @Override
    public boolean supports(Class<?> type) {
        
        return Persona.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        
        Persona persona = (Persona)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "required.nombre","El campo nombre es obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "correo", "required.correo","El campo E-Mail es obligatorio.");
        
        if (!(persona.getCorreo() != null && !persona.getCorreo().isEmpty())){
            
            this.pattern = Pattern.compile(EMAIL_PATTERN);
            this.matcher = pattern.matcher(persona.getCorreo());
            if (!matcher.matches()) {
                errors.rejectValue("correo", "correo.incorrect","El E-Mail " + persona.getCorreo() + " ingresado no es valido");
            }
        }
        
        if(persona.getPais() == 0) {
            errors.rejectValue("pais", "pais.incorrect","El Pais seleccionado no es valido por favor selecciona una de la lista");
        }
    }
    
}
