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
@FacesValidator("ValidatorPassword")
@ManagedBean
@SessionScoped
public class ValidatorPassword implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String entry = (String) value;
                
        if (entry.length()==0) {
            String msg = context.getApplication().evaluateExpressionGet(context,"#{msg.ErrorPasswordNull}", String.class);
            
            FacesMessage mess = new FacesMessage(msg);
            throw new ValidatorException(mess);
        }
        
        if (entry.length() < 5 || entry.length() > 15) {
            String msg = context.getApplication().evaluateExpressionGet(context,"#{msg.ErrorPasswordCaracters}", String.class);
            
            FacesMessage mess = new FacesMessage(msg);
            throw new ValidatorException(mess);
        }
        
        if (!(entry.matches(".*(?=.{5,})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*"))){
            String msg = context.getApplication().evaluateExpressionGet(context,"#{msg.ErrorPasswordNotSecured}", String.class);
            
            FacesMessage mess = new FacesMessage(msg);
            throw new ValidatorException(mess);
        }
    }   
}
