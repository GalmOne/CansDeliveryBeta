/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeanPackage;

import entityPackage.Orders;
import entityPackage.Customer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Arnaud
 */
@Stateless
public class OrdersFacade extends AbstractFacade<Orders> implements OrdersFacadeLocal {
    @PersistenceContext(unitName = "CansDeliveryBeta-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdersFacade() {
        super(Orders.class);
    }
    
    public void addOrder (model.Order order)
    {
        Orders entityOrder = new Orders ();
        entityOrder.setNumber(order.getNumber());
        Customer cust = new Customer ();
        // passer d'un client modèle à un cllient entity
        cust.setId(order.getClient().getId());
        /*
        cust.setName(order.getClient().getName());
        cust.setFirstname(order.getClient().getFirstname());
        cust.setLogin(order.getClient().getLogin());
        cust.setPassword(order.getClient().getPassword());
        cust.setBirthdate(order.getClient().getBirthdate());
        cust.setEmail(order.getClient().getEmail());
        cust.setGsm(order.getClient().getGsm());
        cust.setAdrNumber(order.getClient().getNumber());
        cust.setAdrStreet(order.getClient().getStreet());
        cust.setAdrPostecode(order.getClient().getPosteCode());
        cust.setAdrCity(order.getClient().getCity());
          */    
        entityOrder.setCustomer(cust);
        entityOrder.setCreationdate(order.getCreationDate());
        entityOrder.setRemise(BigDecimal.ZERO);
        entityOrder.setStatus(order.getStatus());
        
        create(entityOrder);             
    }
    
    public List<model.Order> getCustomerOrders (model.Customer cModel)
    {
        List<model.Order> listOrdersModel = new ArrayList<model.Order> ();
        Query query; 
        
        Customer cEntity = new Customer();
        cEntity.setId(cModel.getId());
        
        query = em.createNamedQuery("Orders.findByCustomer");
        query.setParameter("Customer", cEntity);
        
        List<Orders> listOrders = query.getResultList();
        
        for(int i =0; i<listOrders.size(); i++)
        {
            model.Order order = new model.Order();
            
            order.setNumber(listOrders.get(i).getNumber());
            order.setRemise(listOrders.get(i).getRemise().doubleValue());
            order.setCreationDate(listOrders.get(i).getCreationdate());
            order.setStatus(listOrders.get(i).getStatus());
            order.setCustomer(null);
            
            listOrdersModel.add(order);
        }     
        
        return listOrdersModel;
    }
    
   
}
