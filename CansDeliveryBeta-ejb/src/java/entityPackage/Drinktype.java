/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityPackage;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arnaud
 */
@Entity
@Table(name = "DRINKTYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Drinktype.findAll", query = "SELECT d FROM Drinktype d"),
    @NamedQuery(name = "Drinktype.findById", query = "SELECT d FROM Drinktype d WHERE d.id = :id")})
public class Drinktype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Short id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "drinktype")
    private Collection<Can> canCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "drinktype1")
    private Collection<Traductiondrinktype> traductiondrinktypeCollection;

    public Drinktype() {
    }

    public Drinktype(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<Can> getCanCollection() {
        return canCollection;
    }

    public void setCanCollection(Collection<Can> canCollection) {
        this.canCollection = canCollection;
    }

    @XmlTransient
    public Collection<Traductiondrinktype> getTraductiondrinktypeCollection() {
        return traductiondrinktypeCollection;
    }

    public void setTraductiondrinktypeCollection(Collection<Traductiondrinktype> traductiondrinktypeCollection) {
        this.traductiondrinktypeCollection = traductiondrinktypeCollection;
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
        if (!(object instanceof Drinktype)) {
            return false;
        }
        Drinktype other = (Drinktype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.Drinktype[ id=" + id + " ]";
    }
    
}
