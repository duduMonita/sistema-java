package DAO;

import MODEL.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOFornecedor {
    private Connection conecta;
    
    public DAOFornecedor(){
        DAO daoFornecedor = new DAO();
        this.conecta = daoFornecedor.conecta();
    }
    
    public void salvarFornecedor(Fornecedor fornecedor){
        String sql = "INSERT INTO Tb_Fornecedor(cnpj, nome) " +
                     "VALUES (?, ?)";
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setString(1, fornecedor.getCnpj());
            stmt.setString(2, fornecedor.getNome());
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
        public List<Fornecedor> listaFornecedor(){
        String sql = "Select * FROM Tb_Fornecedor";
        ResultSet rs;
        List<Fornecedor> listFor = new ArrayList<Fornecedor>();
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Fornecedor forne = new Fornecedor();
                forne.setCnpj(rs.getString("cnpj"));
                forne.setNome(rs.getString("nome"));
                listFor.add(forne);
            }
            rs.close();
            stmt.close();
            return listFor;
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
