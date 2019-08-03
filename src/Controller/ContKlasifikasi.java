/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Jemzsuzura
 */

import Entity.*;

import Interface.FormMain;
import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ContKlasifikasi {
    
    private ContDbase con;
    private double[] akumProb = {1.0,1.0};
    private double[] probDok = new double[2];
    private double[] Probabilitas = {1.0,1.0};
    private String Kesimpulan = "-";
    private double[] akumulasiProb = {1.0,1.0};
    private ContPreprocessing Prepro;
    private  String[] namaTblKlas={"Kata","Prob Positif","Prob Negatif"};
    private  DefaultTableModel dataKlasifikasi = new DefaultTableModel(namaTblKlas, 0);
   private  DefaultListModel modelPecahan = new DefaultListModel();
    private  DefaultListModel<String> modelFilter = new DefaultListModel<>();
    private  DefaultListModel<Integer> listFrekuensi = new DefaultListModel<>();
    
    public ContKlasifikasi() {
    con = new ContDbase();    
    }
    
    public void pengujianReview() throws SQLException{
        long start;
        long end;
 
        start = System.currentTimeMillis();//menghitung waktu proses dalam detik
 
        Prepro = new ContPreprocessing();              
        SetHasilPrepro();       
        prosesKlasifikasi(dataKlasifikasi);
             
        end = System.currentTimeMillis();
        simpanHasil(); 
        System.out.println(((end - start) / 1000.0));
       // System.out.println("=====================================================");
        
    }
    
    
    private void SetHasilPrepro(){
        Prepro.token(modelPecahan);
        Prepro.filter(modelPecahan, modelFilter);
        Prepro.frekuensi(modelFilter,listFrekuensi);

    }
    

    
    public String tampilKesimpulan(){
        return EntHasilKlasifikasi.getKesimpulan();
    }       
    
    
    public void prosesKlasifikasi(DefaultTableModel tabelPros) throws SQLException{
        int idxMaks = 0;
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.###########################################################################");
        
        String[] newLine = new String[3];
        int i,j;
        
        double[] akumulasiProb = {1.0,1.0};
        
        for(i=0;i<EntHasilPreprocessing.getTabelPrepro().getRowCount(); i++){
            String kata = EntHasilPreprocessing.getTabelPrepro().getValueAt(i, 0).toString();
            //System.out.println(kata);
            newLine[0]=kata;
            
            try{
                con.ambilData("Select * from hasil_pelatihan where kata='"+kata+"'");
                if(con.isNotEmpty()){
                    String[][] Data= con.tampilData();
                    for(j=0;j<2;j++){
                        newLine[j+1]=Data[0][j+1];
                        //System.out.println("prob X = "+Data[0][j+1]);
                       //  System.out.println("akumProb[j] ="+akumProb[j]);
                        akumulasiProb[j]=akumProb[j]* (Double.parseDouble(Data[0][j+1]));
                        
                        //System.out.println("akumulasiProb[j] = "+akumulasiProb[j]);
                        //akumulasiProb[j]=df.parse(df.format(akumulasiProb[j])).doubleValue();
                        akumProb[j]=akumulasiProb[j];
                        akumProb[j]=df.parse(df.format(akumProb[j])).doubleValue();
                        
                       // System.out.println(akumProb[j]);
                    }
                    tabelPros.addRow(newLine); 
                    
                }
            }catch (ParseException ex){
                Logger.getLogger(ContKlasifikasi.class.getName()).log(Level.SEVERE, null, ex);
            }catch(SQLException e){
                System.out.print("XaX="+e.getMessage());
            }
        }
       EntHasilKlasifikasi.setTabelHasilKlasifikasi(tabelPros);
        try{
            con.ambilData("SELECT prob_positif, prob_negatif from dokumen order by id_dokumen desc limit 1 ");
            String[][] Data=con.tampilData();
            
            for(i=0;i<2;i++){
                probDok[i] = Double.parseDouble(Data[0][i]);
               
                Probabilitas[i] = probDok[i] * akumProb[i];
                // System.out.println("1 = "+Probabilitas[i]);
               //  System.out.println("2 = "+Probabilitas[idxMaks]);
                if(Double.compare(Probabilitas[i], Probabilitas[idxMaks])>0){
                    idxMaks = i;
                }
                
                try{
                    Probabilitas[i]=df.parse(df.format(Probabilitas[i])).doubleValue();
                }catch (ParseException ex){
                    Logger.getLogger(ContKlasifikasi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            EntHasilKlasifikasi.setProbDok(probDok);
            EntHasilKlasifikasi.setSentimenKat(Probabilitas);

        }catch (SQLException e){
            System.out.print("cc "+e.getMessage());
        }
        
        if(idxMaks==0){
            Kesimpulan="Positif";
            
            //System.out.println("kesimpulan = "+Kesimpulan);
        }else if(idxMaks==1){
            Kesimpulan="Negatif ";
            //System.out.println("kesimpulan = "+Kesimpulan);
        }     
        EntHasilKlasifikasi.setKesimpulan(Kesimpulan);
    }

    
    
      public void simpanHasil() {
        boolean sukses = true;
        
        try{
            con.insertData("insert into hasil_klasifikasi value('"+EntDokumen.getNamaDok()+"','"+Kesimpulan+"','"+Probabilitas[0]+"','"+Probabilitas[1]+"')");
        }catch(SQLException e){
            sukses = false;
            System.out.println("ff ="+e.getMessage());
        }
        
        if(sukses){
            try{
                if(Kesimpulan.equals("Positif")){
                    File outFile = new File("D:\\Data\\Kesimpulan\\Positif\\"+EntDokumen.getNamaDok());
                    FileWriter fstream =new FileWriter(outFile);
                    BufferedWriter out = new BufferedWriter(fstream);
                    out.write(EntDokumen.getIsiDok());
                    out.close();
                }else if(Kesimpulan.equals("Negatif")){
                    File outFile = new File("D:\\Data\\Kesimpulan\\Negatif\\"+EntDokumen.getNamaDok());
                    FileWriter fstream =new FileWriter(outFile);
                    BufferedWriter out = new BufferedWriter(fstream);
                    out.write(EntDokumen.getIsiDok());
                    out.close();
                }
            }catch (Exception e){
                sukses = false;
                System.err.println("Error :"+e.getMessage());
            }
            /*
            if(sukses){
                JOptionPane.showMessageDialog(null, "Dokumen hasil klasifikasi berhasil disimpan");
            }else{
                JOptionPane.showMessageDialog(null, "Dokumen hasil klasifikasi gagal disimpan");
            } */
        }
    }
    
}
