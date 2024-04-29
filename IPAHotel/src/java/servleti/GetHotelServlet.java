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
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import modeli.Hotel;
import modeli.Korisnik;
import modeli.TipSobe;
import modeli.Soba;

/**
 *
 * @author B
 */
@WebServlet(name = "GetHotelServlet", urlPatterns = {"/GetHotelServlet"})
public class GetHotelServlet extends HttpServlet {

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
        HttpSession sesija = request.getSession();
        Korisnik trenutni = (Korisnik) sesija.getAttribute("trenutni");
        int id;
        if(request.getAttribute("zahotel") != null)
        {
            id = (int) request.getAttribute("zahotel");
        } 
        else if (trenutni.getTipkorisnika().equals("M")) {
            id = trenutni.getMenadzer();
        }
        else id=Integer.parseInt(request.getParameter("idhotel"));
        Hotel hotel = Queries.getHotel(id);
        ArrayList<TipSobe> tipovi = Queries.getTipovi(id);
        ArrayList<Soba> sobeLista = Queries.getSoba();
        ArrayList<Soba> sobe = new ArrayList<Soba>();
        for(Soba s : sobeLista)
        {
            for(TipSobe t : tipovi)
            {
                if(t.getSifrahotela()==hotel.getId() && !sobe.contains(s))
                    sobe.add(s);
            }
        }
        
         request.setAttribute("tipovisoba", tipovi);
            request.setAttribute("sobe", sobe);
            request.setAttribute("hotel", hotel);
        if (trenutni.getTipkorisnika().equals("M") || trenutni.getTipkorisnika().equals("A")){
            RequestDispatcher rd = request.getRequestDispatcher("hotel.jsp");
            rd.forward(request, response);
        } else
        {
            RequestDispatcher rd = request.getRequestDispatcher("rezervacijasobe.jsp");
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
