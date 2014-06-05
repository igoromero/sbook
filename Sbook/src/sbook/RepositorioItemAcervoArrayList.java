package sbook;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lásaro Rocha
 */
public class RepositorioItemAcervoArrayList implements RepositorioItemAcervo {
    private static RepositorioItemAcervoArrayList instancia;
    private final ArrayList<ItemAcervo> itens;

    private RepositorioItemAcervoArrayList() {
        itens = new ArrayList();
    }
    
    public static RepositorioItemAcervo obterInstancia() {
        if(instancia == null) {
            instancia = new RepositorioItemAcervoArrayList();
        }
        return instancia;
    }
    
    @Override
    public void incluirItem(ItemAcervo i) throws ItemJaExisteException {
        for(ItemAcervo a:itens) {
            if(a.getCodigoItem() == i.getCodigoItem()) {
                throw new ItemJaExisteException();
            }
        }
        itens.add(i);
    }

    @Override
    public void excluirItem(ItemAcervo i) throws ItemNaoExisteException {
        for(ItemAcervo a:itens) {
            if(a.getCodigoItem() == i.getCodigoItem()) {
                itens.remove(a);
                return;
            }
        }
        throw new ItemNaoExisteException();
    }

    @Override
    public ItemAcervo pesquisarItem(int codigo) throws ItemNaoExisteException {
        for(ItemAcervo a:itens) {
            if(a.getCodigoItem() == codigo) {
                return a;
            }
        }
        throw new ItemNaoExisteException();
    }

    @Override
    public List<ItemAcervo> listarItens() throws AcervoVazioException {
        return itens;
    }
}