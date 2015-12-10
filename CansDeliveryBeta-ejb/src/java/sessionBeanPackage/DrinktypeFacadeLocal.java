/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeanPackage;

import entityPackage.Drinktype;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Arnaud
 */
@Local
public interface DrinktypeFacadeLocal {

    void create(Drinktype drinktype);

    void edit(Drinktype drinktype);

    void remove(Drinktype drinktype);

    Drinktype find(Object id);

    List<Drinktype> findAll();

    List<Drinktype> findRange(int[] range);

    int count();
    
    public List<model.DrinkType> getCategories ();
    
}
