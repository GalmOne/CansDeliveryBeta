/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeanPackage;

import entityPackage.Ordercontents;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Arnaud
 */
@Stateless
public class OrdercontentsFacade extends AbstractFacade<Ordercontents> implements OrdercontentsFacadeLocal {
    @PersistenceContext(unitName = "CansDeliveryBeta-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdercontentsFacade() {
        super(Ordercontents.class);
    }
    
}
