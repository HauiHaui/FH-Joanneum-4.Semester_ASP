/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;



/**
 *
 * @author Michael Hausegger
 */
public class SessionData  {
    
    
    //private int UserNr;
    
    //private long cookieValue;
    
    
    private String userName;

    
    public SessionData(){
    
        
    }
    
    
    public SessionData( String userName ) {
        
        this.userName = userName;
        //this.cookieValue =  new Random().nextLong();
    }

    
    public String getUserName() {
        return userName;
    }

    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    
    


    
    
    /**
    public int getUserNr() {
        return UserNr;
    }

    public void setUserNr(int UserNr) {
        this.UserNr = UserNr;
    }
    * **/

    /**
    
    public long getCookieValue() {
        return cookieValue;
    }
    
    **/

    /**
    public void setCookieValue(String cookieValue) {
        this.cookieValue = cookieValue;
    }
    **/

    
    

}
