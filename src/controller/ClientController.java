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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import transfer.Request;
import session.Session;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author 38169
 */
public class ClientController {

    private static ClientController instance;

    private ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    private Object sendRequest(int operation, Object data) throws Exception {
        Request request = new Request(operation, data);

        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(request);

        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Response response = (Response) in.readObject();

        if (response.getResponseStatus().equals(ResponseStatus.Error)) {
            throw response.getException();
        } else {
            return response.getData();
        }

    }

    public Sanker login(Sanker sanker) throws Exception {
        return (Sanker) sendRequest(Operation.LOGIN, sanker);
    }

    public void addGost(Gost gost) throws Exception {
        sendRequest(Operation.ADD_GOST, gost);
    }

    public ArrayList<Gost> getAllGost() throws Exception {
        return (ArrayList<Gost>) sendRequest(Operation.GET_ALL_GOST, null);
    }

    public void updateGost(Gost gost) throws Exception {
        sendRequest(Operation.UPDATE_GOST, gost);
    }

    public ArrayList<VrstaPica> getAllVrstaPica() throws Exception {
        return (ArrayList<VrstaPica>) sendRequest(Operation.GET_ALL_VRSTAPICA, null);
    }

    public void addPice(Pice pice) throws Exception {
        sendRequest(Operation.INSERT_PICE, pice);
    }

    public ArrayList<Pice> getAllPice() throws Exception {
        return (ArrayList<Pice>) sendRequest(Operation.GET_ALL_PICE, null);
    }
    

    public void deletePice(Pice pice) throws Exception {
        sendRequest(Operation.DELETE_PICE, pice);
    }

    public void updatePice(Pice pice) throws Exception {
        sendRequest(Operation.UPDATE_PICE, pice);
    }

    public ArrayList<Porudzbina> getAllPorudzbina() throws Exception {
        return (ArrayList<Porudzbina>) sendRequest(Operation.GET_ALL_PORUDZBINA, null);
    }

    public ArrayList<StavkaPorudzbine> getAllStavkaPorudzbine(Porudzbina porudzbina) throws Exception {
        return (ArrayList<StavkaPorudzbine>) sendRequest(Operation.GET_ALL_STAVKA_PORUDZBINE, porudzbina);
    }

    public ArrayList<Sto> getAllSto() throws Exception {
        return (ArrayList<Sto>) sendRequest(Operation.GET_ALL_STO, null);
    }

    public void addPorudzbina(Porudzbina porudzbina) throws Exception {
        sendRequest(Operation.INSERT_PORUDZBINA, porudzbina);
    }
    
        public void updatePorudzbina(Porudzbina porudzbina) throws Exception {
        sendRequest(Operation.UPDATE_PORUDZBINA, porudzbina);
    }
}
