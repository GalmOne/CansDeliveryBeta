/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;
import ejb.SaveSessionBeanLocal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import model.Customer;
@FacesValidator("ValidatorLogin")
@ManagedBean
@SessionScoped
public class ValidatorLogin implements Validator {
    @EJB
    private SaveSessionBeanLocal saveSessionBean;
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String entry = String.valueOf(value);
                
        if (entry.length()==0) {
            String msg = context.getApplication().evaluateExpressionGet(context,"#{msg.ErrorLoginNull}", String.class);
            
            FacesMessage mess = new FacesMessage(msg);
            throw new ValidatorException(mess);
        }
        
        if (entry.length() < 5 || entry.length() >  15){
            String msg = context.getApplication().evaluateExpressionGet(context,"#{msg.ErrorLoginCaracters}", String.class);
            
            FacesMessage mess = new FacesMessage(msg);
            throw new ValidatorException(mess);
        }
        
        if (entry.equals("admin") || entry.equals("login") ) {
            String msg = context.getApplication().evaluateExpressionGet(context,"#{msg.ErrorLoginReserved}", String.class);
            
            FacesMessage mess = new FacesMessage(msg);
            throw new ValidatorException(mess);
        }
        
        Customer customer = new Customer();
        customer = saveSessionBean.checkLogin(entry);
        
        if ((customer.getLogin().equals(entry))) {
            String msg = context.getApplication().evaluateExpressionGet(context,"#{msg.ErrorLoginExisted}", String.class);
            
            FacesMessage mess = new FacesMessage(msg);
            throw new ValidatorException(mess);
        }
    }   
}

