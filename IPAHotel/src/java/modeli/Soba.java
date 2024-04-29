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
public class Soba {
     private int idsobe, idtipa, brojsobe, cena;

    public Soba() {
    }

    public Soba(int idsobe, int idtipa, int brojsobe, int cena) {
        this.idsobe = idsobe;
        this.idtipa = idtipa;
        this.brojsobe = brojsobe;
        this.cena = cena;
    }

    public int getIdsobe() {
        return idsobe;
    }

    public void setIdsobe(int idsobe) {
        this.idsobe = idsobe;
    }

    public int getIdtipa() {
        return idtipa;
    }

    public void setIdtipa(int idtipa) {
        this.idtipa = idtipa;
    }

    public int getBrojsobe() {
        return brojsobe;
    }

    public void setBrojsobe(int brojsobe) {
        this.brojsobe = brojsobe;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
}
