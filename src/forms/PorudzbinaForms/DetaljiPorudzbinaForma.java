/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forms.PorudzbinaForms;

import controller.ClientController;
import domain.Gost;
import domain.Pice;
import domain.Porudzbina;
import domain.StavkaPorudzbine;
import domain.Sto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.TableModelStavkaPorudzbine;

/**
 *
 * @author 38169
 */
public class DetaljiPorudzbinaForma extends javax.swing.JDialog {

    private Porudzbina porudzbina;
    private double cenaPorudzbine;

    /**
     * Creates new form DetaljiPorudzbinaForma
     */
    public DetaljiPorudzbinaForma(java.awt.Frame parent, boolean modal, Porudzbina porudzbina) {
        super(parent, modal);
        initComponents();
        this.porudzbina = porudzbina;
        setLocationRelativeTo(null);
        setTitle("Izmeni porudzbinu forma");
        cmbGost.getModel().setSelectedItem(porudzbina.getGost());
        cmbSto.getModel().setSelectedItem(porudzbina.getSto());
        txtNapomena.setText(porudzbina.getNapomena());
        rbPlacenaDa.setSelected(porudzbina.isPlacena());
        rbPlacenaNe.setSelected(!porudzbina.isPlacena());
        rbPopustDa.setSelected(porudzbina.isSaPopustom());
        rbPopustNe.setSelected(!porudzbina.isSaPopustom());
        txtUkupnaCena.setText(""+porudzbina.getUkupanIznos());
        prepare();
        tabelaStavkePorudzbine.setModel(new TableModelStavkaPorudzbine(porudzbina));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUkupnaCena = new javax.swing.JFormattedTextField();
        rbPlacenaNe = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaStavkePorudzbine = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtKolicinaStavke = new javax.swing.JFormattedTextField();
        cmbPice = new javax.swing.JComboBox();
        btnDodajStavku = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnObrisiStavku = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnIzmeniPorudzbinu = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbSto = new javax.swing.JComboBox();
        cmbGost = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNapomena = new javax.swing.JTextArea();
        rbPopustDa = new javax.swing.JRadioButton();
        rbPopustNe = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        rbPlacenaDa = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtUkupnaCena.setEditable(false);
        txtUkupnaCena.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        rbPlacenaNe.setSelected(true);
        rbPlacenaNe.setText("ne");

        tabelaStavkePorudzbine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabelaStavkePorudzbine);

        jLabel2.setText("Gost:");

        jLabel8.setText("Pice:");

        jLabel9.setText("Kolicina:");

