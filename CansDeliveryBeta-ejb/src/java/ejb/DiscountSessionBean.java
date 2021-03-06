/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;

/**
 *
 * @author Arnaud
 */
@Stateless
public class DiscountSessionBean implements DiscountSessionBeanLocal {

    private double price;    //Voire si on ne passe pas directement l'objet model
    
    public double calculateDiscount(double price)
    {
        if(price >= 15)
        {
            if(price < 30)
            {
                return price * 0.05;
            }
            else if(price < 75)
            {
                return price * 0.10;
            }
            else if(price < 150)
            {
                return price * 0.15;
            }
            else
            {
                return price * 0.20;
            }
        }
        else
        {
            return 0;
        }
    }
}
