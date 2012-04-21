<%-- 
    Document   : welcome
    Created on : Mar 17, 2012, 3:07:18 PM
    Author     : Michael Hausegger
--%>

<%@page import="java.util.Date"%>


<%! 

private static  Integer numCount = 0;

private Integer getRequestCount(){

    return ++numCount;
    
}

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        
        
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
            
            <a href="controller?pAction=register" > Registrieren </a>
            
            <br>
            <br>            
            


            <a href="controller?pAction=logon&pDoItNow=no" > Anmelden </a>            
            
            
            <br>
            <br>
            <br>
            <br>            
            <br>
            <br>            
            
            This is your <%= getRequestCount() %> visit on this subpage since this specific servlet is running.
            
            <br>
            <br>
            Play <a href="#" onmouseover="javascript: showImage('1');" >erstes Bild anzeigen</a>, <a href="#" onmouseover="javascript: showImage('2');" >zweites Bild anzeigen</a>, <a href="#" onmouseover="javascript: showImage('3');" >drittes Bild anzeigen</a>.
            
            &nbsp;&nbsp;<img alt="Bild welches entweder die Zahl 1 oder 2 oder 3 enthält." id="myImage" src="#" width="60" height="60" onmouseover="javascript: this.setAttribute('src', '#'); this.setAttribute('alt', '');">
            
            <%
            
            //TimeServerTime serverTime = new TimeServerTime();
            
            //out.append( TimeServerTime.getTime().toString() );
            
            //Date date = new Date();
            
            //out.print(date.toString());
            
            %>
            
            
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
            
            
            <script src="javascripts/1.js" charset="UTF-8"></script>
            
    </body>
</html>
