/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enteties.service;

import enteties.Producte_1;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author stian
 */
@Stateless
@Path("enteties.producte_1")
public class Producte_1FacadeREST extends AbstractFacade<Producte_1> {

    @PersistenceContext(unitName = "Oblig1PU")
    private EntityManager em;

    public Producte_1FacadeREST() {
        super(Producte_1.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Producte_1 entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Producte_1 entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    //Gir ett produkt/auksjon med en gitt produkt id
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Producte_1 find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producte_1> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producte_1> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    //lister ut aktive auksjoner
    @GET
    @Path("activeauctions")
    @Produces({MediaType.APPLICATION_XML})
    public List<Producte_1> findActiveAuctions() {
        List<Producte_1> activeAuctions = new ArrayList<Producte_1>();
        List<Producte_1> allProducts = super.findAll();

        for(Producte_1 product : allProducts) {
            if(BigInteger.valueOf(0).compareTo(product.getTimeleft()) < 0) {
                // if Timeleft is bigger than 0
                activeAuctions.add(product);
            } 
        }
        return activeAuctions;
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}