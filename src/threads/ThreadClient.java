/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import controller.ServerController;
import domain.Gost;
import domain.Pice;
import domain.Porudzbina;
import domain.Sanker;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author 38169
 */
public class ThreadClient extends Thread {

    private Socket socket;

    public ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            while (!socket.isClosed()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) in.readObject();
                Response response = handleRequest(request);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    private Response handleRequest(Request request) {
        Response response = new Response(null, null, ResponseStatus.Success);
        try {
            switch (request.getOperation()) {
                case Operation.LOGIN:
                    response.setData(ServerController.getInstance().login((Sanker) request.getData()));
                    break;

                case Operation.ADD_GOST:
                    ServerController.getInstance().addGost((Gost) request.getData());
                    break;
                case Operation.GET_ALL_GOST:
                    response.setData(ServerController.getInstance().getAllGost());
                    break;
                case Operation.UPDATE_GOST:
                    ServerController.getInstance().updateGost((Gost) request.getData());
                    break;
                case Operation.INSERT_PICE:
                    ServerController.getInstance().insertPice((Pice) request.getData());
                    break;
                case Operation.GET_ALL_PICE:
                    response.setData(ServerController.getInstance().getAllPice());
                    break;
                case Operation.DELETE_PICE:
                    ServerController.getInstance().deletePice((Pice) request.getData());
                    break;
                case Operation.UPDATE_PICE:
                    ServerController.getInstance().updatePice((Pice) request.getData());
                    break;
                case Operation.GET_ALL_VRSTAPICA:
                    response.setData(ServerController.getInstance().getAllVrstaPica());
                    break;
                case Operation.GET_ALL_PORUDZBINA:
                    response.setData(ServerController.getInstance().getAllPorudzbina());
                    break;
                case Operation.GET_ALL_STAVKA_PORUDZBINE:
                    response.setData(ServerController.getInstance().getAllStavkaPorudzbine((Porudzbina) request.getData()));
                    break;
                case Operation.GET_ALL_STO:
                    response.setData(ServerController.getInstance().getAllSto());
                    break;
                case Operation.INSERT_PORUDZBINA:
                    ServerController.getInstance().insertPourdzbina((Porudzbina) request.getData());
                    break;
                case Operation.UPDATE_PORUDZBINA:
                    ServerController.getInstance().updatePorudzbina((Porudzbina) request.getData());
                    break;
                default:
                    return null;
            }
        } catch (Exception e) {
            response.setException(e);
            response.setResponseStatus(ResponseStatus.Error);
        }
        return response;
    }

}
