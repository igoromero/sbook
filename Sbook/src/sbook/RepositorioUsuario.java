
package sbook;

import java.util.ArrayList;

/**
 * Class interface RepositorioUsuario
 * Objetivo: assinatura dos metodos implementados nos repositorios
 * atualização: 03/06/2014 
 * Empresa: IFBA 
 * @author Igo Romero
 * @version 0.1
 */


public interface RepositorioUsuario {
    void incluirUsuario(Usuario u) throws UsuariojaexisteException;
    void excluirUsuario(Usuario u) throws UsuarionaoexisteException;
    Usuario pesquisarUsuario(String cpf) throws UsuarionaoexisteException;
    ArrayList<Usuario> listarUsuario()  throws UsuariosnaoexisteException;
    
}
