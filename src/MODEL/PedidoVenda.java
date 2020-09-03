package MODEL;

public class PedidoVenda {
    private String codVenda;
    private String codUsuario;
    private double valorTotal;
    private String dtEntrada;

    public PedidoVenda(String codVenda) {
        this.codVenda = codVenda;
    }
    
    public PedidoVenda() {
        this.codVenda = "";
        this.valorTotal = 0;
        this.dtEntrada = "99/99/9999";
    }
    
    public String getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(String codVenda) {
        this.codVenda = codVenda;
    }

    public String getCodUsuario(String valor) {
        Usuario usuario = new Usuario(valor);
        this.codUsuario = usuario.getCodUsuario();
        return this.codUsuario;
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

    public void setDtEntrada(String dtEntrada) {
        this.dtEntrada = dtEntrada;
    }
}
