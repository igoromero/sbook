package sbook;

/**
 * Classe Usuario Objetivo: Definir o Usuario Data da última atualização:
 * 03/06/2014 Empresa: IFBA
 *
 * @author Igo Romero
 * @version 0.1
 */
public class Usuario {

//atributos da classe Usuario
    private int codUsuario;
    private static int contador = 0x29A;
    private String nome;
    private String cpf;
    private String senha;
    private String email;

    //construtor da class 
    public Usuario(String nome, String cpf, String senha, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
//        this.codUsuario = codUsuario+1; <-isso não funciona. Vai dá sempre 1
        this.codUsuario = contador;
        contador++;
    }

//metodos da classe usuario
    public void pagar() {

    }

    public ItemAcervo escolherItemAcervo() {
        return null;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Este método retorna uma string contendo todo o Objeto na forma de string
     * para ser salvo em um arquivo de texto.
     *
     * @return String que representa o objeto.
     */
    public String retornaEstado() {
        return codUsuario + " " +
            nome + " " +
            cpf + " " +
            senha + " " +
            email + "\n";
    }
    
    /**
     * Inicializa o objeto a partir dos dados em <code>s</code>
     *
     * @param s A string contendo o estado do objeto
     * @return true se tudo aconteceu normal. false se não.
     */
    public boolean carregaEstado(String s) {
        return false;
    }

}