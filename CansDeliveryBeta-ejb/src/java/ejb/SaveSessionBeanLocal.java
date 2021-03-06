/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;


import java.util.HashMap;
import java.util.List;
import javax.ejb.Local;
import model.Can;
import model.Customer;
import model.DrinkType;
import model.Order;
import model.OrderContents;

/**
 *
 * @author Arnaud
 */
@Local
public interface SaveSessionBeanLocal {
 
    
    public void saveOrder(Order order);
    
    public List<Can> allCans();
    
    public Customer getCustomer(Integer id);
    
    public List<DrinkType> getCategories();
    
    public List<Can> getCanByCategory(DrinkType cat);
    
    public void saveListOrder(HashMap<Integer, OrderContents> listOrder);
    
    public Customer verifyLogin(String loginCheck, String passwordCheck);
    
    public Customer checkLogin(String loginCheck);
    
    public Customer checkEmail (String emailCheck);
    
    public void creationCustomer(Customer c);
    
    public List<Order> getCustomerOrders (Customer cModel);
   
}
