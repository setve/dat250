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
import enteties.UserE;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author SebastianRojas
 */
@ManagedBean
@Named(value="userView")
@RequestScoped
public class UserView {

    @EJB
    UserFacade userFacade;
    
    private UserE user;
    
    public UserE getUser() {
        return user;
    }

    public UserView() {
        user = new UserE();
    }
    
    public List<UserE> getUserList() {
        return userFacade.findAll();
    } 
    
    public String postUser() {
        userFacade.create(user);
        return "login";
    };
   
    public String loginUser(){
        List<UserE> uList = getUserList();
        //uList = getUserList();
        for (Iterator<UserE> it = uList.iterator(); it.hasNext();) {
            UserE u = it.next();
            if(u.getUsername() != null && u.getPassword() != null){
                
                
                if(u.getUsername().equals(user.getUsername())){          // user.get funksjonene returnerer ikke rett string
                    if(u.getPassword().equals(user.getPassword())){      // Funker om man tester med å skrive "admin" og "admin1234" (som er registrert i databasen) 
                        return "successfulLogin";
                    }
                
                }
            }    
        }
            
        return "index";
    }
    

    
}
