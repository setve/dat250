/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enteties;

import java.io.Serializable;
import java.sql.Time;
import java.util.concurrent.TimeUnit;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author SebastianRojas
 */
@Entity
public class ProductE implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Long timeLeft;
    private String status;
    private Long currentBid;

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

    public Long getTimeLeft() {
        return timeLeft;
    }
    
    public String getTimeLeftString() {
    String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(timeLeft),
    TimeUnit.MILLISECONDS.toMinutes(timeLeft) % TimeUnit.HOURS.toMinutes(1),
    TimeUnit.MILLISECONDS.toSeconds(timeLeft) % TimeUnit.MINUTES.toSeconds(1));
    return hms;
    };

    public void setTimeLeft(Long timeLeft) {
        this.timeLeft = timeLeft;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(Long currentBid) {
        this.currentBid = currentBid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof ProductE)) {
            return false;
        }
        ProductE other = (ProductE) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enteties.Product[ id=" + id + " ]";
    }
    
}
