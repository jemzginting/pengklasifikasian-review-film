/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author personal
 */
public class EntHasilKlasifikasi {
    
    private static DefaultTableModel tabelKlasifikasi;
    private static double[] probDok;
     private static double[] sentimenKat;
    private static String kesimpulan="-";
    
   public static void setTabelHasilKlasifikasi (DefaultTableModel tabelKlasifikasi) {
        EntHasilKlasifikasi.tabelKlasifikasi= tabelKlasifikasi;
    }
   
   public static void setProbDok(double[] probDok){
       EntHasilKlasifikasi.probDok=probDok;
   }
     
  public static void setSentimenKat(double[] sentimenKat){
       EntHasilKlasifikasi.sentimenKat=sentimenKat;
   }  

   public static void setKesimpulan(String kesimpulan){
       EntHasilKlasifikasi.kesimpulan=kesimpulan;
   }
   
   public static DefaultTableModel getTabelHasilKlasifikasi() {
        return EntHasilKlasifikasi.tabelKlasifikasi;
    }
   
   public static double[] getProbDok(){
       return EntHasilKlasifikasi.probDok;
   } 

  public static double[] getSentimenKat(){
      return EntHasilKlasifikasi.sentimenKat;
   }
   
  public static String getKesimpulan(){
       return EntHasilKlasifikasi.kesimpulan;
   }

   
   
}
