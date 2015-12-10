/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeansPackage;

import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Arnaud
 */
@ManagedBean
@SessionScoped
public class InternationalizationMB {

    private Locale locale;
    
    public InternationalizationMB() {
        locale = new Locale("en");
    }
    
    public Locale getLocale() {
        return locale;
    }
    
    
    public void setToFrench() {
        locale = new Locale("fr");
    }
    
    public void setToEnglish() {
        locale = new Locale("en");
    }
    
}
