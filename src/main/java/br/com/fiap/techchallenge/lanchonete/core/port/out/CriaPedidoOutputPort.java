package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.interfaces.CriaPedidoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.PedidoOut;

public interface CriaPedidoOutputPort {
    PedidoOut criar(CriaPedidoIn criaPedidoIn);
}
