/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enteties;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "producte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producte_1.findAll", query = "SELECT p FROM Producte_1 p")
    , @NamedQuery(name = "Producte_1.findById", query = "SELECT p FROM Producte_1 p WHERE p.id = :id")
    , @NamedQuery(name = "Producte_1.findByCurrentbid", query = "SELECT p FROM Producte_1 p WHERE p.currentbid = :currentbid")
    , @NamedQuery(name = "Producte_1.findByDescription", query = "SELECT p FROM Producte_1 p WHERE p.description = :description")
    , @NamedQuery(name = "Producte_1.findByName", query = "SELECT p FROM Producte_1 p WHERE p.name = :name")
    , @NamedQuery(name = "Producte_1.findByStatus", query = "SELECT p FROM Producte_1 p WHERE p.status = :status")
    , @NamedQuery(name = "Producte_1.findByTimeleft", query = "SELECT p FROM Producte_1 p WHERE p.timeleft = :timeleft")
    , @NamedQuery(name = "Producte_1.findByUserid", query = "SELECT p FROM Producte_1 p WHERE p.userid = :userid")
    , @NamedQuery(name = "Producte_1.findByNumberofratings", query = "SELECT p FROM Producte_1 p WHERE p.numberofratings = :numberofratings")
    , @NamedQuery(name = "Producte_1.findBySumofratings", query = "SELECT p FROM Producte_1 p WHERE p.sumofratings = :sumofratings")})
public class Producte_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Column(name = "currentbid")
    private BigInteger currentbid;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @Column(name = "timeleft")
    private BigInteger timeleft;
    @Size(max = 255)
    @Column(name = "userid")
    private String userid;
    @Column(name = "numberofratings")
    private BigInteger numberofratings;
    @Column(name = "sumofratings")
    private BigInteger sumofratings;

    public Producte_1() {
    }

    public Producte_1(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getCurrentbid() {
        return currentbid;
    }

    public void setCurrentbid(BigInteger currentbid) {
        this.currentbid = currentbid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigInteger getTimeleft() {
        return timeleft;
    }

    public void setTimeleft(BigInteger timeleft) {
        this.timeleft = timeleft;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public BigInteger getNumberofratings() {
        return numberofratings;
    }

    public void setNumberofratings(BigInteger numberofratings) {
        this.numberofratings = numberofratings;
    }

    public BigInteger getSumofratings() {
        return sumofratings;
    }

    public void setSumofratings(BigInteger sumofratings) {
        this.sumofratings = sumofratings;
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
        if (!(object instanceof Producte_1)) {
            return false;
        }
        Producte_1 other = (Producte_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enteties.Producte_1[ id=" + id + " ]";
    }
    
}
