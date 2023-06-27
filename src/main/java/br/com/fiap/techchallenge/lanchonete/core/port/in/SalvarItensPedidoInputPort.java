package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ItemPedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ItemPedidoOut;

public interface SalvarItensPedidoInputPort {
    ItemPedidoOut salvarItem(ItemPedidoIn itemPedidoIn);
}
