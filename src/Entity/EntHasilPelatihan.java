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
public class EntHasilPelatihan {
    public static DefaultTableModel tabelPelatihan =new DefaultTableModel();
    private static int jmlSemuaKata ;
    private static int jmlFrekNeg;
    private static  int jmlFrekPos;
    private static double probPos;
    private static double probNeg;
    
    public static void setTabelHasilPelatihan (DefaultTableModel tabelPelatihan) {
        EntHasilPelatihan.tabelPelatihan= tabelPelatihan;
    }

    
    public static void setjumlahKataLatih(int jmlSemuaKata){
        EntHasilPelatihan.jmlSemuaKata=jmlSemuaKata;
    }
    
    public static void setFrekPos(int jmlFrekNeg){
        EntHasilPelatihan.jmlFrekNeg=jmlFrekNeg;
    }
    
    public static void setFrekNeg(int jmlFrekPos){
        EntHasilPelatihan.jmlFrekPos=jmlFrekPos;
    }
    
    public static void setProbPos(double probPos){
        EntHasilPelatihan.probPos=probPos;
    }
    
    public static void setProbNeg(double probNeg){
        EntHasilPelatihan.probNeg=probNeg;
    }
    
   public static DefaultTableModel getTabelHasilPelatihan () {
       return EntHasilPelatihan.tabelPelatihan;
    }
    
    public static int getJumlahKataLatih(){
        return EntHasilPelatihan.jmlSemuaKata;
    }
    
    public static int getFrekPos(){
       return EntHasilPelatihan.jmlFrekNeg;
    }
    
    public static int getFrekNeg(){
       return EntHasilPelatihan.jmlFrekPos;
    }
    
    public static double getProbPos(){
        return EntHasilPelatihan.probPos;
    }
    
    public static double getProbNeg(){
        return EntHasilPelatihan.probNeg;
    }
    
}
