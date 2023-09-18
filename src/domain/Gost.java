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
public class Gost extends AbstractDomainObject{
 private long gostID;
 private String imeGosta;
 private String prezimeGosta;

 

    public Gost() {
    }

    public Gost(long gostID, String imeGosta, String prezimeGosta) {
        this.gostID = gostID;
        this.imeGosta = imeGosta;
        this.prezimeGosta = prezimeGosta;

    }


 
    @Override
    public String nazivTabele() {
        return "Gost";
    }

    @Override
    public String alijas() {
        return "g";
    }
     
    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
     ArrayList<AbstractDomainObject> lista= new ArrayList<>();
     while(rs.next()){
         Gost g= new Gost(rs.getLong("GostID"), rs.getString("ImeGosta"), rs.getString("PrezimeGosta"));
         lista.add(g);
     }
     rs.close();
     return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (ImeGosta, PrezimeGosta) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
                return " GostID = " + gostID;

    }

    @Override
    public String vrednostiZaInsert() {
           return "'" + imeGosta + "', '" + prezimeGosta + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " imeGosta = '" + imeGosta + "', prezimeGosta = '" + prezimeGosta +"'";

    }

    @Override
    public String uslov() {
        return "";
    }

    public long getGostID() {
        return gostID;
    }

    public void setGostID(long gostID) {
        this.gostID = gostID;
    }

    public String getImeGosta() {
        return imeGosta;
    }

    public void setImeGosta(String imeGosta) {
        this.imeGosta = imeGosta;
    }

    public String getPrezimeGosta() {
        return prezimeGosta;
    }

    public void setPrezimeGosta(String prezimeGosta) {
        this.prezimeGosta = prezimeGosta;
    }

    @Override
    public String toString() {
        return imeGosta+ " "+prezimeGosta;
    }

    
    
    
    
}
