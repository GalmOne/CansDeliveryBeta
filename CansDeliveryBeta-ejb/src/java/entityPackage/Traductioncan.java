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
@Table(name = "TRADUCTIONCAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Traductioncan.findAll", query = "SELECT t FROM Traductioncan t"),
    @NamedQuery(name = "Traductioncan.findByLanguages", query = "SELECT t FROM Traductioncan t WHERE t.traductioncanPK.languages = :languages"),
    @NamedQuery(name = "Traductioncan.findByCan", query = "SELECT t FROM Traductioncan t WHERE t.traductioncanPK.can = :can"),
    @NamedQuery(name = "Traductioncan.findByName", query = "SELECT t FROM Traductioncan t WHERE t.name = :name"),
    @NamedQuery(name = "Traductioncan.findByDescription", query = "SELECT t FROM Traductioncan t WHERE t.description = :description")})
public class Traductioncan implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TraductioncanPK traductioncanPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NAME")
    private String name;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "CAN", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Can can1;
    @JoinColumn(name = "LANGUAGES", referencedColumnName = "IDLANGUAGES", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Languages languages1;

    public Traductioncan() {
    }

    public Traductioncan(TraductioncanPK traductioncanPK) {
        this.traductioncanPK = traductioncanPK;
    }

    public Traductioncan(TraductioncanPK traductioncanPK, String name) {
        this.traductioncanPK = traductioncanPK;
        this.name = name;
    }

    public Traductioncan(String languages, int can) {
        this.traductioncanPK = new TraductioncanPK(languages, can);
    }

    public TraductioncanPK getTraductioncanPK() {
        return traductioncanPK;
    }

    public void setTraductioncanPK(TraductioncanPK traductioncanPK) {
        this.traductioncanPK = traductioncanPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Can getCan1() {
        return can1;
    }

    public void setCan1(Can can1) {
        this.can1 = can1;
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
        hash += (traductioncanPK != null ? traductioncanPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Traductioncan)) {
            return false;
        }
        Traductioncan other = (Traductioncan) object;
        if ((this.traductioncanPK == null && other.traductioncanPK != null) || (this.traductioncanPK != null && !this.traductioncanPK.equals(other.traductioncanPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.Traductioncan[ traductioncanPK=" + traductioncanPK + " ]";
    }
    
}
