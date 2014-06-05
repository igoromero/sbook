/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sbook;

import java.util.List;

/**
 *
 * @author Lásaro Rocha
 */
public interface RepositorioItemAcervo {
    public void incluirItem(ItemAcervo i) throws ItemJaExisteException;
    
    public void excluirItem(ItemAcervo i) throws ItemNaoExisteException;
    
    public ItemAcervo pesquisarItem(int codigo) throws ItemNaoExisteException;
    
    public List<ItemAcervo> listarItens() throws AcervoVazioException;
}
