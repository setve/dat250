/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enteties;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stian
 */
@Entity
@Table(name = "usere")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usere_1.findAll", query = "SELECT u FROM Usere_1 u")
    , @NamedQuery(name = "Usere_1.findById", query = "SELECT u FROM Usere_1 u WHERE u.id = :id")
    , @NamedQuery(name = "Usere_1.findByAddress", query = "SELECT u FROM Usere_1 u WHERE u.address = :address")
    , @NamedQuery(name = "Usere_1.findByEmail", query = "SELECT u FROM Usere_1 u WHERE u.email = :email")
    , @NamedQuery(name = "Usere_1.findByFirstname", query = "SELECT u FROM Usere_1 u WHERE u.firstname = :firstname")
    , @NamedQuery(name = "Usere_1.findByLastname", query = "SELECT u FROM Usere_1 u WHERE u.lastname = :lastname")
    , @NamedQuery(name = "Usere_1.findByPassword", query = "SELECT u FROM Usere_1 u WHERE u.password = :password")
    , @NamedQuery(name = "Usere_1.findByPhonenumber", query = "SELECT u FROM Usere_1 u WHERE u.phonenumber = :phonenumber")
    , @NamedQuery(name = "Usere_1.findByRating", query = "SELECT u FROM Usere_1 u WHERE u.rating = :rating")
    , @NamedQuery(name = "Usere_1.findByUsername", query = "SELECT u FROM Usere_1 u WHERE u.username = :username")})
public class Usere_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 255)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @Size(max = 255)
    @Column(name = "phonenumber")
    private String phonenumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rating")
    private Double rating;
    @Size(max = 255)
    @Column(name = "username")
    private String username;

    public Usere_1() {
    }

    public Usere_1(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        if (!(object instanceof Usere_1)) {
            return false;
        }
        Usere_1 other = (Usere_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enteties.Usere_1[ id=" + id + " ]";
    }
    
}
