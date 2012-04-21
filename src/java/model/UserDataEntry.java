/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



/**
 *
 * @author Michael Hausegger
 */
public class UserDataEntry  {

    public UserDataEntry(String username, String password) {
        this.username = username;
        this.passwordSalted = password;
    }
    
    
    //private int nr;

    
    private String username;
    
    private String passwordSalted;
    

    /**
    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }    
    **/
    
    public String getPassword() {
        return passwordSalted;
    }

    public void setPassword(String password) {
        this.passwordSalted = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    

}
