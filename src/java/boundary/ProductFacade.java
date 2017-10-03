/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import enteties.ProductE;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
