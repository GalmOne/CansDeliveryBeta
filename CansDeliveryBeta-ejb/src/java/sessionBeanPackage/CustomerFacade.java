/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeanPackage;

import entityPackage.Customer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Arnaud
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeLocal {
    @PersistenceContext(unitName = "CansDeliveryBeta-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }
    
    public model.Customer getCustomer(Integer id)
    {
        Customer customerEntity = new Customer ();
        model.Customer customerModel = new model.Customer ();
        
        customerEntity = find(id);
                      
        customerModel.setId(customerEntity.getId());
        customerModel.setName(customerEntity.getName());
        customerModel.setFirstname(customerEntity.getFirstname());
        customerModel.setLogin(customerEntity.getLogin());
        customerModel.setPassword(customerEntity.getPassword());
        customerModel.setBirthdate(customerEntity.getBirthdate());
        customerModel.setEmail(customerEntity.getEmail());
        customerModel.setGsm(customerEntity.getGsm());
        customerModel.setNumber(customerEntity.getAdrNumber());
        customerModel.setStreet(customerEntity.getAdrStreet());
        customerModel.setPosteCode(customerEntity.getAdrPostecode());
        customerModel.setCity(customerEntity.getAdrCity());
        
        return customerModel;
    }
    
    public Integer verifyLogin(model.Customer c)
    {
        Query query = em.createNativeQuery("SELECT id FROM A.CUSTOMER WHERE LOGIN = '"+c.getLogin()+"' AND PASSWORD = '"+c.getPassword()+"'");
        
        Integer id = 0 ;
        id = (Integer) query.getSingleResult();
        
        return id;        
    }
    
}