        txtKolicinaStavke.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        cmbPice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDodajStavku.setText("Dodaj stavku");
        btnDodajStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajStavkuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKolicinaStavke, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbPice, javax.swing.GroupLayout.Alignment.TRAILING, 0, 169, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnDodajStavku)))
                .addGap(0, 34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKolicinaStavke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnDodajStavku)
                .addGap(21, 21, 21))
        );

        jLabel3.setText("Sa popustom:");

        btnObrisiStavku.setText("Obrisi stavku");
        btnObrisiStavku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiStavkuActionPerformed(evt);
            }
        });

        jLabel4.setText("Napomena:");

        btnIzmeniPorudzbinu.setText("Izmeni porudzbinu");
        btnIzmeniPorudzbinu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniPorudzbinuActionPerformed(evt);
            }
        });

        jLabel5.setText("Placena:");

        jLabel6.setText(" Ukupna cena porudzbine:");

        cmbSto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbGost.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtNapomena.setColumns(20);
        txtNapomena.setRows(5);
        jScrollPane1.setViewportView(txtNapomena);

        rbPopustDa.setSelected(true);
        rbPopustDa.setText("da");

        rbPopustNe.setText("ne");

        jLabel11.setText(" Stavka porudzbine:");

        rbPlacenaDa.setText("da");

        jLabel1.setText("Sto:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addComponent(cmbSto, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addComponent(cmbGost, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbPopustDa))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(45, 45, 45)
                                .addComponent(rbPlacenaDa)))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbPlacenaNe)
                            .addComponent(rbPopustNe)))
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jLabel11)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtUkupnaCena, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnObrisiStavku)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnIzmeniPorudzbinu)
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cmbSto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbGost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(rbPopustDa)
                            .addComponent(rbPopustNe))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbPlacenaDa)
                            .addComponent(jLabel5)
                            .addComponent(rbPlacenaNe))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtUkupnaCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnObrisiStavku)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnIzmeniPorudzbinu)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajStavkuActionPerformed
        if (txtKolicinaStavke.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!",
                    "Upozorenje!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Pice pice = (Pice) cmbPice.getSelectedItem();
        int kolicina = Integer.valueOf(txtKolicinaStavke.getText());
        StavkaPorudzbine sp = new StavkaPorudzbine();
        sp.setPorudzbina(porudzbina);
        sp.setPice(pice);
        sp.setKolicina(kolicina);
        TableModelStavkaPorudzbine tmodel = (TableModelStavkaPorudzbine) tabelaStavkePorudzbine.getModel();
        if (tmodel.unetoPice(pice)) {
            JOptionPane.showMessageDialog(this, "Ovo pice je vec dodato!",
                    "Upozorenje!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        tmodel.dodajStavkuPorudzbine(sp);
        cenaPorudzbine = tmodel.getUkupnaCena();
        txtUkupnaCena.setText("" + cenaPorudzbine);

    }//GEN-LAST:event_btnDodajStavkuActionPerformed

    private void btnObrisiStavkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiStavkuActionPerformed
        int row = tabelaStavkePorudzbine.getSelectedRow();
        if (row != -1) {
            TableModelStavkaPorudzbine tmodel = (TableModelStavkaPorudzbine) tabelaStavkePorudzbine.getModel();
            tmodel.obrisiStavkuPorudzbine(row);
            cenaPorudzbine = tmodel.getUkupnaCena();
            txtUkupnaCena.setText("" + cenaPorudzbine);
        }
    }//GEN-LAST:event_btnObrisiStavkuActionPerformed

    private void btnIzmeniPorudzbinuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniPorudzbinuActionPerformed
        try {
            Sto sto = (Sto) cmbSto.getSelectedItem();
            Gost gost = (Gost) cmbGost.getSelectedItem();
            boolean placeno = rbPlacenaDa.isSelected();
            boolean popust = rbPopustDa.isSelected();
            String napomena = txtNapomena.getText();
            TableModelStavkaPorudzbine tmodel = (TableModelStavkaPorudzbine) tabelaStavkePorudzbine.getModel();
            ArrayList<StavkaPorudzbine> stavke = tmodel.getLista();
            porudzbina.setGost(gost);
            porudzbina.setSto(sto);
            porudzbina.setPlacena(placeno);
            porudzbina.setSaPopustom(popust);
            porudzbina.setNapomena(napomena);
            porudzbina.setStavkePorudzbine(stavke);
            System.out.println("GRESKA JE U UPDATE METODI");
        ClientController.getInstance().updatePorudzbina(porudzbina);
            JOptionPane.showMessageDialog(this, "Porudzbina je uspesno izmenjena!", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Poruka o greski", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnIzmeniPorudzbinuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnIzmeniPorudzbinu;
    private javax.swing.JButton btnObrisiStavku;
    private javax.swing.JComboBox cmbGost;
    private javax.swing.JComboBox cmbPice;
    private javax.swing.JComboBox cmbSto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbPlacenaDa;
    private javax.swing.JRadioButton rbPlacenaNe;
    private javax.swing.JRadioButton rbPopustDa;
    private javax.swing.JRadioButton rbPopustNe;
    private javax.swing.JTable tabelaStavkePorudzbine;
    private javax.swing.JFormattedTextField txtKolicinaStavke;
    private javax.swing.JTextArea txtNapomena;
    private javax.swing.JFormattedTextField txtUkupnaCena;
    // End of variables declaration//GEN-END:variables

    private void prepare() {
        popuniCbGosti();
        popuniCbPica();
        popuniCbStolovi();
    }
         private void popuniCbStolovi() {
        try {
            cmbSto.removeAllItems();
            ArrayList<Sto> list = ClientController.getInstance().getAllSto();
            for (Sto sto : list) {
                cmbSto.addItem(sto);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void popuniCbGosti() {
        try {
            cmbGost.removeAllItems();
            ArrayList<Gost> list = ClientController.getInstance().getAllGost();
            for (Gost gost : list) {
                cmbGost.addItem(gost);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());

        }
    }

    private void popuniCbPica() {
        cmbPice.removeAllItems();
        try {
            ArrayList<Pice> list = ClientController.getInstance().getAllPice();
            for (Pice pice : list) {
                cmbPice.addItem(pice);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());

        }
    }
    
}