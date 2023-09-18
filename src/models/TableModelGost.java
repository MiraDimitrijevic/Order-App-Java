/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controller.ClientController;
import domain.Gost;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 38169
 */
public class TableModelGost extends AbstractTableModel implements Runnable {

    private ArrayList<Gost> lista;
    private String[] kolone = {"ID", "Ime", "Prezime"};
   private String parametar = "";

    public TableModelGost() {
        try {
            lista = ClientController.getInstance().getAllGost();
        } catch (Exception ex) {
            Logger.getLogger(TableModelGost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Gost gost = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return gost.getGostID();
            case 1:
                return gost.getImeGosta();
            case 2:
                return gost.getPrezimeGosta();
 
            default:
                return null;
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refresh();
            }
        } catch (Exception ex) {
            Logger.getLogger(TableModelGost.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    private void refresh() {
        try {
            lista = ClientController.getInstance().getAllGost();
            if (!parametar.equals("")) {
                ArrayList<Gost> novaLista = new ArrayList<>();
                for (Gost gost : lista) {
                    if (gost.getImeGosta().toUpperCase().contains(parametar.toUpperCase())
                            || gost.getPrezimeGosta().toUpperCase().contains(parametar.toUpperCase())) {
                        novaLista.add(gost);
                    }
                }
                lista = novaLista;
            }
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TableModelGost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refresh();
    }

    public Gost getGost(int selectedRow) {
        return lista.get(selectedRow);

    }

}
