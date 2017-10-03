/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import enteties.ProductE;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author SebastianRojas
 */
@Stateless
public class ProductFacade extends AbstractFacade<ProductE> {

    @PersistenceContext(unitName = "Oblig1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(ProductE.class);
    }

    public List<ProductE> getProduct() {
        Query query = em.createNamedQuery("Product.findAll");
        return query.getResultList();
    }
    
    public void AuctionProduct(ProductE product){
        em.persist(product);
    }
    
    public void updateBid(int currentBid, Long productId){
        //Query query = em.createQuery("UPDATE producte Set currentBid = " + currentBid + 
        //        " Where productId = " + productId);
        
        Query query = em.createQuery("Update ProductE p Set p.currentBid = " + currentBid
        + " Where p.id = " + productId);
        query.executeUpdate();
    }
    
    public void updateRating(double sumOfRatings, double avgRating, Long productId){
        Query query = em.createQuery("Update ProductE p Set p.sumOfRatings = " + sumOfRatings
        + " Where p.id = " + productId);
        query.executeUpdate();
        
        query = em.createQuery("Update ProductE p Set p.numberOfRatings = " + avgRating
        + " Where p.id = " + productId);
        query.executeUpdate();
    }
    
}
