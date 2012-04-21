/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author student
 */
public class GuestBookEntry {
    
    
    private String creatorName;
    
    private String heading;

    public GuestBookEntry(String creatorName, String heading, String Entry) {
        this.creatorName = creatorName;
        this.heading = heading;
        this.Entry = Entry;
    }
    

    public GuestBookEntry() {
    }    
    
    
    private String Entry;

    public String getEntry() {
        return Entry;
    }

    public void setEntry(String Entry) {
        this.Entry = Entry;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }
    
    
    
    
    
    
}
