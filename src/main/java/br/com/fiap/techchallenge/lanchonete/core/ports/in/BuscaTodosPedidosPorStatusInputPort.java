package br.com.fiap.techchallenge.lanchonete.core.ports.in;


import br.com.fiap.techchallenge.lanchonete.core.entities.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.entities.enums.StatusPedidoEnum;

import java.util.List;

public interface BuscaTodosPedidosPorStatusInputPort {
    List<PedidoOut> buscarTodosStatus(StatusPedidoEnum status);
}
