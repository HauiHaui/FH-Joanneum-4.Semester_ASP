/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Michael Hausegger
 */
public class GuestBook {
    
    
   private  java.util.ArrayList<GuestBookEntry>  entryList = new java.util.ArrayList<GuestBookEntry>();

   
    public ArrayList<GuestBookEntry> getEntryList() {
        return entryList;
    }

    public void setEntryList(ArrayList<GuestBookEntry> entryList) {
        this.entryList = entryList;
    }
    
    
    public void addEntry( GuestBookEntry  entry  ) {
        this.entryList.add(entry);
    }    
    
    
    
}
