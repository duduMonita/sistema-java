package MODEL;

public class Localizacao {
    private int codLocalizacao;
    private String nome;
    private String setor;
    private String cpfResponsavel;

    public Localizacao(int codLocalizacao) {
        this.codLocalizacao = codLocalizacao;
    }

    public Localizacao(){
        this.codLocalizacao = 0;
        this.nome = "";
        this.setor = "";
        this.cpfResponsavel = "";
    }

    public int getCodLocalizacao() {
        return codLocalizacao;
    }

    public void setCodLocalizacao(int codLocalizacao) {
        this.codLocalizacao = codLocalizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }
}
