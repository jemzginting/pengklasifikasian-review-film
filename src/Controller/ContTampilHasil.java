/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author personal
 */
public class ContTampilHasil {
   
    public DefaultTableModel tampilTabelPrepro(){
        return EntHasilPreprocessing.getTabelPrepro();
    }
    
    public  int tampilTotalFrekuensi(){
        return EntHasilPreprocessing.getTotalFrekuensi();
    }

    
    public DefaultTableModel tampilTabelPelatihan () {
       return EntHasilPelatihan.getTabelHasilPelatihan();
    }
    
    public  int tampilJumlahKataLatih(){
        return EntHasilPelatihan.getJumlahKataLatih();
    }
    
    public int tampilFrekPos(){
       return EntHasilPelatihan.getFrekPos();
    }
    
    public int tampilFrekNeg(){
       return EntHasilPelatihan.getFrekNeg();
    }
    
    public double tampilProbPos(){
        return EntHasilPelatihan.getProbPos();
    }
    
    public double tampilProbNeg(){
        return EntHasilPelatihan.getProbNeg();
    }
    
    public DefaultTableModel tampilTabelHasilKlasifikasi() {
        return EntHasilKlasifikasi.getTabelHasilKlasifikasi();
    }
   
   public double[] tampilProbDok(){
       return EntHasilKlasifikasi.getProbDok();
   } 

  public double[] tampilSentimenKat(){
      return EntHasilKlasifikasi.getSentimenKat();
   }
   
  public String tampilKesimpulan(){
       return EntHasilKlasifikasi.getKesimpulan();
   }
    
}
