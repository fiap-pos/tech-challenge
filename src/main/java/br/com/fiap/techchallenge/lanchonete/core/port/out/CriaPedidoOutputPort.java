package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.PedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.PedidoOut;

public interface CriaPedidoOutputPort {
    PedidoOut criar(PedidoIn pedidoIn);
}
