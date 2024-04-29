/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeli.Hotel;
import modeli.Korisnik;
import modeli.Rezervacija;
import modeli.Soba;
import modeli.TipSobe;
/**
 *
 * @author B
 */
public class Queries {
     public static void insertKorisnik(Korisnik k) {
        String upit = "insert into korisnik "
                + " (ime, prezime, password, tipkorisnika, email, bodovi) "
                + " values (?,?,?,?,?,?)";

        Connection baza = DBConnection.getInstance();

        try {
            PreparedStatement ps = baza.prepareStatement(upit,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, k.getIme());
            ps.setString(2, k.getPrezime());
            ps.setString(3, k.getPassword());
            ps.setString(4, k.getTipkorisnika());
            ps.setString(5, k.getEmail());
            ps.setInt(6, 0);
            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                int id = keys.getInt(1);
                k.setId(id);
                System.out.println("ID KORISNIKA JE :" + id);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void insertHotel(Hotel h){
        String upit = "insert into hotel (naziv, lokacija) values (?,?)";
        
        Connection baza = DBConnection.getInstance();
        
        try{
            PreparedStatement ps = baza.prepareStatement(upit,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, h.getNaziv());
            ps.setString(2, h.getLokacija());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                int id = keys.getInt(1);
                h.setId(id);
                System.out.println("ID Hotela je :" + id);
            }
        }
        
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insertSoba(Soba s){
        String upit = "insert into soba (idtipa, brojsobe, cena) values (?,?,?)";
        
        Connection baza = DBConnection.getInstance();
        
        try{
            PreparedStatement ps = baza.prepareStatement(upit,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, s.getIdtipa());
            ps.setInt(2, s.getBrojsobe());
            ps.setInt(3, s.getCena());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                int id = keys.getInt(1);
                s.setIdsobe(id);
                System.out.println("ID Sobe je :" + id);
            }
        }
        
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void insertTipSobe(TipSobe t){
        String upit = "insert into tipsobe (nazivtipa, sifrahotela) values (?,?)";
        
        Connection baza = DBConnection.getInstance();
        
        try{
            PreparedStatement ps = baza.prepareStatement(upit,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getNazivTipa());
            ps.setInt(2, t.getSifrahotela());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                int id = keys.getInt(1);
                t.setIdtipa(id);
                System.out.println("ID Tipa Sobe je :" + id);
            }
        }
        
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void insertRezervacija(Rezervacija r){
        String upit = "insert into rezervacija (sifrakorisnika, sifrasobe, datumod, datumdo) values (?,?,?,?)";
        
        Connection baza = DBConnection.getInstance();
        
        try{
            PreparedStatement ps = baza.prepareStatement(upit,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, r.getSifrakorisnika());
            ps.setInt(2, r.getSifrasobe());
            ps.setString(3, r.getDatumod());
            ps.setString(4, r.getDatumdo());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                int id = keys.getInt(1);
                r.setIdrez(id);
                System.out.println("ID Sobe je :" + id);
            }
        }
        
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static int checkBodovi(int id) {
        String upit = "SELECT bodovi FROM korisnik where idkorisnika=?";
        Connection baza = DBConnection.getInstance();
        try {
            PreparedStatement ps = baza.prepareStatement(upit);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                return result.getInt("bodovi");
            } else {
                return 0;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static Hotel getHotel(int idhotela) {
        Hotel hotel = new Hotel();
        String upit = "SELECT * FROM hotel where id=?";
        Connection baza = DBConnection.getInstance();
        try {
            PreparedStatement ps = baza.prepareStatement(upit);
            ps.setInt(1, idhotela);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                    hotel.setId(result.getInt("id"));
                    hotel.setNaziv(result.getString("naziv"));
                    hotel.setLokacija(result.getString("lokacija"));                    
                }

        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hotel;
    }
    public static ArrayList<Hotel> getHoteli()
    {
        ArrayList<Hotel> hoteli = new ArrayList<Hotel>();
        String upit = "SELECT * FROM hotel";
        Connection baza = DBConnection.getInstance();
        try {
            PreparedStatement ps = baza.prepareStatement(upit);           
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                    Hotel hotel = new Hotel();
                    hotel.setId(result.getInt("id"));
                    hotel.setNaziv(result.getString("naziv"));
                    hotel.setLokacija(result.getString("lokacija"));
                    hoteli.add(hotel);
                }

        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hoteli;
    }
    
    public static ArrayList<TipSobe> getTipovi(int idhotela) {
        ArrayList<TipSobe> tipovi = new ArrayList<TipSobe>();
        String upit = "SELECT * FROM tipsobe where sifrahotela=?";
        Connection baza = DBConnection.getInstance();
        try {
            PreparedStatement ps = baza.prepareStatement(upit);
            ps.setInt(1, idhotela);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                    TipSobe tip = new TipSobe();
                    tip.setIdtipa(result.getInt("idtipa"));
                    tip.setNazivTipa(result.getString("nazivtipa"));
                    tip.setSifrahotela(idhotela);
                    tipovi.add(tip);
                }

        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipovi;
    }
    
    public static ArrayList<Soba> getSoba()
    {
        ArrayList<Soba> sobe = new ArrayList<Soba>();
        String upit = "SELECT * FROM soba";
        Connection baza = DBConnection.getInstance();
        try {
            PreparedStatement ps = baza.prepareStatement(upit);           
            ResultSet result = ps.executeQuery();
            while(result.next())
            {
                Soba soba = new Soba();
                soba.setIdsobe(result.getInt("idsobe"));
                soba.setIdtipa(result.getInt("idtipa"));
                soba.setBrojsobe(result.getInt("brojsobe"));
                soba.setCena(result.getInt("cena"));
                sobe.add(soba);
            }
            
        }
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sobe;
    }
    public static ArrayList<Korisnik> getKorisnici()
    {
        ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
        
        String upit = "SELECT * from korisnik";
        Connection baza = DBConnection.getInstance();
        
        try {
            PreparedStatement ps = baza.prepareStatement(upit);
            ResultSet result = ps.executeQuery();
            while(result.next())
            {
              Korisnik korisnik = new Korisnik();
              korisnik.setId(result.getInt("idkorisnika"));
                korisnik.setIme(result.getString("ime"));
                korisnik.setPrezime(result.getString("prezime"));
                korisnik.setEmail(result.getString("email"));
                korisnik.setTipkorisnika(result.getString("tipkorisnika"));
                korisnik.setBodovi(result.getInt("bodovi"));
                korisnik.setMenadzer(result.getInt("menadzer"));
                korisnici.add(korisnik);
            }
            
        }
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return korisnici;
    }
    public static Rezervacija getRezervacija(int idKorisnika)
    {
        Rezervacija rezervacija = new Rezervacija();
        String upit = "SELECT * FROM rezervacija where sifrakorisnika=?";
        Connection baza = DBConnection.getInstance();
        try {
            PreparedStatement ps = baza.prepareStatement(upit);
            ps.setInt(1, idKorisnika);
            ResultSet result = ps.executeQuery();
            while(result.next())
            {              
                rezervacija.setIdrez(result.getInt("idrez"));
                rezervacija.setSifrakorisnika(idKorisnika);
                rezervacija.setSifrasobe(result.getInt("sifrasobe"));
                rezervacija.setDatumod(result.getString("datumod"));
                rezervacija.setDatumdo(result.getString("datumdo"));
            }
            
        }
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rezervacija;
    }
     public static ArrayList<Rezervacija> getRezervacijaPoKorisniku(int idKorisnika)
    {
        ArrayList<Rezervacija> rezervacije = new ArrayList<Rezervacija>();
        String upit = "SELECT * FROM rezervacija where sifrakorisnika=?";
        Connection baza = DBConnection.getInstance();
        try {
            
            PreparedStatement ps = baza.prepareStatement(upit);
            ps.setInt(1, idKorisnika);
            ResultSet result = ps.executeQuery();
            while(result.next())
            {      
                Rezervacija rezervacija = new Rezervacija();
                rezervacija.setIdrez(result.getInt("idrez"));
                rezervacija.setSifrakorisnika(idKorisnika);
                rezervacija.setSifrasobe(result.getInt("sifrasobe"));
                rezervacija.setDatumod(result.getString("datumod"));
                rezervacija.setDatumdo(result.getString("datumdo"));
                rezervacije.add(rezervacija);
            }
            
        }
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rezervacije;
    }
    
    public static Soba getSobaPoId(int idsobe)
    {
        Soba soba = new Soba();
        String upit = "SELECT * FROM soba where idsobe=?";
        Connection baza = DBConnection.getInstance();
        try {
            PreparedStatement ps = baza.prepareStatement(upit);
            ps.setInt(1, idsobe);
            ResultSet result = ps.executeQuery();
            while(result.next())
            {
              
                soba.setIdsobe(result.getInt("idsobe"));
                soba.setIdtipa(result.getInt("idtipa"));
                soba.setBrojsobe(result.getInt("brojsobe"));
                soba.setCena(result.getInt("cena"));
                
            }
            
        }
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soba;
    }
    
    public static void insertRezervacijaPopust(Rezervacija r, int sifrakorisnika, int bodovi){
        String upit = "insert into rezervacija (sifrakorisnika, sifrasobe, datumod, datumdo) values (?,?,?,?)";
        
        Connection baza = DBConnection.getInstance();
        
        try{
            PreparedStatement ps = baza.prepareStatement(upit,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, r.getSifrakorisnika());
            ps.setInt(2, r.getSifrasobe());
            ps.setString(3, r.getDatumod());
            ps.setString(4, r.getDatumdo());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                int id = keys.getInt(1);
                r.setIdrez(id);
                System.out.println("ID Sobe je :" + id);
            }
        }
        
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        String upit2 = "update korisnik set bodovi=? where idkorisnika=?";
        
        try{
            PreparedStatement ps = baza.prepareStatement(upit2,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, bodovi);
            ps.setInt(2, sifrakorisnika);
            ps.executeUpdate();
        }
        
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateBodovi(int id, int bodovi){
        String upit = "update korisnik set bodovi=? where idkorisnika=?";
        
        Connection baza = DBConnection.getInstance();
        
        try{
            PreparedStatement ps = baza.prepareStatement(upit,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, bodovi);
            ps.setInt(2, id);
            ps.executeUpdate();
           
        }
        
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void deleteRezervacija(int rezid)
    {
        String upit = "delete from rezervacija where idrez=?";
        
        Connection baza = DBConnection.getInstance();
        
        try{
            PreparedStatement ps = baza.prepareStatement(upit,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,rezid);
            ps.executeUpdate();           
        }
        
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static void deleteSoba(int sobaid)
    {
        String upit = "delete from soba where idsobe=?";
        
        Connection baza = DBConnection.getInstance();
        
        try{
            PreparedStatement ps = baza.prepareStatement(upit,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,sobaid);
            ps.executeUpdate();           
        }
        
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public static void deleteTipSobe(int tipid)
    {
        String upit = "delete from tipsobe where idtipa=?";
        
        Connection baza = DBConnection.getInstance();
        
        try{
            PreparedStatement ps = baza.prepareStatement(upit,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,tipid);
            ps.executeUpdate();           
        }
        
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
       public static void deleteHotel(int hotelid)
    {
        String upit = "delete from hotel where id=?";
        
        Connection baza = DBConnection.getInstance();
        
        try{
            PreparedStatement ps = baza.prepareStatement(upit,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,hotelid);
            ps.executeUpdate();           
        }
        
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void deleteKlijent(int id)
    {
        String upit = "delete from korisnik where idkorisnika=?";
        
        Connection baza = DBConnection.getInstance();
        
        try{
            PreparedStatement ps = baza.prepareStatement(upit,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id);
            ps.executeUpdate();           
        }
        
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     public static Korisnik checkLogin(String email, String password) {
        String upit = "SELECT * FROM korisnik where email=?"
                + " and password=?";
        Connection baza = DBConnection.getInstance();
        Korisnik korisnik = new Korisnik();
        try {
            PreparedStatement ps = baza.prepareStatement(upit);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                korisnik.setId(result.getInt("idkorisnika"));
                korisnik.setIme(result.getString("ime"));
                korisnik.setPrezime(result.getString("prezime"));
                korisnik.setEmail(result.getString("email"));
                korisnik.setTipkorisnika(result.getString("tipkorisnika"));
                korisnik.setBodovi(result.getInt("bodovi"));
                korisnik.setMenadzer(result.getInt("menadzer"));

            } 

        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return korisnik;

    }
     
      public static Korisnik getSingleKorisnik(int idkorisnika) {
        String upit = "SELECT * FROM korisnik where idkorisnika=?";
        Connection baza = DBConnection.getInstance();
        Korisnik korisnik = new Korisnik();
        try {
            PreparedStatement ps = baza.prepareStatement(upit);
            ps.setInt(1, idkorisnika);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                korisnik.setId(result.getInt("idkorisnika"));
                korisnik.setIme(result.getString("ime"));
                korisnik.setPrezime(result.getString("prezime"));
                korisnik.setEmail(result.getString("email"));
                korisnik.setTipkorisnika(result.getString("tipkorisnika"));
                korisnik.setBodovi(result.getInt("bodovi"));
                korisnik.setMenadzer(result.getInt("menadzer"));

            } 

        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return korisnik;

    }
     
     public static void updateSoba(int idsobe, int idtipa, int cena){
        String upit = "update soba set idtipa=?, cena=? where idsobe=?";
        
        Connection baza = DBConnection.getInstance();
        
        try{
            PreparedStatement ps = baza.prepareStatement(upit,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idtipa);
            ps.setInt(2, cena);
            ps.setInt(3, idsobe);
            ps.executeUpdate();
          
        }
        
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public static void updateHotel(String naziv, int id){
        String upit = "update hotel set naziv=? where id=?";
        
        Connection baza = DBConnection.getInstance();
        
        try{
            PreparedStatement ps = baza.prepareStatement(upit,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, naziv);
            ps.setInt(2, id);
            ps.executeUpdate();
           
        }
        
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void updateTip(String naziv, int id){
        String upit = "update tipsobe set nazivtipa=? where idtipa=?";
        
        Connection baza = DBConnection.getInstance();
        
        try{
            PreparedStatement ps = baza.prepareStatement(upit,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, naziv);
            ps.setInt(2, id);
            ps.executeUpdate();
           
        }
        
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void updateKlijent(int id, int bodovi){
        String upit = "update korisnik set bodovi=? where idkorisnika=?";
        
        Connection baza = DBConnection.getInstance();
        
        try{
            PreparedStatement ps = baza.prepareStatement(upit,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, bodovi);
            ps.setInt(2, id);
            ps.executeUpdate();
           
        }
        
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
