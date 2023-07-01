package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ItemPedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;

public class ItemPedidoResponse extends ItemPedidoOut {
    public ItemPedidoResponse(Long id, PedidoOut pedido, ProdutoOut produto, int quantidade) {
        super(id, pedido, produto, quantidade);
    }
}
