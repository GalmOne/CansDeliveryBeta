/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeanPackage;

import entityPackage.Customer;
import java.security.Key;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Arnaud
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeLocal {
    @PersistenceContext(unitName = "CansDeliveryBeta-ejbPU")
    private EntityManager em;
    
    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = 
    new byte[] { 'T', 'h', 'i', 's', 'I', 's', 'A', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y' };

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
    
    public model.Customer verifyLogin(String loginCheck, String passwordCheck)
    {
        Customer customerEntity = new Customer();
        model.Customer customerModel = new model.Customer ();
        Query queryLogin;
        String passwordDecrypt = null;
        try {
            queryLogin = em.createNamedQuery("Customer.findByLogin");
            queryLogin.setParameter("login",loginCheck);
            customerEntity = (Customer)queryLogin.getSingleResult();
        } catch(NoResultException e) {
            customerModel.setName("NULL");
        }
        
        try {
            passwordDecrypt = decrypt(customerEntity.getPassword());
        } catch (Exception ex) {
            Logger.getLogger(CustomerFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if ((loginCheck.equals(customerEntity.getLogin()) && passwordCheck.equals(passwordDecrypt))) {
            customerModel.setId(customerEntity.getId());
            customerModel.setName(customerEntity.getName());
            customerModel.setFirstname(customerEntity.getFirstname());
            customerModel.setEmail(customerEntity.getEmail());
            customerModel.setGsm(customerEntity.getGsm());
            customerModel.setNumber(customerEntity.getAdrNumber());
            customerModel.setStreet(customerEntity.getAdrStreet());
            customerModel.setPosteCode(customerEntity.getAdrPostecode());
            customerModel.setCity(customerEntity.getAdrCity());
        } else {
            customerModel.setName("NULL");
        }         
        
        return customerModel;
    }
    
    public model.Customer checkLogin(String loginCheck) {
        
        Query query;
        Customer customer = new Customer();
        model.Customer customerModel = new model.Customer();
        
        try {
            query = em.createNamedQuery("Customer.findByLogin");
            query.setParameter("login",loginCheck);
            customer = (Customer)query.getSingleResult();
        } catch(NoResultException e) {
            customerModel.setLogin("NULL");
            return customerModel;
        }
        
        customerModel.setLogin(customer.getLogin());
        
        return customerModel;
    } 
    
    public model.Customer checkEmail (String emailCheck) {
        
        Query query;
        Customer customer = new Customer();
        model.Customer customerModel = new model.Customer();
        
        try {
            query = em.createNamedQuery("Customer.findByEmail");
            query.setParameter("email", emailCheck);
            customer = (Customer)query.getSingleResult();
        } catch(NoResultException e) {
            customerModel.setEmail("NULL");
            return customerModel;
        }
        
        customerModel.setEmail(customer.getEmail());
        
        return customerModel;
    }
    
    public void creationCustomer (model.Customer c) {
        String passwordCrypt = null;
        Customer customer = new Customer();
        customer.setName(c.getName());
        customer.setFirstname(c.getFirstname());
        customer.setLogin(c.getLogin());
        
        try {
            passwordCrypt = encrypt(c.getPassword());
        } catch (Exception ex) {
            Logger.getLogger(CustomerFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        customer.setPassword(passwordCrypt);
        
        customer.setBirthdate(c.getBirthdate());
        customer.setEmail(c.getEmail());
        customer.setGsm(c.getGsm());
        customer.setAdrNumber(c.getNumber());
        customer.setAdrStreet(c.getStreet());
        customer.setAdrPostecode(c.getPosteCode());
        customer.setAdrCity(c.getCity());
        customer.setAdrCountry("Belgium");
        
        create(customer);
    }
    
    // Cryptage Password 
    
    public static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue,ALGORITHM);
        return key;
    }
    
    
    public String encrypt (String valueToEnc) throws Exception {
    	Key key = generateKey();
	Cipher c = Cipher.getInstance(ALGORITHM);
	c.init(Cipher.ENCRYPT_MODE, key);
	byte[] encValue = c.doFinal(valueToEnc.getBytes());
	String encryptedValue = new BASE64Encoder().encode(encValue);
	return encryptedValue;
    }
    
    public String decrypt(String encryptedValue) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedValue);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
    
}
