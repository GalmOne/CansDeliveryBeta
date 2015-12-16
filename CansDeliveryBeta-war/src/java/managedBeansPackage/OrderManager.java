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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
    private int quantity = 1;
    private double remise=0;
    private double totalPrice = 0;
    
    private HashMap<Integer, OrderContents> listOrder = new HashMap <> ();
     
    
    
    public OrderManager() {
        orderToManage = new Order();
         
    }
    
    public String addItem(Can c)
    {                     
        OrderContents item = new OrderContents(c, orderToManage);
        
        if(listOrder.containsKey(c.getId()))
            listOrder.get(c.getId()).setQuantity(listOrder.get(c.getId()).getQuantity()+1);
        else
            listOrder.put(c.getId(), item);
        return "faces/basket.xhtml";
    }
    
    public String addfewItems(Can c, int qtt)
    {
        OrderContents item = new OrderContents(c, orderToManage);
        
        if(qtt <= 0)
            qtt = 1;
        
        if(listOrder.containsKey(c.getId()))
            listOrder.get(c.getId()).setQuantity(listOrder.get(c.getId()).getQuantity()+qtt);
        else
        {
            item.setQuantity(qtt);
            listOrder.put(c.getId(), item);
        }       
        quantity = 1;
        return "faces/basket.xhtml";
    }
    
    
    public String deleteItem (Integer k)
    {
        listOrder.remove(k);
        return "faces/basket.xhtml";
    }
    
    public double calculatePrix(int qty, double price)
    {   
        if(qty <= 0)
            qty = 1;
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
            if(listOrder.isEmpty())
            {
                return "faces/listCan.xhtml";
            }
            else
            {
                                
                Date date = Calendar.getInstance().getTime();
                orderToManage.setCreationDate(date);
                orderToManage.setNumber(Integer.SIZE);
                orderToManage.setStatus("Validée");
                orderToManage.setClient(c);

                saveSessionBean.saveOrder(orderToManage);         
                saveSessionBean.saveListOrder(listOrder);
                removeAllBasket();
            }
            
            
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
        remise = discountSessionBean.calculateDiscount(tot);
        return remise;
    }
    
    public double getDiscountPrice(double price)
    {
        totalPrice = price - remise;
        return totalPrice;
    }
    
    public List<Order> getCustomerOrders(Customer c)
    {
        return saveSessionBean.getCustomerOrders(c);
    }
    
    public void removeAllBasket()
    {
        listOrder.clear();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    
    
}
