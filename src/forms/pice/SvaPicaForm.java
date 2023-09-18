/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forms.pice;

import controller.ClientController;
import domain.Pice;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.TableModelPice;

/**
 *
 * @author 38169
 */
public class SvaPicaForm extends javax.swing.JDialog {

    /**
     * Creates new form SvaPicaForm
     */
    public SvaPicaForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Forma lista pica");
        setLocationRelativeTo(null);
        TableModelPice tmp= new TableModelPice();
        Thread t= new Thread(tmp);
        t.start();
        tblPica.setModel(tmp);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPica = new javax.swing.JTable();
        btnIzmeniPice = new javax.swing.JButton();
        btnObrisiPice = new javax.swing.JButton();
        btnOtkazi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblPica.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPica);

        btnIzmeniPice.setText("Izmeni pice");
        btnIzmeniPice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniPiceActionPerformed(evt);
            }
        });

        btnObrisiPice.setText("Obrisi pice");
        btnObrisiPice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiPiceActionPerformed(evt);
            }
        });

        btnOtkazi.setText("Otkazi");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIzmeniPice)
                        .addGap(116, 116, 116)
                        .addComponent(btnObrisiPice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOtkazi)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzmeniPice)
                    .addComponent(btnObrisiPice)
                    .addComponent(btnOtkazi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
this.dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnIzmeniPiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniPiceActionPerformed
        int row= tblPica.getSelectedRow();
        if(row!=-1){
            TableModelPice tmp= (TableModelPice) tblPica.getModel();
            Pice pice= tmp.getPice(row);
            DetaljiPicaForm forma= new DetaljiPicaForm(null, true, pice);
            forma.setVisible(true);
            
        }
    }//GEN-LAST:event_btnIzmeniPiceActionPerformed

    private void btnObrisiPiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiPiceActionPerformed
           int row= tblPica.getSelectedRow();
        if(row!=-1){
            TableModelPice tmp= (TableModelPice) tblPica.getModel();
            Pice pice= tmp.getPice(row);
           int choice= JOptionPane.showConfirmDialog(this,
                   "Da li ste sigurni da zelite da obrisete izabrano pice?",
                   "Brisanje pica", JOptionPane.YES_NO_OPTION);
           if(choice==JOptionPane.NO_OPTION) return;
           else if(choice== JOptionPane.YES_OPTION){
                try {
                    ClientController.getInstance().deletePice(pice);
                    JOptionPane.showMessageDialog(this, "Pice je uspesno obrisano!",
                            "Brisanje pica", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Ne mozete obrisati ovo pice,"
                            + "jer postoje porudzbine koje ga sadrze!",
                            "Onemoguceno brisanje pica", JOptionPane.ERROR_MESSAGE);
                }
           }
        }
    }//GEN-LAST:event_btnObrisiPiceActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SvaPicaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SvaPicaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SvaPicaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SvaPicaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SvaPicaForm dialog = new SvaPicaForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeniPice;
    private javax.swing.JButton btnObrisiPice;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPica;
    // End of variables declaration//GEN-END:variables
}
