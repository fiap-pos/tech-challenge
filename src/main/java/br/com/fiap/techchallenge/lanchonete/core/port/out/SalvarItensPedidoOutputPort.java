package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.CriaItemPedido;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ItemPedidoOut;

public interface SalvarItensPedidoOutputPort {
    ItemPedidoOut salvarItem(CriaItemPedido itemPedidoIn);
}
