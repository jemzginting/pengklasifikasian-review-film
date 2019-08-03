/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Controller.DokumenManager;
import Entity.EntDokumen;
import Interface.FormMain;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author personal
 */
public class DokumenManager {
    private String namaDok,isiDok;
    
    public void loadDokumen(FormMain main){
       
            JFileChooser filechooser = new JFileChooser();
            filechooser.setCurrentDirectory(new File("D:\\Data Penelitian\\Uji Negatif"));
            filechooser.setFileFilter(new FileNameExtensionFilter("TXT File","txt"));
            int retval = filechooser.showOpenDialog(main);

            if(retval == JFileChooser.APPROVE_OPTION){
                File inFile = filechooser.getSelectedFile();
                try{
                    isiDok="";
                    namaDok = inFile.getName();
                    FileReader fr = new FileReader(inFile);
                    BufferedReader bufrdr = new BufferedReader(fr);

                    String line = null;
                    while((line = bufrdr.readLine()) != null){
                        isiDok=isiDok+line;
                    }
                   //System.out.println(namaDok);
                    EntDokumen.setDokumen(namaDok, isiDok);                 
                    bufrdr.close();
                }catch(IOException ioex){
                    System.exit(1);
                }
            }
        
        
        
    }
    
    public String tampilIsiDok(){
        return EntDokumen.getIsiDok();
    }
    
    public String tampilNamaDok(){
        return EntDokumen.getNamaDok();

    }
}
