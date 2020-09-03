package DAO;

import MODEL.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOUsuario {
    private Connection conecta;
    
    public DAOUsuario(){
        DAO daoUsuario = new DAO();
        this.conecta = daoUsuario.conecta();
    }
    
    public void salvarUsuario(Usuario usuario){
        String sql = "INSERT INTO Tb_Usuario(cod_usuario, senha, nome_usuario, tp_usuario) " +
                     "VALUES (?, ?, ?, ?)";
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setString(1, usuario.getCodUsuario());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getNome());
            stmt.setInt(4, usuario.getTpUsuario());
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void alteraUsuario(Usuario usuario){
        String sql = "UPDATE Tb_Usuario" + 
                     "SET senha = ?, nome_usuario = ?, tp_usuario = ?" + 
                     "Where cod_usuario = ?";
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setString(4, usuario.getCodUsuario());
            stmt.setString(1, usuario.getSenha());
            stmt.setString(2, usuario.getNome());
            stmt.setInt(3, usuario.getTpUsuario());
            stmt.execute();
            stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void deletaUsuario(Usuario usuario){
        String sql = "DELETE FROM Tb_Usuario" + 
                     "Where cod_usuario = ?";
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setString(1, usuario.getCodUsuario());
            stmt.execute();
            stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public List<Usuario> listaUsuario(){
        String sql = "Select * FROM tb_usuario";
        ResultSet rs;
        List<Usuario> listUsu = new ArrayList<Usuario>();
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Usuario usu = new Usuario();
                usu.setCodUsuario(rs.getString("cod_usuario"));
                usu.setSenha(rs.getString("senha"));
                usu.setNomeUsuario(rs.getString("nome_usuario"));
                usu.setTpUsuario(rs.getInt("tp_usuario"));
                listUsu.add(usu);
            }
            rs.close();
            stmt.close();
            return listUsu;
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
