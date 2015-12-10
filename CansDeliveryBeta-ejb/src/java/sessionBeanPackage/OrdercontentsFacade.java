/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeanPackage;

import entityPackage.Can;
import entityPackage.Ordercontents;
import entityPackage.Orders;
import java.math.BigDecimal;
import java.util.HashMap;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


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
    
    public void addOrderContents (HashMap<Integer, model.OrderContents> listOrder)
    {
        for (model.OrderContents item : listOrder.values())
        {
            Ordercontents itemEntity = new Ordercontents();
            Can can = new Can ();
            Orders orders = new Orders ();
            
            can.setId(item.getCan().getId());
            itemEntity.setCan1(can);
            orders.setNumber(item.getOrder().getNumber()); //////////////////////ARRIVER ICI ! 
            itemEntity.setOrders1(orders);
            itemEntity.setQuantity((short) item.getQuantity());
            itemEntity.setTotalprice(new BigDecimal(item.getPrice()));
            
            create(itemEntity);
        }
    }
    
    
}
