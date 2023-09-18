/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import controller.ClientController;
import domain.Pice;
import domain.Porudzbina;
import domain.StavkaPorudzbine;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 38169
 */
public class TableModelStavkaPorudzbine extends AbstractTableModel{
    private ArrayList<StavkaPorudzbine> lista;
    private String[] kolone = {"Rbr","Pice","Kolicina","Iznos"};
    private long rbrStavke=0;
    
    public TableModelStavkaPorudzbine (){
        lista= new ArrayList<>();
    }
    
      public TableModelStavkaPorudzbine (Porudzbina porudzbina){
        try {
            lista= ClientController.getInstance().getAllStavkaPorudzbine(porudzbina);
        } catch (Exception ex) {
            Logger.getLogger(TableModelStavkaPorudzbine.class.getName()).log(Level.SEVERE, null, ex);
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
        StavkaPorudzbine sp = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sp.getRbrStavke();
                case 1:
                return sp.getPice();
                 case 2:
                return sp.getKolicina();
                 case 3:
                return sp.getIznos();
            default:
               return null;
        }
    }

    public ArrayList<StavkaPorudzbine> getLista() {
        return lista;
    }
    
    
    
    public void dodajStavkuPorudzbine(StavkaPorudzbine sp){
        rbrStavke= lista.size();
        sp.setRbrStavke(++rbrStavke);
        sp.setIznos(izracunajIznos(sp.getKolicina(), sp.getPice().getCena()));
        lista.add(sp);
        fireTableDataChanged();
     }
   
        public void obrisiStavkuPorudzbine(int row){
            rbrStavke=0;
        lista.remove(row);
            for (StavkaPorudzbine stavkaPorudzbine : lista) {
                stavkaPorudzbine.setRbrStavke(++rbrStavke);
            }
        fireTableDataChanged();
     }

    private double izracunajIznos(double kolicina, double cena) {
        return kolicina*cena;
    }
    
    private double izracunajCenuPorudzbine(){
        double cena=0;
        for (StavkaPorudzbine stavkaPorudzbine : lista) {
            cena+=stavkaPorudzbine.getIznos();
        }
        return cena;
    }

    public boolean unetoPice(Pice pice) {
        for (StavkaPorudzbine stavkaPorudzbine : lista) {
            if(stavkaPorudzbine.getPice().getPiceID()==pice.getPiceID())
       return true;
                }
        return false;
    }

    public double getUkupnaCena() {
       double ukupnaCena=0;
        for (StavkaPorudzbine stavkaPorudzbine : lista) {
            ukupnaCena+=stavkaPorudzbine.getIznos();
        }
        return ukupnaCena;
    }
}
