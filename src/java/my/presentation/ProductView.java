/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.ProductFacade;
import enteties.Product;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

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
    private String timeUnit;
    private int timeAmount;

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
    }
    
    public Product getProduct() {
        return product;
    }
    
    public List<Product> getProductList() {
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
