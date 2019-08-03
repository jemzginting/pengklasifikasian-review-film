/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.*;
import Entity.*;
import Interface.FormMain;
import Interface.FormPelatihan;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author personal
 */

 public class ContPelatihan {
    
    private ContPreprocessing Prepro;
    private ContNaiveBayes naiveBayes;
    private ContInformationGain infoGain;
    private  DefaultListModel modelPecahan = new DefaultListModel();
    private  DefaultListModel<String> modelFilter = new DefaultListModel<>();
    private  String []namaTblLatih = {"No","Kata", "F.Positif", "F.Negatif", "P.Positif", "P.Negatif","Info Gain"};
    private  DefaultTableModel dataPelatihan = new DefaultTableModel(namaTblLatih, 0);
     private  DefaultListModel<Integer> listFrekuensi = new DefaultListModel<>();
    
    
    public void pelatihanReview() throws ParseException{
       Prepro = new ContPreprocessing();
       naiveBayes = new ContNaiveBayes();
       infoGain = new ContInformationGain();
       SetHasilPrepro();
 // proses_simpan();
  proses_IG();
  proses_NB();
        
    }
    
   public void pelatihanLangsung() throws ParseException{
       //Prepro = new ContPreprocessing();
       naiveBayes = new ContNaiveBayes();
       infoGain = new ContInformationGain();
           
       
       try{                    
           // infoGain.simpanKategori(FormMain.kategori);
            infoGain.daftarkanKata(dataPelatihan);
            infoGain.hitungProbDok();
            infoGain.mulaiInformationGain(dataPelatihan);  
            infoGain.urutkanData(dataPelatihan); 
            infoGain.seleksi_fitur(dataPelatihan,0.003);         

           
            if(dataPelatihan.getRowCount()>0){
            int jlhFPositif = 0, jlhFNegatif = 0;
           
            for(int i=0; i<dataPelatihan.getRowCount();i++){
                jlhFPositif += Integer.parseInt(dataPelatihan.getValueAt(i, 2).toString());
                jlhFNegatif += Integer.parseInt(dataPelatihan.getValueAt(i, 3).toString());
            
            }
        
           
            EntHasilPelatihan.setjumlahKataLatih(dataPelatihan.getRowCount());
            EntHasilPelatihan.setFrekPos(jlhFPositif);
            EntHasilPelatihan.setFrekNeg(jlhFNegatif);
            }else{
                JOptionPane.showMessageDialog(null, "Data anda kosong karena threshold terlalu tinggi");
            }
            
                        
        }catch (IOException ex) {
            Logger.getLogger(FormPelatihan.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
        naiveBayes.latih(dataPelatihan);
        naiveBayes.simpanProbDok(); 
       
    }
    
    
    
    
    
    
    
  private void SetHasilPrepro(){
        Prepro.token(modelPecahan);
        Prepro.filter(modelPecahan, modelFilter);
        Prepro.frekuensi(modelFilter,listFrekuensi);

    }
    
    
    private void proses_simpan(){
        try {
            infoGain.simpanKategori(FormMain.kategori);
            System.out.println(EntDokumen.getNamaDok());
        } catch (SQLException ex) {
            Logger.getLogger(ContPelatihan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
        
    
    private void proses_IG() {
   
        try{                    
            infoGain.simpanKategori(FormMain.kategori);
            infoGain.daftarkanKata(dataPelatihan);
            infoGain.hitungProbDok();
            infoGain.mulaiInformationGain(dataPelatihan);  
            infoGain.urutkanData(dataPelatihan); 
            infoGain.seleksi_fitur(dataPelatihan,0.003);         


//infoGain.seleksi_fitur2(dataPelatihan,150);
           
            if(dataPelatihan.getRowCount()>0){
            int jlhFPositif = 0, jlhFNegatif = 0;
           
            for(int i=0; i<dataPelatihan.getRowCount();i++){
                jlhFPositif += Integer.parseInt(dataPelatihan.getValueAt(i, 2).toString());
                jlhFNegatif += Integer.parseInt(dataPelatihan.getValueAt(i, 3).toString());
            
            }
        
           
            EntHasilPelatihan.setjumlahKataLatih(dataPelatihan.getRowCount());
            EntHasilPelatihan.setFrekPos(jlhFPositif);
            EntHasilPelatihan.setFrekNeg(jlhFNegatif);
            }else{
                JOptionPane.showMessageDialog(null, "Data anda kosong karena threshold terlalu tinggi");
            }
            
                        
        }catch (IOException ex) {
            Logger.getLogger(FormPelatihan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
             Logger.getLogger(FormPelatihan.class.getName()).log(Level.SEVERE, null, ex);
         }       
        
    }
    
    
    private void proses_NB() throws ParseException{       
      
        naiveBayes.latih(dataPelatihan);
        naiveBayes.simpanProbDok();
    }

    
 
    
}
