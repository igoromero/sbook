package sbook;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/** Esta classe representa um item no acervo da biblioteca.
 *
 * @author Lásaro Rocha
 */
public class ItemAcervo {
    private final int codigoItem; //codigo do item (6 números)
    private String titulo;
    private String autor;
    private double custo; //custo do item
    private Usuario alugadoPara; //usuario para quem este item esta alugado
    private Date dataAluguel;
    private Date dataDevolucao;
    private final Queue<Usuario> listaDeEspera; //fila de espera para este item
    private int quantidade;

    /**
     * Cria um novo item.
     *
     * @param codigoItem Codigo do item
     * @param titulo Titulo do item
     * @param autor Autor
     * @param custo Custo para alugar esse item
     * @param quantidade Quantidade de itens no acervo
     */
    public ItemAcervo(int codigoItem, String titulo, String autor, double custo, int quantidade) {
        this.codigoItem = codigoItem;
        this.titulo = titulo;
        this.autor = autor;
        this.custo = custo;
        this.quantidade = quantidade;
        this.listaDeEspera = new LinkedList<>();
        this.alugadoPara = null;
        this.dataAluguel = null;
        this.dataDevolucao = null;
    }
    
    
    /**
     * Aluga o item para o usuário <code>u</code> por <code>numDias</code> dias.
     * 
     * @param u Usuário que alugou o item.
     * @param numDias Número de dias que o item vai ficar alugado.
     */
    public void aluga(Usuario u, int numDias) {
        alugadoPara = u;
        dataAluguel = Calendar.getInstance().getTime();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, numDias);
        dataDevolucao = c.getTime();
    }
    
    /**
     * Devolve o item.
     *
     */
    public void devolve() {
        alugadoPara = null;
        dataAluguel = null;
        dataDevolucao = null;
    }

    /**
     * Indica se o item está alugado ou não.
     *
     * @return <code>true</code> se o item está alugado. <code>false</code> se não está.
     */
    public boolean estaAlugado() {
        return alugadoPara != null;
    }

    /**
     * Altera o custo do item.
     *
     * @param custo O novo valor do item.
     */
    public void setCusto(double custo) {
        this.custo = custo;
    }

    /**
     * Retorna o valor do item.
     * 
     *
     * @return o valor do item.
     */
    public double getCusto() {
        return custo;
    }

    /**
     * Retorna a data que o item foi alugado.
     *
     * @return Data de aluguel
     */
    public Date getDataAluguel() {
        return dataAluguel;
    }

    /**
     * Retorna a data que este item deve ser devolvido.
     * 
     *
     * @return Data de devolução.
     */
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * Retorna o código do item.
     *
     * @return o código do item
     */
    public int getCodigoItem() {
        return codigoItem;
    }

    /**
     * Retorna o Usuario para quem este item está alugado.
     *
     * @return Usuario para quem este item está alugado ou null caso não esteja.
     */
    public Usuario getAlugadoPara() {
        return alugadoPara;
    }

    /**
     * Retorna a fila de usuários esperando por este item.
     *
     * @return Fila de usuários.
     */
    public Queue<Usuario> getListaDeEspera() {
        return listaDeEspera;
    }
    
    /**
     * Adiciona um usuario na fila de espera pelo item.
     *
     * @param u O usuário
     */
    public void reserva(Usuario u) {
        listaDeEspera.offer(u);
    }
    
    @Override
    public String toString() {
        return "#" + codigoItem + " " + titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    
}
