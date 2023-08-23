package br.com.fiap.techchallenge.lanchonete.core.usecases;

import br.com.fiap.techchallenge.lanchonete.core.entities.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.entities.enums.StatusPedidoEnum;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.BuscaTodosPedidosPorStatusInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.BuscaTodosPedidosPorStatusOutputPort;

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
