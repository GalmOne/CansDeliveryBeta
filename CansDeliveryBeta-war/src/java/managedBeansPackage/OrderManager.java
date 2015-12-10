/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeansPackage;

import ejb.DiscountSessionBeanLocal;
import ejb.SaveSessionBeanLocal;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.ejb.EJB;
import model.*;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Arnaud
 */
@ManagedBean(name="orderManager")
@SessionScoped
public class OrderManager implements Serializable{
    
    @EJB
    private DiscountSessionBeanLocal discountSessionBean;
    
    @EJB
    private SaveSessionBeanLocal saveSessionBean;       
    private Order orderToManage;  
    private static Integer key = 0;
    
    private HashMap<Integer, OrderContents> listOrder = new HashMap <> ();
     
    
    
    public OrderManager() {
        orderToManage = new Order();
         
    }
    
    public void addItem(Can c)
    {                     
        OrderContents item = new OrderContents(c,1, orderToManage);
        
        if(listOrder.containsKey(c.getId()))
            listOrder.get(c.getId()).setQuantity(listOrder.get(c.getId()).getQuantity()+1);
        else
            listOrder.put(c.getId(), item);
          
    
    }
    
    
    
    public void deleteItem (Integer k)
    {
        listOrder.remove(k);
        
    }
    
    public double calculatePrix(int qty, double price)
    {   
        return qty * price; 
        
    }
    
    public double CalculateTotalPrice()
    {    
        
        double total = 0;
        
        
        
        for(OrderContents item : listOrder.values())
        {
            total += item.getPrice();
        }
        
        return total;
    }
    
    
    
    //Méthode pour sauver la commande dans la base de données. 
    public String saveOrder(Customer c, boolean connected)
    {
        System.out.println(c.getName());
        
        if(connected)
        {
            Date date = Calendar.getInstance().getTime();
            orderToManage.setCreationDate(date);
            orderToManage.setNumber(Integer.SIZE);
            orderToManage.setStatus("Validée");
            orderToManage.setClient(c);

            saveSessionBean.saveOrder(orderToManage);
            saveSessionBean.saveListOrder(listOrder);
        return "faces/account.xhtml";
        }
        else     
            return "faces/login.xhtml";
    }
    
    
    
    public HashMap<Integer, OrderContents> getListOrder ()
    {
        return listOrder;
    }
    
    public double discount(double tot)
    {
        return discountSessionBean.calculateDiscount(tot);
    }
    
}
