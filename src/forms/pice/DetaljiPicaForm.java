/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forms.pice;

import controller.ClientController;
import domain.Pice;
import domain.VrstaPica;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 38169
 */
public class DetaljiPicaForm extends javax.swing.JDialog {
    Pice pice;
    /**
     * Creates new form DetaljiPicaForm
     */
    public DetaljiPicaForm(java.awt.Frame parent, boolean modal,Pice pice) {
        super(parent, modal);
        initComponents();
        this.pice=pice;
        setTitle("Izmeni pice");
        setLocationRelativeTo(null);
        prepare();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        txtNazivPica = new javax.swing.JTextField();
        rbDa = new javax.swing.JRadioButton();
        rbNe = new javax.swing.JRadioButton();
        txtCena = new javax.swing.JFormattedTextField();
        cmbVrstaPica = new javax.swing.JComboBox();
        btnIzmeniPice = new javax.swing.JButton();
        btnOtkazi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setText("Vrsta pica:");

        buttonGroup1.add(rbDa);
        rbDa.setSelected(true);
        rbDa.setText("da");

        buttonGroup1.add(rbNe);
        rbNe.setText("ne");

        txtCena.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        cmbVrstaPica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnIzmeniPice.setText("Izmeni pice");
        btnIzmeniPice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniPiceActionPerformed(evt);
            }
        });

        btnOtkazi.setText("Otkazi");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        jLabel1.setText("Naziv pica:");

        jLabel2.setText("Na popustu:");

        jLabel3.setText("Cena pica:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIzmeniPice)
                        .addGap(146, 146, 146)
                        .addComponent(btnOtkazi))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(53, 53, 53)
                            .addComponent(txtNazivPica, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(44, 44, 44)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rbDa)
                                    .addGap(18, 18, 18)
                                    .addComponent(rbNe)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(txtCena)
                                .addComponent(cmbVrstaPica, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNazivPica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rbDa)
                    .addComponent(rbNe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbVrstaPica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzmeniPice)
                    .addComponent(btnOtkazi))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzmeniPiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniPiceActionPerformed
        if(txtNazivPica.getText().isEmpty() || txtCena.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Sva polja su obavezna!",
                "Nepopunjena polja", JOptionPane.ERROR_MESSAGE);
            return;}

        String naziv= txtNazivPica.getText();
        double cena= Double.valueOf(txtCena.getText().replace(',', '.'));
        boolean naPopustu=rbDa.isSelected();
        VrstaPica vp= (VrstaPica) cmbVrstaPica.getSelectedItem();

        Pice p = new Pice(pice.getPiceID(), naziv, naPopustu, cena, vp);
        try {
                    ClientController.getInstance().updatePice(p);
            JOptionPane.showMessageDialog(this, "Pice uspesno izmenjeno!",
                "Uspesna izmena!", JOptionPane.PLAIN_MESSAGE);
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnIzmeniPiceActionPerformed

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeniPice;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbVrstaPica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton rbDa;
    private javax.swing.JRadioButton rbNe;
    private javax.swing.JFormattedTextField txtCena;
    private javax.swing.JTextField txtNazivPica;
    // End of variables declaration//GEN-END:variables

    private void prepare() {
        txtNazivPica.setText(pice.getNazivPica());
        rbDa.setSelected(pice.isNaPopustu());
        rbNe.setSelected(!pice.isNaPopustu());
        txtCena.setText(String.valueOf(pice.getCena()));
                cmbVrstaPica.removeAllItems();
        try {
            ArrayList<VrstaPica> list= ClientController.getInstance().getAllVrstaPica();
            for (VrstaPica vrstaPica : list) {
                cmbVrstaPica.addItem(vrstaPica);
            }
            cmbVrstaPica.setSelectedItem(pice.getVrstaPica());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}
