/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sbook;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lásaro Rocha
 */
public class Sistema {
    private final RepositorioUsuario usuarios;
    private final RepositorioItemAcervo acervo;
    private final IAdicionaAdm janelaAddAdm;
    private final ILogin janelaLogin;
    private final IUsuario janelaUsuario;
    private Usuario usuarioLogado;
    private Administrador admLogado;
    
    
    Sistema() {
        usuarios = RepositorioUsuarioArrayList.obterInstancia();
        acervo = RepositorioItemAcervoArrayList.obterInstancia();
        
        janelaAddAdm = new IAdicionaAdm(this);
        janelaLogin = new ILogin(this);
        janelaUsuario = new IUsuario(this);
        carregaDatabase();
        
    }
    
    void executa() {
        try {
            //        if(administradores.isEmpty()) { //se não tem nenhum administrador, obriga o usuário a criar um.
//            JOptionPane.showMessageDialog(null, "O sistema não tem nenhum administrador. Adicione um.");
//            janelaAddAdm.cadastraAdm();
//        }
//        
//        if(!janelaLogin.fazLogin()) { //se o usuário clicou no botão de fechar a janela
//            salvaDatabase();
//            System.exit(0);
//        }
//        
//        //se quem fez login foi um usuario
//        if(usuarioLogado != null) {
//            //exibe a janela
            acervo.incluirItem(new Livro("Lásaro", "909898", 1, 999666, "Valhala", 5.00, 1));
            acervo.incluirItem(new Apostila(999, "Como cozinhar", "Lásaro", 0.90, 2));
            acervo.incluirItem(new Texto(969, "texto inutil", "Lásaro", 0.10, 1));
        } catch (ItemJaExisteException ex) {
            
        }
            janelaUsuario.exibe(usuarioLogado);
//        }
        // o código vai continuar aqui.
    }

    private void carregaDatabase() {
        //iniciar a database aqui
    }

    private void salvaDatabase() {
    
    }
    
    void loginUsuario(String cpf, String senha) throws UsuarioNaoExisteException, SenhaInvalidaException {
        //procura nos administradores
        usuarioLogado = usuarios.pesquisarUsuario(cpf);
        if(!usuarioLogado.getSenha().equals(senha)) {
            throw new SenhaInvalidaException();
        }
        //se o usuário logado é um administrador
        if(usuarioLogado.getClass().isInstance(Administrador.class)) {
            admLogado = (Administrador) usuarioLogado;
            usuarioLogado = null;
        }
    }

    public Usuario procuraUsuario(String cpf) throws UsuarioNaoExisteException {
        return usuarios.pesquisarUsuario(cpf);
    }
    
    public void cadastraUsuario(Usuario a) throws UsuarioJaExisteException {
        usuarios.incluirUsuario(a);
    }
    
    List<ItemAcervo> obtemAcervo() throws AcervoVazioException {
        return acervo.listarItens();
    }
}
