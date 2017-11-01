/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
//import javax.jms.*;

/**
 *
 * @author stian
 */
public class notifyBuyerClient {
    @Resource(mappedName="jms/__defaultConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName="jms/NotificationQueue")
    private Queue queue;
    
    public notifyBuyerClient() {
        
    }
    
    public void addMessageToQueue(String prodID) {
        try {
            //This line throws a NullPointerException, we don't know why
            // The message will therefore not be added to the queue
            Connection connection = connectionFactory.createConnection();
            
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            TextMessage createdTextMessage = session.createTextMessage(prodID);
            messageProducer.send(createdTextMessage);
            messageProducer.close();
            connection.close();
        }
        catch(Exception ex) {
            System.out.println(ex);
            System.out.println("Prodct ID: " + prodID);
        }
    }
}
