package MODEL;

public class Usuario {
    private String codUsuario;
    private String senha;
    private String nomeUsuario;
    private int tpUsuario;

    public Usuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }
    
    public Usuario(){
        this.codUsuario = "";
        this.senha = "";
        this.nomeUsuario = "";
        this.tpUsuario = 1;
    }

    public String getCodUsuario(){
        return this.codUsuario;
    }
    
    public void setCodUsuario(String codUsuario){
        this.codUsuario = codUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public int getTpUsuario() {
        return tpUsuario;
    }

    public void setTpUsuario(int tpUsuario) {
        this.tpUsuario = tpUsuario;
    }
}
