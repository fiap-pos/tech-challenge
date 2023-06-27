package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Pedido;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Produto;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ItemPedidoOut;

public class ItemPedidoResponse extends ItemPedidoOut {
    public ItemPedidoResponse(Long id, Pedido pedido, Produto produto, int quantidade) {
        super(id, pedido, produto, quantidade);
    }
}
