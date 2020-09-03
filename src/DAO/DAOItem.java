package DAO;

import MODEL.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOItem {
    private Connection conecta;
    
    public DAOItem(){
        DAO daoItem = new DAO();
        this.conecta = daoItem.conecta();
    }
    
    public void salvarItem(Item item){
        String sql = "INSERT INTO Tb_Item(cod_item, nome, descricao, valor_unitario, tp_item, cod_barra) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setInt(1, item.getCodItem());
            stmt.setString(2, item.getNome());
            stmt.setString(3, item.getDescricao());
            stmt.setDouble(4, item.getValorUnitario());
            stmt.setInt(5, item.getTpItem());
            stmt.setInt(6, item.getCodBarra());
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void alteraItem(Item item){
        String sql = "UPDATE Tb_Item" + 
                     "SET nome = ?, descricao = ?, valor_unitario = ?, tp_item = ?, cod_barra = ?" + 
                     "Where cod_item = ?";
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setInt(6, item.getCodItem());
            stmt.setString(1, item.getNome());
            stmt.setString(2, item.getDescricao());
            stmt.setDouble(3, item.getValorUnitario());
            stmt.setInt(4, item.getTpItem());
            stmt.setInt(5, item.getCodBarra());
            stmt.execute();
            stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void deletaUsuario(Item item){
        String sql = "DELETE FROM Tb_Item" + 
                     "Where cod_item = ?";
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setInt(1, item.getCodItem());
            stmt.execute();
            stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public List<Item> listaUsuario(){
        String sql = "Select * FROM tb_item";
        ResultSet rs;
        List<Item> listIt = new ArrayList<Item>();
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Item it = new Item();
                it.setCodItem(rs.getInt("cod_item"));
                it.setNome(rs.getString("nome"));
                it.setValorUnitario(rs.getDouble("valor_unitario"));
                it.setTpItem(rs.getInt("tp_item"));
                it.setCodBarra(rs.getInt("cod_barra"));
                listIt.add(it);
            }
            rs.close();
            stmt.close();
            return listIt;
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
