/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import enteties.Fback;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author stian
 */
@Stateless
public class FeedbackFacade extends AbstractFacade<Fback> {

    @PersistenceContext(unitName = "Oblig1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FeedbackFacade() {
        super(Fback.class);
    }
    
}
