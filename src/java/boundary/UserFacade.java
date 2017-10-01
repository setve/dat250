/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import enteties.UserE;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author SebastianRojas
 */
@Stateless
public class UserFacade extends AbstractFacade<UserE> {

    @PersistenceContext(unitName = "Oblig1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(UserE.class);
    }
        
    public List<UserE> listUsers(){
        Query query = em.createQuery("SELECT a FROM UserE a");
        return query.getResultList();
    }
        
        // More to come

    
}
