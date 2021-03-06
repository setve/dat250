/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.ProductFacade;
import clients.notifyBuyerClient;
import enteties.ProductE;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.swing.JOptionPane;
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
    private notifyBuyerClient notifyBuyerCli;
    
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
    
    public String Soap(){
        return "SoapOutPut";
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
    
    public static void infoBox(){
        System.out.println("In infoBox");
        JOptionPane.showInputDialog("Denied");
        System.out.println("Finished, but this one is pointless since java cn not work correctly since it"
                                + "s shit.");
    }
    
    @RolesAllowed("USER")
    public String editCurrentBid(String currentBid, Long productId, Long oldBid, String bidderUserName, String creatorUserName){
            if(bidderUserName == null ? creatorUserName == null : bidderUserName.equals(creatorUserName)){
                return "failedBid";
            } else if(oldBid == null){
                productFacade.updateBid(Integer.parseInt(currentBid), productId, bidderUserName);
                goToProdList();
            } else if(oldBid < Long.parseLong(currentBid)){
                productFacade.updateBid(Integer.parseInt(currentBid), productId, bidderUserName);
                goToProdList();
            }
            //System.out.println("Bidder username: " + bidderUserName);
            return "productPage";
        }
    
    @RolesAllowed("USER")
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
    
    public String goToProdList(){
        return "ProductList";
    }
    
    @RolesAllowed("USER")
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
    
    Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
        
        @Override
        public void run() {
            
                //Send epost
                System.out.println("Legger til melding i queue");
                notifyBuyerCli.addMessageToQueue(product.getId().toString());
                t.cancel();
            
        }
    },1000,5000);  //Every 30. second
        
    return "ProductList";
    }
    
    @RolesAllowed("USER")
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
