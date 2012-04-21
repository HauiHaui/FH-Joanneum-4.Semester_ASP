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
        <title>Login</title>
    </head>
    <body onload="document.forms[0].username.focus();">
        
        
        <!-- 
        Include it at compile time.
        This can be  very error prone when it comes to deployment.
        -->
        <%@include file="header.jsp" %>
        

        <br>
        <br>        
        <br>
        <br>                
            

        <%! 
                
                      String getCookieValue(Cookie[] cookies,
                                                        String cookieName,
                                                        String defaultValue) {
                        for(int i=0; i<cookies.length; i++) {
                        Cookie cookie = cookies[i];
                        if (cookieName.equals(cookie.getName()))
                            return(cookie.getValue());
                        }
                        return(defaultValue);
                    }        
                
                      
        
        %> 



        <h1>Login</h1>
        <br>
            <br>
            
            <form action="controller" > 
                
                <input type="hidden" name="pAction" value="logon">
                <input type="hidden" name="pDoItNow" value="yes">                                
                
                Benutzername: <input  name="username" value="<%=  getCookieValue( request.getCookies(), "UserNameCookie","") %>" >
            
            <br>
            <br>            
            
            
                Passwort: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input  name="password">
            
                <br>
                <br>
                <input type="submit" value="Absenden">
            
            </form>
            
            
            
            <br>
            <br>
            <br>
            <br>            
            <br>
            <br>            
            
            This is your <%= getRequestCount() %> visit on this subpage since this specific servlet is running.
            
            <br>
            <br>
            It is exactly: 
            
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
            
            
    </body>
</html>
