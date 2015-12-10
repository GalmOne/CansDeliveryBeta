/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityPackage;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arnaud
 */
@Entity
@Table(name = "TRADUCTIONDRINKTYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Traductiondrinktype.findAll", query = "SELECT t FROM Traductiondrinktype t"),
    @NamedQuery(name = "Traductiondrinktype.findByLanguages", query = "SELECT t FROM Traductiondrinktype t WHERE t.traductiondrinktypePK.languages = :languages"),
    @NamedQuery(name = "Traductiondrinktype.findByDrinktype", query = "SELECT t FROM Traductiondrinktype t WHERE t.traductiondrinktypePK.drinktype = :drinktype"),
    @NamedQuery(name = "Traductiondrinktype.findByDescription", query = "SELECT t FROM Traductiondrinktype t WHERE t.description = :description")})
public class Traductiondrinktype implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TraductiondrinktypePK traductiondrinktypePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "DRINKTYPE", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Drinktype drinktype1;
    @JoinColumn(name = "LANGUAGES", referencedColumnName = "IDLANGUAGES", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Languages languages1;

    public Traductiondrinktype() {
    }

    public Traductiondrinktype(TraductiondrinktypePK traductiondrinktypePK) {
        this.traductiondrinktypePK = traductiondrinktypePK;
    }

    public Traductiondrinktype(TraductiondrinktypePK traductiondrinktypePK, String description) {
        this.traductiondrinktypePK = traductiondrinktypePK;
        this.description = description;
    }

    public Traductiondrinktype(String languages, short drinktype) {
        this.traductiondrinktypePK = new TraductiondrinktypePK(languages, drinktype);
    }

    public TraductiondrinktypePK getTraductiondrinktypePK() {
        return traductiondrinktypePK;
    }

    public void setTraductiondrinktypePK(TraductiondrinktypePK traductiondrinktypePK) {
        this.traductiondrinktypePK = traductiondrinktypePK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Drinktype getDrinktype1() {
        return drinktype1;
    }

    public void setDrinktype1(Drinktype drinktype1) {
        this.drinktype1 = drinktype1;
    }

    public Languages getLanguages1() {
        return languages1;
    }

    public void setLanguages1(Languages languages1) {
        this.languages1 = languages1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (traductiondrinktypePK != null ? traductiondrinktypePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Traductiondrinktype)) {
            return false;
        }
        Traductiondrinktype other = (Traductiondrinktype) object;
        if ((this.traductiondrinktypePK == null && other.traductiondrinktypePK != null) || (this.traductiondrinktypePK != null && !this.traductiondrinktypePK.equals(other.traductiondrinktypePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.Traductiondrinktype[ traductiondrinktypePK=" + traductiondrinktypePK + " ]";
    }
    
}
