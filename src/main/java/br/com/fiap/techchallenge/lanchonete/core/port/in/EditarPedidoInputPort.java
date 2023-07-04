package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.PedidoIn;

public interface EditarPedidoInputPort {
    PedidoOut editar(PedidoIn pedidoIn);
}
