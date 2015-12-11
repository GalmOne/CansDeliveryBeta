/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeanPackage;

import entityPackage.Ordercontents;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Arnaud
 */
@Local
public interface OrdercontentsFacadeLocal {

    void create(Ordercontents ordercontents);

    void edit(Ordercontents ordercontents);

    void remove(Ordercontents ordercontents);

    Ordercontents find(Object id);

    List<Ordercontents> findAll();

    List<Ordercontents> findRange(int[] range);

    int count();
    
    public void addOrderContents (HashMap<Integer, model.OrderContents> listOrder);
    
    public Integer getMaxNumberOrder();
    
}
