/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 38169
 */
public class Sto extends AbstractDomainObject{
   private long rbrStola;
   private int brojMesta;
   private boolean zauzet;
   private double ukupanDnevniIznos;

    public Sto() {
    }

    public Sto(long rbrStola, int brojMesta, boolean zauzet, double ukupanDnevniIznos) {
        this.rbrStola = rbrStola;
        this.brojMesta = brojMesta;
        this.zauzet = zauzet;
        this.ukupanDnevniIznos = ukupanDnevniIznos;
    }

    public double getUkupanDnevniIznos() {
        return ukupanDnevniIznos;
    }

    public void setUkupanDnevniIznos(double ukupanDnevniIznos) {
        this.ukupanDnevniIznos = ukupanDnevniIznos;
    }

    public long getRbrStola() {
        return rbrStola;
    }

    public void setRbrStola(long rbrStola) {
        this.rbrStola = rbrStola;
    }

    public int getBrojMesta() {
        return brojMesta;
    }

    public void setBrojMesta(int brojMesta) {
        this.brojMesta = brojMesta;
    }

    public boolean isZauzet() {
        return zauzet;
    }

    public void setZauzet(boolean zauzet) {
        this.zauzet = zauzet;
    }

    @Override
    public String nazivTabele() {
        return "Sto";
    }

    @Override
    public String alijas() {
        return "s";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
     ArrayList<AbstractDomainObject> lista= new ArrayList<>();
     while(rs.next()){
         Sto s= new Sto(rs.getLong("RbrStola"), rs.getInt("BrojMesta"), rs.getBoolean("Zauzet"), rs.getDouble("UkupanDnevniIznos"));
         lista.add(s);
     }
     rs.close();
     return lista;
    }

    @Override
    public String koloneZaInsert() {
                return " (BrojMesta, Zauzet, UkupanDnevniIznos ) ";

    }

    @Override
    public String vrednostZaPrimarniKljuc() {
                        return " RbrStola = " + rbrStola;

    }

    @Override
    public String vrednostiZaInsert() {
           return "" + brojMesta + ", " + zauzet + " , "+ ukupanDnevniIznos+"";

    }

    @Override
    public String vrednostiZaUpdate() {
                return " BrojMesta = " + brojMesta + ", Zauzet = " + zauzet + " , UkupanDnevniIznos= "+ ukupanDnevniIznos;

    }

    @Override
    public String uslov() {
        return "";
    }

    @Override
    public String toString() {
        return rbrStola+"["+brojMesta+"]";
    }
   
   
}
