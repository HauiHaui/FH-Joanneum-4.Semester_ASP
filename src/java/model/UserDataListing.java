/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.TreeMap;
import security.BCrypt;



/**
 *
 * @author student
 */
public class UserDataListing {
    
    
    private TreeMap<String,String>    userEntrys = new TreeMap<String,String>();
    
    
    public void addUser(String userName, String password){
    
        if ( this.getUserNameAlreadyExists(userName) )
                throw new UnsupportedOperationException();
                
        userEntrys.put(userName.toUpperCase(), BCrypt.hashpw( password, BCrypt.gensalt() ) );
    
    }
    
    
    public boolean getUserNameAlreadyExists(String userName){
    
        if ( userEntrys.containsKey(userName.toUpperCase()) ) 
            return true;
        
        return false;
        
    }
    
    
    public boolean getLogonInformationIsCorrect(String userName,String password ){

        if ( getUserNameAlreadyExists(userName) ){

            if ( BCrypt.checkpw(password, userEntrys.get(userName.toUpperCase()) ) ) {

                return true;
                
            }
            else{

                return false;
                
            }              
            
        }
        else{
            return false;
        }
                                
    
    }
    
    
    public int getTotalNumberOfUsers(){
    
        return userEntrys.size();
        
    }
    
}
