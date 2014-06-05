/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sbook;

/**
 *
 * @author Lásaro Rocha
 */
class Livro extends ItemAcervo {
    private final String ISBN;
    private final int edicao;

    public Livro(String autor, String ISBN, int edicao, int codigoItem, String titulo, double custo, int quantidade) {
        super(codigoItem, titulo, autor, custo, quantidade);
        this.ISBN = ISBN;
        this.edicao = edicao;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getEdicao() {
        return edicao;
    }
    
    @Override
    public String toString() {
        return "#" + getCodigoItem() + " - " + "Livro: " + getTitulo();
    }
    
}
