/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.ProductFacade;
import enteties.ProductE;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author SebastianRojas
 */
@Named(value = "productView")
@Dependent
public class ProductView {
    
    @EJB
    private ProductFacade productFacade;
    
    private Product product;
    
    private String title = "GTX 1080";
    String currentBid;
    private String timeUnit;
    private int timeAmount;
    
    public String getCurrentBid(){
        return currentBid;
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

    /**
     * Creates a new instance of ProductView
     */
    public ProductView() {
        this.product = new ProductE();
    this.timeUnit = new String();
    this.timeAmount = 0;
        
    }
    
    public ProductE getProduct() {
        return product;
    public String getProdTitle(){
        return title;
    }
    
    public List<ProductE> getProductList() {
        return productFacade.findAll();
    } 
    
    public void postProduct() {
      if (timeUnit.equals("weeks")) {
          product.setTimeLeft((System.currentTimeMillis()) + (604800000 * timeAmount));
      } else if (timeUnit.equals("days")) {
          product.setTimeLeft((System.currentTimeMillis()) + (86400000 * timeAmount));
      } else {
          product.setTimeLeft((System.currentTimeMillis()) + (3600000 * timeAmount));
      }
    this.productFacade.create(product);
    };
    
}
