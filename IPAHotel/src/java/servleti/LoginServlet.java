/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servleti;

import database.Queries;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import modeli.Korisnik;
import modeli.Hotel;

/**
 *
 * @author B
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
       String korisnickoIme = request.getParameter("email");
        String sifra = request.getParameter("sifra");

        String poruka = "";
        if (korisnickoIme.isEmpty() || korisnickoIme == null) {
            poruka = "NEDOSTAJE EMAIL KORISNIKA";
        }

        if (sifra.isEmpty() || sifra == null) {
            poruka = "NEDOSTAJE SIFRA KORISNIKA";
        }
        if (!poruka.isEmpty()) {
            request.setAttribute("poruka", poruka);
            RequestDispatcher rd = request.getRequestDispatcher("registracija.jsp");
            rd.forward(request, response);
        }
        
        
        Korisnik ulogovaniKorisnik = Queries.checkLogin(korisnickoIme, sifra);
        System.out.println(ulogovaniKorisnik.getIme());
        System.out.println(ulogovaniKorisnik.getTipkorisnika());
        if (ulogovaniKorisnik != null) {
            
            HttpSession sesija = request.getSession();
            
            sesija.setAttribute("trenutni", ulogovaniKorisnik);
            if(ulogovaniKorisnik.getTipkorisnika().equals("K"))
            {
                request.setAttribute("trenutni", ulogovaniKorisnik);
                
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            }
            else if(ulogovaniKorisnik.getTipkorisnika().equals("A")) {
                ArrayList<Hotel> hoteli = Queries.getHoteli();
                request.setAttribute("hoteli", hoteli);
                 request.setAttribute("trenutni", ulogovaniKorisnik);
            RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
            rd.forward(request, response);
            }
            else if(ulogovaniKorisnik.getTipkorisnika().equals("M")) {
                
                 request.setAttribute("trenutni", ulogovaniKorisnik);
                 request.setAttribute("zahotel", ulogovaniKorisnik.getMenadzer());
            RequestDispatcher rd = request.getRequestDispatcher("GetHotelServlet");
            rd.forward(request, response);
            }

        } else {
            poruka = "LOGOVANJE NIJE PROSLO.";
            request.setAttribute("poruka", poruka);
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
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
        processRequest(request, response);
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
