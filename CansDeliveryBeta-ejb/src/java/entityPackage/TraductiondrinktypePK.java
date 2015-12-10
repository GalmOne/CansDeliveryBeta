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
public class TraductiondrinktypePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "LANGUAGES")
    private String languages;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DRINKTYPE")
    private short drinktype;

    public TraductiondrinktypePK() {
    }

    public TraductiondrinktypePK(String languages, short drinktype) {
        this.languages = languages;
        this.drinktype = drinktype;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public short getDrinktype() {
        return drinktype;
    }

    public void setDrinktype(short drinktype) {
        this.drinktype = drinktype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (languages != null ? languages.hashCode() : 0);
        hash += (int) drinktype;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TraductiondrinktypePK)) {
            return false;
        }
        TraductiondrinktypePK other = (TraductiondrinktypePK) object;
        if ((this.languages == null && other.languages != null) || (this.languages != null && !this.languages.equals(other.languages))) {
            return false;
        }
        if (this.drinktype != other.drinktype) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.TraductiondrinktypePK[ languages=" + languages + ", drinktype=" + drinktype + " ]";
    }
    
}
