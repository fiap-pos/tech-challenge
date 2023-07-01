package br.com.fiap.techchallenge.lanchonete.core.domain.models;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Pedido;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Produto;

public class ItemPedidoOut extends ItemPedidoBase{
    private PedidoOut pedidoOut;
    private ProdutoOut produtoOut;
    public ItemPedidoOut(Long id, PedidoOut pedido, ProdutoOut produto, int quantidade) {
        super(id, quantidade);
        this.pedidoOut = pedido;
        this.produtoOut = produto;
    }

    public PedidoOut getPedidoOut() {
        return pedidoOut;
    }

    public void setPedidoOut(PedidoOut pedidoOut) {
        this.pedidoOut = pedidoOut;
    }

    public ProdutoOut getProdutoOut() {
        return produtoOut;
    }

    public void setProdutoOut(ProdutoOut produtoOut) {
        this.produtoOut = produtoOut;
    }
}
