package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.pedido.PedidoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.BuscaTodosPedidosInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscaTodosPedidosOutputPort;

import java.util.List;

public class BuscaTodosPedidosUseCase implements BuscaTodosPedidosInputPort {

    private final BuscaTodosPedidosOutputPort buscaTodosPedidosOutputPort;

    public BuscaTodosPedidosUseCase(BuscaTodosPedidosOutputPort buscaTodosPedidosOutputPort) {
        this.buscaTodosPedidosOutputPort = buscaTodosPedidosOutputPort;
    }

    @Override
    public List<PedidoOut> buscarTodos() {
        return buscaTodosPedidosOutputPort.buscarTodos();
    }
}
