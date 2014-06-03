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
public class RepositorioItemdoarcevoArrayList implements RepositorioItemdoacervo {

    private ArrayList<ItemAcervo> Itens;
    private static RepositorioItemdoacervo instancia;

    public RepositorioItemdoarcevoArrayList() {
        this.Itens = new ArrayList<ItemAcervo>();
    }

    public RepositorioItemdoacervo obterInstanciaItem() {
        if (Itens == null) {
            instancia = new RepositorioItemdoarcevoArrayList();
        }

        return instancia;

    }

    @Override
    public void incluirItem(ItemAcervo ia) throws itemjaexisteException {
        for (ItemAcervo a : Itens) {
            if (ia.getCodigoItem() == a.getCodigoItem()) {
                throw new itemjaexisteException();
            }
        }

        Itens.add(ia);

    }

    @Override
    public void excluirItem(ItemAcervo ia) throws itemnaoexisteException {

        for (ItemAcervo a : Itens) {

            if (ia.getCodigoItem() == a.getCodigoItem()) {
             Itens.remove(ia);
             return;
            }

        }
        
     throw new itemnaoexisteException();
    }
    
    
        @Override
        public ItemAcervo pesquisarUsuario(int codigoItem) throws itemnaoexisteException {
            
            for (ItemAcervo a : Itens) {
                if (a.getCodigoItem()==codigoItem) {
                    return a;
                    
                }
            }
            
            throw new itemnaoexisteException();

        }

        @Override
        public ArrayList<ItemAcervo> listaritens() throws itensnaoexisteException {
            return Itens;

        }

    }
