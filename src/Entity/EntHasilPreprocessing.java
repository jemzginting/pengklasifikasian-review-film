/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author personal
 */
public class EntHasilPreprocessing {
   private static DefaultTableModel tabelPreprocessing =new DefaultTableModel();
    private static int totalFrekuensi;
    
    private static String kelompok ="-";
    
    public static void setKelompok(String Kelompok) {
        EntHasilPreprocessing.kelompok=Kelompok;
        
    }   
    
    
    public static void setTabelHasilPreprocessing (DefaultTableModel tabelPreprocessing) {
        EntHasilPreprocessing.tabelPreprocessing = tabelPreprocessing;
    }
    
    public static void setTotalFrekuensi(int totalFrekuensi){
        EntHasilPreprocessing.totalFrekuensi = totalFrekuensi;
    }
         
    public static String getKelompok(){
        return kelompok;
    }
    
    public static DefaultTableModel getTabelPrepro(){
        return EntHasilPreprocessing.tabelPreprocessing;
    }
    
    public static int getTotalFrekuensi(){
        return EntHasilPreprocessing.totalFrekuensi;
    }

}
