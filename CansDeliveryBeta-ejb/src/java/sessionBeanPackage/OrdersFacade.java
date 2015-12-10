/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeanPackage;

import entityPackage.Orders;
import entityPackage.Customer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
        entityOrder.setNumber(Integer.SIZE);
        Customer cust = new Customer ();
        // passer d'un client modèle à un cllient entity
        cust.setId(order.getClient().getId());
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
              
        entityOrder.setCustomer(cust);
        entityOrder.setCreationdate(order.getCreationDate());
        entityOrder.setStatus(order.getStatus());
        
        create(entityOrder);
        
    }
}
