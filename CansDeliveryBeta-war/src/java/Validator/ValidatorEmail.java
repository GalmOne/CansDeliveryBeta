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
import sessionBeanPackage.CustomerFacadeLocal;
@FacesValidator("ValidatorEmail")
@ManagedBean
@SessionScoped
public class ValidatorEmail implements Validator {
    @EJB
    private SaveSessionBeanLocal saveSessionBean;
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String entry = (String) value;
                
        if (entry.length()==0) {
            String msg = context.getApplication().evaluateExpressionGet(context,"#{msg.ErrorEmailNull}", String.class);
            
            FacesMessage mess = new FacesMessage(msg);
            throw new ValidatorException(mess);
        }
        
        if (!(entry.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)"))){
            String msg = context.getApplication().evaluateExpressionGet(context,"#{msg.ErrorEmailNotCorrect}", String.class);
            
            FacesMessage mess = new FacesMessage(msg);
            throw new ValidatorException(mess);
        }
        
        Customer customer = new Customer();
        
        customer = saveSessionBean.checkEmail(entry);
            
        if (customer.getEmail().equals(entry)) {
            String msg = context.getApplication().evaluateExpressionGet(context,"#{msg.ErrorEmailnExisted}", String.class);
            
            FacesMessage mess = new FacesMessage(msg);
            throw new ValidatorException(mess);
        }
    }   
}