/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import boundary.ProductFacade;
import enteties.ProductE;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author setve
 */
@WebService(serviceName = "SoapWebService")
@Stateless()
public class SoapWebService {
    
    private final String message = "Hello, ";
    
    public SoapWebService(){
        
    }
    
    
    @EJB
    private ProductFacade productFacade;
    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getActiveAuctions")
    public List<ProductE> getActiveAuctions() {
        return productFacade.findAll();
//this.productFacade.getProductAuctions();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "sayHello")
    public String sayHello(@WebParam(name = "name") String name) {
        //TODO write your implementation code here:
        return "Hello ," + name + ".";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "bidForAuction")
    public String bidForAuction(@WebParam(name = "newBid") int newBid) {
        //TODO write your implementation code here:
        String message = "Bid was accepted";
        return message;
    }
}
