/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityPackage;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arnaud
 */
@Entity
@Table(name = "CAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Can.findAll", query = "SELECT c FROM Can c"),
    @NamedQuery(name = "Can.findById", query = "SELECT c FROM Can c WHERE c.id = :id"),
    @NamedQuery(name = "Can.findByBrand", query = "SELECT c FROM Can c WHERE c.brand = :brand"),
    @NamedQuery(name = "Can.findByPrice", query = "SELECT c FROM Can c WHERE c.price = :price"),
    @NamedQuery(name = "Can.findByLimitededition", query = "SELECT c FROM Can c WHERE c.limitededition = :limitededition"),
    @NamedQuery(name = "Can.findByCapacity", query = "SELECT c FROM Can c WHERE c.capacity = :capacity"),
    @NamedQuery(name = "Can.findByPicture", query = "SELECT c FROM Can c WHERE c.picture = :picture"),
    @NamedQuery(name = "Can.findByStock", query = "SELECT c FROM Can c WHERE c.stock = :stock"),
    @NamedQuery(name = "Can.findByCategory", query = "SELECT c FROM Can c WHERE c.drinktype = :DrinkType")})
public class Can implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "BRAND")
    private String brand;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private BigDecimal price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LIMITEDEDITION")
    private Boolean limitededition;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAPACITY")
    private short capacity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PICTURE")
    private String picture;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STOCK")
    private short stock;
    @JoinColumn(name = "DRINKTYPE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Drinktype drinktype;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "can1")
    private Collection<Traductioncan> traductioncanCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "can1")
    private Collection<Ordercontents> ordercontentsCollection;

    public Can() {
    }

    public Can(Integer id) {
        this.id = id;
    }

    public Can(Integer id, String brand, BigDecimal price, Boolean limitededition, short capacity, String picture, short stock) {
        this.id = id;
        this.brand = brand;
        this.price = price;
        this.limitededition = limitededition;
        this.capacity = capacity;
        this.picture = picture;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getLimitededition() {
        return limitededition;
    }

    public void setLimitededition(Boolean limitededition) {
        this.limitededition = limitededition;
    }

    public short getCapacity() {
        return capacity;
    }

    public void setCapacity(short capacity) {
        this.capacity = capacity;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public short getStock() {
        return stock;
    }

    public void setStock(short stock) {
        this.stock = stock;
    }

    public Drinktype getDrinktype() {
        return drinktype;
    }

    public void setDrinktype(Drinktype drinktype) {
        this.drinktype = drinktype;
    }

    @XmlTransient
    public Collection<Traductioncan> getTraductioncanCollection() {
        return traductioncanCollection;
    }

    public void setTraductioncanCollection(Collection<Traductioncan> traductioncanCollection) {
        this.traductioncanCollection = traductioncanCollection;
    }

    @XmlTransient
    public Collection<Ordercontents> getOrdercontentsCollection() {
        return ordercontentsCollection;
    }

    public void setOrdercontentsCollection(Collection<Ordercontents> ordercontentsCollection) {
        this.ordercontentsCollection = ordercontentsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Can)) {
            return false;
        }
        Can other = (Can) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.Can[ id=" + id + " ]";
    }
    
}
