package sbook;

import java.util.ArrayList;

/**
 * Classe RepositorioArrayList Objetivo: A Class RepositorioArrayList representa
 * o conjunto de usuarios 
 * atualização: 03/06/2014 
 * Empresa: IFBA
 * @author Igo Romero
 * @version 0.1
 */
public class RepositorioUsuarioArrayList implements RepositorioUsuario {

    private ArrayList<Usuario> usuarios; //arraylist usuarios
    private static RepositorioUsuario instancia;
    private static int codUsuario = 1000;

    public RepositorioUsuarioArrayList() {
        this.usuarios = new ArrayList<Usuario>();
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
     * @param u Usuario
     * @return void
     * @exception UsuariojaexisteException
     */
    public void incluirUsuario(Usuario u) throws UsuariojaexisteException {

        for (Usuario d : usuarios) {
            if (u.getCpf().equals(d.getCpf())) {
                throw new UsuariojaexisteException();
            }

        }
        usuarios.add(u);
    }

    /**
     * remove um usuario ao repositorio
     *
     * @param u Usuario
     * @return
     * @exception UsuarionaoexisteException
     */
    public void excluirUsuario(Usuario u) throws UsuarionaoexisteException {
        for (Usuario d : usuarios) {

            if (u.getCpf().equals(d.getCpf())) {
                usuarios.remove(d);
                return;
            }
        }

        throw new UsuarionaoexisteException();

    }

    /**
     * pesquisar um usuario ao repositorio
     *
     * @param cpf usuario
     * @return usuario
     * @exception UsuarionaoexisteException
     */
    public Usuario pesquisarUsuario(String cpf) throws UsuarionaoexisteException {

        for (Usuario a : usuarios) {
            if (a.getCpf().equals(cpf)) {
                return a;
            }

        }
        throw new UsuarionaoexisteException();
    }

    /**
     * ListarUsuario lista todos os usuarios do repositorio
     *
     * @return usuarios
     * @exception UsuarionaoexisteException
     */
    public ArrayList<Usuario> listarUsuario() throws UsuariosnaoexisteException {
        return usuarios;
    }

}
