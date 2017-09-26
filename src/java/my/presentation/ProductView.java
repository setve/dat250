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

    /**
     * Creates a new instance of ProductView
     */
    public ProductView() {
    }
    
    public List<Product> getProductList() {
        return productFacade.findAll();
    } 
    
    public void postProduct() {
    this.productFacade.create(product);
    };
    
}
