package DAO;

import MODEL.PedidoCompra;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOPedidoCompra {
    private Connection conecta;
    
    DAO daoPedidoCompraDate = new DAO();
    
    public DAOPedidoCompra(){
        DAO daoPedCompra = new DAO();
        this.conecta = daoPedCompra.conecta();
    }
    
    public void salvarPedidoCompra(PedidoCompra pedCompra, String cpfFuncionario, String cnpj){
        String sql = "INSERT INTO Tb_PedidoCompra(cod_compra, cpf_funcionario, cnpj, valor_total, dt_pedido) " +
                     "VALUES (?, ?, ?, ?, ?)";
        
        try{
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            stmt.setString(1, pedCompra.getCodCompra());
            stmt.setString(2, pedCompra.getCpfFuncionario(cpfFuncionario));
            stmt.setString(3, pedCompra.getCnpj(cnpj));
            stmt.setDouble(4, pedCompra.getValorTotal());
            stmt.setDate(5, (Date) daoPedidoCompraDate.buscaData());
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
