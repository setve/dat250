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

    public SoapWebService() {

    }

    @EJB
    private ProductFacade productFacade;

    /**
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "getActiveAuctions")
    public List<ProductE> getActiveAuctions() {
        //return productFacade.findAll();
        this.productFacade.getProductAuctions();
        return this.productFacade.getProductAuctions();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "bidForAuction")
    public String bidForAuction(@WebParam(name = "currentBid") String currentBid, @WebParam(name = "productId") long productId, @WebParam(name = "oldBid") long oldBid, @WebParam(name = "bidderUserName") String bidderUserName, @WebParam(name = "creatorUserName") String creatorUserName) {
        //TODO write your implementation code here:
        System.out.println("webservice.SoapWebService.bidForAuction()");
        String failed = "failedBid";
        oldBid = productFacade.getOneProduct(productId).getCurrentBid();
        if (bidderUserName == null ? creatorUserName == null : bidderUserName.equals(creatorUserName)) {
            return failed;
        } else if ((int)oldBid == Integer.parseInt(currentBid)){
            return failed;
        } else if ((int)oldBid > Integer.parseInt(currentBid)) {
            return failed;
        } else {
            //bidForAuction(currentBid, productId, oldBid, bidderUserName, creatorUserName);
            System.out.println("webservice.SoapWebService.bidForAuction()");
            try {
                productFacade.updateBid(Integer.parseInt(currentBid), productId);
            } catch (NumberFormatException ex) {
                System.out.println("Exception: " + ex);
            }
            return "ProductList";
        }
    }
}
