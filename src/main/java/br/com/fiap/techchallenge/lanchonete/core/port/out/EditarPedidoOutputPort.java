package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.PedidoIn;

public interface EditarPedidoOutputPort {
    PedidoOut editar(PedidoIn pedidoIn);
}
