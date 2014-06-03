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
    
    
    Sistema() {
        administradores = new LinkedList<>();
        usuarios = new LinkedList<>();
        acervo = new LinkedList<>();
        
        painelAdicionaAdm = new IAdicionaAdm();
        painelLogin = new ILogin();
        iniciaDatabase();
        
    }
    
    void executa() {
        if(administradores.size() == 0) { //se não tem nenhum administrador, obriga o usuário a criar um.
            JOptionPane.showMessageDialog(null, "O sistema não tem nenhum administrador. Adicione um.");
            Administrador adm = painelAdicionaAdm.getAdm();
            administradores.add(adm);
        }
        Usuario u = painelLogin.fazLogin(this);
    }

    private void iniciaDatabase() {
        //iniciar a database aqui
    }

    Usuario loginUsuario(String nome, String senha) {
        //procura nos administradores
        for(Administrador adm:administradores) {
            if(adm.getNome().equals(nome) && adm.getSenha().equals(senha)) {
                return adm;
            }
        }
        return null;
    }
    
}
