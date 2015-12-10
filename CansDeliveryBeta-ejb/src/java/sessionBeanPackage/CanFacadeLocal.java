/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeanPackage;

import entityPackage.Can;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Arnaud
 */
@Local
public interface CanFacadeLocal {

    void create(Can can);

    void edit(Can can);

    void remove(Can can);

    Can find(Object id);

    List<Can> findAll();

    List<Can> findRange(int[] range);

    int count();
    
    public List<model.Can> allCans();
    
    public List<model.Can> getCanByCategory(model.DrinkType cat);
    
}
