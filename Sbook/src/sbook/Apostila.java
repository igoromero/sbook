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
class Apostila extends ItemAcervo {

    public Apostila(int codigoItem, String titulo, String autor, double custo, int quantidade) {
        super(codigoItem, titulo, autor, custo, quantidade);
    }

    public String toString() {
        return "#" + getCodigoItem() + " - " + "Apostila: " + getTitulo();
    }
}
