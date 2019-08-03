/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Interface.*;
import Entity.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author personal
 */
public class ContForm {
    
    public ContForm(){

        }
    

 
    public void createFormPelatihan(){
        FormPelatihan fLatih;
        fLatih = new FormPelatihan();      
        fLatih.setLocationRelativeTo(fLatih);
        fLatih.setVisible(true);
                
    }
    
     public void createFormKlasifikasi(){
        FormKlasifikasi fKlas; 
        fKlas = new FormKlasifikasi();
        fKlas.setLocationRelativeTo(fKlas);
        fKlas.setVisible(true);

    }
     

     
    
}
