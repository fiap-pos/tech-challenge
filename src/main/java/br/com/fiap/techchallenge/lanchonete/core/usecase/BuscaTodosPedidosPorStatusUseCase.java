package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.port.in.BuscaTodosPedidosPorStatusInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscaTodosPedidosPorStatusOutputPort;

import java.util.List;

public class BuscaTodosPedidosPorStatusUseCase implements BuscaTodosPedidosPorStatusInputPort {

    private final BuscaTodosPedidosPorStatusOutputPort buscaTodosPedidosPorStatusOutputPort;

    public BuscaTodosPedidosPorStatusUseCase(BuscaTodosPedidosPorStatusOutputPort buscaTodosPedidosPorStatusOutputPort) {
        this.buscaTodosPedidosPorStatusOutputPort = buscaTodosPedidosPorStatusOutputPort;
    }

    @Override
    public List<PedidoOut> buscarTodosStatus(StatusPedidoEnum status) {
        return buscaTodosPedidosPorStatusOutputPort.buscarPedidosPorStatus(status);
    }

}
