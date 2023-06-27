package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.PedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.PedidoOut;

public interface CriaPedidoInputPort {
    PedidoOut criar(PedidoIn pedidoIn);
}
