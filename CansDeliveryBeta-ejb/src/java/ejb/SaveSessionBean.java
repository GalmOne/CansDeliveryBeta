/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.EJB;

import javax.ejb.Stateless;

import model.*;
import sessionBeanPackage.CanFacadeLocal;
import sessionBeanPackage.CustomerFacadeLocal;
import sessionBeanPackage.DrinktypeFacadeLocal;
import sessionBeanPackage.OrdersFacadeLocal;



/**
 *
 * @author Arnaud
 */
@Stateless
public class SaveSessionBean implements SaveSessionBeanLocal {
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
    
    public Integer verifyLogin(Customer c)
    {
        return customerFacade.verifyLogin(c);
    }
    
    public List<DrinkType> getCategories()
    {
        return drinktypeFacade.getCategories();
    }
    
    public List<Can> getCanByCategory(DrinkType cat)
    {
        return canFacade.getCanByCategory(cat);
    }
}
