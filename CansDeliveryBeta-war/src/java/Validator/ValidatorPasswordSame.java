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
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
@FacesValidator("ValidatorPasswordSame")
@ManagedBean
@SessionScoped
public class ValidatorPasswordSame implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        String confirm =(String) value;
        
        UIInput confirmComponent = (UIInput) component.getAttributes().get("password");
        String password = (String) confirmComponent.getValue();
        
        if (confirm.length()==0) {
            String msg = context.getApplication().evaluateExpressionGet(context,"#{msg.ErrorPasswordNull}", String.class);
            FacesMessage mess = new FacesMessage(msg);
            throw new ValidatorException(mess);
        }
        if (!(password.equals(confirm))) {
            String msg = context.getApplication().evaluateExpressionGet(context,"#{msg.ErrorPasswordDifferent}", String.class);
            FacesMessage mess = new FacesMessage(msg);
            throw new ValidatorException(mess);
        }
    }
}