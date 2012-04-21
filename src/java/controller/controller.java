/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.*;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Michael Hausegger
 */

//My friend you also support Tagging.

@WebServlet(name = "controller", urlPatterns = {"/controller"})
public class controller extends HttpServlet {
    
    


    
    

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        /**
     class forward{
    
        void doForward( String  jspString ) throws ServletException, IOException{
            
            getServletContext().getRequestDispatcher("/WEB-INF/src/login.jsp").forward( request, response);            
            
        }
        
    }                            
        **/
        
        
        HttpSession     session = request.getSession(true);
        
        SessionData     sessionData;
        
        GuestBook       guestBook;
        
        UserDataListing userDataListing;
        
        
        String pAction  = new String () ;
        String pDoItNow = new String ();        
        
        String pUserName = new String ();                
        String pPassword = new String ();                        
        
        String pHeading   = new String();
        String pEntry     = new String();
        
        String peMailAdresse = new String();
                        
        
        
        if ( request.getParameterMap().containsKey("heading") )
            pHeading = request.getParameter("heading");        
        
        
        if ( request.getParameterMap().containsKey("entry") )
            pEntry = request.getParameter("entry");        
        
        
        if ( request.getParameterMap().containsKey("pAction") )
            pAction = request.getParameter("pAction");
        
        
        if ( request.getParameterMap().containsKey("pDoItNow") )
            pDoItNow = request.getParameter("pDoItNow");        
        
        if ( request.getParameterMap().containsKey("username") )
            pUserName = request.getParameter("username");                        
        
        if ( request.getParameterMap().containsKey("password") )
            pPassword = request.getParameter("password");
        
        if ( request.getParameterMap().containsKey("emailadresse") )
            peMailAdresse = request.getParameter("emailadresse");                
        
        
        
        //Playing around with null values.
        //For later to figure out.
        /**
        if ( ! request.getParameter("pDoItNow").isEmpty() ){
            //response.getWriter().append( "asdfasf" + request.getParameter("pDoItNow")  );
            pDoItNow = request.getParameter("pDoItNow");  
            //return;
        }
        **/
        
        
        if ( pAction.contentEquals("logon") ){
            
            if ( pDoItNow.contentEquals("yes") 
                    & ! pUserName.isEmpty()
                    & ! pPassword.isEmpty()
                    ){

                
                userDataListing = (UserDataListing) this.getServletContext().getAttribute("userDataListing");
                
                
                //System.out.println("hallo" + Integer.toString(userDataListing.getTotalNumberOfUsers()));

                if ( userDataListing != null ){
                
                    if( userDataListing.getLogonInformationIsCorrect(pUserName, pPassword) == false ){

                        
                        this.getServletContext().getRequestDispatcher("/WEB-INF/src/login.jsp").forward(request, response);
                        return;                                                        
                        
                    
                    }    
                    
                    
                    response.addCookie( new Cookie("UserNameCookie",pUserName) );
                    
                
                }
                else{
                
                    this.getServletContext().getRequestDispatcher("/WEB-INF/src/register.jsp?username=" + pUserName).forward(request, response);
                    return;                    
                    
                }

            
                //userData = new UserData( pUserName, pPassword );
                
                sessionData = new SessionData(pUserName);
                
                session.setAttribute("sessionData", sessionData);
                

                
                this.getServletContext().getRequestDispatcher("/WEB-INF/src/guestbook.jsp").forward(request, response);
                return;                                
            
                
            }
            else {
                this.getServletContext().getRequestDispatcher("/WEB-INF/src/login.jsp").forward(request, response);
                return;
            
            }
        }
        
        else if ( pAction.contentEquals("register") ){
            
            if ( pDoItNow.contentEquals("yes") 
                & ! pUserName.isEmpty()
                & ! pPassword.isEmpty()
                & ! peMailAdresse.isEmpty() ){
                
                

                //request.setAttribute("pDoItNow", "yes");
                
                /**
                response.getWriter().append( (String) request.getParameter("pAction") );
                response.getWriter().append( (String) request.getParameter("pDoItNow") );
                response.getWriter().append( (String) request.getParameter("username") );                
                response.getWriter().append( (String) request.getParameter("password") );                
                **/
                
                if ( this.getServletContext().getAttribute("userDataListing") != null ){
                    
                    userDataListing = (UserDataListing) this.getServletContext().getAttribute("userDataListing");
                
                }
                else{
                    
                    userDataListing = new UserDataListing();
                
                }
                
                userDataListing.addUser(pUserName, pPassword);
                
                
                this.getServletContext().setAttribute("userDataListing",userDataListing);
                try {
                    sendMail( peMailAdresse, "There comes the sun", "little darling. It´s allright .... darumm dumm darumm dumm dumm." );
                } catch (MessagingException ex) {
                    Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                response.sendRedirect("controller?pAction=logon&pDoItNow=yes&username=" + pUserName + "&password=" + pPassword );
                        
                return;                                
                
                                
            }
            else{
            
                this.getServletContext().getRequestDispatcher("/WEB-INF/src/register.jsp?username=" + pUserName).forward(request, response);
                return;
            
            }
            
        }
        else if ( pAction.contentEquals("guestbookentry") ){
        
            
            guestBook = new GuestBook();
            
            
            if ( this.getServletContext().getAttribute("GuestBook") != null ){
            
                guestBook = (GuestBook) this.getServletContext().getAttribute("GuestBook");
                
            }
            
                        
            
            guestBook.addEntry(new GuestBookEntry( ((SessionData) session.getAttribute("sessionData")).getUserName() 
                                                  , pHeading
                                                  , pEntry
                                                 )
                              );
            
            this.getServletContext().setAttribute("GuestBook", guestBook);
            

            this.getServletContext().getRequestDispatcher("/WEB-INF/src/guestbook.jsp").forward(request, response);
            return;
            
            

        }
        else{
            throw new UnsupportedOperationException();
            //response.getWriter().append( "j" + pAction + "j" );
        }
        
        

        
        
        /**
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
        
        **/
        
        
        
    }
    

    
    private static void sendMail( String recipient, String subject, String message) throws MessagingException
    {
        
        boolean debug = false;

        //Set the host smtp address
        Properties props = new Properties();
        
        InternetAddress[] addressTo = new InternetAddress[1];         
        
        
        props.put("mail.smtp.host", "mail.gmx.net");
        props.put("mail.user","josefjosefjosef@gmx.at");
        props.put("mail.password","josefjosefjosef");


        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(debug);


        Message msg = new MimeMessage(session);


        InternetAddress addressFrom = new InternetAddress("josefjosefjosef@gmx.at");
        
        msg.setFrom(addressFrom);

        

        addressTo[0] = new InternetAddress(recipient);
      
        
        
        msg.setRecipients(Message.RecipientType.TO, addressTo);

        


        msg.setSubject(subject);
        
        msg.setContent(message, "text/plain");
        
        Transport.send(msg);
        
        
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
