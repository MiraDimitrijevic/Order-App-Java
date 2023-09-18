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
public class StavkaPorudzbine extends AbstractDomainObject {

    private Porudzbina porudzbina;
    private long rbrStavke;
    private int kolicina;
    private double iznos;
    private Pice Pice;

    public StavkaPorudzbine() {
    }

    public StavkaPorudzbine(Porudzbina porudzbina, long rbrStavke, int kolicina, double iznos, Pice Pice) {
        this.porudzbina = porudzbina;
        this.rbrStavke = rbrStavke;
        this.kolicina = kolicina;
        this.iznos = iznos;
        this.Pice = Pice;
    }

    @Override
    public String nazivTabele() {
        return "StavkaPorudzbine";
    }

    @Override
    public String alijas() {
        return "sp";
    }

    @Override
    public String join() {
        return "JOIN PICE pice ON (sp.PiceID = pice.PiceID)"
                + "JOIN VrstaPica vp ON (vp.VrstaPicaID = pice.VrstaPicaID)"
                + "JOIN PORUDZBINA p ON(p.PorudzbinaID=sp.PorudzbinaID)"
                + " JOIN STO s ON (s.RbrStola = p.StoID) "
                + "JOIN GOST g ON (g.GostID = p.GostID) "
                + "JOIN SANKER sank ON (p.SankerID = sank.SankerID)";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Gost g = new Gost(rs.getLong("GostID"), rs.getString("ImeGosta"), rs.getString("PrezimeGosta"));
            Sto s = new Sto(rs.getLong("RbrStola"), rs.getInt("BrojMesta"), rs.getBoolean("Zauzet"), rs.getDouble("UkupanDnevniIznos"));
            Sanker sank = new Sanker(rs.getLong("SankerID"), rs.getString("Ime"),
                    rs.getString("Prezime"), rs.getString("email"), rs.getString("password"));
            Porudzbina p = new Porudzbina(rs.getLong("PorudzbinaID"), rs.getDouble("UkupanIznos"), rs.getBoolean("Placena"),
                    rs.getBoolean("SaPopustom"), rs.getString("Napomena"), g, s, sank, null);
            VrstaPica vp = new VrstaPica(rs.getLong("VrstaPicaID"), rs.getString("NazivVrstePica"));
            Pice pice = new Pice(rs.getLong("PiceID"), rs.getString("NazivPica"),
                    rs.getBoolean("NaPopustu"), rs.getDouble("Cena"), vp);
            StavkaPorudzbine sp = new StavkaPorudzbine(porudzbina, rs.getLong("RbrStavke"), rs.getInt("Kolicina"), rs.getDouble("Iznos"), pice);
            lista.add(sp);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (porudzbinaID, RbrStavke, Kolicina, Iznos, PiceID) ";

    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " porudzbinaID = " + porudzbina.getPorudzbinaID();

    }

    @Override
    public String vrednostiZaInsert() {
        return " " + porudzbina.getPorudzbinaID() + ", " + rbrStavke + ", "
                + kolicina + ", " + iznos + ", " + Pice.getPiceID() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return " WHERE p.PorudzbinaID = " + porudzbina.getPorudzbinaID();

    }

    public Porudzbina getPorudzbina() {
        return porudzbina;
    }

    public void setPorudzbina(Porudzbina porudzbina) {
        this.porudzbina = porudzbina;
    }

    public long getRbrStavke() {
        return rbrStavke;
    }

    public void setRbrStavke(long rbrStavke) {
        this.rbrStavke = rbrStavke;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public Pice getPice() {
        return Pice;
    }

    public void setPice(Pice Pice) {
        this.Pice = Pice;
    }

}
