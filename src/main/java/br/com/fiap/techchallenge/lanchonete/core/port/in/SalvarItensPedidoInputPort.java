package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.CriaItemPedido;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ItemPedidoOut;

public interface SalvarItensPedidoInputPort {
    ItemPedidoOut salvarItem(CriaItemPedido itemPedidoIn);
}
