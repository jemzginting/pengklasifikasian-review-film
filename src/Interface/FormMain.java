/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Controller.*;
import Entity.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author personal
 */
public class FormMain extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public FormMain() {
        initComponents();
        //CF = new ContForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textField1 = new java.awt.TextField();
        btnKlasifikasi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn1 = new javax.swing.JButton();
        lblNamaDok = new javax.swing.JLabel();
        btnPelatihanNB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDok = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        cmbKateg = new javax.swing.JComboBox();
        btnViewTrain = new javax.swing.JButton();
        lblKlasifikasi = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        btnViewTest = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        textField1.setText("textField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnKlasifikasi.setText("Testing");
        btnKlasifikasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKlasifikasiActionPerformed(evt);
            }
        });

        jLabel1.setText("Nama Dokumen :");

        btn1.setText("...");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btnPelatihanNB.setText("Training");
        btnPelatihanNB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPelatihanNBActionPerformed(evt);
            }
        });

        txtDok.setColumns(20);
        txtDok.setRows(5);
        jScrollPane1.setViewportView(txtDok);

        jLabel8.setText("Pilih Kategori");

        cmbKateg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Positif", "Negatif" }));
        cmbKateg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKategActionPerformed(evt);
            }
        });

        btnViewTrain.setText("v");
        btnViewTrain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewTrainActionPerformed(evt);
            }
        });

        lblKlasifikasi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblKlasifikasi.setForeground(new java.awt.Color(35, 35, 168));
        lblKlasifikasi.setText("-");

        jLabel3.setText("Hasil Klasifikasi :");

        btnViewTest.setText("v");
        btnViewTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewTestActionPerformed(evt);
            }
        });

        jLabel2.setText("Tampil Hasil Pelatihan");

        jLabel4.setText("Tampil Hasil Pengujian");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Pengklasifikasian Review Film Menggunakan ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Information Gain dan Naive Bayes Classifier");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(btnViewTrain)
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnViewTest)
                .addGap(112, 112, 112))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnPelatihanNB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(cmbKateg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblKlasifikasi, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnKlasifikasi, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNamaDok, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn1)))
                        .addGap(0, 22, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNamaDok, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn1))
                .addGap(13, 13, 13)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbKateg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(lblKlasifikasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKlasifikasi, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPelatihanNB, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewTest)
                    .addComponent(btnViewTrain)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(463, 421));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

public static String kategori;
     
    private void btnKlasifikasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKlasifikasiActionPerformed
        // TODO add your handling code here:
        
        if(txtDok.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Input Dokumen Terlebih Dahulu");
        }else{
            ContKlasifikasi klas;
            klas = new ContKlasifikasi();
            try {
                klas.pengujianReview();
            } catch (SQLException ex) {
                Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            lblKlasifikasi.setText(klas.tampilKesimpulan());          
            
           
        }
        
    }//GEN-LAST:event_btnKlasifikasiActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        DokumenManager dok;
        txtDok.setText("");
        dok=new DokumenManager();
        dok.loadDokumen(FormMain.this);
        txtDok.append(dok.tampilIsiDok());
        txtDok.setLineWrap(true);
        lblNamaDok.setText(dok.tampilNamaDok());
    }//GEN-LAST:event_btn1ActionPerformed

    private void btnPelatihanNBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPelatihanNBActionPerformed
        // TODO add your handling code here:
    
        if(txtDok.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(null,"Input Dokumen Terlebih Dahulu");
        }else{
             if(cmbKateg.getSelectedItem().toString().equals("-")){
                    JOptionPane.showMessageDialog(null, "Pilih kategori terlebih dahulu");
                }else{
                 try {
                     ContPelatihan cm;
                     kategori=cmbKateg.getSelectedItem().toString();
                     JOptionPane.showMessageDialog(null, "Sedang melakukan Proses....");
                     cm = new ContPelatihan();
                     cm.pelatihanReview();
                     
                 } catch (ParseException ex) {
                     Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
                 }
                }
        }
       
    }//GEN-LAST:event_btnPelatihanNBActionPerformed
    
   
      
    private void cmbKategActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKategActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKategActionPerformed

    private void btnViewTrainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewTrainActionPerformed
        // TODO add your handling code here:
       if(EntHasilPelatihan.getTabelHasilPelatihan().getRowCount()==0){
           JOptionPane.showMessageDialog(null, "Data anda Kosong atau belum melakukan Training");
       }else{
           ContForm CF;   
            CF = new ContForm();
            CF.createFormPelatihan(); 
       }
            
        
    }//GEN-LAST:event_btnViewTrainActionPerformed

    private void btnViewTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewTestActionPerformed
        // TODO add your handling code here:
      if(EntHasilKlasifikasi.getKesimpulan()=="-"){
           JOptionPane.showMessageDialog(null, "Anda belum melakukan Testing");
       }else{
          ContForm CF;   
            CF = new ContForm();
            CF.createFormKlasifikasi(); 
       }
        
    }//GEN-LAST:event_btnViewTestActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       
       
        try {
             ContPelatihan cm;
            cm = new ContPelatihan();
            cm.pelatihanLangsung();
        } catch (ParseException ex) {
            Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FormMain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btnKlasifikasi;
    private javax.swing.JButton btnPelatihanNB;
    private javax.swing.JButton btnViewTest;
    private javax.swing.JButton btnViewTrain;
    private javax.swing.JComboBox cmbKateg;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblKlasifikasi;
    private javax.swing.JLabel lblNamaDok;
    private java.awt.TextField textField1;
    private javax.swing.JTextArea txtDok;
    // End of variables declaration//GEN-END:variables
}
