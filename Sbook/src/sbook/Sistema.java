/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sbook;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Lásaro Rocha
 */
class Sistema {
    private final List<Administrador> administradores;
    private final List<Usuario> usuarios;
    private final List<ItemAcervo> acervo;
    
    
    Sistema() {
        administradores = new LinkedList<>();
        usuarios = new LinkedList<>();
        acervo = new LinkedList<>();
        
        iniciaDatabase();
        
    }
    
    void executa() {
        
    }

    private void iniciaDatabase() {
        //iniciar a database aqui
    }
    
}
