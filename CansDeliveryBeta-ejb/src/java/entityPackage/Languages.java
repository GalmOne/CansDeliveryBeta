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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arnaud
 */
@Entity
@Table(name = "LANGUAGES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Languages.findAll", query = "SELECT l FROM Languages l"),
    @NamedQuery(name = "Languages.findByIdlanguages", query = "SELECT l FROM Languages l WHERE l.idlanguages = :idlanguages")})
public class Languages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDLANGUAGES")
    private String idlanguages;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languages1")
    private Collection<Traductioncan> traductioncanCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languages1")
    private Collection<Traductiondrinktype> traductiondrinktypeCollection;

    public Languages() {
    }

    public Languages(String idlanguages) {
        this.idlanguages = idlanguages;
    }

    public String getIdlanguages() {
        return idlanguages;
    }

    public void setIdlanguages(String idlanguages) {
        this.idlanguages = idlanguages;
    }

    @XmlTransient
    public Collection<Traductioncan> getTraductioncanCollection() {
        return traductioncanCollection;
    }

    public void setTraductioncanCollection(Collection<Traductioncan> traductioncanCollection) {
        this.traductioncanCollection = traductioncanCollection;
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
        hash += (idlanguages != null ? idlanguages.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Languages)) {
            return false;
        }
        Languages other = (Languages) object;
        if ((this.idlanguages == null && other.idlanguages != null) || (this.idlanguages != null && !this.idlanguages.equals(other.idlanguages))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.Languages[ idlanguages=" + idlanguages + " ]";
    }
    
}
