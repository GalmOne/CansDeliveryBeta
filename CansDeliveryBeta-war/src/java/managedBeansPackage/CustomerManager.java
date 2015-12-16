/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeansPackage;

import ejb.SaveSessionBeanLocal;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import model.*;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Arnaud
 */
@ManagedBean(name="customerManager")
@SessionScoped
public class CustomerManager implements Serializable{
    @EJB
    private SaveSessionBeanLocal saveSessionBean;

    
    private Customer customerToManage;
    private static boolean connected = false;
    private String postalCodeString;
    private String birthdateString;
    private static boolean welcomeMess = true;
    
    public CustomerManager() {
               
        customerToManage = new Customer ();
        
    }
    
    

    public Customer getCustomerToManage() {
        return customerToManage;
    }

    public void setCustomerToManage(Customer customerToManage) {
        this.customerToManage = customerToManage;
    }
    
    public void getCustomer(Integer id)
    {
        customerToManage = saveSessionBean.getCustomer(id);
    }
    
    public String verifyLogin()
    {
        String loginCheck = customerToManage.getLogin();
        String passwordCheck = customerToManage.getPassword();
        
        Customer customer = new Customer();
        
        customer = saveSessionBean.verifyLogin(loginCheck, passwordCheck);
        
        if (customer.getName().equals("NULL")) {
            FacesMessage message = new FacesMessage( "Erreur de login / mot de passe. ");
            FacesContext.getCurrentInstance().addMessage( null, message );
            return null;
        } else {
            customerToManage=customer;
            connected=true;
            return "faces/account";
        }
    }
    
    public String createAccount() throws ParseException {
        
        String test = getBirthdateString();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = sdf.parse(test);
        
        customerToManage.setBirthdate(d);
        customerToManage.setPosteCode(Integer.parseInt(getPostalCodeString()));
        //customerToManage.setBirthdate(null);

        saveSessionBean.creationCustomer(customerToManage);
                               
        
        return "faces/login.xhtml";
            
        }
    public String getPostalCodeString() {
        return postalCodeString;
    }
    public void setPostalCodeString(String postalCodeString) {
        this.postalCodeString = postalCodeString;
    }
    public String getBirthdateString() {
        return birthdateString;
    }
    public void setBirthdateString(String birthdateString) {
        this.birthdateString = birthdateString;
    }
    
    public String checkConnexion ()
    {
        if(connected)
            return "faces/account.xhtml";
        else
            return "faces/login.xhtml";
    }
    
    public String deconnexion()
    {
        welcomeMess = true;
        connected = false;
        return "faces/login.xhtml";
    }

    public static boolean isConnected() {
        return connected;
    }

    public static void setConnected(boolean connected) {
        CustomerManager.connected = connected;
    }
    
    public String WelcomeMessage () {
        if (welcomeMess) {
            welcomeMess = false;
            return (customerToManage.getName() + "  " + customerToManage.getFirstname() + " !" );
        } else {
            return null;
        }
    }
    
    public static boolean isWelcomeMess() {
        return welcomeMess;
    }
    
    public static void setWelcomeMess(boolean welcomeMess) {
        CustomerManager.welcomeMess = welcomeMess;
    }
}
