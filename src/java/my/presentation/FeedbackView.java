/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.FeedbackFacade;
import enteties.Fback;
import enteties.ProductE;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author stian
 */
@Named(value = "FeedbackView")
@RequestScoped
public class FeedbackView {

    @EJB
    private FeedbackFacade feedbackFacade;
    private Fback feedback;

    /**
     * Creates a new instance of FeedbackView
     */
    public FeedbackView() {
        this.feedback = new Fback();
    }
    
    public Fback getFeedback() {
        return feedback;
    }
    
    @RolesAllowed("USER")
    public String postFeedback(ProductE product) {
        
        if(feedback.getRating() < 1)
            feedback.setRating(1);
        else if(feedback.getRating() > 5)
            feedback.setRating(5);
        this.feedbackFacade.create(feedback);
        product.setSumOfRatings(feedback.getRating());
        System.out.println("FeedbackView; numberOfRatings" + feedback.getRating());
        return "ProductList";
    }
    
    
}
