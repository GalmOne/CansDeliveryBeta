/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeanPackage;

import entityPackage.Customer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Arnaud
 */
@Local
public interface CustomerFacadeLocal {

    void create(Customer customer);

    void edit(Customer customer);

    void remove(Customer customer);

    Customer find(Object id);

    List<Customer> findAll();

    List<Customer> findRange(int[] range);

    int count();
    
    public model.Customer getCustomer(Integer id);
    
    public Integer verifyLogin(model.Customer c);
}
