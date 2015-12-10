/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityPackage;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Arnaud
 */
@Embeddable
public class OrdercontentsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAN")
    private int can;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERS")
    private int orders;

    public OrdercontentsPK() {
    }

    public OrdercontentsPK(int can, int orders) {
        this.can = can;
        this.orders = orders;
    }

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) can;
        hash += (int) orders;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdercontentsPK)) {
            return false;
        }
        OrdercontentsPK other = (OrdercontentsPK) object;
        if (this.can != other.can) {
            return false;
        }
        if (this.orders != other.orders) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.OrdercontentsPK[ can=" + can + ", orders=" + orders + " ]";
    }
    
}
