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
public class VrstaPica extends AbstractDomainObject{
    private long vrstaPicaID;
    private String nazivVrstePica;

    public VrstaPica() {
    }

    public VrstaPica(long vrstaPicaID, String nazivVrstePica) {
        this.vrstaPicaID = vrstaPicaID;
        this.nazivVrstePica = nazivVrstePica;
    }

    public String getNazivVrstePica() {
        return nazivVrstePica;
    }

    public void setNazivVrstePica(String nazivVrstePica) {
        this.nazivVrstePica = nazivVrstePica;
    }

    public long getVrstaPicaID() {
        return vrstaPicaID;
    }

    public void setVrstaPicaID(long vrstaPicaID) {
        this.vrstaPicaID = vrstaPicaID;
    }

    @Override
    public String nazivTabele() {
        return "vrstapica";
    }
    

    @Override
    public String alijas() {
        return "vp";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
  ArrayList<AbstractDomainObject> lista= new ArrayList<>();
     while(rs.next()){
         VrstaPica vp= new VrstaPica(rs.getLong("VrstaPicaID"), rs.getString("NazivVrstePica"));
         lista.add(vp);
     }
     rs.close();
     return lista;
    }

    @Override
    public String koloneZaInsert() {
                return " ( NazivVrstePica) ";

    }

    @Override
    public String vrednostZaPrimarniKljuc() {
                        return " VrstaPicaID = " + vrstaPicaID;

    }

    @Override
    public String vrednostiZaInsert() {
                   return "'" + nazivVrstePica + "'";

    }

    @Override
    public String vrednostiZaUpdate() {
                return " nazivVrstePica = '" + nazivVrstePica + "'";
    }

    @Override
    public String uslov() {
        return "";
    }

    @Override
    public String toString() {
        return nazivVrstePica;
    }
    
    
    
    
    
}
