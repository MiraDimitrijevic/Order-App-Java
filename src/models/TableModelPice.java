/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controller.ClientController;
import domain.Pice;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 38169
 */
public class TableModelPice extends AbstractTableModel implements Runnable {

    private ArrayList<Pice> lista;
    private String[] kolone = {"ID", "Naziv", "Na popustu", "Cena", "Vrsta pica"};

    public TableModelPice() {
        try {
            lista = ClientController.getInstance().getAllPice();
        } catch (Exception ex) {
            Logger.getLogger(TableModelPice.class.getName()).log(Level.SEVERE, null, ex);
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
        Pice pice = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pice.getPiceID();
            case 1:
                return pice.getNazivPica();
            case 2:
                return pice.isNaPopustu();
            case 3:
                return pice.getCena();
            case 4:
                return pice.getVrstaPica().getNazivVrstePica();

            default:
                return null;
        }
    }

    public Pice getPice(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(5000);
                refresh();}
            }catch (InterruptedException ex) {
            Logger.getLogger(TableModelPice.class.getName()).log(Level.SEVERE, null, ex);
        }

        }

    

    

    private void refresh() {
        try {
            lista= ClientController.getInstance().getAllPice();
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TableModelPice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
