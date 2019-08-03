/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Interface.*;
import Entity.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.StringTokenizer;




public class ContPreprocessing {
        public ContPreprocessing () {
        loadstopword();
    }
    
    private String kata;
    private DefaultListModel stopword = new DefaultListModel(); 
    
    JTable tabelFrekuensi1l;
    JTextField txtJumlah;
    JTextField txtTotal;
    
    
    private void loadstopword() {
        try {
            FileReader fr = new FileReader("D:\\stopword.txt");
            BufferedReader bufrdr = new BufferedReader(fr);
            
            String line = null;
            while((line = bufrdr.readLine())!= null) {
                stopword.addElement(line);                
            }
            bufrdr.close();
            
        }catch(IOException ioex) {
            System.err.println(ioex);
            System.exit(1);
        }
    }
    
    
    
    
    
    public void token(DefaultListModel listPecahan){
        kata = EntDokumen.getIsiDok();

        kata = kata.toLowerCase();
        StringTokenizer strtok = new StringTokenizer(kata,"! ?,.-\t\n\r\f\"\'/()=%0123456789:<>[]-/+;'^@~$&*");
        int i = -1;
        while(strtok.hasMoreElements()){
            listPecahan.add(++i,strtok.nextToken());
     
        }
    }
    
   
    
    public void filter(DefaultListModel listPecahan, DefaultListModel listFilter){
        int i,j;
        i=0;
        boolean isStopword;
        while(i<listPecahan.getSize()){
            isStopword = false;
            j=0;
            while(j<stopword.getSize() && !isStopword){
                if(listPecahan.getElementAt(i).toString().compareTo(stopword.getElementAt(j).toString())==0||listPecahan.getElementAt(i).toString().length()<3){
                    isStopword=true;                
                             
                }
                j++;
            }
            if(!isStopword){
                listFilter.addElement(listPecahan.getElementAt(i));
               
            }
            i++;
        }
                
    }
    
    
    public void frekuensi(DefaultListModel listPenyaringan,DefaultListModel listFrekuensi){
        int i,j;
        String namaKolom[]={"Kata","Frekuensi"};
        EntHasilPreprocessing.setTabelHasilPreprocessing(new DefaultTableModel(namaKolom,0));
        int totalFrekuensi = listPenyaringan.getSize();
        EntHasilPreprocessing.setTotalFrekuensi(totalFrekuensi);
        Object record[]= new Object[2];
        String kata;
        int jumlah;
        boolean ketemu;
        
        for(i=0;i<listPenyaringan.getSize();i++){
            try{
                kata=listPenyaringan.getElementAt(i).toString();
                
                ketemu=false;
                j=0;
                
                while(j<EntHasilPreprocessing.getTabelPrepro().getRowCount() && !ketemu){
                    if(EntHasilPreprocessing.getTabelPrepro().getValueAt(j,0).toString().compareTo(kata)==0){
                        ketemu=true;
                    }
                    j++;
                }
                if(!ketemu){
                    jumlah=1;
                    for(j=i+1;j<listPenyaringan.getSize();j++){
                        if(listPenyaringan.getElementAt(j).toString().compareTo(kata)==0){
                            jumlah++;
                        }
                    }
                    listFrekuensi.addElement(jumlah);
                    record[0]=kata;
                    record[1]=jumlah;
                    EntHasilPreprocessing.getTabelPrepro().addRow(record);
                }
            }catch(NullPointerException e){}
       
         }
        //tabelPrePro.setModel(EntHasilPreprocessing.tabelPreprocessing);
    }
    
    
    
}
