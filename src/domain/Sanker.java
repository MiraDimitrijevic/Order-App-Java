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
public class Sanker extends AbstractDomainObject{
private long sankerID;
private String ime;
private String prezime;
private String email;
private String password;

    public Sanker() {
    }

    public Sanker(long sankerID, String ime, String prezime, String email, String password) {
        this.sankerID = sankerID;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.password = password;
    }



    @Override
    public String nazivTabele() {
        return "Sanker";
    }

    @Override
    public String alijas() {
        return "sank";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
ArrayList<AbstractDomainObject> lista= new ArrayList<>();
        while (rs.next()) {            
            Sanker s= new Sanker(rs.getLong("SankerID"), rs.getString("Ime"), 
                  rs.getString("Prezime")  , rs.getString("email"), rs.getString("password"));
            lista.add(s);
        }
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(Ime, Prezime, Email, Password)";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "SankerID = "+sankerID;
    }

    @Override
    public String vrednostiZaInsert() {
      return "'" + ime + "', '" + prezime + "', '"+email+"', '"+password+"'";   
    }

    @Override
    public String vrednostiZaUpdate() {
                return " ime = '" + ime + "', prezime = '" + prezime +"', email = '"+
                        email+"', password= '"+password+"'";

    }

    @Override
    public String uslov() {
        return "";
    }

    public long getSankerID() {
        return sankerID;
    }

    public void setSankerID(long sankerID) {
        this.sankerID = sankerID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
    }
    
    
}
