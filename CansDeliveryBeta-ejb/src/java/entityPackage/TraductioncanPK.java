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
import javax.validation.constraints.Size;

/**
 *
 * @author Arnaud
 */
@Embeddable
public class TraductioncanPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "LANGUAGES")
    private String languages;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAN")
    private int can;

    public TraductioncanPK() {
    }

    public TraductioncanPK(String languages, int can) {
        this.languages = languages;
        this.can = can;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (languages != null ? languages.hashCode() : 0);
        hash += (int) can;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TraductioncanPK)) {
            return false;
        }
        TraductioncanPK other = (TraductioncanPK) object;
        if ((this.languages == null && other.languages != null) || (this.languages != null && !this.languages.equals(other.languages))) {
            return false;
        }
        if (this.can != other.can) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.TraductioncanPK[ languages=" + languages + ", can=" + can + " ]";
    }
    
}
