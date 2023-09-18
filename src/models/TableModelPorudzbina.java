/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controller.ClientController;
import domain.Porudzbina;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 38169
 */
public class TableModelPorudzbina extends AbstractTableModel implements Runnable{
    private ArrayList<Porudzbina> lista;
    private String[] kolone ={"Sto","Gost","Sanker","Iznos","Placena","Sa popustom","Napomena"};

    public TableModelPorudzbina(){
        try {
            lista= ClientController.getInstance().getAllPorudzbina();
        } catch (Exception ex) {
            Logger.getLogger(TableModelPorudzbina.class.getName()).log(Level.SEVERE, null, ex);
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
        Porudzbina p= lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getSto().getRbrStola();
                   case 1:
                return p.getGost();
                     case 2:
                return p.getSanker();
                     case 3:
                return p.getUkupanIznos();
                     case 4:
                return p.isPlacena();
                     case 5:
                return p.isSaPopustom();
                     case 6:
                return p.getNapomena();
              
            default:
                return null;
        }
    }
    
   public Porudzbina getPorudzbina(int row){
        return lista.get(row);
    }

    @Override
    public void run() {
        try{
        while(!Thread.currentThread().isInterrupted()){
            Thread.sleep(5000);
            refresh();
        }
  } catch(InterruptedException ex) {
                  Logger.getLogger(TableModelPice.class.getName()).log(Level.SEVERE, null, ex);

  }
    }  

    private void refresh()  {
        try {
            lista=ClientController.getInstance().getAllPorudzbina();
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TableModelPorudzbina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
