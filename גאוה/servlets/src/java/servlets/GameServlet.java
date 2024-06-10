/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static util.GameUtil.numOfTryings;
import static util.GameUtil.sentenceToShow;
import static util.GameUtil.updateSentenceToShow;
import static util.GameUtil.increaseNumOfTryings;
import javax.servlet.RequestDispatcher;
import util.GameUtil;



/**
 *
 * @author User
 */
@WebServlet(name = "GameServlet", urlPatterns = {"/GameServlet"})
public class GameServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter() ;
    
            /* TODO output your page here. You may use following sample code. */
        String s=" <html>\n"
                +"    <head>\n"
                +"    <title>TODO supply a title</title>\n" 
                +"    <meta charset=\"UTF-8\">\n" 
                +"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" 
                +"    </head>\n" 
                +"    <body>\n" 
                +"    <div>hello</div>\n" 
                +"    <h1>welcome to my project</h1>\n" 
                +"    </body>\n" 
                +"</html>" ;
                out.print(s);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      char letter;
    if (request.getParameter("letter") != null) {
        letter = request.getParameter("letter").charAt(0);
    } else {
        letter = ' ';
    }

    if (letter != 0) {

        // מעדכן את המשפט לתצוגה
        updateSentenceToShow(letter);

        // מגדיל את מספר ניסיונות הניחוש
        increaseNumOfTryings();

        // בודק אם היה ניצחון
        if (GameUtil.checkWinning()) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/win");
            dispatcher.forward(request, response);

        } else {
            showPage(response);
        }

    } else {
        showPage(response);
    }
    
    }
      public void showPage(HttpServletResponse response) throws IOException {

       
        String form = "<html><head><title>דף המשחק</title></head><body>" +
                "<h1>המשפט : " + sentenceToShow + "</h1>" +
                "<h2>מספר ניסיונות: " + numOfTryings + "</h2>" +
                "<form action='/game' method='post'>" +
                "<input type='text' name='letter' placeholder='enter a letter' />" +
                "<input type='submit' value='הכנס אות' />" +
                "</form>" +
                "</body></html>";

        
//        response.setContentType("text/html");
//        response.getWriter().write(form);  
          out.print(form);  
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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
