package sbook;

/**
 * Classe Administrador
 * Objetivo: A Class Administrado é um usuario 
 * Data da última atualização: 03/06/2014
 * Empresa: IFBA
 * @author Igo Romero 
 * @version  0.1
 */


public class Administrador extends Usuario {

    public Administrador(String nome, String cpf, String senha, String email) {
        super(nome, cpf, senha, email);
    }

    Administrador(String nome, String CPF, String senha) {
        super(nome, CPF, senha, senha);
      
    }

   
       
}
