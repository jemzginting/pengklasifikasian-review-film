/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author personal
 */
public class EntDokumen {
    private static String namaDok;
    private static String isiDok;
    
    public static void setDokumen(String namaDok, String isiDok){
        EntDokumen.namaDok=namaDok;
        EntDokumen.isiDok=isiDok;
    }
    
    public static String getNamaDok(){
        return namaDok;
    }
    
    public static String getIsiDok(){
        return isiDok;
    }
}
