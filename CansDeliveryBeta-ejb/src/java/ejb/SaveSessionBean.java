/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;

import javax.ejb.Stateless;

import model.*;
import sessionBeanPackage.CanFacadeLocal;
import sessionBeanPackage.CustomerFacadeLocal;
import sessionBeanPackage.DrinktypeFacadeLocal;
import sessionBeanPackage.OrdercontentsFacadeLocal;
import sessionBeanPackage.OrdersFacadeLocal;



/**
 *
 * @author Arnaud
 */
@Stateless
public class SaveSessionBean implements SaveSessionBeanLocal {
    @EJB
    private OrdercontentsFacadeLocal ordercontentsFacade;
    @EJB
    private DrinktypeFacadeLocal drinktypeFacade;
    @EJB
    private CustomerFacadeLocal customerFacade;
    @EJB
    private OrdersFacadeLocal ordersFacade;
    @EJB
    private CanFacadeLocal canFacade;
    
    
    
    public void saveOrder(Order order)
    {
        ordersFacade.addOrder(order);
    }
    
    public List<Can> allCans()
    {
        return canFacade.allCans();
    }
     
    public Customer getCustomer(Integer id)
    {
        return customerFacade.getCustomer(id);
    }
    
    
    
    public List<DrinkType> getCategories()
    {
        return drinktypeFacade.getCategories();
    }
    
    public List<Can> getCanByCategory(DrinkType cat)
    {
        return canFacade.getCanByCategory(cat);
    }
    
    public void saveListOrder(HashMap<Integer, OrderContents> listOrder)
    {
        ordercontentsFacade.addOrderContents(listOrder);
    }
    
    public Customer verifyLogin(String loginCheck, String passwordCheck)
    {
        return customerFacade.verifyLogin(loginCheck, passwordCheck);
    }
    
    public Customer checkLogin(String loginCheck) {
        return customerFacade.checkLogin(loginCheck);
    }
    
    public Customer checkEmail (String emailCheck) {
        return customerFacade.checkEmail(emailCheck);
    }
    
    public void creationCustomer(Customer c) {
        customerFacade.creationCustomer(c);   
    }
    
    public List<Order> getCustomerOrders (Customer cModel)
    {
        return ordersFacade.getCustomerOrders(cModel);
    }
    
    
}
