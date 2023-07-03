package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;

import java.util.List;

public interface BuscaTodosPedidosPorStatusOutputPort {
    List<PedidoOut> buscarPedidosPorStatus(StatusPedidoEnum status);
}
