/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.UserFacade;
import javax.inject.Named;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import enteties.User;

/**
 *
 * @author SebastianRojas
 */
@Named(value = "userView")
@RequestScoped
public class UserView {

    @EJB
    private UserFacade userFacade;
    
    private User user;

    /**
     * Creates a new instance of UserView
     */
    public UserView() {
        this.user = new User();
    }
    
}
