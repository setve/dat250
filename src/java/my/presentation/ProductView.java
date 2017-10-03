/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.ProductFacade;
import enteties.ProductE;
<<<<<<< HEAD

=======
>>>>>>> 0a3f275463624644deb7c329f646be63ce12afca
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author SebastianRojas
 */
@Named(value = "productView")
@RequestScoped
public class ProductView {
    
    @EJB
    private ProductFacade productFacade;
    
    private ProductE product;
    
    
    
    private String title = "GTX 1080";
    String currentBid;
    private String timeUnit;
    private int timeAmount;
<<<<<<< HEAD
    private Long productId = new Long(123);
=======
    private String sellerId;
>>>>>>> 0a3f275463624644deb7c329f646be63ce12afca
    
    /**
     * Creates a new instance of ProductView
     */
    public ProductView() {
    this.product = new ProductE();
    this.timeUnit = new String();
    this.timeAmount = 0;
        
    }
    
    public String seeProduct() {
        return "productPage";
    }
    
    public String getCurrentBid(){
        return currentBid;
    }
    
    public void printDate(Date newDate){
        System.out.println(newDate);
    }
    
    public String goToProductPage(Long productId){
        this.productId = productId;
        System.out.println(productId);
        return "productPage";
    }
    
    public Long getProductId(){
        return productId;
    }
    
    public void editCurrentBid(String currentBid){
        System.out.println(currentBid);
        this.currentBid = currentBid;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    public int getTimeAmount() {
        return timeAmount;
    }

    public void setTimeAmount(int timeAmount) {
        this.timeAmount = timeAmount;
    }
    
    public ProductE getProduct() {
        return productFacade.find(productId);
    }
    
    public String getProdTitle(){
        return title;
    }
    
    public List<ProductE> getProductList() {
        return productFacade.findAll();
    } 
    
    public void postProduct() {
      if (timeUnit.equals("weeks")) {
          product.setTimeLeft((System.currentTimeMillis()) + ((604800000 * timeAmount)- 86400000 - 3600000));
      } else if (timeUnit.equals("days")) {
          product.setTimeLeft((System.currentTimeMillis()) + ((86400000 * timeAmount) - 86400000 - 3600000));
      }
    this.productFacade.create(product);
    }
    
}
