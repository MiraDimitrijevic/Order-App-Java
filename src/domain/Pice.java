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
public class Pice extends AbstractDomainObject{
private long piceID;
private String nazivPica;
private boolean naPopustu;
private double cena;
private VrstaPica vrstaPica;

    public Pice() {
    }

    public Pice(long piceID, String nazivPica, boolean naPopustu, double cena, VrstaPica vrstaPica) {
        this.piceID = piceID;
        this.nazivPica = nazivPica;
        this.naPopustu = naPopustu;
        this.cena = cena;
        this.vrstaPica = vrstaPica;
    }


    @Override
    public String nazivTabele() {
        return "Pice";
    }

    @Override
    public String alijas() {
        return "pice";
    }

    @Override
    public String join() {
       return "JOIN VrstaPica vp ON (vp.VrstaPicaID = pice.VrstaPicaID)";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
   ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
                     VrstaPica vp= new VrstaPica(rs.getLong("VrstaPicaID"), rs.getString("NazivVrstePica"));
Pice pice= new Pice(rs.getLong("PiceID"), rs.getString("NazivPica"), 
        rs.getBoolean("NaPopustu"), rs.getDouble("Cena"), vp);
            lista.add(pice);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
                        return " (NazivPica, NaPopustu, Cena, VrstaPicaID) ";

    }

    @Override
    public String vrednostZaPrimarniKljuc() {
                                return " PiceID = " + piceID;

    }

    @Override
    public String vrednostiZaInsert() {
             return "'" + nazivPica + "', " +naPopustu + ", " +cena +", "+
                vrstaPica.getVrstaPicaID()+ " "  ;
    }

    @Override
    public String vrednostiZaUpdate() {
        return "nazivPica = '" + nazivPica+"' , naPopustu = "+ naPopustu
                +" , cena = " + cena+" ";
    }

    @Override
    public String uslov() {
        return "";
    }

    public long getPiceID() {
        return piceID;
    }

    public void setPiceID(long piceID) {
        this.piceID = piceID;
    }

    public String getNazivPica() {
        return nazivPica;
    }

    public void setNazivPica(String nazivPica) {
        this.nazivPica = nazivPica;
    }

    public boolean isNaPopustu() {
        return naPopustu;
    }

    public void setNaPopustu(boolean naPopustu) {
        this.naPopustu = naPopustu;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public VrstaPica getVrstaPica() {
        return vrstaPica;
    }

    public void setVrstaPica(VrstaPica vrstaPica) {
        this.vrstaPica = vrstaPica;
    }

    @Override
    public String toString() {
        return nazivPica;
    }
    
    
    
}
