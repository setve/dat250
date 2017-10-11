/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.ProductFacade;
import enteties.ProductE;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sebas
 */
@Named(value = "productECreation")
@RequestScoped
public class ProductECreation {

    @EJB
    private ProductFacade productFacade;
    
    private ProductE product;
    
    private String timeUnit;

    public ProductFacade getProductFacade() {
        return productFacade;
    }

    public void setProductFacade(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    public ProductE getProduct() {
        return product;
    }

    public void setProduct(ProductE product) {
        this.product = product;
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
    private int timeAmount;
    
    /**
     * Creates a new instance of ProductECreation
     */
    public ProductECreation() {
        this.product = new ProductE();
        this.timeUnit = new String();
        this.timeAmount = 0;
    }
    
    public String postProduct(String id) throws IOException {
        System.out.print(id);
        product.setUserId(id);
        product.setNumberOfRatings(0);
        product.setSumOfRatings(0);
      if (timeUnit.equals("weeks")) {
          product.setTimeLeft((System.currentTimeMillis()) + ((604800000 * timeAmount)- 86400000 - 3600000));
      } else if (timeUnit.equals("days")) {
          product.setTimeLeft((System.currentTimeMillis()) + ((86400000 * timeAmount) - 86400000 - 3600000));
      }
    this.productFacade.create(product);
    
    return "ProductList";
    }
    
    
}
