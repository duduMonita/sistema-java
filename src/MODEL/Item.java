package MODEL;

public class Item {
    private int codItem;
    private String nome;
    private String descricao;
    private int tpItem;
    private double valorUnitario;
    private int codBarra;

    public Item(int codItem) {
        this.codItem = codItem;
    }
    
    public Item(){
        this.codItem = 0;
        this.nome = "";
        this.descricao = "";
        this.tpItem = 1;
        this.valorUnitario = 0;
        this.codBarra = 0;
    }

    public int getCodItem(){
        return codItem;
    }
    
    public void setCodItem(int codItem){
        this.codItem = codItem;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTpItem() {
        return tpItem;
    }

    public void setTpItem(int tpItem) {
        this.tpItem = tpItem;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(int codBarra) {
        this.codBarra = codBarra;
    }
    
    
}
