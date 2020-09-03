package MODEL;

public class Estoque {
    private int codItemEstoque;
    private int codLocalizacao;
    private int quantidade;
    private int sitInventario;
    private String DtInventario;

    public Estoque(int codItemEstoque) {
        this.codItemEstoque = codItemEstoque;
    }

    public Estoque(){
        this.codItemEstoque = 0;
        this.quantidade = 0;
        this.sitInventario = 0;
        this.DtInventario = "99/99/9999";
    }

    public int getCodItemEstoque() {
        return codItemEstoque;
    }

    public void setCodItemEstoque(int codItemEstoque) {
        this.codItemEstoque = codItemEstoque;
    }
    
    public int getCodLocalizacao(int valor) {
        Localizacao localizacao = new Localizacao(valor);
        this.codLocalizacao = localizacao.getCodLocalizacao();
        return this.codLocalizacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getSituacaoInventario() {
        return sitInventario;
    }

    public void setSituacaoInventario(int situacaoInventario) {
        this.sitInventario = situacaoInventario;
    }

    public String getDtInventario() {
        return DtInventario;
    }

    public void setDtInventario(String DtInventario) {
        this.DtInventario = DtInventario;
    }
}
