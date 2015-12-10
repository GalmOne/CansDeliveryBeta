/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityPackage;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arnaud
 */
@Entity
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findById", query = "SELECT c FROM Customer c WHERE c.id = :id"),
    @NamedQuery(name = "Customer.findByName", query = "SELECT c FROM Customer c WHERE c.name = :name"),
    @NamedQuery(name = "Customer.findByFirstname", query = "SELECT c FROM Customer c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "Customer.findByLogin", query = "SELECT c FROM Customer c WHERE c.login = :login"),
    @NamedQuery(name = "Customer.findByPassword", query = "SELECT c FROM Customer c WHERE c.password = :password"),
    @NamedQuery(name = "Customer.findByBirthdate", query = "SELECT c FROM Customer c WHERE c.birthdate = :birthdate"),
    @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email"),
    @NamedQuery(name = "Customer.findByGsm", query = "SELECT c FROM Customer c WHERE c.gsm = :gsm"),
    @NamedQuery(name = "Customer.findByAdrNumber", query = "SELECT c FROM Customer c WHERE c.adrNumber = :adrNumber"),
    @NamedQuery(name = "Customer.findByAdrStreet", query = "SELECT c FROM Customer c WHERE c.adrStreet = :adrStreet"),
    @NamedQuery(name = "Customer.findByAdrPostecode", query = "SELECT c FROM Customer c WHERE c.adrPostecode = :adrPostecode"),
    @NamedQuery(name = "Customer.findByAdrCity", query = "SELECT c FROM Customer c WHERE c.adrCity = :adrCity"),
    @NamedQuery(name = "Customer.findByAdrCountry", query = "SELECT c FROM Customer c WHERE c.adrCountry = :adrCountry")})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BIRTHDATE")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "GSM")
    private String gsm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "ADR_NUMBER")
    private String adrNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ADR_STREET")
    private String adrStreet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADR_POSTECODE")
    private int adrPostecode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ADR_CITY")
    private String adrCity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ADR_COUNTRY")
    private String adrCountry;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Collection<Orders> ordersCollection;

    public Customer() {
    }

    public Customer(Integer id) {
        this.id = id;
    }

    public Customer(Integer id, String name, String firstname, String login, String password, Date birthdate, String email, String gsm, String adrNumber, String adrStreet, int adrPostecode, String adrCity, String adrCountry) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.login = login;
        this.password = password;
        this.birthdate = birthdate;
        this.email = email;
        this.gsm = gsm;
        this.adrNumber = adrNumber;
        this.adrStreet = adrStreet;
        this.adrPostecode = adrPostecode;
        this.adrCity = adrCity;
        this.adrCountry = adrCountry;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getAdrNumber() {
        return adrNumber;
    }

    public void setAdrNumber(String adrNumber) {
        this.adrNumber = adrNumber;
    }

    public String getAdrStreet() {
        return adrStreet;
    }

    public void setAdrStreet(String adrStreet) {
        this.adrStreet = adrStreet;
    }

    public int getAdrPostecode() {
        return adrPostecode;
    }

    public void setAdrPostecode(int adrPostecode) {
        this.adrPostecode = adrPostecode;
    }

    public String getAdrCity() {
        return adrCity;
    }

    public void setAdrCity(String adrCity) {
        this.adrCity = adrCity;
    }

    public String getAdrCountry() {
        return adrCountry;
    }

    public void setAdrCountry(String adrCountry) {
        this.adrCountry = adrCountry;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityPackage.Customer[ id=" + id + " ]";
    }
    
}
