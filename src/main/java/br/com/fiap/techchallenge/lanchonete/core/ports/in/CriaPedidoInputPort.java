package br.com.fiap.techchallenge.lanchonete.core.ports.in;

import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.entities.PedidoOut;

public interface CriaPedidoInputPort {
    PedidoOut criar(PedidoIn pedidoIn);
}
