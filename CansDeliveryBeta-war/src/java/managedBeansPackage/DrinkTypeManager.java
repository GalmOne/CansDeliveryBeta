/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeansPackage;

import ejb.SaveSessionBeanLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.*;

/**
 *
 * @author Arnaud
 */
@ManagedBean(name="drinkTypeManager")
@SessionScoped
public class DrinkTypeManager implements Serializable {
    @EJB
    private SaveSessionBeanLocal saveSessionBean;
    
    private DrinkType typeToManage;
    
    
    public DrinkTypeManager() {
        
        typeToManage = new DrinkType ();
       
    }
    
    public List<DrinkType> getCategories()
    {
        return saveSessionBean.getCategories();
    }
    
    
    
}
