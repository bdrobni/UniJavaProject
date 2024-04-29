/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

/**
 *
 * @author B
 */
public class Korisnik {
    private int id, bodovi, menadzer;

    public int getMenadzer() {
        return menadzer;
    }

    public void setMenadzer(int menadzer) {
        this.menadzer = menadzer;
    }
    private String ime, prezime, password, email, tipkorisnika;

    public Korisnik() {
    }

    public Korisnik(int id, int bodovi, String ime, String prezime, String password, String email, String tipkorisnika, int menadzer) {
        this.id = id;
        this.bodovi = bodovi;
        this.ime = ime;
        this.prezime = prezime;
        this.password = password;
        this.email = email;
        this.tipkorisnika = tipkorisnika;
        this.menadzer = menadzer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBodovi() {
        return bodovi;
    }

    public void setBodovi(int bodovi) {
        this.bodovi = bodovi;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipkorisnika() {
        return tipkorisnika;
    }

    public void setTipkorisnika(String tipkorisnika) {
        this.tipkorisnika = tipkorisnika;
    }
}
