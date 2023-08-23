package br.com.fiap.techchallenge.lanchonete.core.ports.in;

import br.com.fiap.techchallenge.lanchonete.core.entities.CriaItemPedido;
import br.com.fiap.techchallenge.lanchonete.core.entities.ItemPedidoOut;

public interface EditarItemPedidoInputPort {
    ItemPedidoOut editarItem(CriaItemPedido itemPedidoIn);
}
