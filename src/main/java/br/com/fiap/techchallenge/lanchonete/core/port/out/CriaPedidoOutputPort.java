package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.pedido.PedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.pedido.PedidoOut;

public interface CriaPedidoOutputPort {
    PedidoOut criar(PedidoIn pedidoIn);
}
