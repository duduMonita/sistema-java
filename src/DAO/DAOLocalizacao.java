package DAO;

import MODEL.Localizacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOLocalizacao {
    private Connection conecta;
    
    public DAOLocalizacao(){
        DAO daoLocAlmoxerifado = new DAO();
        this.conecta = daoLocAlmoxerifado.conecta();
    }
    
    public void salvarLocalizacao(Localizacao localizacao){
        String sql = "INSERT INTO tb_localizacao(cod_localizacao, nome, setor, cpf_responsavel) " +
                     "VALUES (?, ?, ?, ?)";
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setInt(1, localizacao.getCodLocalizacao());
            stmt.setString(2, localizacao.getNome());
            stmt.setString(3, localizacao.getSetor());
            stmt.setString(4, localizacao.getCpfResponsavel());
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public List<Localizacao> listaLocalizacao(){
        String sql = "Select * FROM tb_localizacao";
        ResultSet rs;
        List<Localizacao> listLoc = new ArrayList<Localizacao>();
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Localizacao loc = new Localizacao();
                loc.setCodLocalizacao(rs.getInt("cod_localizacao"));
                loc.setNome(rs.getString("nome"));
                loc.setSetor(rs.getString("setor"));
                loc.setCpfResponsavel(rs.getString("cpf_responsavel"));
                listLoc.add(loc);
            }
            rs.close();
            stmt.close();
            return listLoc;
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public int buscaLocalizacao(int codLocalizacao){
        String sql = "SELECT * FROM Tb_Localizacao " +
                     "Where cod_localizacao = " + String.valueOf(codLocalizacao) + ";";
        ResultSet rs;
        System.out.println(sql);
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            rs.next();
            Localizacao loc = new Localizacao();
            loc.setCodLocalizacao(rs.getInt("cod_localizacao"));
            
            rs.close();
            stmt.close();
            return loc.getCodLocalizacao();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
