/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeansPackage;

import ejb.SaveSessionBeanLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.*;

/**
 *
 * @author Arnaud
 */
@ManagedBean(name="canManager")
@SessionScoped
public class CanManager implements Serializable{
    @EJB
    private SaveSessionBeanLocal saveSessionBean;
   
    private Can canToManage;
    private DrinkType categoryToManage;
    private List<Can> listCategoryCan;
    
    public CanManager() {
        
        canToManage = new Can ();
        categoryToManage = new DrinkType();
        
    }
    
    public List<Can> getCanList ()
    {
        return saveSessionBean.allCans();
    }
    
    
    public String getCanByCategory(DrinkType cat)
    {
        listCategoryCan = saveSessionBean.getCanByCategory(cat);
        
        
        return "faces/specificCan.xhtml";
    }
    
    public List<Can> getListCategoryCan()
    {
        return listCategoryCan;
    }
    
    
    
}
