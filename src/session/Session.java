/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package session;

import domain.Gost;
import domain.Sanker;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author 38169
 */
public class Session {
    
    private static Session instance;
    private Socket socket;
    private Sanker ulogovani;

    private Session() {
        try {
            socket = new Socket("localhost", 11000);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setUlogovani(Sanker ulogovani) {
        this.ulogovani = ulogovani;
    }

    public Sanker getUlogovani() {
        return ulogovani;
    }
}
