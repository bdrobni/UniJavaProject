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
public class TipSobe {
    private int idtipa, sifrahotela;
    private String NazivTipa;

    public TipSobe() {
    }

    public TipSobe(int idtipa, int sifrahotela, String NazivTipa) {
        this.idtipa = idtipa;
        this.sifrahotela = sifrahotela;
        this.NazivTipa = NazivTipa;
    }

    public int getIdtipa() {
        return idtipa;
    }

    public void setIdtipa(int idtipa) {
        this.idtipa = idtipa;
    }

    public int getSifrahotela() {
        return sifrahotela;
    }

    public void setSifrahotela(int sifrahotela) {
        this.sifrahotela = sifrahotela;
    }

    public String getNazivTipa() {
        return NazivTipa;
    }

    public void setNazivTipa(String NazivTipa) {
        this.NazivTipa = NazivTipa;
    }
}
