/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeanPackage;

import entityPackage.Drinktype;
import entityPackage.Traductiondrinktype;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Arnaud
 */
@Stateless
public class DrinktypeFacade extends AbstractFacade<Drinktype> implements DrinktypeFacadeLocal {
    @PersistenceContext(unitName = "CansDeliveryBeta-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DrinktypeFacade() {
        super(Drinktype.class);
    }
    
    public List<model.DrinkType> getCategories ()
    {
        List<Drinktype> listTypeEntity = findAll();
        List<model.DrinkType> listTypeModel = new ArrayList <> ();
      
        for(Drinktype allType : listTypeEntity)
        {
            model.DrinkType catModel = new model.DrinkType();           
            
            catModel.setId(allType.getId()); 
                       
            HashMap<String, model.TraductionDrinkType> tradCatHashMap = new HashMap<>();
            for(Traductiondrinktype tradCatEntity : allType.getTraductiondrinktypeCollection())
            {
                model.TraductionDrinkType tradCatModel = new model.TraductionDrinkType();
                
                tradCatModel.setDescritpion(tradCatEntity.getDescription());
                tradCatHashMap.put(tradCatEntity.getLanguages1().getIdlanguages(), tradCatModel);
            }
            catModel.setTraductionType(tradCatHashMap);
         
            listTypeModel.add(catModel);
        }
        
        return listTypeModel;
    }
    
}
