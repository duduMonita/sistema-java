package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class DAO {
    public Connection conecta(){
        try{
            String url = "jdbc:postgresql://localhost:5432/APS";
            String usuario = "postgres";
            String senha = "91536813e";
            
            Connection con = DriverManager.getConnection(url, usuario, senha);
            return con;
        }
        catch(SQLException e){
            throw new RuntimeException(e); 
        }
    }
    
    public Date buscaData(){
        Date date = new Date(System.currentTimeMillis());
        
        Date dataUtil = date;
        java.sql.Date dataSql = null;
        
        try {
            dataUtil = new java.sql.Date(dataUtil.getTime());
            dataSql = (java.sql.Date) dataUtil;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao converte data para sql: " + e.getMessage());
        }
    return dataSql;
    }
    
    public String dateToString(String data){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
        Date d1 = null;
        try {
            d1 = f.parse(data);            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao converte string para data: " + e.getMessage());
        }
        
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        data = format.format(d1);
        
        return data;       
    }
}
