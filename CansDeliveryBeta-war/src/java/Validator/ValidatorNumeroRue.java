/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

import javax.faces.bean.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
@FacesValidator("ValidatorNumeroRue")
@ManagedBean
@SessionScoped
public class ValidatorNumeroRue implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String entry = (String) value;
                
        if (entry.length()==0) {
            FacesMessage mess = new FacesMessage("NumbersNull");
            throw new ValidatorException(mess);
        }
        
        if ((entry.length() > 3)) {
            FacesMessage mess = new FacesMessage("NumbersCount");
            throw new ValidatorException(mess);
        }
        
        if (!(entry.matches("[0-9]*"))){
            FacesMessage mess = new FacesMessage("NumbersOnlyNumbers");
            throw new ValidatorException(mess);
        }
    }   
}
