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
public class Porudzbina extends AbstractDomainObject {

    private long porudzbinaID;
    private double ukupanIznos;
    private boolean placena;
    private boolean saPopustom;
    private String napomena;
    private Gost gost;
    private Sto sto;
    private Sanker sanker;
    private ArrayList<StavkaPorudzbine> stavkePorudzbine;

    public Porudzbina() {
    }

    public Porudzbina(long porudzbinaID, double ukupanIznos, boolean placena, boolean saPopustom, String napomena, Gost gost, Sto sto, Sanker sanker, ArrayList<StavkaPorudzbine> stavkePorudzbine) {
        this.porudzbinaID = porudzbinaID;
        this.ukupanIznos = ukupanIznos;
        this.placena = placena;
        this.saPopustom = saPopustom;
        this.napomena = napomena;
        this.gost = gost;
        this.sto = sto;
        this.sanker = sanker;
        this.stavkePorudzbine = stavkePorudzbine;
    }

  

    @Override
    public String nazivTabele() {
        return "Porudzbina";
    }

    @Override
    public String alijas() {
        return "p";
    }

    @Override
    public String join() {
        return " JOIN STO s ON (s.RbrStola = p.StoID) "
                + "JOIN GOST g ON (g.GostID = p.GostID) "
                + "JOIN SANKER sank ON (p.SankerID = sank.SankerID)";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
                     Gost g= new Gost(rs.getLong("GostID"), rs.getString("ImeGosta"), rs.getString("PrezimeGosta"));
             Sto s= new Sto(rs.getLong("RbrStola"), rs.getInt("BrojMesta"), rs.getBoolean("Zauzet"), rs.getDouble("UkupanDnevniIznos"));
             Sanker sank =new Sanker(rs.getLong("SankerID"), rs.getString("Ime"), 
                  rs.getString("Prezime")  , rs.getString("email"), rs.getString("password"));
             Porudzbina p= new Porudzbina(rs.getLong("PorudzbinaID"), rs.getDouble("UkupanIznos"), rs.getBoolean("Placena"),
                     rs.getBoolean("SaPopustom"), rs.getString("Napomena"), g, s, sank, null);
            lista.add(p);
        }

        rs.close();
        return lista;

    }

    @Override
    public String koloneZaInsert() {
                return " (ukupanIznos, Placena, SaPopustom, Napomena, StoID, GostID, SankerID) ";

    }

    @Override
    public String vrednostZaPrimarniKljuc() {
                return " PorudzbinaID = " + porudzbinaID;

    }

    @Override
    public String vrednostiZaInsert() {
        return ukupanIznos + ", " +placena + ", " +saPopustom +", '"+
                napomena+"' , "
                + sto.getRbrStola()+ ", " + gost.getGostID()+ ", "+sanker.getSankerID()+" ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " ukupanIznos = " + ukupanIznos+" , placena = "+ placena
                +" , saPopustom = " + saPopustom + " , Napomena = '"+ napomena+"' , stoID = "
                + sto.getRbrStola()+" , gostID = "+gost.getGostID()+" ";
    }

    @Override
    public String uslov() {
        return "";
    }

    public long getPorudzbinaID() {
        return porudzbinaID;
    }

    public void setPorudzbinaID(long porudzbinaID) {
        this.porudzbinaID = porudzbinaID;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public boolean isPlacena() {
        return placena;
    }

    public void setPlacena(boolean placena) {
        this.placena = placena;
    }

    public boolean isSaPopustom() {
        return saPopustom;
    }

    public void setSaPopustom(boolean saPopustom) {
        this.saPopustom = saPopustom;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Gost getGost() {
        return gost;
    }

    public void setGost(Gost gost) {
        this.gost = gost;
    }

    public Sto getSto() {
        return sto;
    }

    public void setSto(Sto sto) {
        this.sto = sto;
    }

    public ArrayList<StavkaPorudzbine> getStavkePorudzbine() {
        return stavkePorudzbine;
    }

    public void setStavkePorudzbine(ArrayList<StavkaPorudzbine> stavkePorudzbine) {
        this.stavkePorudzbine = stavkePorudzbine;
    }

    public Sanker getSanker() {
        return sanker;
    }

    public void setSanker(Sanker sanker) {
        this.sanker = sanker;
    }

    
}
