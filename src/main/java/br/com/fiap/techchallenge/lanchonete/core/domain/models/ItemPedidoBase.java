package br.com.fiap.techchallenge.lanchonete.core.domain.models;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Pedido;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Produto;

public abstract class ItemPedidoBase {

    private Long id;
    private Pedido pedido;
    private Produto produto;
    private int quantidade;

    public ItemPedidoBase(Long id, Pedido pedido, Produto produto, int quantidade) {
        this.id = id;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
