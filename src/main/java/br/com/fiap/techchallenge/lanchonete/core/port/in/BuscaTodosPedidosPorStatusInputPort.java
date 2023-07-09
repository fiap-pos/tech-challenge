package br.com.fiap.techchallenge.lanchonete.core.port.in;


import br.com.fiap.techchallenge.lanchonete.core.domain.models.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;

import java.util.List;

public interface BuscaTodosPedidosPorStatusInputPort {
    List<PedidoOut> buscarTodosStatus(StatusPedidoEnum status);
}
