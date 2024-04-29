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
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import modeli.Soba;
import modeli.Korisnik;
import modeli.Rezervacija;
/**
 *
 * @author B
 */
@WebServlet(name = "IzaberiSobuServlet", urlPatterns = {"/IzaberiSobuServlet"})
public class IzaberiSobuServlet extends HttpServlet {

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
        HttpSession sesija = request.getSession();
        Korisnik trenutni = (Korisnik) sesija.getAttribute("trenutni");
        int idsobe = Integer.parseInt(request.getParameter("idsobe"));
        Soba soba = Queries.getSobaPoId(idsobe);
        int idkorisnik = trenutni.getId();
        String koristibodove = (String) request.getParameter("koristibodove");
        String datumod = (String)request.getParameter("datumod");
        String datumdo = (String)request.getParameter("datumdo");
        int id = 0;
        if (idsobe == 0) {
            poruka = "NEDOSTAJE ID SOBE";
        }
        if (idkorisnik == 0) {
            poruka = "NEDOSTAJE ID KORISNIKA";
        }
        if (datumod == null ) {
            poruka = "NEDOSTAJE DATUM POČETKA REZERVACIJE";
        }
        if (datumdo == null ) {
            poruka = "NEDOSTAJE DATUM KRAJA REZERVACIJE";
        }

        if (!poruka.isEmpty()) {
            request.setAttribute("poruka", poruka);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        else {
            Rezervacija r = new Rezervacija(id, idkorisnik, idsobe, datumod, datumdo);
            int bodovi = Queries.checkBodovi(idkorisnik);
            if(bodovi>0 && koristibodove.equals("yes"))
            { 
                poruka = "Ostvarili ste popust od 50%!";
                request.setAttribute("poruka", poruka);
                request.setAttribute("cena", soba.getCena()/2);
                System.out.println(bodovi);
                bodovi-=1;
                System.out.println(bodovi);
                Queries.insertRezervacijaPopust(r, idkorisnik, bodovi);
                RequestDispatcher rd = request.getRequestDispatcher("uspesnarezervacija.jsp");
                rd.forward(request, response);
            }
            else {
                request.setAttribute("cena", soba.getCena());
                poruka = "Zelimo Vam srećan boravak!";
                request.setAttribute("poruka", poruka);
                System.out.println(bodovi);
                bodovi+=1;
                System.out.println(bodovi);
                Queries.insertRezervacija(r);
                Queries.updateKlijent(idkorisnik, bodovi);
                RequestDispatcher rd = request.getRequestDispatcher("uspesnarezervacija.jsp");
                rd.forward(request, response);
            }
            
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
