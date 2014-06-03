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
    private final IAdicionaAdm painelAdicionaAdm;
    private final ILogin painelLogin;
    private Usuario logado;
    
    
    Sistema() {
        administradores = new LinkedList<>();
        usuarios = new LinkedList<>();
        acervo = new LinkedList<>();
        
        painelAdicionaAdm = new IAdicionaAdm(this);
        painelLogin = new ILogin(this);
        carregaDatabase();
        
    }
    
    void executa() {
        if(administradores.isEmpty()) { //se não tem nenhum administrador, obriga o usuário a criar um.
            JOptionPane.showMessageDialog(null, "O sistema não tem nenhum administrador. Adicione um.");
            Administrador adm = painelAdicionaAdm.cadastraAdm();
        }
        logado = painelLogin.entraUsuario();
        if(logado == null) {
            salvaDatabase();
            System.exit(0);
        }
    }

    private void carregaDatabase() {
        //iniciar a database aqui
    }

    private void salvaDatabase() {
    
    }
    
    Usuario loginUsuario(String email, String senha) {
        //procura nos administradores
        for(Administrador adm:administradores) {
            if(adm.getEmail().equals(email) && adm.getSenha().equals(senha)) {
                return adm;
            }
        }
        return null;
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
