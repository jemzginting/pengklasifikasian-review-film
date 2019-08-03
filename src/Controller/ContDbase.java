/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author personal
 */
public class ContDbase {
    
    private Connection con;
    private Statement stt;
    private ResultSet rs;
    
    public ContDbase(){
        String host="localhost",db ="programta",user="root",pass="";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Driver not found!"+ex.getMessage());
        }
        
        try {
            con=DriverManager.getConnection("jdbc:mysql://"+host+"/"+db, user, pass);
            stt=con.createStatement();
           // JOptionPane.showMessageDialog(null, "Koneksi Database Berhasil");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Connection Failed "+e.getMessage());
        }                     
        
    }
    

    
    
    public void ambilData(String query)throws SQLException{
        rs=stt.executeQuery(query);
    }
    
    public void insertData(String query)throws SQLException{
        stt.executeUpdate(query);
    }
    
    public void updateData(String query)throws SQLException{
        stt.executeUpdate(query);
    }
    
    public boolean isNotEmpty() throws SQLException{
        if(rs.next()){
            rs.beforeFirst();
            return true;
        }else{
            rs.beforeFirst();;
            return false;
        }
            
    }
    
    
    public String[][]tampilData()throws SQLException{
        String[][] data;
        if(isNotEmpty()){
            int colCount=rs.getMetaData().getColumnCount();
            rs.last();
            int rowCount=rs.getRow();
            data=new String[rowCount][colCount];
            rs.first();
            
            for(int i=0;i<rowCount;i++){
                for(int j=0;j<colCount;j++){
                    data[i][j]=rs.getString(j+1);
                }
                rs.next();
                
            }
            rs.close();
        }else{
            data=new String[1][1];
            data[0][0]="null";
        }
        return data;
    }
    
}
