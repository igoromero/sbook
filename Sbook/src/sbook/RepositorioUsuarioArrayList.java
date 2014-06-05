package sbook;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe RepositorioArrayList Objetivo: A Class RepositorioArrayList representa
 * o conjunto de usuarios atualização: 03/06/2014 Empresa: IFBA
 *
 * @author Igo Romero
 * @version 0.1
 */
public class RepositorioUsuarioArrayList implements RepositorioUsuario {
    private ArrayList<Usuario> usuarios; //arraylist usuarios
    private static RepositorioUsuario instancia;

    
    //só deve ser instanciada pelo método obterInstancia
    private RepositorioUsuarioArrayList() {
        this.usuarios = new ArrayList<>();
    }

    /**
     * Cria um novo nova instancia do repositorio caso não exista
     *
     * @return instancia
     */
    public static RepositorioUsuario obterInstancia() {
        if (instancia == null) {
            instancia = new RepositorioUsuarioArrayList();
        }
        return instancia;
    }

    /**
     * Incluir um usuario ao repositorio
     *
     * @param u Usuario a ser adicionado
     * @throws UsuarioJaExisteException
     */
    @Override
    public void incluirUsuario(Usuario u) throws UsuarioJaExisteException {
        for (Usuario d : usuarios) {
            if (u.getCpf().equals(d.getCpf())) {
                throw new UsuarioJaExisteException();
            }
        }
        usuarios.add(u);
    }

    /**
     * Remove um usuario do repositorio
     *
     * @param u Usuario a ser removido.
     * @throws UsuarioNaoExisteException caso o usuário não exista.
     */
    @Override
    public void excluirUsuario(Usuario u) throws UsuarioNaoExisteException {
        for (Usuario d : usuarios) {
            if (u.getCpf().equals(d.getCpf())) {
                usuarios.remove(d);
                return;
            }
        }

        throw new UsuarioNaoExisteException();
    }

    /**
     * pesquisar um usuario ao repositorio
     *
     * @param cpf usuario
     * @return usuario
     * @throws UsuarioNaoExisteException
     */
    @Override
    public Usuario pesquisarUsuario(String cpf) throws UsuarioNaoExisteException {
        for (Usuario a : usuarios) {
            if (a.getCpf().equals(cpf)) {
                return a;
            }

        }
        throw new UsuarioNaoExisteException();
    }

    /**
     * <code>ListarUsuario</code> lista todos os usuarios do repositorio
     *
     * @return Um ArrayList contendo todos os usuários do repositório.
     * @throws sbook.UsuariosNaoExisteException
     */
    @Override
    public ArrayList<Usuario> listarUsuario() throws UsuariosNaoExisteException {
        return usuarios;
    }

    @Override
    public Iterator iterator() {
        return usuarios.iterator();
    }
}
