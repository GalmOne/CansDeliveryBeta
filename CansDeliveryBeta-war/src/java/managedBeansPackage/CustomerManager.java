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
    
    public void createAccount() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        Date d = sdf.parse(getBirthdateString());
        
                customerToManage.setPosteCode(Integer.parseInt(getPostalCodeString()));
                //customerToManage.setBirthdate(null);
                
                saveSessionBean.creationCustomer(customerToManage);
                
                FacesMessage message = new FacesMessage( "Succès de l'inscription, bienvenue " + customerToManage.getName() + " " + customerToManage.getFirstname() + " !" );
                FacesContext.getCurrentInstance().addMessage( null, message );
            
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
        
        connected = false;
        return "faces/login.xhtml";
    }

    public static boolean isConnected() {
        return connected;
    }

    public static void setConnected(boolean connected) {
        CustomerManager.connected = connected;
    }
    
    
}
