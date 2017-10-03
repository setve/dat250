/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import enteties.Product;
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

    public List<Product> getProduct() {
        Query query = em.createNamedQuery("Product.findAll");
        return query.getResultList();
    }
    
    public Product update(Product product){
        return em.merge(product);
    }
    
}
