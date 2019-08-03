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
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import jdk.nashorn.internal.objects.Global;

/**
 *
 * @author Jemzsuzura
 */
public class ContInformationGain {
    
    private final ContDbase con;
    private boolean sukses=true;
    public static double totalIG;
    private double probPos, probNeg;
    private int total = 0;
    private int[] jlhKatDok = new int[2];
     private double threshold;
     
    public ContInformationGain(){
        con = new ContDbase();
    }
    
    public void simpanKategori(String kategori) throws SQLException{
        //EntHasilPreprocessing.setKelompok(kategori);
        
        String kata;
        int jumlah;
        double probDokPos=0, probDokNeg=0;
        int n= EntHasilPreprocessing.getTabelPrepro().getRowCount();
        boolean sukses=true;
        double nilaiIG;
        for(int i=0;i<n;i++){
            kata= EntHasilPreprocessing.getTabelPrepro().getValueAt(i, 0).toString(); //mengambil data/nilai pada barus ke NOL
            jumlah= Integer.parseInt(EntHasilPreprocessing.getTabelPrepro().getValueAt(i, 1).toString()); //mengambil data/nilai pada barus ke SATU
                  

            try{
                
                con.ambilData("select frek_kata from daftar_kata where kata='"+kata+"'and kategori='"+kategori+"'");
                if(con.isNotEmpty()){
                    int current= Integer.parseInt(con.tampilData()[0][0]);
                    jumlah += current;
                    con.updateData("update daftar_kata set frek_kata='"+Integer.toString(jumlah)+"'where kata='"+kata+"'and kategori='"+kategori+"'");
                }else{
                   
                    con.insertData("Insert into daftar_kata value('"+kata+"','"+kategori+"','"+Integer.toString(jumlah)+"')");
                }
                //EntDokumen.getNamaDok()

                con.insertData("Insert into isi_dokumen value('"+EntDokumen.getNamaDok()+"','"+kata+"','"+kategori+"')");
               
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "SQL Error ce, "+e.getMessage());
                sukses=false;
            }
                    
        }
         con.insertData("INSERT INTO dokumen(nama_dokumen, kategori) VALUES('"+EntDokumen.getNamaDok()+"', '"+kategori+"')");
       if(!sukses){
            JOptionPane.showMessageDialog(null, "Data gagal disimpan dalam kategori"+kategori);
        }else{
           JOptionPane.showMessageDialog(null, "Data berhasil dalam disimpan kategori"+kategori);
       }
        
    }
    
    
    public void daftarkanKata(DefaultTableModel hslPelatihan){
        int i,j,k;
        
        try{
            con.ambilData("select kata, kategori, frek_kata from daftar_kata ORDER BY kata ASC");
            
            if(con.isNotEmpty()){
                String[][]Data = con.tampilData();
                int pilih;
                boolean ketemu;
                String[] newLine = new String[4];
                
                for(i=0;i<Data.length;i++){

                    newLine[1]=Data[i][0];
                    k=0;
                    ketemu=false;
                    
                    while(k<hslPelatihan.getRowCount() && !ketemu){
                        if(newLine[1].compareTo(hslPelatihan.getValueAt(k, 1).toString())==0){
                            ketemu=true;
                        }else{
                            k++;
                        }
                    }
                    
                    if(Data[i][1].compareTo("Positif")==0){
                        pilih=2;
                    }else{
                        pilih=3;
                    }
                    
                    if(ketemu){
                        
                        hslPelatihan.setValueAt(Data[i][2], k, pilih);
                        
                    }else{
                        for(j=2;j<=3;j++){
                            if(j==pilih){
                                newLine[j]=Data[i][2];
                            
                            }else{
                                newLine[j]="0";
                            }
                        }
                        String nomor = String.valueOf(k+1)+".";                                        
                        newLine[0]= nomor;
                        hslPelatihan.addRow(newLine);
                        System.out.println("x ="+newLine[0]+" "+newLine[1]+" "+newLine[2]+" "+newLine[3]);
  
                    }
                }
   
            }
        }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    
    
    
    public void mulaiInformationGain(DefaultTableModel tabelPelatihan){
                
        double hasil=0;       
        
        for(int i=0;i<tabelPelatihan.getRowCount();i++){
                
            java.text.DecimalFormat df= new java.text.DecimalFormat("###.####");//inisialiasi untuk mengubah format desimal dengan mengambil 4 digit angka setelah koma
            String kata = tabelPelatihan.getValueAt(i, 1).toString();//mengambil data string pada tabel pelatihan baris ke-i kolom 0
            try{
                    
                hitungDokFrekuensi(kata);
                hasil = get_totalIG();
                hasil = df.parse(df.format(hasil)).doubleValue();//mengubah format desimal variabel hasil
                tabelPelatihan.setValueAt(hasil, i, 6);//memasukkan nilai IG ke dalam kolom tabel
                //bubblesort(tabelPelatihan);
                
                
                
                }catch(ParseException e){
                    
            }
        }

    }
 
     public void hitungProbDok()throws IOException{        
                 java.text.DecimalFormat df = new java.text.DecimalFormat("###.####");
        try{           
                    
                con.ambilData("SELECT count(nama_dokumen) FROM dokumen WHERE kategori = 'Positif'");
                jlhKatDok[0] = Integer.parseInt(con.tampilData()[0][0]); // jumlah banyak dokumen latih yang berkategori positif
                
                
                con.ambilData("SELECT count(nama_dokumen) FROM dokumen WHERE kategori = 'Negatif' ");
                jlhKatDok[1] = Integer.parseInt(con.tampilData()[0][0]); // jumlah banyak dokumen latih yang berkategori negatif
                
                
                con.ambilData("SELECT count(nama_dokumen) FROM dokumen");
                total= Integer.parseInt(con.tampilData()[0][0]); // jumlah banyak dokumen latih 
                      

            probPos = (double)jlhKatDok[0]/total;
            probNeg = (double)jlhKatDok[1]/total;
            
           try{
                probPos = df.parse(df.format(probPos)).doubleValue();          
                probNeg = df.parse(df.format(probNeg)).doubleValue();
            }catch(ParseException e){                
            }
            EntHasilPelatihan.setProbPos(probPos);
            EntHasilPelatihan.setProbNeg(probNeg);
            
            /*
            System.out.println("jmlKatDok[0]  ="+jlhKatDok[0] );
            System.out.println("jmlKatDok[1]  ="+jlhKatDok[1] );
            System.out.println("jmlAllDok  ="+total );   
            System.out.println("probPos  ="+probPos ); 
            System.out.println("probNeg  ="+probNeg ); */
            
        }catch(SQLException e){
            sukses=false;
            System.out.println(e.getMessage());
           
        }
        
    }
    
    
    
     private int getTotalAllDok(){
        return total;
    }
    
    private int getJmlDokPos(){
        return jlhKatDok[0];
    }
    
     private int getJmlDokNeg(){
        return jlhKatDok[1];
    }
    
    
    private void setThreshold(double tHold){
        threshold=tHold;
        
    }
    
    private double getThreshold(){
        return threshold;
    }
    
    private void hitungDokFrekuensi(String kata) throws ParseException{
  
        int[] jmlDokKata = new int[2];
        int[] jmlDokBukanKata = new int[2];
        int jmlAllDokKata=0,jmlAllDokBukanKata=0,jmlDokNegKata=0,jmlDokPosKata=0;  
        double probKata=0,probBukanKata=0,probPosKata=0,probNegKata=0,probPosBukanKata=0,probNegBukanKata=0;
        
        boolean valid;
        int jmlAllDok = getTotalAllDok();
       
            try{ 
                

                
                con.ambilData("SELECT count(nama_dokumen) FROM isi_dokumen WHERE kata = '"+kata+"'");
                jmlAllDokKata = Integer.parseInt(con.tampilData()[0][0]); //jumlah semua dokumen latih yang memiliki kemunculan suatu kata tertentu
              
                
                jmlAllDokBukanKata=jmlAllDok-jmlAllDokKata; //jumlah semua dokumen latih yang tidak memiliki kemunculan suatu kata tertentu
               
                
                con.ambilData("SELECT count(nama_dokumen) FROM isi_dokumen where kata='"+kata+"'and kategori = 'Positif' ");
                jmlDokKata[0] = Integer.parseInt(con.tampilData()[0][0]); // jumlah dokumen latih kategori positif yg memiliki kemunculan suatu kata tertentu 
               
                
                con.ambilData("SELECT count(nama_dokumen) FROM isi_dokumen where kata='"+kata+"'and kategori = 'Negatif' ");
                jmlDokKata[1] = Integer.parseInt(con.tampilData()[0][0]); // jumlah dokumen latih kategori negatif yg memiliki kemunculan suatu kata tertentu 
               
                
                jmlDokBukanKata[0] =  getJmlDokPos()-jmlDokKata[0]; //hitung jumlah dokumen latih yang tidak memiliki kemunculan suata kata pada kategori positif
               
                jmlDokBukanKata[1] =  getJmlDokNeg()-jmlDokKata[1]; //hitung jumlah dokumen latih yang tidak memiliki kemunculan suata kata pada kategori negatif
              

                  
                probKata = (double)jmlAllDokKata/jmlAllDok; //probabilitas Dokumen yang memiliki kemunculan suatu kata tertentu
                probBukanKata = (double)jmlAllDokBukanKata/jmlAllDok; //probabilitas Dokumen yang tidak memiliki kemunculan suatu kata
                probPosKata = (double)jmlDokKata[0]/jmlAllDokKata; //probabilitas Dokumen positif yang memiliki kemunculan suatu kata tertentu
                probNegKata = (double)jmlDokKata[1]/jmlAllDokKata; //probabilitas dokumen negatif yang memiliki kemunculan suatu kata tertentu
                probPosBukanKata = (double)jmlDokBukanKata[0]/jmlAllDokBukanKata; //probabilitas dokumen positif yang tidak memilki kemunculan suatu kata tertentu
                probNegBukanKata = (double)jmlDokBukanKata[1]/jmlAllDokBukanKata; //probabilitas dokumen negatif yang tidak memilki kemunculan suatu kata tertentu
                
                             
               /*
                System.out.println("===================" ); 
                 System.out.println(kata +"=" ); 
                 System.out.println("jmlDokKata[1]  ="+jmlDokKata[1]);
                 System.out.println("jmlDokKata[0]  ="+jmlDokKata[0] );
                 System.out.println("jmlAllDokBukanKata  ="+jmlAllDokBukanKata );
                 System.out.println("jmlAllDokKata  ="+jmlAllDokKata );
                System.out.println("jmlDokBukanKata[0] ="+jmlDokBukanKata[0] );
                System.out.println("jmlDokBukanKata[1]  ="+jmlDokBukanKata[1]  );
                // JOptionPane.showMessageDialog(null, jmlDokBukanKata[0]);
                //hitung probabilitas
               System.out.println("probKata  ="+probKata  );
                 System.out.println("probBukanKata   ="+probBukanKata  );
                 System.out.println("probPosKata  ="+probPosKata  );
                 System.out.println("probNegKata  ="+probNegKata  );
                 System.out.println("probPosBukanKata  ="+probPosBukanKata ); 
                  System.out.println("probNegBukanKata  ="+probNegBukanKata ); */
               
               
        double[] prob = {probPosKata,probNegKata,probPosBukanKata,probNegBukanKata};
        double[] nilaiIG = new double[3]; 
        for(int i=0;i<4;i++){
            if(prob[i]==0.0){             
                prob[i]=1.0;//mengubah nilai pada parameter menjadi bernilai 1 untuk menangani penyelesaian LOGARITMA NAN                      
                
            }                       
  
        }
        
        double probDokPos = EntHasilPelatihan.getProbPos();
        double probDokNeg = EntHasilPelatihan.getProbNeg();
        nilaiIG[0]= (-((probDokPos*Math.log10(probDokPos))+(probDokNeg*Math.log10(probDokNeg))));
        nilaiIG[1] = (probKata*((probPosKata*Math.log10(prob[0]))+(probNegKata*Math.log10(prob[1]))));
        nilaiIG[2]=(probBukanKata*((probPosBukanKata*Math.log10(prob[2]))+(probNegBukanKata*Math.log10(prob[3]))));        
        hitungTotalIG(nilaiIG);
        /*
        System.out.println(" hitung[0]  ="+ hitung[0] ); 
                System.out.println(" hitung[1]  ="+ hitung[1] ); 
                    System.out.println(" hitung[2]  ="+ hitung[2] ); 
        //totalIG = hitung[0]+hitung[1]+hitung[2];
        */
        
               
             
            }catch(SQLException e){
                sukses=false;
                JOptionPane.showMessageDialog(null, "SQL Error, "+e.getMessage());
           
            }
    }
        
    private double hitungTotalIG(double[] nilaiIG){
     
        totalIG= 0;
        for(int i=0;i<3;i++){
            totalIG =  totalIG+nilaiIG[i];
        }
        
        if(Double.isNaN(totalIG)){         
            totalIG=0.0;                  
             
        }            
        
        return totalIG; 
       

    }
    
    public double get_totalIG(){
        return totalIG;
    }
    
    
    
    public void urutkanData(DefaultTableModel tabelPelatihan){
                
        double hasil=0;           
      
       Vector x= new Vector<String>(tabelPelatihan.getDataVector()); //mengubah data tabel menjadi bentuk vector
        Object [][] data = new Object[x.size()][6]; 
     
        for(int i=0;i<data .length;i++){ 
            data [i]=((Vector) x.get(i)).toArray() ; //convert vector to array
        }            
        buble_sort(data ); //mengurutkan data sesuai nilai InfoGain        
        tampil_data(data , tabelPelatihan); //menampilkan data yang sudah terurut
    }
    
    private void buble_sort(Object[][] data){
       
        for(int i=0;i<data.length;i++){     
            try{
                for(int j = 0; j< data.length-1; j++) { 
                    double nilai1=(double) data[j][6];
                    double nilai2=(double) data[j+1][6];
               // boolean valid = nilai1==Double.POSITIVE_INFINITY || nilai1==Double.NEGATIVE_INFINITY ||nilai2==Double.POSITIVE_INFINITY || nilai2==Double.NEGATIVE_INFINITY;
                  

                    if(nilai1<nilai2){
                        for(int k = 1; k <data[i].length; k++) { 
                            //System.out.println(coba[j][k]);
                            Object temp = data[j][k];
                            data[j][k]=data[j+1][k];
                            data[j+1][k]=temp;                    
                           
                        }                   
                       
                    }    
                    
                }
           }catch(ArrayIndexOutOfBoundsException ex){
               System.out.println("Exception = "+ex.getMessage());
           }
        }
    }
    
  private void tampil_data(Object[][] dataBaru,DefaultTableModel tabellatih){
       resetTabel(tabellatih); //menghapus data tabel yang lama
       
       for(int i=0;i<dataBaru.length;i++){ 
            tabellatih.addRow(dataBaru[i]);//mengganti data tabel yang sudah terurut 
            
        }  
   } 
      

    public void seleksi_fitur(DefaultTableModel tabelPelatihan, double thold){
        boolean yes=true;        
        setThreshold(thold);
        int n=tabelPelatihan.getRowCount();//jumlah daftar kata
        
        double nilai_IG;
        int jumlah=0;
        
        for(int j=0;j<n;j++){
            nilai_IG = (double) tabelPelatihan.getValueAt(j, 6);
            if(nilai_IG<=thold){
                jumlah++;
            }
        }
        
        int i=n-1;
        
        int x=0;
       
        do{
                      
           try{              
                tabelPelatihan.removeRow(i);
    
            }catch(NullPointerException e){
               JOptionPane.showMessageDialog(null, e);
            }  
            i--;
            x++;
        }while(x<jumlah);       
        
                
    }
    
    
    
    private void resetTabel(DefaultTableModel tabellatih){
        int brs = tabellatih.getRowCount();
         
        for(int i=0;i<brs;i++){
		tabellatih.removeRow(0);
        }
    }

}

