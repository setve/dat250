/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enteties;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author SebastianRojas
 */
@Entity
@Table(name= "ProductE")
public class ProductE implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column
    private Long id;
    private String name;
    private String description;
    private Long timeLeft;
    private String status;
    private Long currentBid;
    private String userId;
    
    @Transient
    private int numberOfRatings;
    @Transient
    private int sumOfRatings;

    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(int numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    public int getSumOfRatings() {
        return sumOfRatings;
    }

    public void setSumOfRatings(int sumOfRatings) {
        this.sumOfRatings += sumOfRatings;
        this.numberOfRatings++;
        System.out.println("Product Entity Funksjon; numberOfRatings" + this.getNumberOfRatings());
        System.out.println("Product Entity Funksjon: sumOfRatings" + this.getSumOfRatings());
    }
    

    

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Long getTimeLeft() {
        return timeLeft;
    }
    
    public String getTimeLeftString() {
    SimpleDateFormat formatter = new SimpleDateFormat("dd:HH:mm:ss", Locale.UK);
    Date date = new Date(timeLeft - System.currentTimeMillis());
    String hms = formatter.format(date);
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
    
    public double getAverageRating(){
        System.out.println("Product Entity; numberOfRatings" + this.numberOfRatings);
        System.out.println("Product Entity: sumOfRatings" + this.sumOfRatings);
        //if(this.getNumberOfRatings() != 0){
            //return (this.sumOfRatings/numberOfRatings);
        //}
        return 0.0;
    }
    
    
}
