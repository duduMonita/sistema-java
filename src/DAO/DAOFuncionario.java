package DAO;

import MODEL.Funcionario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOFuncionario {
    private Connection conecta;
    
    DAO daoFuncionarioDate = new DAO();
    
    public DAOFuncionario(){
        DAO daoFuncionario = new DAO();
        this.conecta = daoFuncionario.conecta();
    }
    
    public void salvarFuncionario(Funcionario funcionario, int codLocalizacao){
        String sql = "INSERT INTO Tb_Funcionario(cpf_funcionario, cod_localizacao, nome_funcionario, cargo_funcionario, sit_funcionario, dt_entrada) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setString(1, funcionario.getCpfFuncionario());
            stmt.setInt(2, funcionario.getCodLocalizacao(codLocalizacao));
            stmt.setString(3, funcionario.getNomeFuncionario());
            stmt.setString(4, funcionario.getCargoFuncionario());
            stmt.setInt(5, funcionario.getSitFuncionario());
            stmt.setDate(6, (Date) daoFuncionarioDate.buscaData());
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public List<Funcionario> listaFuncionario(){
        String sql = "Select * FROM tb_funcionario";
        ResultSet rs;
        List<Funcionario> listFun = new ArrayList<Funcionario>();
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Funcionario fun = new Funcionario();
                fun.setCpfFuncionario(rs.getString("cpf_funcionario"));
                fun.setCodLocalizacao(rs.getInt("cod_localizacao"));
                fun.setNomeFuncionario(rs.getString("nome_funcionario"));
                fun.setCargoFuncionario(rs.getString("cargo_funcionario"));
                fun.setSitFuncionario(rs.getInt("sit_funcionario"));
                fun.setDtEntrada(daoFuncionarioDate.dateToString(rs.getString("dt_entrada")));
                listFun.add(fun);
            }
            rs.close();
            stmt.close();
            return listFun;
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
