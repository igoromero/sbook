/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sbook;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lásaro Rocha
 */
public class Sistema {
    private final List<Administrador> administradores;
    private final List<Usuario> usuarios;
    private final List<ItemAcervo> acervo;
    private final IAdicionaAdm janelaAddAdm;
    private final ILogin janelaLogin;
    private final IUsuario janelaUsuario;
    private Usuario usuarioLogado;
    private Administrador admLogado;
    
    
    Sistema() {
        administradores = new LinkedList<>();
        usuarios = new LinkedList<>();
        acervo = new LinkedList<>();
        
        janelaAddAdm = new IAdicionaAdm(this);
        janelaLogin = new ILogin(this);
        janelaUsuario = new IUsuario(this);
        carregaDatabase();
        
    }
    
    void executa() {
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
            janelaUsuario.exibe(usuarioLogado);
//        }
        // o código vai continuar aqui.
    }

    private void carregaDatabase() {
        //iniciar a database aqui
    }

    private void salvaDatabase() {
    
    }
    
    boolean loginUsuario(String email, String senha) {
        //procura nos administradores
        for(Administrador adm:administradores) {
            if(adm.getEmail().equals(email) && adm.getSenha().equals(senha)) {
                admLogado = adm;
                return true;
            }
        }
        
        for(Usuario u:usuarios) {
            if(u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                usuarioLogado = u;
                return true;
            }
        }
        return false;
    }

    Usuario procuraUsuarioPorEmail(String email) {
        for(Administrador adm:administradores) {
            if(adm.getEmail().equals(email))
                return adm;
        }
        for(Usuario u:usuarios) {
            if(u.getEmail().equals(email))
                return u;
        }
        return null;
    }
    
    public boolean cadastra(Administrador a) {
        if(procuraUsuarioPorEmail(a.getEmail()) == null) {//usuário não existe
            return administradores.add(a);
        } else {
            return false;
        }
    }
    
    
    public boolean cadastra(Usuario a) {
        if(procuraUsuarioPorEmail(a.getEmail()) == null) {//usuário não existe
            return usuarios.add(a);
        } else {
            return false;
        }
    }

    
}
