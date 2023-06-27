package br.com.fiap.techchallenge.lanchonete.adapters.web.models;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Pedido;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Produto;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ItemPedidoIn;

public class ItemPedidoRequest extends ItemPedidoIn {
    public ItemPedidoRequest(Long id, Pedido pedido, Produto produto, int quantidade) {
        super(id, pedido, produto, quantidade);
    }
}
