package MODEL;

public class PedidoCompra{
    private String codCompra;
    private String cpfFuncionario;
    private String cnpj;
    private double valorTotal;
    private String dtEntrada;

    public PedidoCompra(String codPedido) {
        this.codCompra = codPedido;
    }
    
    public PedidoCompra(){
        this.codCompra = "";
        this.valorTotal = 0;
        this.dtEntrada = "99/99/9999";
    }

    public String getCodCompra() {
        return codCompra;
    }

    public void setCodCompra(String codCompra) {
        this.codCompra = codCompra;
    }

    public String getCpfFuncionario(String valor) {
        Funcionario funcionario = new Funcionario(valor);
        this.cpfFuncionario = funcionario.getCpfFuncionario();
        return this.cpfFuncionario;
    }

    public String getCnpj(String valor) {
        Fornecedor fornecedor = new Fornecedor(valor);
        this.cnpj = fornecedor.getCnpj();
        return this.cnpj;
    }
    
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrega(String dtEntrega) {
        this.dtEntrada = dtEntrega;
    }
}
