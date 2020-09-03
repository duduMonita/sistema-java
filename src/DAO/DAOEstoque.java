package DAO;

import MODEL.Estoque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class DAOEstoque {
    private Connection conecta;
    
    DAO daoEstoqueData = new DAO();
    
    public DAOEstoque(){
        DAO daoEstoque = new DAO();
        this.conecta = daoEstoque.conecta();
    }
    
    public void salvaItensEstoque(Estoque Estoque, int codLocalizacao){
        String sql = "INSERT INTO Tb_Estoque(cod_item_estoque, cod_localizacao, quantidade, sit_inventario)" +
                     "VALUES (?, ?, ?, ?)";
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);

            stmt.setInt(1, Estoque.getCodItemEstoque());
            stmt.setInt(2, Estoque.getCodLocalizacao(codLocalizacao));
            stmt.setInt(3, Estoque.getQuantidade());
            stmt.setInt(4, Estoque.getSituacaoInventario());
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void salvaItensInventario(Estoque Estoque){
        String sql = "UPDATE Tb_Estoque" + 
                     "SET situacao_inventario = ?, dt_inventario = ?" +
                     "Where = " + Integer.toString(Estoque.getCodItemEstoque());
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            //Date dt_inventario = daoEstoqueData.dateToString(Estoque.getDtInventario());
            
            stmt.setInt(1, Estoque.getSituacaoInventario());
            //stmt.setDate(2, (java.sql.Date) dt_inventario);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

}
