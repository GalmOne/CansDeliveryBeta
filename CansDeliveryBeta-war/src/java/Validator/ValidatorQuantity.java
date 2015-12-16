/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;


import java.util.regex.*;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Arnaud
 */
@FacesValidator("quantityValidator")
public class ValidatorQuantity implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        //String entry = String.valueOf(value);
        //int entryInt = Integer.parseInt(entry);
        
        if(value == null)
        {
            String msg = context.getApplication().evaluateExpressionGet(context,"#{msg.ErrorQtyEmpty}", String.class);
            
            FacesMessage mess = new FacesMessage(msg);
            throw new ValidatorException(mess);  
        }else
        {
            String entry = String.valueOf(value);
            int entryInt = Integer.parseInt(entry);
            

            if ((entry.length() >3)) {
                String msg = context.getApplication().evaluateExpressionGet(context,"#{msg.ErrorQty}", String.class);

                FacesMessage mess = new FacesMessage(msg);
                throw new ValidatorException(mess);
            }

            if (!(entry.matches("^[0-9]+$"))){
                String msg = context.getApplication().evaluateExpressionGet(context,"#{msg.ErrorOnlyNumber}", String.class);

                FacesMessage mess = new FacesMessage(msg);
                throw new ValidatorException(mess);
            }

            if(entryInt <= 0)
            {
                String msg = context.getApplication().evaluateExpressionGet(context,"#{msg.ErrorNegative}", String.class);

                FacesMessage mess = new FacesMessage(msg);
                throw new ValidatorException(mess);
            }
        }
        
        
        
    }
    
    
}
