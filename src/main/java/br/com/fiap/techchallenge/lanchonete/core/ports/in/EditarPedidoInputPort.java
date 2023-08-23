package br.com.fiap.techchallenge.lanchonete.core.ports.in;

import br.com.fiap.techchallenge.lanchonete.core.entities.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.dtos.PedidoIn;

public interface EditarPedidoInputPort {
    PedidoOut editar(PedidoIn pedidoIn);
}
