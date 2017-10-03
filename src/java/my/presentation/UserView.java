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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;



/**
 *
 * @author SebastianRojas
 */
@Named(value="userView")
@RequestScoped
public class UserView{

    @EJB
    UserFacade userFacade;
    
    private UserE user;
    
    public UserE getUser() {
        return user;
    }

    public UserView() {
        user = new UserE();
    }
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM HH:mm:ss");
    String datoOgTid = sdf.format(new Date());
    Date date = new Date();
    
    
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
                if(u.getUsername().equals(user.getUsername())){     
                    if(u.getPassword().equals(user.getPassword())){       
                        return "successfulLogin";
                    }
                }
            }    
        }
            
        return "login";
    }
}
