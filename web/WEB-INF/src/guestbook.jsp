<%-- 
    Document   : welcome
    Created on : Mar 17, 2012, 3:07:18 PM
    Author     : Michael Hausegger
--%>

<%@page import="java.util.Iterator"%>
<%@page import="model.GuestBook"%>
<%@page import="model.GuestBookEntry"%>
<%@page import="model.SessionData"%>
<%@page import="java.util.Date"%>


<%! 

private static  Integer numCount = 0;

private Integer getRequestCount(){

    return ++numCount;
    
}

%>






<jsp:useBean class="model.GuestBook" scope="application" id="GuestBook"/>
    



<%@page contentType="text/html" pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body onload="document.forms[0].heading.focus();">
        
        
        <!-- 
        Include it at compile time.
        This can be  very error prone when it comes to deployment.
        -->
        <%@include file="header.jsp" %>
        

        <br>
        <br>        
        <br>
        <br>                
            

        <h1>Welcome at my site!</h1>
        <br>
            <br>
            

            Willkommen in meinem Gästebuch.
            
            

            
            
            
            <br>
            <br>
            <br>
            <br>            
            <br>
            <br>                        
            
            <%= GuestBook.getEntryList().size() %> bisherige Starkommentare:
            
            <br>
            <br>                         
            
            <%
            
            
            GuestBookEntry entry;
            
            Iterator iterator = GuestBook.getEntryList().iterator();
            
            while ( iterator.hasNext() ){
            
                entry = (GuestBookEntry) iterator.next();
                
                out.append("Ersteller: " + entry.getCreatorName());
                out.append("<br>");
                out.append("<b>" + entry.getHeading() + "</b>");
                out.append("<br>");                
                out.append(entry.getEntry());
                
                out.append("<br>");
                out.append("<br>");
                out.append("<br>");                                              
              
            } 

            %>
            
            
            <br>
            <br>
            <br>
            <br>            
            <br>
            <br>                                    
            
            
            <form action="controller" >
                
                <input type="hidden" name="pAction" value="guestbookentry">
                
                Überschrift: <input name="heading" size="30" maxlength="30">
                
                <br>
                
                Eintrag: &nbsp;&nbsp; <input type="text" size="30" width="30" height="10" maxlength="260" name="entry">   
                
                <br>
                
                <input type="submit" value="Eintragen">
                
                
            </form>
            
            <br>
            <br>
            <br>
            <br>            
            <br>
            <br>            
            
            This is the <%= getRequestCount() %> visit on this subpage since this specific servlet is running.
            
            <br>
            <br>
            

            
            
            <br>
            <br>
            

            <!-- 
            Includes the content of the jsp site at runtime of the class.
            -->
            
            <!-- 
            Mein Goot bist du ein ......
            a)Korrekter Pfad zur Quellcodedatei muss angegeben werden!!!
            
            b)
            Wenn Datei zur Laufzeit nicht gefunden wird wird kein Error geworfen.
            Sondern Verarbeitung einfach abgebrochen.
            Super Konzept - wirklich.
            -->
            <jsp:include page="/WEB-INF/src/footer.jsp" flush="true" />
            
            
    </body>
</html>
