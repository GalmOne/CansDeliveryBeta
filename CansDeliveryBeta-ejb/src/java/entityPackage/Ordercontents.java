/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityPackage;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arnaud
 */
@Entity
@Table(name = "ORDERCONTENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordercontents.findAll", query = "SELECT o FROM Ordercontents o"),
    @NamedQuery(name = "Ordercontents.findByCan", query = "SELECT o FROM Ordercontents o WHERE o.ordercontentsPK.can = :can"),
    @NamedQuery(name = "Ordercontents.findByOrders", query = "SELECT o FROM Ordercontents o WHERE o.ordercontentsPK.orders = :orders"),
    @NamedQuery(name = "Ordercontents.findByQuantity", query = "SELECT o FROM Ordercontents o WHERE o.quantity = :quantity"),
    @NamedQuery(name = "Ordercontents.findByTotalprice", query = "SELECT o FROM Ordercontents o WHERE o.totalprice = :totalprice")})
public class Ordercontents implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdercontentsPK ordercontentsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY")
    private short quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTALPRICE")
    private BigDecimal totalprice;
    @JoinColumn(name = "CAN", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Can can1;
    @JoinColumn(name = "ORDERS", referencedColumnName = "NUMBER", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orders orders1;

    public Ordercontents() {
    }

    public Ordercontents(OrdercontentsPK ordercontentsPK) {
        this.ordercontentsPK = ordercontentsPK;
    }

    public Ordercontents(OrdercontentsPK ordercontentsPK, short quantity, BigDecimal totalprice) {
        this.ordercontentsPK = ordercontentsPK;
        this.quantity = quantity;
        this.totalprice = totalprice;
    }

    public Ordercontents(int can, int orders) {
        this.ordercontentsPK = new OrdercontentsPK(can, orders);
    }

    public OrdercontentsPK getOrdercontentsPK() {
        return ordercontentsPK;
    }

    public void setOrdercontentsPK(OrdercontentsPK ordercontentsPK) {
        this.ordercontentsPK = ordercontentsPK;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public Can getCan1() {
        return can1;
    }

    public void setCan1(Can can1) {
        this.can1 = can1;
    }

    public Orders getOrders1() {
        return orders1;
    }

    public void setOrders1(Orders orders1) {
        this.orders1 = orders1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordercontentsPK != null ? ordercontentsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordercontents)) {
            return false;
        }
        Ordercontents other = (Ordercontents) object;
        if ((this.ordercontentsPK == null && other.ordercontentsPK != null) || (this.ordercontentsPK != null && !this.ordercontentsPK.equals(other.ordercontentsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.Ordercontents[ ordercontentsPK=" + ordercontentsPK + " ]";
    }
    
}
