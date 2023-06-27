package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ItemPedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ItemPedidoOut;

public interface EditarItemPedidoInputPort {
    ItemPedidoOut editarItem(ItemPedidoIn itemPedidoIn);
}
