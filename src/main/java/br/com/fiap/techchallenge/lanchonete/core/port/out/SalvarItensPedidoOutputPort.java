package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ItemPedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ItemPedidoOut;

public interface SalvarItensPedidoOutputPort {
    ItemPedidoOut salvarItem(ItemPedidoIn itemPedidoIn);
}
