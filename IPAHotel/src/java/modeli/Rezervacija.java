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
public class Rezervacija {
    private int idrez, sifrakorisnika, sifrasobe;
    private String datumod, datumdo;
    public Rezervacija() {
    }

    public Rezervacija(int idrez, int sifrakorisnika, int sifrasobe, String datumod, String datumdo) {
        this.idrez = idrez;
        this.sifrakorisnika = sifrakorisnika;
        this.sifrasobe = sifrasobe;
        this.datumod = datumod;
        this.datumdo = datumdo;
    }

    public String getDatumod() {
        return datumod;
    }

    public void setDatumod(String datumod) {
        this.datumod = datumod;
    }

    public String getDatumdo() {
        return datumdo;
    }

    public void setDatumdo(String datumdo) {
        this.datumdo = datumdo;
    }

    public int getIdrez() {
        return idrez;
    }

    public void setIdrez(int idrez) {
        this.idrez = idrez;
    }

    public int getSifrakorisnika() {
        return sifrakorisnika;
    }

    public void setSifrakorisnika(int sifrakorisnika) {
        this.sifrakorisnika = sifrakorisnika;
    }

    public int getSifrasobe() {
        return sifrasobe;
    }

    public void setSifrasobe(int sifrasobe) {
        this.sifrasobe = sifrasobe;
    }
}
