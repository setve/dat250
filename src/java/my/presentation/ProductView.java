/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.ProductFacade;
import enteties.ProductE;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author SebastianRojas
 */
@Named(value = "productView")
@SessionScoped

public class ProductView implements Serializable {

    
    @EJB
    private ProductFacade productFacade;
    
    private ProductE product;
    
    
    
    private final String title = "GTX 1080";
    String currentBid;
    private String timeUnit;
    private int timeAmount;
    private Long productId = new Long(123);

    
    /**
     * Creates a new instance of ProductView
     */
    public ProductView() {
    this.product = new ProductE();
    this.timeUnit = new String();
    this.timeAmount = 0;
        
    }
    
    public String goToNext(){
        return "template";
    }
    
    public String seeProduct() {
        return "productPage";
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
    
    public void editCurrentBid(String currentBid, Long productId, Long oldBid, String bidderUserName, String creatorUserName){
            if(bidderUserName == null ? creatorUserName == null : bidderUserName.equals(creatorUserName)){
                System.out.println("Can't bid on your own product.");
            } else if(oldBid == null){
                productFacade.updateBid(Integer.parseInt(currentBid), productId);
            } else if(oldBid < Long.parseLong(currentBid)){
                productFacade.updateBid(Integer.parseInt(currentBid), productId);
            }
        }
    
    public String updateRating(double rating){
        System.out.println("new rating: " + rating);
        ProductE prod = productFacade.find(productId);
        double sumOfRating = prod.getSumOfRatings() + rating;
        double numberOfRatings = prod.getNumberOfRatings()+1;
        productFacade.updateRating(sumOfRating, numberOfRatings, productId);
        
        return "ProductList";
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
    
    public ProductE getOneProduct() {
        return productFacade.find(productId);
    }

    public ProductE getProduct() {
        return product;

    }
    
    public String getProdTitle(){
        return title;
    }
    
    public List<ProductE> getProductList() {
        return productFacade.findAll();
    } 
    
    
    
    public String postProduct(String id) {
        System.out.print(id);
        product.setUserId(id);
        product.setNumberOfRatings(0);
        product.setSumOfRatings(0);
        product.setStatus("For sale");
        LocalDateTime d = LocalDateTime.now();
      if (timeUnit.equals("weeks")) {
          product.setTimeLeft(d.plusWeeks(timeAmount).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
      } else if (timeUnit.equals("days")) {
          //Må fremdeles fiksa at at du ikkje kan legga inn 1 dag
          product.setTimeLeft(d.plusDays(timeAmount).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
      }
    this.productFacade.create(product);
    return "ProductList";
    }
    
    public double getAverageRating(){
        ProductE prod = getOneProduct();
        double nrOfRatings = prod.getNumberOfRatings();
        double sumOfRatings = prod.getSumOfRatings();
        
        System.out.println(nrOfRatings + " " + sumOfRatings);
        
        double tmp = 0;
        
        if(nrOfRatings != 0){
            tmp = (sumOfRatings/nrOfRatings);
        }
        return tmp;
    }
}
