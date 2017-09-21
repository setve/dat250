
package my.presentation;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;


@Named(value = "loginBean")
@SessionScoped
public class loginBean implements Serializable {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username;
    private String password;
    
    
    public loginBean() {
    }
    
    public String goToLogin(){
        return "login";
    }
    
    
}
