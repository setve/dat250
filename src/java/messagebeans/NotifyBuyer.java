/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messagebeans;

import boundary.ProductFacade;
import enteties.ProductE;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author stian
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/NotificationQueue")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class NotifyBuyer implements MessageListener {
    
    private ProductFacade productFacade;
    
    public NotifyBuyer() {
    }
    
    @Override
    public void onMessage(Message message) {
        //message consists of the product id
        try {
            String prodID = message.toString();
            ProductE product = productFacade.getOneProduct(prodID);
            
            String link = "http://localhost:8080/dat250/webresources/enteties.producte_1/" + prodID;
            String emailContent = "Dear " + product.getUserIdBuyer() + "! \n"
                + "Congratulations! You have won in bidding for product '" + product.getName() + ". \n"
                + "You can access the product using the following link: " + link;
            System.out.println(emailContent);
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}