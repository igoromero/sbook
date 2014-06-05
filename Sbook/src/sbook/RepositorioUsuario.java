
package sbook;

import java.util.List;

/**
 * Class interface RepositorioUsuario
 * Objetivo: assinatura dos metodos implementados nos repositorios
 * atualização: 03/06/2014 
 * Empresa: IFBA 
 * @author Igo Romero
 * @version 0.1
 */


public interface RepositorioUsuario extends Iterable {
    void incluirUsuario(Usuario u) throws UsuarioJaExisteException;
    
    void excluirUsuario(Usuario u) throws UsuarioNaoExisteException;
    
    Usuario pesquisarUsuario(String cpf) throws UsuarioNaoExisteException;
    
    List<Usuario> listarUsuario()  throws UsuariosNaoExisteException;    
}
