/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Local;

/**
 *
 * @author Arnaud
 */
@Local
public interface DiscountSessionBeanLocal {
    
    public double calculateDiscount(double price);
}
