/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbook;

import java.util.ArrayList;

/**
 *
 * @author acer
 */
public interface RepositorioItemdoacervo {

    void incluirItem(ItemAcervo ia) throws itemjaexisteException;

    void excluirItem(ItemAcervo ia) throws itemnaoexisteException;

    ItemAcervo pesquisarUsuario(int codigoItem) throws itemnaoexisteException;

    ArrayList<ItemAcervo> listaritens() throws itensnaoexisteException;

}
