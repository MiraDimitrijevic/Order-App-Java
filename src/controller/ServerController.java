/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Gost;
import domain.Pice;
import domain.Porudzbina;
import domain.Sanker;
import domain.StavkaPorudzbine;
import domain.Sto;
import domain.VrstaPica;
import java.util.ArrayList;
import so.gost.SOIzmeniGosta;
import so.gost.SONoviGost;
import so.gost.SOSviGosti;
import so.login.SOLogin;
import so.pice.SOIzmeniPice;
import so.pice.SONovoPice;
import so.pice.SOObrisiPice;
import so.pice.SOSvaPica;
import so.porudzbina.SOIzmeniPorudzbinu;
import so.porudzbina.SONovaPorudzbina;
import so.porudzbina.SOSvePorudzbine;
import so.stavkaPorudzbine.SOSveStavkePorudzbine;
import so.sto.SOSviStolovi;
import so.vrstaPica.SOSveVrstePica;

/**
 *
 * @author 38169
 */
public class ServerController {

    private static ServerController instance;

    private ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public Sanker login(Sanker sanker) throws Exception {
        SOLogin soLogin = new SOLogin();
        soLogin.templateExecute(sanker);
        return soLogin.getUlogovani();
    }

    public void addGost(Gost gost) throws Exception {
        (new SONoviGost()).templateExecute(gost);
    }

    public ArrayList<Gost> getAllGost() throws Exception {
        SOSviGosti so = new SOSviGosti();
        so.templateExecute(new Gost());
        return so.getList();
    }

    public void updateGost(Gost gost) throws Exception {
        (new SOIzmeniGosta()).templateExecute(gost);
    }

    public void insertPice(Pice pice) throws Exception {
        (new SONovoPice()).templateExecute(pice);
    }

    public ArrayList<Pice> getAllPice() throws Exception {
        SOSvaPica so = new SOSvaPica();
        so.templateExecute(new Pice());
        return so.getList();

    }

    public void deletePice(Pice pice) throws Exception {
        (new SOObrisiPice()).templateExecute(pice);
    }

    public void updatePice(Pice pice) throws Exception {
        (new SOIzmeniPice()).templateExecute(pice);
    }

    public ArrayList<VrstaPica> getAllVrstaPica() throws Exception {
        SOSveVrstePica so = new SOSveVrstePica();
        so.templateExecute(new VrstaPica());
        return so.getList();
    }

    public ArrayList<Porudzbina> getAllPorudzbina() throws Exception {
        SOSvePorudzbine so = new SOSvePorudzbine();
        so.templateExecute(new Porudzbina());
        return so.getLista();
    }


    public ArrayList<Sto> getAllSto() throws Exception {
        SOSviStolovi so = new SOSviStolovi();
        so.templateExecute(new Sto());
        return so.getLista();
    }
    
        public void updatePorudzbina(Porudzbina porudzbina) throws Exception {
        (new SOIzmeniPorudzbinu()).templateExecute(porudzbina);
    }

    public void insertPourdzbina(Porudzbina porudzbina) throws Exception {
        (new SONovaPorudzbina()).templateExecute(porudzbina);
    }

    public Object getAllStavkaPorudzbine(Porudzbina porudzbina) throws Exception {
         SOSveStavkePorudzbine so = new SOSveStavkePorudzbine();
         StavkaPorudzbine sp= new StavkaPorudzbine();
         sp.setPorudzbina(porudzbina);
          so.templateExecute(sp);
        return so.getLista();
    }

}
