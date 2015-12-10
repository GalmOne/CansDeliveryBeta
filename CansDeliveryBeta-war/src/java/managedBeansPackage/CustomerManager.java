/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeansPackage;

import ejb.SaveSessionBeanLocal;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import model.*;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Arnaud
 */
@ManagedBean(name="customerManager")
@SessionScoped
public class CustomerManager implements Serializable{
    @EJB
    private SaveSessionBeanLocal saveSessionBean;

    private String welcome = "Welcome";
    private Customer customerToManage;
    private static boolean connected = false;
    
    public CustomerManager() {
        
        //customerToManage = new Customer (10000, "Henry","Bienfait","a","a",new Date(1993, 02,04), "r", "z","r", "r", 55555, "rrrr");
        customerToManage = new Customer ();
        
    }
    
    
    public String getWelcomeMessage()
    {
        return welcome;
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
        Integer id = saveSessionBean.verifyLogin(customerToManage);
        
        if(id >= 10000 && id <= 11000)
        {
            getCustomer(id);
            connected = true;
            return "faces/account";
            
        }
        else
            return "Mauvais combinaison login-password";
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
    
    
}
