package MODEL;

public class Funcionario {
    private String cpfFuncionario;
    private int codLocalizacao;
    private String nomeFuncionario;
    private String cargoFuncionario;
    private int sitFuncionario;
    private String dtEntrada;
    
    public Funcionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public Funcionario(){
        this.cpfFuncionario = "";
        this.nomeFuncionario = "";
        this.cargoFuncionario = "";
        this.sitFuncionario = 1;
        this.dtEntrada = "99/99/9999";
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public int getCodLocalizacao(int valor) {
        Localizacao localizacao = new Localizacao(valor);
        this.codLocalizacao = localizacao.getCodLocalizacao();
        return this.codLocalizacao;
    }
    
    public int getCodLocalizacao() {
        return this.codLocalizacao;
    }
    
    public void setCodLocalizacao(int codLocalizacao) {
        this.codLocalizacao = codLocalizacao;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getCargoFuncionario() {
        return cargoFuncionario;
    }

    public void setCargoFuncionario(String cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }

    public int getSitFuncionario() {
        return sitFuncionario;
    }

    public void setSitFuncionario(int sitFuncionario) {
        this.sitFuncionario = sitFuncionario;
    }

    public String getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrada(String dtEntrada) {
        this.dtEntrada = dtEntrada;
    }

    
}
