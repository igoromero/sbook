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
    private String nome;
    private String cpf;
    private String senha;

//metodos da classe usuario
    public void pagar() {

    }

    public ItemAcervo escolherItemAcervo() {
        return null;
    }

    public Usuario(int codUsuario, String nome, String cpf, String senha) {
        this.codUsuario = codUsuario;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
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

}
