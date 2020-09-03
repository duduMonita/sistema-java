package MODEL;

public class Ordem {
    private String notaFiscal;
    private int codItem;
    private int quantidade;
    private int tpOrdem;

    public Ordem(String notaFiscal, int codItem) {
        this.notaFiscal = notaFiscal;
        this.codItem = codItem;
    }

    public Ordem() {
        this.notaFiscal = "";
        this.codItem = 0;
        this.quantidade = 0;
        this.tpOrdem = 1;
    }
    
    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public int getCodItem(int valor) {
        Item item = new Item(valor);
        this.codItem = item.getCodItem();
        return this.codItem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getTpOrdem() {
        return tpOrdem;
    }

    public void setTpOrdem(int tpOrdem) {
        this.tpOrdem = tpOrdem;
    }
    
}
