/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Entity.*;
import Interface.FormMain;
import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author personal
 */
public class ContNaiveBayes {
    
    private ContDbase con;  
    private double probPos, probNeg;
    private boolean sukses=true;

    
    public ContNaiveBayes(){
        con = new ContDbase();
    }
    
    
   
    public void latih(DefaultTableModel hslPelatihan){
  
        
        int[] jlhFrekuensi=new int[3];
        jlhFrekuensi[1]=EntHasilPelatihan.getFrekPos();
        jlhFrekuensi[2]=EntHasilPelatihan.getFrekNeg();
        String query1="TRUNCATE TABLE hasil_pelatihan";
        try{
            con.updateData(query1);//eksekusi query pada database
                        
        }catch(SQLException e){}                
       
        for(int a=1;a<3;a++){
            int idxFrek = a+1;
            int kolom= idxFrek + 2;
            int frek=0;
            double prob;

            for(int i=0;i<hslPelatihan.getRowCount();i++){
                frek=Integer.parseInt(hslPelatihan.getValueAt(i, idxFrek).toString());//mengambil nilai frekuensi kata pada kategori positif&negatif baris ke-i kolom ke-a
                System.out.println("frek "+i+"= "+frek);
                prob=(double)(frek+1)/(jlhFrekuensi[a]+EntHasilPelatihan.getJumlahKataLatih());//lakukan perhitungan P(Ai|Vj)
                java.text.DecimalFormat df= new java.text.DecimalFormat("###.####");//inisialiasi untuk mengubah format desimal dengan mengambil 4 digit angka setelah koma
                
                try{
                    prob = df.parse(df.format(prob)).doubleValue();//mengubah format desimal variabel prob
                    String valProb = Double.toString(prob);//mengubah tipe data prob menjadi tipe string 
                    hslPelatihan.setValueAt(valProb, i, kolom);//memasukkan nilai prob ke dalam kolom tabel
                    
                    String kata = hslPelatihan.getValueAt(i, 1).toString();//mengambil data string pada tabel pelatihan baris ke-i kolom 0
                    System.out.println(kata);
                    System.out.println("");
                    String query = null;
 
                    if(idxFrek==2){
                        query="INSERT INTO hasil_pelatihan VALUES ('"+kata+"',"+valProb+",0)";//query insert nilai prob pada kategori positif
                        //System.out.println(query);
                    }else if(idxFrek==3){
                        query="update hasil_pelatihan set prob_negatif ="+valProb+"where kata='"+kata+"'"; //query update nilai prob pada kategori negatif
                       
                    }
                    try{
                        con.updateData(query);//eksekusi query pada database
                        
                    }catch(SQLException e){                        
                    }                
                }catch(ParseException e){
                    
                }
            }
        }
                EntHasilPelatihan.setTabelHasilPelatihan(hslPelatihan);
    }
 
   
    public void simpanProbDok(){
        String sprobPos, sprobNeg;               
      
            
            sprobPos = Double.toString(EntHasilPelatihan.getProbPos());       
            
            sprobNeg = Double.toString(EntHasilPelatihan.getProbNeg());
            
            try {                
                String query="UPDATE dokumen SET prob_positif ="+sprobPos+", prob_negatif ="+sprobNeg+"WHERE nama_dokumen='"+EntDokumen.getNamaDok()+"'";
                con.updateData(query);
            }catch (SQLException ex){
                Logger.getLogger(ContNaiveBayes.class.getName()).log(Level.SEVERE, null, ex);
                
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
           
       
        
        if(sukses){
            JOptionPane.showMessageDialog(null, "Proses pelatihan telah selesai");
            
        }else{
            JOptionPane.showMessageDialog(null, "Dokumen latih gagal disimpan");
        }

    }
}
