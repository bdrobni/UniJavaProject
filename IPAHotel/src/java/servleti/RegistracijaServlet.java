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
import javax.servlet.RequestDispatcher;
import modeli.Korisnik;

/**
 *
 * @author B
 */
@WebServlet(name = "RegistracijaServlet", urlPatterns = {"/RegistracijaServlet"})
public class RegistracijaServlet extends HttpServlet {

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
        String poruka = "";
        String ime = request.getParameter("ime");
        String prezime = request.getParameter("prezime");
        String email = request.getParameter("email");
        String sifra = request.getParameter("sifra");
        String sifra_potvrda = request.getParameter("sifra_potvrda");
        
        if (ime == null || ime == "") {
            poruka = "NEDOSTAJE IME KORISNIKA";
        }
        if (prezime.isEmpty() || prezime == null) {
            poruka = "NEDOSTAJE PREZIME KORISNIKA";
        }
        if (email.isEmpty() || email == null) {
            poruka = "NEDOSTAJE EMAIL KORISNIKA";
        }
        if (sifra.isEmpty() || sifra == null
                || sifra_potvrda.isEmpty() || sifra_potvrda == null) {
            poruka = "NEDOSTAJE SIFRA KORISNIKA";
        }
        if (!poruka.isEmpty()) {
            request.setAttribute("poruka", poruka);
            RequestDispatcher rd = request.getRequestDispatcher("registracija.jsp");
            rd.forward(request, response);
        }
        
        if (sifra.equals(sifra_potvrda)) {
            Korisnik novi_korisnik = new Korisnik(0, 0, ime, prezime, sifra, email, "K",0);
            //unesi korisnika u DB
            Queries.insertKorisnik(novi_korisnik);
            response.sendRedirect("index.jsp");
        } else {
            poruka = "NISTE UNELI ISTU SIFRU ZA POTVRDU.";
            request.setAttribute("poruka", poruka);
            RequestDispatcher rd = request.getRequestDispatcher("registracija.jsp");
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
