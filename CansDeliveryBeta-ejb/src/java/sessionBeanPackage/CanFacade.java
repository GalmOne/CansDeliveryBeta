/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeanPackage;

import entityPackage.Can;
import entityPackage.Drinktype;
import entityPackage.Traductioncan;
import java.util.ArrayList;
import java.util.HashMap;
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
public class CanFacade extends AbstractFacade<Can> implements CanFacadeLocal {
    @PersistenceContext(unitName = "CansDeliveryBeta-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CanFacade() {
        super(Can.class);
    }
    
    public List<model.Can> allCans()
    {
        List<Can> allEntityCanette = findAll();
        List<model.Can> allModelCanette = new ArrayList<model.Can>();
        
        for(Can allCan : allEntityCanette)
        {
            model.Can can = new model.Can();
            model.DrinkType type = new model.DrinkType();
            
            can.setId(allCan.getId());         
            can.setBrand(allCan.getBrand());
            can.setPrice(allCan.getPrice().doubleValue());
            can.setLimitedEdition(allCan.getLimitededition());
            can.setCapacity(allCan.getCapacity());
            can.setPicture(allCan.getPicture());
            can.setStock(allCan.getStock());
            
            HashMap<String, model.TraductionCan> tradCanHashMap = new HashMap<>();
            for(Traductioncan tradCanEntity : allCan.getTraductioncanCollection())
            {
                model.TraductionCan tradCanModel = new model.TraductionCan();
                tradCanModel.setName(tradCanEntity.getName());
                tradCanModel.setDscription(tradCanEntity.getDescription());
                tradCanHashMap.put(tradCanEntity.getLanguages1().getIdlanguages(), tradCanModel);
            }
            can.setTradCan(tradCanHashMap);
            
            //type.setId(allEntityCanette.get(i).getDrinktype().getId());
            
            can.setDrinktype(null);
            
            allModelCanette.add(can);
        }
        
        return allModelCanette;
    }
    
    public List<model.Can> getCanByCategory(model.DrinkType cat)
    {
        Query query; 
        List<model.Can> listModCategoryCan = new ArrayList<model.Can>();
        Drinktype catEntity = new Drinktype ();
        catEntity.setId(cat.getId());
        
        query = em.createNamedQuery("Can.findByCategory");
        query.setParameter("DrinkType", catEntity);
        List<Can> listEntCategoryCan = query.getResultList();
        
        for(Can allCan : listEntCategoryCan)
        {
            model.Can can = new model.Can();           
            
            can.setId(allCan.getId());         
            can.setBrand(allCan.getBrand());
            can.setPrice(allCan.getPrice().doubleValue());
            can.setLimitedEdition(allCan.getLimitededition());
            can.setCapacity(allCan.getCapacity());
            can.setPicture(allCan.getPicture());
            can.setStock(allCan.getStock());
            
            HashMap<String, model.TraductionCan> tradCanHashMap = new HashMap<>();
            for(Traductioncan tradCanEntity : allCan.getTraductioncanCollection())
            {
                model.TraductionCan tradCanModel = new model.TraductionCan();
                tradCanModel.setName(tradCanEntity.getName());
                tradCanModel.setDscription(tradCanEntity.getDescription());
                tradCanHashMap.put(tradCanEntity.getLanguages1().getIdlanguages(), tradCanModel);
            }
            can.setTradCan(tradCanHashMap);
                                  
            can.setDrinktype(null);
            
            listModCategoryCan.add(can);
        }
                     
        
        return listModCategoryCan; 
    }
}
