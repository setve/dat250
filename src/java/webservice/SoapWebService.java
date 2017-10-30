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
    
    @EJB
    private ProductFacade productFacade;
    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getActiveAuctions")
    public List<ProductE> getActiveAuctions() {
        return this.productFacade.getProductAuctions();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "bidForAuctions")
    public String bidForAuctions(@WebParam(name = "bid") long bid) {
        //TODO write your implementation code here:
        return null;
    }
}
